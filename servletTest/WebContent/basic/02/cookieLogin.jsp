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
		String id ="";
		String check = "";
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
			for(Cookie c : cookies){
				if(c.getName().equals("id")){
					id = c.getValue();
					check = "checked";
				}
			}
		}
	%>

<form method="post" action="/servletTest/cookieLoginCheckServlet.do">
	아이디 : <input name="id" value="<%=id%>"><input type="checkbox" name="chkid" <%=check%>>id기억하기<br>
	비밀번호 : <input type="password" name="password"><br> 
	<input type="submit" value="확인">
</form>

</body>
</html>