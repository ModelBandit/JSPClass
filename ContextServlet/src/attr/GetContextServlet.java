package attr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.ServletContext;
import java.util.List;
import java.util.ArrayList;

import java.io.PrintWriter;

/**
 * Servlet implementation class GetContextServlet
 */
@WebServlet("/cget")
public class GetContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext sc = getServletContext();
		List member = (ArrayList)sc.getAttribute("member");

		String name = (String)member.get(0);
		int age = (int)member.get(1);

		out.print("<html><body>");
		out.print(name);
		out.print(age);
		out.print("<body><html>");
	}

}
