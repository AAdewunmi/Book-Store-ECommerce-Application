<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Evergreen Books - Online Books Store</title>
<style><%@include file="../css/style.css"%></style>
</head>
<body>

	<jsp:directive.include file="header.jsp"/>
	
	<div class="center">
		<div>
			<h2>New Books: </h2>
				<c:forEach items="${listNewBooks}" var="book">
					<jsp:directive.include file="book_group.jsp" />
				</c:forEach>
	</div>
		<div class="next_row">
			<h2>Best-Selling Books: </h2>
					<c:forEach items="${listBestSellingBooks}" var="book">
					<jsp:directive.include file="book_group.jsp" />	
					</c:forEach>
		</div>
		<div class="next_row">
			<h2>Most - Favoured Books: </h2>
					<c:forEach items="${listMostFavoredBooks}" var="book">
					<jsp:directive.include file="book_group.jsp" />	
					</c:forEach>
		</div>
		<br>
	</div>

	<jsp:directive.include file="footer.jsp"/>
	
</body>
</html>