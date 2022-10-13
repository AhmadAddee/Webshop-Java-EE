package servlet.controllers;

import ui.ProductInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ShoppingCartServlet", urlPatterns = "/shoppingCart")
public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<String> cart = (ArrayList<String>) req.getSession().getAttribute("cart");
        List<ProductInfo> shoppingChard = (ArrayList<ProductInfo>) req.getSession().getAttribute("carts");
        req.setAttribute("carts", shoppingChard);


        getServletContext().getRequestDispatcher("/html/shoppingCart.jsp").forward(req, resp);
    }
}
