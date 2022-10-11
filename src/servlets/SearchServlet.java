package servlets;

import beans.Product;
import db.DBManager;
import db.ProductDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //collect search string from the form
        String searchString = req.getParameter("search");

        Connection connection = DBManager.getConnection();//(Connection)getServletContext().getAttribute("dbconnection");
        req.getSession().setAttribute("search", searchString);
        //call DAO layer and get all products for search criteria
        ProductDB dao = new ProductDB();
        List<Product> products = dao.searchProducts(searchString,connection);

        //write the products data back to the client browser
		/*String page = getHTMLString(req.getServletContext().getRealPath("/html/searchResults.html"), products);
		resp.getWriter().write(page);*/
        req.setAttribute("products", products);
        req.getRequestDispatcher("/html/searchResults.jsp").forward(req, resp);


    }
}
