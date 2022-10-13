package servlet.controllers;

import beans.ProductHandler;
import ui.ProductInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addProducts")
public class ProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<String> cart = (ArrayList<String>)session.getAttribute("cart");
        List<ProductInfo> shoppingChard = (ArrayList<ProductInfo>)session.getAttribute("carts");

        if(cart==null){
            cart = new ArrayList<>();
        }

        if(request.getParameter("product_name")!=null){
            cart.add(request.getParameter("product_name"));
        }

        if(shoppingChard==null){
            shoppingChard = new ArrayList<>();
        }

        if(request.getParameter("product_ID")!=null ||
           request.getParameter("product_imgUrl")!=null ||
           request.getParameter("product_descr")!=null ||
           request.getParameter("product_price")!=null
        ){
            shoppingChard.add(new ProductInfo(Integer.parseInt(request.getParameter("product_ID")),
                    request.getParameter("product_name"),
                    request.getParameter("product_imgUrl"),
                    request.getParameter("product_descr"),
                    Float.parseFloat(request.getParameter("product_price"))
                    ));
        }

        session.setAttribute("cart", cart);
        session.setAttribute("carts", shoppingChard);
        //System.out.println("Yallaaaaaa");
        //System.out.println(cart.get(cart.size()-1));
        //System.out.println(request.getParameter("product_name"));
        //System.out.println(request.getParameter("product_imgUrl"));
        //System.out.println(request.getParameter("product_price"));
        //System.out.println(request.getParameter("product_descr"));
        //System.out.println(request.getParameter("product_ID"));
        //System.out.println("Yallaaaaaa");



        String search = (String)session.getAttribute("search");

        ArrayList<ProductInfo> products = (ArrayList<ProductInfo>) ProductHandler.getItemsWithGroup(search);

        request.setAttribute("products", products);
        request.setAttribute("carts", shoppingChard);
        //System.out.println(request.getAttribute("products"));

        request.getRequestDispatcher("/html/searchResults.jsp").forward(request, response);
    }

}
