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
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
		<div align="center">
			<form id="reviewForm" action="submit_review" method="post">
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
							<div id="rateYo"></div>
							<input type="hidden" id="rating" name="rating" />
							<input type="hidden" name="bookId" value="${book.bookId}"/>
							<br/>
							<input type="text" name="headline" size="60" placeholder="Headline or Summary for your review (required)" />
							<br/>
							<br/>
							<textarea name="comment" rows="10" cols="64" placeholder="Write your review details ... "></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="center">
							<button type="submit">Submit</button>
							&nbsp;&nbsp;
							<button>Cancel</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
	<jsp:directive.include file="footer.jsp"/>
</body>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#reviewForm").validate({
				rules:{
					headline: "required",
					comment: "required",
				},
				messages:{
					headline: "Please enter headline",
					comment: "Please enter review details",
				}
			});
			$("#rateYo").rateYo({
			    startWidth: "40px",
			    fullStar: true,
			    onSet: function (rating, rateYoInstance){
			    	$("#rating").val(rating);
			    }
			});
		});
	</script>
</html>