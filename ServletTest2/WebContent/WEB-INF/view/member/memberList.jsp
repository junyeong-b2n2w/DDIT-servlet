<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<thead>
		<tr>
			<th>ID</th> <th>이름</th> <th>전화</th> <th>주소</th>
		</tr>
	</thead>
	<tbody>
	
	<%
		List<MemberVO> memList =
			(List<MemberVO>) request.getAttribute("memList");
		for(MemberVO memVo : memList){
			
			%>
			<tr>
			
				<td><%=memVo.getMem_id()%></td>
				<td><%=memVo.getMem_name()%></td>
				<td><%=memVo.getMem_tel()%></td>
				<td><%=memVo.getMem_addr()%></td>
			</tr>
			
			
			<%
		}
	%>
	
	</tbody>
	
	
	
</table>
</body>
</html>