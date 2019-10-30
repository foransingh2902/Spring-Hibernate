<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Add support for Spring MVC form tags first -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Form</title>
</head>
<body>
	
		<div>
			<h2>CRM- customer Relationship Manager</h2>
		</div>
	
	<div>
	<h3>Save Customer</h3>
	<!-- action will send the data to saveCustomer, modelAttribute name 'customer' is same
	we have given in controller with same name 'customer' so it data added
	will be mapped to that Model attribute and that data is used to populate the form.
	When form is loaded, Spring MVC will call:
	customer.getFirstname()
	customer.getLastName()
	
	 -->
	<form:form action="saveCustomer" modelAttribute="customer" method="POST">
	<!-- need to associate this data with customer id -->
	<!-- when this form is loaded this will talk to 'customer' and call
	customer.getId and when form is submitted it will call customer.setId.
	This is imp as with this he back end will come to know on which customer ID
	the update is to be performed
	  -->
	<form:hidden path="id"/>
	
	
	<table>
	<tr>
	<td>First Name</td>
	<td><form:input path="firstName"/></td>
	</tr>
	<tr>
	<td>Last Name</td>
	<td><form:input path="lastName"/></td>
	</tr>
	<tr>
	<td>Email</td>
	<td><form:input path="email"/></td>
	</tr>
	<tr>
	<td></td>
	<td><input type="submit" value="Save"></td>
	</tr>
	</table>
	</form:form>
	<p>
	<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
	</p>
	</div>
</body>
</html>