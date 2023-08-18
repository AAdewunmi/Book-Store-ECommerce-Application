<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Administrator Login</title>
	<style><%@include file="../css/style.css"%></style>
	<script src="<c:url value="../js/jquery-3.7.0.min.js" />"></script>
	<script src="<c:url value="../js/jquery.validate.min.js" />"></script>
</head>
<body>
	<div align="center">
		<h1>Book Store Administration</h1>
	<h2>Administrator Login</h2>
	<form id="loginForm" action="login" method="post">
		<table>
			<tr>
				<td>Email: </td>
				<td><input type="text" name="email" id="email" size="20"></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password" id="password" size="20"></td>
			</tr>
			<tr>
				<td colspan="10" align="center"><button type="submit">Login</button></td>
			</tr>
		</table>
	</form>
	</div>
</body>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#loginForm").validate({
				rules:{
					email: {
						required: true,
						email: true,
					},
					password: "required",
				},
				messages:{
					email: {
						required: "Please enter email",
						email: "Please enter a valid email address",
					},
					password: "Enter password",
				}
			});
		});
	</script>
</html>