package servlets;

import db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet{
	public Connection connection=null;
	//lifecycle methods - init, service, destroy
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doGET method");

		//forward the control to the index.html
		req.getRequestDispatcher("/html/index.html").forward(req, resp);
	}

	@Override
	public void init() throws ServletException {

		//initialization activity - set up DB connection object
		System.out.println("in init method");
		connection = DBManager.getConnection();
	}

	@Override
	public void destroy() {
		System.out.println("in destroy method");

		//clean up activity - close DB connection object
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
