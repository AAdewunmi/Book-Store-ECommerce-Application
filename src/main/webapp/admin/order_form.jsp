<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Edit Order Details - Evergreen Bookstore </title>
<style><%@include file="../css/style.css"%></style>
<script src="<c:url value="../js/jquery-3.7.0.min.js" />"></script>
<script src="<c:url value="../js/jquery.validate.min.js" />"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<div align="center">
		<h2 class="pageheading"> Edit Order ID: ${order.orderId} </h2>
	</div>
	
	<c:if test="${message != null}">
		<div align="center">
			<h4 class="message">${message}</h4>
		</div>
	</c:if>
	<form action="update_order" method="post" id="orderForm">
	
	
		<div align="center">
			<table>
				<tr>
					<td><b>Order By: </b></td>
					<td>${order.customer.fullname}</td>
				</tr>			
				<tr>
					<td><b>Order Date: </b></td>
					<td>${order.orderDate}</td>
				</tr>
				<tr>
					<td><b>Recipient Name: </b></td>
					<td><input type="text" name="recipientName" value="${order.recipientName}" size="45"/></td>
				</tr>
				<tr>
					<td><b>Recipient Phone: </b></td>
					<td><input type="text" name="recipientPhone" value="${order.recipientPhone}" size="45"/></td>
				</tr>			
				<tr>
					<td><b>Ship To: </b></td>
					<td><input type="text" name="shippingAddress" value="${order.shippingAddress}" size="45"/></td>
				</tr>
				<tr>
					<td><b>Payment Method: </b></td>
					<td>
						<select name="paymentMethod">
							<option value="DebitCard">${order.paymentMethod}</option>
							<option value="CreditCard">Credit Card</option>
							<option value="CashOnDelivery">Cash On Delivery</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><b>Order Status: </b></td>
					<td>
						<select name="paymentMethod">
							<option value="Processing">${order.status}</option>
							<option value="Shipping">Shipping</option>
							<option value="Delivered">Delivered</option>
							<option value="Completed">Completed</option>
							<option value="Cancelled">Cancelled</option>
						</select>
					</td>
				</tr>																
			</table>
		</div>
		<div align="center">
			<h2>Ordered Books</h2>
			<table border="1">
				<tr>
					<th>Index</th>
					<th>Book Title</th>
					<th>Author</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Subtotal</th>
					<th></th>
				</tr>
				<c:forEach items="${order.orderDetails}" var="orderDetail" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>
						<img style="vertical-align: middle;" src="data:image/jpg;base64,${orderDetail.book.base64Image}" width="48" height="64" />
						${orderDetail.book.title}
					</td>
					<td>${orderDetail.book.author}</td>
					<td><fmt:formatNumber value="${orderDetail.book.price}" type="currency" /></td>
					<td>
						<input type="text" name="recipientPhone" value="${orderDetail.quantity}" size="5"/>
					</td>
					<td><fmt:formatNumber value="${orderDetail.subtotal}" type="currency" /></td>
					<td><a href="remove_book_from_order?id=${orderDetail.book.bookId}">Remove</a></td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="right">
						<b><i>TOTAL:</i></b>
					</td>
					<td>
						<b>${order.bookCopies}</b>
					</td>
					<td>
						<b><fmt:formatNumber value="${order.total}" type="currency" /></b>
					</td>
					<td></td>
				</tr>
			</table>
		</div>	
		<div align="center">
			</br>
			<a href="javascript:showAddBookPopup()">Add Books</a>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<input type="submit" value="Save"/>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<input type="button" value="Cancel" onclick="javascript:window.location.href='list_order';"/>
		</div>
	
	</form>	
	
	<jsp:directive.include file="footer.jsp"/>
	
	<script>
		function showAddBookPopup() {
			var width = 600;
			var height = 250;
			var left = (screen.width - width) / 2;
			var top = (screen.height - height) / 2;
			
			window.open('add_book_form', '_blank', 
					'width=' + width + ', height=' + height + ', top=' + top + ', left=' + left);
		}
		
		$(document).ready(function() {
			$("#orderForm").validate({
				rules: {	
					recipientName: "required",
					recipientPhone: "required",
					shippingAddress: "required",
					
					<c:forEach items="${order.orderDetails}" var="book" varStatus="status">
						quantity${status.index + 1}: {
							required: true, number: true, min: 1
						},
					</c:forEach>					
				},
				
				messages: {
					recipientName: "Please enter recipient name",
					recipientPhone: "Please enter recipient phone",
					shippingAddress: "Please enter shipping address",
					
					<c:forEach items="${order.orderDetails}" var="book" varStatus="status">
						quantity${status.index + 1}: { 
							required: "Please enter quantity",
							number: "Quantity must be a number",
							min: "Quantity must be greater than 0"
						},
					</c:forEach>						
				}
			});
			
		});		
	</script>
</body>
</html>