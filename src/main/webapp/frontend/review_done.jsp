<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Review Posted - Online Book Store </title>
	<style><%@include file="../css/style.css"%></style>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
		<div align="center">
				<table class="normal" width="60%">
					<tr>
						<td><h2> Your Reviews </h2></td>
						<td><h2>${loggedCustomer.fullname}</h2></td>
					</tr>
					<tr>
						<td colspan="3"><hr/></td>
					</tr>
					<tr>
						<td>
							 <span id="book-title">${book.title} </span>
							 <br/> 
							 <img class="book-small" src="data:image/jpg;base64, ${book.base64Image}"/>
						</td>
						<td colspan="2">
							<h3>Your review has been posted. Thank you!</h3>
						</td>
					</tr>
				</table>
		</div>
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>