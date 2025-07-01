package attr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import java.io.PrintWriter;

import java.util.List;
import java.util.ArrayList;

/**
 * Servlet implementation class SetContextServlet
 */
@WebServlet("/cset")
public class SetContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	public void init() {
		System.out.print("set init()");
	}

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
		ServletContext context = getServletContext();
		
		List member = new ArrayList();
		member.add("이순신");
		member.add(30);
		context.setAttribute("member", member);

		out.print("<html><body>");
		out.print("이순신과 30 설정");
		out.print("<body><html>");
	}
}
