<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	
	<jsp:directive.include file="header.jsp"/>
	<div align="center">
		<h2>Please login: </h2>
		<form action="">
			Email: <input type="text" size="10"><br/><br/>
			Passport: <input type="password" size="10"><br/><br/>
			<input type="submit" value="Login">
		</form>
	</div>
	
	<jsp:directive.include file="footer.jsp"/>

</body>
</html>