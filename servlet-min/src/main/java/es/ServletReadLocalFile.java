package es;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletReadLocalFile")
public class ServletReadLocalFile extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServletContext contexto = request.getServletContext();
		PrintWriter pw = response.getWriter();
		File f = new File(contexto.getRealPath("hola.txt"));

		BufferedReader lectorCadenas = new BufferedReader(new FileReader(f));
		String mensaje = lectorCadenas.readLine();
		lectorCadenas.close();
		pw.print(mensaje);
		pw.close();

	}

}
