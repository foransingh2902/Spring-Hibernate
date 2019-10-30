<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- remember to add taglib for jstl support -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>
</head>
<body>
	<div>
		<h2>CRM - Customer Relationship Manager</h2>
	</div>
	<div>
	<!-- put new button: Add Customer -->
	<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;">
	<!-- will call our Spring Controller mapping showFormForAdd-->
		<!-- add our html table here -->
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<!-- loop over and print our customers -->
			<c:forEach var="tempCustomer" items="${customers }">
			<!-- construct an "update" link with customer id -->
			<c:url var="updateLink" value="/customer/showFormForUpdate">
				<c:param name="customerId" value="${tempCustomer.id}"></c:param>
			</c:url>
			<!-- construct an "delete" link with customer id -->
			<c:url var="deleteLink" value="/customer/delete">
				<c:param name="customerId" value="${tempCustomer.id}"></c:param>
			</c:url>
			
				<!-- customers is actually  the attribute name from our spring MVC model-->
				<tr>
					<td>${tempCustomer.firstName }</td>
					<!-- this will call as tempCustomer.getFirstName(), tempCustomrt.getLastName,tempCustomer.getEmail() in background -->
					<td>${tempCustomer.lastName }</td>
					<td>${tempCustomer.email }</td>
					<td>
					<!-- display the update link: used the variable defined above -->
					<a href="${updateLink}">Update</a>
							|
						<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
					</td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>