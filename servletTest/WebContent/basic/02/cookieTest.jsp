<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
			for(Cookie c : cookies){
		%>		
			쿠키변수 : <%=c.getName() %><br>
			쿠키 값 : <%=URLDecoder.decode(c.getValue(),"utf-8") %><br>
		<%
			}
		}
	%>
	
	<a href="<%=request.getContextPath()%>/CookieAddServlet.do">cookie정보 저장 하기</a><br>
	<a href="<%=request.getContextPath()%>/CookieReadServlet.do">저장된 쿠키정보 확인하기</a><br>
	<a href="<%=request.getContextPath()%>/CookieDelServlet.do">저장된 쿠키정보 삭제하기</a><br>
	
	
</body>
</html>