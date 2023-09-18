<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Book</title>
	<style><%@include file="../css/style.css"%></style>
	<style><%@include file="../css/jquery-ui.min.css"%></style>
	
	<script src="<c:url value="../js/jquery-3.7.0.min.js" />"></script>
    <script src="<c:url value="../js/jquery.validate.min.js" />"></script>
    <script src="<c:url value="../js/jquery-ui.min.js" />"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2 class="pageheading">
			<c:if test="${book != null}">
				Edit Book
			</c:if>
			<c:if test="${book == null}">
				Create New Book
			</c:if>
		</h2>
	</div>

	<div align="center">
		<c:if test="${book != null}">
			<form action="update_user" method="post" id="userForm">
			<input type="hidden" name="userId" value=${user.userId}>
		</c:if>
		<c:if test="${book == null}">
			<form action="create_book" method="post"id="bookForm">
		</c:if>
		
			<table class="form">
				<tr>
					<td>Category</td>
					<td>
						<select name="category">
							<c:forEach items="${listCategory}" var="category">
								<option value="${category.categoryId}">
									${category.name} 
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right">Title:</td>
					<td align="left"><input type="text" id="title" name="title"
						size="20" value="${book.title}"></td>
				</tr>
				<tr>
					<td align="right">Author:</td>
					<td align="left"><input type="text" id="author"
						name="author" size="20" value="${book.author}"></td>
				</tr>
				<tr>
					<td align="right">ISBN:</td>
					<td align="left"><input type="text" id="isbn"
						name="isbn" size="20" value="${book.isbn}"></td>
				</tr>
				<tr>
					<td align="right">Publish Date:</td>
					<td align="left"><input type="text" id="publishDate"
						name="publishDate" size="20" value="${book.publishDate}"></td>
				</tr>
				<tr>
					<td align="right">Book Image:</td>
					<td align="left">
						<input type="file" id="bookImage" name="bookImage" size="20"><br/>
						<img id="thumbnail" alt="Image Preview" style="width:20%; margin-top: 10px"/>
					</td>
				</tr>
				<tr>
					<td align="right">Price:</td>
					<td align="left"><input type="text" id="price"
						name="price" size="20" value="${book.price}"></td>
				</tr>
				<tr>
					<td align="right">Description:</td>
					<td align="left">
						<textarea rows="5" cols="50" name="description" id="description"></textarea>
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
		$('#publishDate').datepicker();
		$('#bookImage').change(function(){
			showImageThumbnail(this);
		});
		$("#bookForm").validate({
			rules: {
				category: "required",
				title: "required",
				author: "required",
				isbn: "required",
				publishDate: "required",
				bookImage: "required",
				price: "required",
				description: "required",
			},
			
			messages: {
				category: "Please select a book category",
				title: "Please enter book title",
				author: "Please enter book author",
				isbn: "Please enter book isbn",
				publishDate: "Please enter book publish date",
				bookImage: "Please choose book image",
				price: "Please enter book price",
				description: "Please enter book description",			
			}
		});
		
		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});
	function showImageThumbnail(fileInput){
		var file = fileInput.files[0];
		var reader = new FileReader();
		reader.onload = function(e){
			$('#thumbnail').attr('src', e.target.result);
		};
		reader.readAsDataURL(file);
	}
	</script>

</html>