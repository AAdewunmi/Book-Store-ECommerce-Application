<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books in ${category.name} - Online Books Store</title>
<style><%@include file="../css/style.css"%></style>
</head>
<body>

	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
		<br>
		<h3> ${category.name} </h3>
		<br>
	</div>
	
	<div align="center">
		<c:forEach items="${listBooks}" var="book">
			<div>
				<div>
					<img src="data:image/jpg;base64, ${book.base64Image}" width="128" height="164">
				</div>
				<div>${book.title}</div>
			</div>
		</c:forEach>
	</div>

	<jsp:directive.include file="footer.jsp"/>
	
</body>
</html>