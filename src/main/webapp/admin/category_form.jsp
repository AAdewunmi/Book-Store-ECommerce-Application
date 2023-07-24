<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		<c:if test="${category != null}">
			<h2>Edit Category</h2>
		</c:if>
		<c:if test="${category == null}">
			<h2>Create New Category</h2>
		</c:if>
	</div>

	<div align="center">
		<c:if test="${category != null}">
			<form action="update_category" method="post" onsubmit="return validateFormInput()">
			<input type="hidden" name="categoryId" value=${category.categoryId}>
		</c:if>
		<c:if test="${category == null}">
			<form action="create_category" method="post" onsubmit="return validateFormInput()">
		</c:if>
			<table>
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
						<input type="submit" value="Save">
						<input type="button" value="Cancel"
						onclick="javascript:history.go(-1);">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
	function validateFormInput() {
		var fieldName = document.getElementById("name");
		if (fieldName.value.length == 0) {
			alert("Category name is required!");
			fieldName.focus();
			return false;
		}
		return true;
	}
</script></html>