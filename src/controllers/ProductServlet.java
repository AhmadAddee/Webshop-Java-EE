package controllers;

import db.ProductDB;

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

        if(cart==null){
            cart = new ArrayList<>();
        }

        if(request.getParameter("product")!=null){
            cart.add(request.getParameter("product"));
        }

        session.setAttribute("cart", cart);

        String search = (String)session.getAttribute("search");

        ArrayList<ProductDB> products = (ArrayList<ProductDB>) ProductDB.searchProducts(search);

        request.setAttribute("products", products);

        request.getRequestDispatcher("/html/searchResults.jsp").forward(request, response);
    }

}
