package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/LoginCheckServlet.do")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String chkid = request.getParameter("chkid");
		if(chkid.equals("true")){
			Cookie idCookie = new Cookie("id", id);
			response.addCookie(idCookie);
		}
		
		
		if(id.equals("admin") && pw.equals("1234")){
			response.sendRedirect("/servletTest/basic/01/main.jsp?id="+id);
		}else{
			response.sendRedirect("/servletTest/basic/01/login.jsp");
		}
		
	}

}
