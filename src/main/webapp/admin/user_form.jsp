<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New User</title>
	<style><%@include file="../css/style.css"%></style>
	<script src="<c:url value="../js/jquery-3.7.0.min.js" />"></script>
    <script src="<c:url value="../js/jquery.validate.min.js" />"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2 class="pageheading">
			<c:if test="${user != null}">
				Edit User
			</c:if>
			<c:if test="${user == null}">
				Create New User
			</c:if>
		</h2>
	</div>

	<div align="center">
		<c:if test="${user != null}">
			<form action="update_user" method="post" id="userForm" style="max-width: 400px; margin: 0 auto;">
			<input type="hidden" name="userId" value=${user.userId}>
		</c:if>
		<c:if test="${user == null}">
			<form action="create_user" method="post"id="userForm" style="max-width: 400px; margin: 0 auto;">
		</c:if>
			<table class="form">
				<tr>
					<td align="right">Email:</td>
					<td align="left"><input type="text" id="email" name="email"
						size="20" value="${user.email}"></td>
				</tr>
				<tr>
					<td align="right">Full Name:</td>
					<td align="left"><input type="text" id="fullname"
						name="fullname" size="20" value="${user.fullName}"></td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" id="password"
						name="password" size="20" value="${user.password}"></td>
				</tr>
				<tr>
					<td>&nbsp<td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit">Save</button> &nbsp;&nbsp;&nbsp;
						<button type="button" onclick="history.go(-1);">Cancel</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<jsp:directive.include file="footer.jsp" />
	</body>
	
	<script type="text/javascript">
	$(document).ready(function() {
		$("#userForm").validate({
			rules: {
				email: {
					required: true,
					email: true
				},
		
				fullname: "required",
				
				<c:if test="${user == null}">
				password: "required"
				</c:if>
			},
			
			messages: {
				email: {
					required: "Please enter email",
					email: "Please enter an valid email address"
				},
				
				fullname: "Please enter full name",
				
				<c:if test="${user == null}">
				password: "Please enter password"
				</c:if>				
			}
		});
		
		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});
	</script>

</html>