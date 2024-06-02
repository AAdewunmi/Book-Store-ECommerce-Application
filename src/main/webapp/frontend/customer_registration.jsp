<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register New Customer</title>

	<style><%@include file="/css/style.css"%></style>
	<script src="<c:url value="/js/jquery-3.7.0.min.js" />"></script>
    <script src="<c:url value="/js/jquery.validate.min.js" />"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2 class="pageheading">
			Register as a new customer ... 
		</h2>
	</div>

	<div align="center">
			<form action="register_customer" method="post"id="customerForm" >
				<jsp:directive.include file="/common/customer_form.jsp" />	
			</form>
	</div>
	
	<jsp:directive.include file="footer.jsp" />
	</body>
	
	<script type="text/javascript" scr="/js/customer-form.js">
	
	</script>

</html>