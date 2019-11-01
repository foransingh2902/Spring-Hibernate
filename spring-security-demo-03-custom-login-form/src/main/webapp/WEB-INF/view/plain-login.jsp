<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- add jstl support -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Login Page</title>
</head>
<body>
<h3>My Custom Login Page</h3>
<hr>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
method="POST">
<c:if test="${param.error!=null }">
<i>Sorry! You entered invalid username/password</i>
</c:if>



<!-- loginProcessingUrl("/authenticateTheUser") from our DemoSecurityConfig -->
<p>
<!-- spring security will read default "username" and "password", so we can't change their name -->
User name :  <input type="text" name="username"><br>
Password : <input type="password" name="password">
</p>
<input type="submit" value="Login"/>
</form:form>
<hr>
</body>
</html>