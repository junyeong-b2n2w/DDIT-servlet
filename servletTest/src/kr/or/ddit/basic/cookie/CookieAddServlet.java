package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieAddServlet.do")
public class CookieAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		
		//Cookie 저장하는 방법
		//1. Cookie 객체를 생성한다.
		//   형식) Cookie cookie변수 = new Cookie("쿠키변수","쿠키값");
		//			=> '쿠키변수'와 '쿠키값' 은 문자열로 지정한다.
		//			=> '쿠키값'으로 한글을 사용할 경우 URLEncoder.encode()메서드로 인코딩후 사용
		
		Cookie nameCookie = new Cookie("name",URLEncoder.encode("홍길동","utf-8"));
		Cookie ageCookie = new Cookie("age", "24");
		Cookie genderCookie = new Cookie("gender", "Male");
		
		//2. respons 객체를 이용하여 쿠키를 웹브라우저로 보낸다.
		// 		그러면 웹브라우저가 이 쿠키를 받아서 저장한다.
		// 형식 ) response.addCooke(1번에서 만든 cookie객체);
		
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		response.addCookie(genderCookie);
	
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>쿠키연습 </title></head>");
		
		
		out.println("<body>");
		out.println("<h2>Cookie 데이터가 저장되었습니다.</h2><br><br>");
		out.println("<a href='" + request.getContextPath()
				+ "/basic/02/cookieTest.jsp'>시작문서로 이동</a>");
		out.println("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
