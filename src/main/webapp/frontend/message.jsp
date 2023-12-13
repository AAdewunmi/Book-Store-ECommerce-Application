<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><%@include file="../css/style.css"%></style>
<title> Evergreen Bookstore - Online Book Store </title>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
		<br>
			<h3> ${message}</h3>
		<br>
	</div>
	
	
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>