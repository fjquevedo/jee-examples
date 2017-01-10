package es;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/samples/servletFwd1" })
public class ServletFwd1 extends HttpServlet {

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

			if (name.equals("servlet")) {
				RequestDispatcher rd = request.getRequestDispatcher("/samples/servletFwd2");
				rd.forward(request, response);
			} else {
				out.print("Sorry UserName Error! Try with 'servlet'");
				RequestDispatcher rd = request.getRequestDispatcher("/samples/samples.html");
				rd.include(request, response);
			}

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
