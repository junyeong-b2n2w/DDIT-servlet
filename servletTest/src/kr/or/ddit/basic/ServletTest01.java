package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//이 예제는 패포서술자(DD. Deployment Descriptor ==> web.xml 파일을 이용해서 실행하는 예제이다


// http://localhost:포트번호/웹어플리캐이션명(프로젝트명)/문서명


//Servlet 클래스는 HttpServlet을 상속해서 작성한다
public class ServletTest01 extends HttpServlet{
	//이곳에서는 대부분 doGot()메서드나 doPost()메서드를 재정의해서 작성한다.
	// service()메서드를 재정의해서 작성하는 방법도 있다.
	
	//doGet()메서드나 doPost()메서드에서는 service()메서드를 통해서 호출된다.
	// 이 메서드에는 다음과 같은 객체를 매개변수로 갖는다.
	//1) HttpServletRequest객체 ==> 서비스 요청에 관련된 정보 및 메서드를 관리하는 객체
	//2) HttpServletResponse객체 ==> 서비스 응답에 관련된 정보 및 메서드를 관리하는 객체
	
	
	//doGet()메서드 ==> get방식으로 요청을 처리하는 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		//처리한 내용을 응답으로 보내기 위해서 PrintWriter객체를 생성한다.
		PrintWriter out = resp.getWriter();
		
		// 처리한 내용을 출력한다.
		out.append("<html>")
			.append("<head>")
			.append("<meta charset='utf-8'>")
			.append("<title>첫번째 Servlet 연습</title>")
			.append("</head>")
			.append("<body>")
			.append("<h1 style='text-align:center'>")
			.append("안녕하세요 .첫번째Servlet프로젝트입니다.<br>")
			.append("Server 정보 : " + req.getContextPath())
			.append("</h1>")
			.append("</body>")
			.append("</html>");
					
				
					
	}
	
	
	//doPost()메서드 ==> post방식의 요청을 처리하는 메서드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
