package servlet.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doGET method");

		req.getRequestDispatcher("/html/login.jsp").forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init method");
	}

	@Override
	public void destroy() {
		System.out.println("in destroy method");
	}
}
