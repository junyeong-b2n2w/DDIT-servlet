<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Session 연습용 main page 입니다</h2>
	
<%
	if(session.getAttribute("memId") != null){
%>
	<a href="<%=request.getContextPath()%>/SessionLogoutServlet.do">Logout</a>
<%
	}else{
%>
	<a href="<%=request.getContextPath()%>/SessionLoginServlet.do">Login</a>
<%
}
%>
</body>
</html>