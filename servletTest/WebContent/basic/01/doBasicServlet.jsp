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
	<a href="http://localhost/servletTest/servletTest03.do">Get 방식요청 1</a>
	<hr>
	
	<h2>get방식 요청 2<br>
	 ==> form의 submit방식<br>
	 ==> form태그의 method속성을 생략하거나 'get'으로 설정한 경우</h2>
	 <form action="http://localhost/servletTest/servletTest03.do" method="">
	 	<input type="submit" value="Get방식 요청2">
	 </form>	
	<hr>
	
	<h2>Post 방식 요청 1<br>
	==> form의 submit방식<br>
	==> form의 method속성을 'post'로 설정한 경우</h2>
	<form action="http://localhost/servletTest/servletTest03.do" method="post">
		<input type="submit" value="post 방식 요청">
	</form>
	

</body>
</html>