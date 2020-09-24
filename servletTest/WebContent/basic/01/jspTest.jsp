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
// 이영역은 java영역입니다.


//JSP문서에서 requset는 HttpServletRequest객체의 참조값이 저장된 변수이다.
//			response는 HttpServletResponse객체의 참조값이 저장된 변수이다.
request.setCharacterEncoding("utf-8");
String username = request.getParameter("username");
String tel = request.getParameter("tel");
String tel2 = (String)request.getAttribute("tel");

String name = "test";
String color = "red";
out.println("이름  : " + name);
%>	

<br>
<!-- jsp영역에서 만든 변수의 값이나 식의 결과를 바로 출력하기 -->
<div style="background-color :<%=color %>">이름 : <%=name %> </div>
<div style="background-color :<%=color %>">이름 : <%=username %> </div>
<div style="background-color :<%=color %>">전화 : <%=tel %> </div>
<div style="background-color :<%=color %>">전2 : <%=tel2 %> </div>



</body>
</html>