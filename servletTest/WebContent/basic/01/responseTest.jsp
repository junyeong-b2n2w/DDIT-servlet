<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>sendRedirect와 forward 연습</h2>
<hr>
<form method="post" action="/servletTest/ResponseTest01.do">
	sendRedirct : <input type="text" name="username">
	<input type="submit" value="확인">
</form>
<hr>
<form method="post" action="/servletTest/ResponseTest02.do">
	forward : <input type="text" name="username">
	<input type="submit" value="확인">
</form>
<hr>


</body>
</html>