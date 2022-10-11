package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "ShoppingCartServlet", urlPatterns = "/shoppingCart")
public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<String> cart = (ArrayList<String>) req.getSession().getAttribute("cart");

        req.setAttribute("carts", cart);

        getServletContext().getRequestDispatcher("/html/shoppingCart.jsp").forward(req, resp);
    }
}
