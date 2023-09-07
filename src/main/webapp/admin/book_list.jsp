<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Manage Users - Evergreen Bookstore Administration </title>
<style><%@include file="../css/style.css"%></style>
<script src="<c:url value="../js/jquery-3.7.0.min.js" />"></script>
<script src="<c:url value="../js/jquery.validate.min.js" />"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<div align="center">
		<h2 class="pageheading"> User Management Dashboard </h2>
		<h3><a href="user_form.jsp"> Create New User</a></h3>
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
				<th>Email</th>
				<th>Full Name</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="user" items="${listUsers}" varStatus="status">
				<tr>
	 				<td>${status.index + 1}</td>
	 				<td>${user.userId}</td>
	 				<td>${user.email}</td>
	 				<td>${user.fullName}</td>
	 				<td>
	 					<a href="edit_user?id=${user.userId}">Edit</a> &nbsp;
	 					<a href="javascript:void(0);" class="deleteLink" id="${user.userId}">Delete</a>
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
				userId = $(this).attr("id");
				if(confirm('Are you sure you want to delete user with ID ' + userId + ' ?')){
					window.location = 'delete_user?id=' + userId;
				}
			});
		});
	});
	</script>
</body>
</html>