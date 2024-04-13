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
					<td><a href="">Remove</a></td>
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
			<a href="">Add Books</a>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<input type="submit" value="Save"/>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<input type="button" value="Cancel"/>
		</div>
	
	</form>	
	
	<jsp:directive.include file="footer.jsp"/>
	
	<script type="text/javascript">
	$(document).ready(function(){
		$(".deleteLink").each(function(){
			$(this).on("click", function(){
				reviewId = $(this).attr("id");
				if(confirm('Are you sure you want to delete review with ID ' + reviewId + ' ?')){
					window.location = 'delete_review?id=' + reviewId;
				}
			});
		});
	});
	</script>
</body>
</html>