<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Servlet 요청 연습</h1>
	<hr>
	
	<h2>get방식 요청 1 ==> 링크방식</h2>
	<a href="http://localhost/servletTest/WrapperTestServlet.do">Get 방식요청 1</a>
	<hr>
	<form action="http://localhost/servletTest/WrapperTestServlet.do">
		id : <input type="text" name="mem_id"><Br>
		nm : <input type="text" name="mem_name"><Br>
		pw : <input type="password" name="mem_pass"><Br>
		<input type="submit" value="확인">
		<input type="reset" value="취소">
	</form>
	

</body>
</html>