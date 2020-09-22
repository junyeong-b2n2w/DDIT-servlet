package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션(@WebServlet)을 이용한 Servlet 처리 예제
//어노테이션(@WebServlet)은 Servlet 버전 3.0이상에서 사용할 수 있다.

//(@WebServlet) 어노테이션의 속성들
//1. name : 서블릿의 이름을 설정한다 (기본값: 빈문자열(""))
//2. urlPatterns : 서블릿의 URL패턴의 목록을 설정한다.(기본값 : 빈배열 ( {} ))
//			예) urlPatterns="/url1"  또는  urlPatterns = {"/url1"} ==> 패턴이 한개인경우
//			예) urlPatterns={"/url1","/url2", ...} => 패턴이 2개 이상일 경우
//3. value : urlPatterns와 동일한 기능을 한다.
//4. description : 주석(설명글)을 설정한다. 

@WebServlet(urlPatterns = { "/servletTest02.do" }, description = "애너테이션을 이용한 서블릿 예제")
public class ServletTest02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// 처리한 내용을 응답으로 보내기 위해서 PrintWriter객체를 생성한다.
		PrintWriter out = response.getWriter();

		// 처리한 내용을 출력한다.
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>2번째 Servlet 연습</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 style='text-align:center'>");
		out.println("안녕하세요 .2번째Servlet프로젝트입니다.<br>");
		out.println("Server 정보 : " + request.getContextPath());
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

}
