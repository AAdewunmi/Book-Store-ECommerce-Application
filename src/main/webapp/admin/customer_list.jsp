<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Manage Customers - Evergreen Bookstore Administration </title>
<style><%@include file="../css/style.css"%></style>
<script src="<c:url value="../js/jquery-3.7.0.min.js" />"></script>
<script src="<c:url value="../js/jquery.validate.min.js" />"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<div align="center">
		<h2 class="pageheading"> Customers Management Dashboard </h2>
		<h3><a href="new_customer"> Create New Customer</a></h3>
	</div>
	
	<c:if test="${message != null}">
		<div align="center">
			<h4 class="message">${message}</h4>
		</div>
	</c:if>
	
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>E Mail</th>
				<th>Full Name</th>
				<th>City</th>
				<th>Country</th>
				<th>Registered Date</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="customer" items="${listCustomer}" varStatus="status">
				<tr>
	 				
	 				<td>${status.index + 1}</td>
	 				<td>${customer.customerId}</td>
	 				<td>${customer.email}</td>
	 				<td>${customer.fullname}</td>
	 				<td>${customer.city}</td>
	 				<td>${customer.country}</td>
	 				<td>${customer.registerDate}</td>
	 				<td>
	 					<a href="edit_customer?id=${customer.customerId}">Edit</a> &nbsp;
	 					<a href="javascript:void(0);" class="deleteLink" id="${customer.customerId}">Delete</a>
	 				</td>
 				
 				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:directive.include file="footer.jsp"/>
	<script type="text/javascript">
	$(document).ready(function(){
		$(".deleteLink").each(function(){
			$(this).on("click", function(){
				bookId = $(this).attr("id");
				if(confirm('Are you sure you want to delete book with ID ' + bookId + ' ?')){
					window.location = 'delete_book?id=' + bookId;
				}
			});
		});
	});
	</script>
</body>
</html>