<%@page import="kr.or.ddit.vo.MemberVO"%>
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
	MemberVO member = (MemberVO)request.getAttribute("member");
%>

<table border="1">
				<tr>
					<td>회원ID</td>
					<td>
						<%=member.getMem_id() %>
					</td>
				</tr>
				<tr>
					<td>회원이름</td>
					<td>
						<%=member.getMem_name() %>
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
						
					<td>
					<%=member.getMem_tel() %>
					</td>
				</tr>
				<tr>
					<td>회원주소</td>
						
					<td><%=member.getMem_addr() %>
					
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="button" value="수정" >
					<input type="button" value="돌아가기" >
					</td>
					
				</tr>
			
			</table>
</body>
</html>