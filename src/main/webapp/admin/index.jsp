<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Style-Type" content="text/css">
	<title> Evergreen Bookstore Administration </title>
	<style><%@include file="../css/style.css"%></style>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<div align="center">
		<h2 class="pageheading"> Administrative Dashboard </h2>
	</div>
	
	<div align="center">
	<hr width="60%"/>
	<b>
		<h2 class="pageheading"> Quick Actions: </h2>
		<a href="create_book"> New Book</a> &nbsp;
		<a href="create_user"> New User</a> &nbsp;
		<a href="create_category"> New Category</a> &nbsp;
		<a href="create_customer"> New Customer</a> 
	</b>
	</div>
	<div align="center">
	<hr width="60%"/>
		<h2 class="pageheading"> Recent Sales: </h2>
	</div>
	<div align="center">
	<hr width="60%"/>
		<h2 class="pageheading"> Recent Views: </h2>
	</div>
	<div align="center">
	<hr width="60%"/>
		<h2 class="pageheading"> Statistics: </h2>
	</div>
	<hr width="60%"/>
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>