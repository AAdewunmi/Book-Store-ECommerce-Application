<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style><%@include file="../css/style.css"%></style>
	<script src="<c:url value="../js/jquery-3.7.0.min.js" />"></script>
    <script src="<c:url value="../js/jquery.validate.min.js" />"></script>
<title>
	<c:if test="${category!=nll}">
		Edit Category
	</c:if>
	<c:if test="${category==nll}">
		Create New Category
	</c:if>
</title>

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">
			<c:if test="${category != null}">
				Edit Category
			</c:if>
			<c:if test="${category == null}">
				Create New Category
			</c:if>
		</h2>
	</div>

	<div align="center">
		<c:if test="${category != null}">
			<form action="update_category" method="post" id="categoryForm" style="max-width: 300px; margin: 0 auto;">
			<input type="hidden" name="categoryId" value=${category.categoryId}>
		</c:if>
		<c:if test="${category == null}">
			<form action="create_category" method="post" id="categoryForm" style="max-width: 300px; margin: 0 auto;">
		</c:if>
			<table class="form">
				<tr>
					<td align="right">Category Name:</td>
					<td align="left"><input type="text" id="name" name="name"
						size="20" value="${category.name}"></td>
				</tr>
				<tr>
					<td>&nbsp<td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit">Save</button> &nbsp;&nbsp;&nbsp;
						<button type="button" onclick="history.go(-1);">Cancel</button>
						
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<jsp:directive.include file="footer.jsp" />
	
</body>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#categoryForm").validate({
			rules:{
				name: "required",
			},
			messages:{
				name: "Please enter category name",
			}
		});
	});
	$("#buttonCancel").click(function(){
		history.go(-1);
	});
	</script>
</html>