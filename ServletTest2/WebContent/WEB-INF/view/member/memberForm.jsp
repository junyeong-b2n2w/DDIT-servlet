<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
	window.onload = function(){
		var check = document.getElementById("check");
		check.onclick = function(){
			id = document.getElementById("mem_id").value;
			window.open("<%=request.getContextPath()%>/member/memberSearch.do?id="+id, "id검색");
		}
		
		
		
		
	}
	
	</script>
	
	</head>
	
	<body>
		<h2>회원 정보 입력 폼</h2>
		<form action="<%=request.getContextPath()%>/member/memberInsert.do" method="post">
			<table border="1">
				<tr>
					<td>회원ID</td>
					<td>
						<input id="mem_id" name="mem_id">
						<input type="button" value="중복확인" id="check">
					</td>
				</tr>
				<tr>
					<td>회원이름</td>
					<td>
						<input id="mem_name" name="mem_name">
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>
						<input id="mem_tel" name="mem_tel">
					</td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td>
						<input id="mem_addr" name="mem_addr">
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="저장">
					<input type="reset" value="취소">
					</td>
					
				</tr>
			
			</table>
		</form>
	</body>
</html>