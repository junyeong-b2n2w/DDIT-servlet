<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		로그인이 성공하면 
			~~~ 님 안녕하세요.
			
		로그아웃 버튼
		
		로그인이 실패하면
			alert("로그인 실패");
			이전 페이지로 이동
	 -->

<%
	String userId = (String)session.getAttribute("memId");
	
	if(userId!=null){%>
		<%=userId %>님 안녕하세요.		
		<a href="<%=request.getContextPath()%>/SessionLogoutServlet.do">로그아웃</a>
	<%}else{%> 
		<script>alert("로그인실패");
				history.back();
		</script>
		
	<%
	}
	%>




</body>
</html>