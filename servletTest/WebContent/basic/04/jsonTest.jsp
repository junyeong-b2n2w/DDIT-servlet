<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>

<script src="../../js/jquery-3.5.1.min.js"></script>

<script>
$(function(){
	$("#btn1").on("click", function(){
		//문자열 처리
// 		$.ajax({
<%-- 			"url" : "<%=request.getContextPath()%>/JSONTestServlet.do", --%>
// 			"type" : "post",
// 			"success" : function(data){
// 				$("#result").html("ajax 처리 데이터 : "  +data);
// 			},
// 			"dataType" :"json"
// 		});
		
		//배열처리
// 		$.ajax({
<%-- 			"url" : "<%=request.getContextPath()%>/JSONTestServlet.do", --%>
// 			"type" : "post",
// 			"success" : function(data){
// 				var str = "";
// 				$.each(data, function(i,v){
// 					str += i +"번째 자료 :  "  + v + "<Br>";
// 				});
// 				$("#result").html(str);
// 			},
// 			"dataType" :"json"
// 		});
// 	});
	
	//객체 처리
// 	$.ajax({
<%-- 			"url" : "<%=request.getContextPath()%>/JSONTestServlet.do", --%>
// 			"type" : "post",
// 			"success" : function(data){
// 				var str = "";
				
// 					str += "ID : " + data.id + "<br>";
// 					str += "NAME : " + data.name + "<br>";
			
// 				$("#result").html(str);
// 			},
// 			"dataType" :"json"
// 		});
	
	//List 컬렉션을 응답 처리
		$.ajax({
			"url" : "<%=request.getContextPath()%>/JSONTestServlet.do",
			"type" : "post",
			"success" : function(data){
				var str = "";
				$.each(data, function(i,v){
					str += "ID : " + data[i].id + "<br>";
					str += "NAME : " + data[i].name + "<hr>";
				});
				$("#result").html(str);
			},
			"dataType" :"json"
		});
	
	
	
	});
	
});
</script>

</head>
<body>
	<button id ="btn1">JSON 데이터 가져오기</button>
	<hr>
	<h3>가져온 데이터</h3>
	<div id="result">
	
	</div>
</body>
</html>