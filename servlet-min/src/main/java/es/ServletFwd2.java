package es;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/samples/servletFwd2" })
public class ServletFwd2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Set the response message's MIME type
		response.setContentType("text/html;charset=UTF-8");
		// Allocate a output writer to write the response message into the
		// network socket
		PrintWriter out = response.getWriter();

		try {
			// Get parameters
			String name = request.getParameter("name");
			out.print("Welcome " + name);
			out.println("<p style=\"font-size: 60%; text-align: center;\"><a href=\"../\">HOME</a></p>");
			out.println(
					"<p style=\"font-size: 60%; text-align: center;\"><a href=\"./samples.html\">SAMPLES</a></p>");

		} finally {
			out.close(); // Always close the output writer
		}
	}

	// doPost() handles POST request
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response); // call doGet()
	}
}
