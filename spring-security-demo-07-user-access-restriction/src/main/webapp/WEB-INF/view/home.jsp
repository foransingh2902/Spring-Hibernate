<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h2>Company home page</h2>
<hr>
<p>
Welcome to the company home page!
</p>
<hr>
<!-- display user name and role -->
<p>
<!-- principal.username will display user id i.e. username in this case-->
User: <security:authentication property="principal.username"/>
<br><br>
<!-- principal.authorities will display the user roles -->
User roles: <security:authentication property="principal.authorities"/>
<!--  during the display, by default, Spring Security uses "ROLE_" prefix. This is configurable -->
</p>
<hr>
<!-- Add a link to /leaders.. this is for the managers -->
<p>
<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
(Only for Manager people)
</p>
<hr>
<!-- Add a link to /systems.. this is for the admins -->
<p>
<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
(Only for Administration people)
</p>



<hr>
<!-- add a logout button -->
<form:form action="${pageContext.request.contextPath}/logout" 
method="POST">
<input type="submit" value="Logout">
</form:form>
</body>
</html>