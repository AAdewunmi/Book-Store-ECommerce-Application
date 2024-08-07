<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Customer</title>

	<style><%@include file="/css/style.css"%></style>
	<script src="<c:url value="/js/jquery-3.7.0.min.js" />"></script>
    <script src="<c:url value="/js/jquery.validate.min.js" />"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2 class="pageheading">
			Edit My Profile
		</h2>
	</div>

	<div align="center">
	
			<form action="update_profile" method="post"id="customerForm" >
		
			<table class="form">
				<tr>
					<td align="right">Email:</td>
					<td align="left"><b>${loggedCustomer.email} (Cannot be changed!)</b></td>
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
					<td align="right">Phone Number:</td>
					<td align="left"><input type="text" id="phone" name="phone" 
					size="45" value="${loggedCustomer.phone}"></td>
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
						name="city" size="45" value="${loggedCustomer.city}"></td>
				</tr>
				<tr>
					<td align="right">State:</td>
					<td align="left"><input type="text" id="state"
						name="state" size="45" value="${customer.state}"></td>
				</tr>
				<tr>
					<td align="right">Zip Code:</td>
					<td align="left"><input type="text" id="zipcode"
						name="zipcode" size="45" value="${loggedCustomer.zipcode}"></td>
				</tr>
				<tr>
					<td align="right">Country:</td>
					<td align="left">
					<select name="country" id="country">
							<c:forEach items="${mapCountries}" var="country">
								<option value="${country.value}"
								<c:if test='${loggedCustomer.country eq country.value}'>
								selected='selected'
								</c:if>
								>
								${country.key}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<i>(Leave password fields blank if you don't want to change password!)</i>
					</td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td align="left"><input type="password" id="password" name="password" 
						size="45" value=""></td>
				</tr>
				<tr>
					<td align="right">Confirm Password:</td>
					<td align="left"><input type="password" id="confirmPassword" name="confirmPassword" 
						size="45" value=""></td>
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
				fullName: "required",
				confirmPassword: {
					equalTo: "#password"
				},
				phone: "required",
				address: "required",
				city: "required",
				zipCode: "required",
				country: "required",
			},
			messages: {
				email: {
					required: "Please enter email address",
					email: "Please enter valid email address",
				},
				fullName: "Please enter full name",
				confirmPassword: {
					equalTo: "Re-Confirm password! It does not match"
				},
				phone: "Please enter email phone",
				address: "Please enter address",
				city: "Please enter city",
				zipCode: "Please enter zipcode",
				country: "Please enter country",		
			}
		});
		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});
	</script>

</html>