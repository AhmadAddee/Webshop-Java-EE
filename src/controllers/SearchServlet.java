package controllers;

import db.ProductDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchString = req.getParameter("search");

        req.getSession().setAttribute("search", searchString);

        List<ProductDB> products = (List<ProductDB>) ProductDB.searchProducts(searchString);

        req.setAttribute("products", products);
        req.getRequestDispatcher("/html/searchResults.jsp").forward(req, resp);
    }
}
