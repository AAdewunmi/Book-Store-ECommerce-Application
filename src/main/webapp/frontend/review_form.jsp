<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Write a Review - Online Book Store </title>
	<style><%@include file="../css/style.css"%></style>
	<script src="<c:url value="js/jquery-3.7.0.min.js" />"></script>
	<script src="<c:url value="js/jquery.validate.min.js" />"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
		<div align="center">
			<form>
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
						<td>
							<input type="text" name="headline" size="60" placeholder="Headline or Summary for your review (required)" />
							<br/>
							<br/>
							<textarea name="comment" rows="10" cols="64" placeholder="Write your review details ... "></textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
	<jsp:directive.include file="footer.jsp"/>
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