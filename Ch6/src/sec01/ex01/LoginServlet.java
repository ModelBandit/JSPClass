package sec01.ex01;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	public void init() throws ServletException{
		System.out.println("init 메서드 호출");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		System.out.println("doGet 메서드 호출");
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println("아이디" + user_id);
		System.out.println("비밀번호" + user_pw);
	}
	
	public void destroy() {
		System.out.println("destory 메서드 호출");
	}
}
