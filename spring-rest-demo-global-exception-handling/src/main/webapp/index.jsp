<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring REST demo</title>
</head>
<body>
<h3>Spring REST demo</h3>
<hr>
<br>
<a href="${pageContext.request.contextPath }/test/hello">Hello</a>
<br>
<a href="${pageContext.request.contextPath }/api/students">Get All students</a>
</body>
</html>