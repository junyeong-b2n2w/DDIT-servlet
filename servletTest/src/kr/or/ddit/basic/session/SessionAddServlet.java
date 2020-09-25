package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionAddServlet
 */
@WebServlet("/SessionAddServlet.do")
public class SessionAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Session 저장하는 방법
		
		
		// 1. Session 객체 구한다.
		// 형식1) request객체.getSession(); 또는 request객체.getSession(true);
		//		==> 현재 세션이 있으면 현재세션 반환, 없으면 새로운 세션생성해서 반환
		// 형식2) request객체.getSession(false);
		//		==> 현재 세션이 있으면 현재 세션 반환, 없으면 null 반환
		
		HttpSession session = request.getSession();
		
		// 2. setAttribute() 메서드를 사용해서 Session값 저장
		// 형식) session객체.setAttribute("세션키값",세션값);
		// 		=> 세션키값은 문자열, 세션값은 모든 데이터
		session.setAttribute("testSession", "연습용세션입니다.");
		session.setAttribute("userName", "hong");
		session.setAttribute("age", "222");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Session연습</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Session 데이터가 저장되었습니다ㅣ.</h2>");
		out.println("<a href='" +request.getContextPath()+
				"/basic/03/sessionTest.jsp'>시작 문서로 이동 </a>");
		
		
		
		
		out.println("</body>");
		out.println("</html>");

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
