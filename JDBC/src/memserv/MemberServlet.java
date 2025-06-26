package memserv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Date;

import java.util.List;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException {
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet Call");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		
		String command = request.getParameter("command");
		if(command != null && command.contentEquals("addMember")) {
			String _id = request.getParameter("id");
			String _pwd = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");
			
			MemberVO _memberVO = new MemberVO();
			_memberVO.setId(_id);
			_memberVO.setPwd(_pwd);
			_memberVO.setName(_name);
			_memberVO.setEmail(_email);
			
			dao.addMember(_memberVO);
		}
		else if(command != null && command.contentEquals("delMember")) {
			String _id = request.getParameter("id");
			dao.delMember(_id);
		}
		
		
		List<MemberVO> list = dao.listMembers();
		

		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><tr>");
		
		for(int i=0;i<list.size();++i) {

			String id = list.get(i).getId();
			String pwd = list.get(i).getPwd();
			String name = list.get(i).getName();
			String email = list.get(i).getEmail();
			Date joinDate = list.get(i).getJoinDate();
			
			
			out.print("<tr><td>"+ id + "</td>" +
					"<td>"+ pwd + "</td>" +
					"<td>"+ name +"</td>" +
					"<td>"+ email +"</td>" +
					"<td>"+ joinDate + "");	
			out.print("<a href='/JDBC/member?command=delMember&id="+ id +"'>삭제</a></td><tr>");
		}
		out.print("</table>");
		out.print("<body><html>");
		out.print("<a href='/JDBC/MemberForm.html'>새 회원 등록</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
