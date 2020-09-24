<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="/servletTest/LoginCheckServlet.do">
	아이디 : <input name="id"><br>
	비밀번호 : <input type="password" name="password"><br>
	<input type="submit" value="확인">
</form>

</body>
</html>