package servlets;

import db.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/html/login.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get the username from the login form
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //call DAO for validation logic
        UserDB dao = new UserDB();
        boolean isValidUser = dao.validateUser(username, password);

        //check if user is invalid and set up an error message
        if (isValidUser) {
            //set up the HTTP session
            HttpSession session = req.getSession();

            //set the username as an attribute
            session.setAttribute("username", username);
            //forward to home jsp
            req.getRequestDispatcher("/html/home.jsp").forward(req, resp);
        } else {
            String errorMessage = "Invalid Credentials, please login again!";
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("/html/login.jsp").forward(req, resp);


        }

    }
}