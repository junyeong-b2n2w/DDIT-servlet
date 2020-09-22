package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//Request객체 관련 예제

@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식으로 전달되는 데이터의 인코딩 방식 설정
		request.setCharacterEncoding("utf-8");
		
		//getparameter("파라미터명") ==> 해당 파라미터에 설정된 '값'을 가져온다.
		//							==> 가져오는 '값'의 자료형은  String 이다.
		//	이 '파라미터명'은 <form>태그의 하위 태그에 만들어진 태그의'name속성값'을 의미한다.
		String userName = request.getParameter("userName");
		
		String job = request.getParameter("job");
		
		//getParameteValues("파라미터명")  ==> 파라미터명이 같은 것이 여러개 일 경우에 사용한다.
		//								==> 가져오는 '값'의 자료형은 'String 배열'이다
		String[] hobbies = request.getParameterValues("hobby");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Requset 객체 연습 </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>request 객체 테스트 결과</h2>");
		out.println("<hr>");
		
		out.println("<table>");
		out.println("<tr><td>이름</td>");
		out.println("<td>" + userName + "</td></tr>");
		out.println("<tr><td>직업</td>");
		out.println("<td>" + job + "</td></tr>");
		out.println("<tr><td>취미</td>");
		out.println("<td>");
		//배열 개수만큼 반복문을 이용해서 출력한다.
		for(String hobby : hobbies){
			out.println(hobby + "<br>");
		}
		
		out.println("</td></tr>");
		out.println("</table>");
		
		out.println("<hr>");
		
		out.println("<h2>request객체 기타메서드 결과</h2>");
		out.println("<table boder='1'><tr><td>");
		out.println("1.클라이언트의 IP주소 : "+ request.getRemoteAddr()+ "<br>");
		out.println("2.요청 메서드 : "+ request.getMethod()+ "<br>");
		out.println("3.ContextPath : "+ request.getContextPath()+ "<br>");
		out.println("4.프로토콜 : "+ request.getProtocol()+ "<br>");
		
		out.println("</td></tr></table>");
		
		
		out.println("</body>");
		out.println("</html>");
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
