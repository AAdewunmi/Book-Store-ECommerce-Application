<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Your Shopping Cart Details</title>
	<style><%@include file="../css/style.css"%></style>
	<script src="<c:url value="js/jquery-3.7.0.min.js" />"></script>
	<script src="<c:url value="js/jquery.validate.min.js" />"></script>
	
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<div align="center">
		<h2>Your Shopping Cart Details</h2>
		<div>
			<c:if test="${message != null}">
			<div align="center">
				<h4 class="message">${message}</h4>
			</div>
		</c:if>
		<c:set var="cart" value="${sessionScope['cart']}" />
		<c:if test="${cart.totalItems == 0}">
			<h2>There's no items in your cart</h2>
		</c:if>
		<c:if test="${cart.totalItems > 0}">
			<form action="update_cart" method="post" id="cartForm">
				<div>
					<table border="1">
						<tr>
							<th>No</th>
							<th colspan="2">Book</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Subtotal</th>
							<th></th>
						</tr>
						<c:forEach items="${cart.items}" var="item" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>
								<img class="book-small"
									src="data:image/jpg;base64, ${item.key.base64Image}"/>
								</td>
								<td><span id="book-title">${item.key.title}</span></td>
								<td>
									<input type="hidden" name="bookId" value="${item.key.bookId}" />
									<input type="text" name="quantity${status.index + 1}" value="${item.value}" size="5" /></td>
								<td><fmt:formatNumber value="${item.key.price}"
										type="currency" /></td>
								<td><fmt:formatNumber
										value="${item.value * item.key.price}" type="currency" /></td>
								<td><a href="remove_from_cart?book_id=${item.key.bookId}">Remove</a></td>
							</tr>
						</c:forEach>

						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td><b>${cart.totalQuantity} book(s)</b></td>
							<td>Total:</td>
							<td colspan="2"><b><fmt:formatNumber
										value="${cart.totalAmount}" type="currency" /></b></td>
						</tr>
					</table>
				</div>
				<div>
					<table class="normal">
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td></td>
							<td><button type="submit">Update</button></td>
							<td><input type="button" id="clearCart" value="Clear Cart"/></td>
							<td><a href="${pageContext.request.contextPath}/">Continue Shopping</a></td>
							<td><a href="checkout">Checkout</a>
						</tr>
					</table>
				</div>
			</form>
		</c:if>
		</div>
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