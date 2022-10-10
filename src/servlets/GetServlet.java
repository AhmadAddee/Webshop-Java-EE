package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The GetServlet class should be configured in the web.xml file.
 * Another alternative could be using annotation configuration
 * You go to localhost:8080/webStore/getServlet?name=...
 * */

@WebServlet("/getServlet")
public class GetServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value = req.getParameter("name");
		// The response returned to the web page.
		String htmlResponse = "<html><h3>Hello! I'm here in GetServlet class!!</h3></html>";
		// a Java IO package API which help writing response on a webpage.
		PrintWriter writer = resp.getWriter();
		writer.write(htmlResponse + " " + value);
	}
}
