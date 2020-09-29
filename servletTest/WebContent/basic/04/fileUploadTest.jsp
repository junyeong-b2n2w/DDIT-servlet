<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>File upload / download</title>
</head>
<body>
<h3>File upload 연습</h3>

<form method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/FileUploadServlet.do">
	파일 1 <input type="file" name="fileUpload1" multiple><br>
	파일 2 <input type="file" name="fileUpload2"><br>
	<input type="submit" value="파일전송">
</form>

<hr>
<a href="<%=request.getContextPath()%>/UploadFileListServlet.do">업로드된 파일보기</a>

</body>
</html>