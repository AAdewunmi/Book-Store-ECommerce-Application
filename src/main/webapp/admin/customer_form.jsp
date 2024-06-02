<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Customer</title>

	<style><%@include file="../css/style.css"%></style>
	<script src="<c:url value="../js/jquery-3.7.0.min.js" />"></script>
    <script src="<c:url value="../js/jquery.validate.min.js" />"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2 class="pageheading">
			<c:if test="${customer != null}">
				Edit Customer
			</c:if>
			<c:if test="${customer == null}">
				Create New Customer
			</c:if>
		</h2>
	</div>

	<div align="center">
		<c:if test="${customer != null}">
			<form action="update_customer" method="post" id="customerForm" >
			<input type="hidden" name="customerId" value=${customer.customerId}>
		</c:if>
		<c:if test="${customer == null}">
			<form action="create_customer" method="post"id="customerForm" >
		</c:if>
		
			<table class="form">
				<tr>
					<td align="right">Email:</td>
					<td align="left"><input type="text" id="email" name="email"
						size="45" value="${customer.email}"></td>
				</tr>
				<tr>
					<td align="right">First Name:</td>
					<td align="left"><input type="text" id="firstname" name="firstname" 
					size="45" value="${customer.firstname}"></td>
				</tr>
				<tr>
					<td align="right">Last Name:</td>
					<td align="left"><input type="text" id="lastname" name="lastname" 
					size="45" value="${customer.lastname}"></td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" id="password" name="password" 
						size="45" value="${customer.password}"></td>
				</tr>
				<tr>
					<td align="right">Confirm Password:</td>
					<td align="left"><input type="password" id="confirmPassword" name="confirmPassword" 
						size="45" value="${customer.password}"></td>
				</tr>
				<tr>
					<td align="right">Phone Number:</td>
					<td align="left"><input type="text" id="phone" name="phone" 
					size="45" value="${customer.phone}"></td>
				</tr>
				<tr>
					<td align="right">Address Line 1:</td>
					<td align="left"><input type="text" id="address1"
						name="address1" size="45" value="${customer.addressLine1}"></td>
				</tr>
				<tr>
					<td align="right">Address Line 2:</td>
					<td align="left"><input type="text" id="address2"
						name="address2" size="45" value="${customer.addressLine2}"></td>
				</tr>
				<tr>
					<td align="right">City:</td>
					<td align="left"><input type="text" id="city"
						name="city" size="45" value="${customer.city}"></td>
				</tr>
				<tr>
					<td align="right">State:</td>
					<td align="left"><input type="text" id="state"
						name="state" size="45" value="${customer.state}"></td>
				</tr>
				<tr>
					<td align="right">Zip Code:</td>
					<td align="left"><input type="text" id="zipcode"
						name="zipcode" size="45" value="${customer.zipcode}"></td>
				</tr>
				<tr>
					<td align="right">Country:</td>
					<td align="left">
						<select name="country" id="country">
							<c:forEach items="${mapCountries}" var="country">
								<option value="${country.value}"
								<c:if test='${customer.country eq country.value}'>
								selected='selected'
								</c:if>
								>
								${country.key}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp<td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit">Save</button> &nbsp;&nbsp;&nbsp;
						<button id="buttonCancel">Cancel</button>
						
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<jsp:directive.include file="footer.jsp" />
	</body>
	
	<script type="text/javascript">
	$(document).ready(function() {
		$("#customerForm").validate({
			rules: {
				email: {
					required: true,
					email: true
					},
				firstname: "required",
				lastname: "required",
				<c:if test="${customer == null}">
					password: "required",
				</c:if>
				confirmPassword: {
				<c:if test="${customer == null}">
					required: true,
				</c:if>
					equalTo: "#password"
				},
				
				phone: "required",
				address1: "required",
				address2: "required",
				city: "required",
				state: "required",
				zipcode: "required",
				country: "required",
			},
			messages: {
				email: {
					required: "Please enter email address",
					email: "Please enter valid email address",
				},
				firstname: "Please enter first name",
				lastname: "Please enter last name",
				<c:if test="${customer == null}">
					password: "Please enter email password",
				</c:if>
				confirmPassword: {
				<c:if test="${customer == null}">
					required: "Please re-enter email address",
				</c:if>
					equalTo: "Re-Confirm password! It does not match"
				},
				phone: "Please enter email phone",
				address1: "Please enter address line 1",
				address2: "Please enter address line 2",
				city: "Please enter city",
				state: "Please enter state",
				zipcode: "Please enter zipcode",
				country: "Please enter country",		
			}
		});
		
		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});
	</script>

</html>