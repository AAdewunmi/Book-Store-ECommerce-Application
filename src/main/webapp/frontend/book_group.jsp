<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="book">
		<div>
			<a href="view_book?id=${book.bookId}">
				<img class="book-small"
				src="data:image/jpg;base64, ${book.base64Image}">
			</a>
		</div>
		<div>
			<a href="view_book?id=${book.bookId}">
				<b>${book.title}</b>
			</a>
		</div>
		<div>
			<jsp:directive.include file="book_rating.jsp"/>
		</div>
		<div><i>by ${book.author}</i></div>
		<div><b>$ ${book.price}</b></div>
	</div>
</body>
</html>