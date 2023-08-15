<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrator Login</title>
<style><%@include file="../css/style.css"%></style>
</head>
<body>
	<div align="center">
		<h1>Book Store Administration</h1>
	<h2>Administrator Login</h2>
	<form id="formLogin" action="login" method="post">
		<table>
			<tr>
				<td>Email: </td>
				<td><input type="text" name="email" id="email" size="20"></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="text" name="password" id="password" size="20"></td>
			</tr>
			<tr>
				<td colspan="10" align="center"><button type="submit">Login</button></td>
			</tr>
		</table>
	</form>
	</div>
	
</body>
</html>