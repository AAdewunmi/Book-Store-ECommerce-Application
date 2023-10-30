<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results for ${keyword} - Online Books Store</title>
<style><%@include file="../css/style.css"%></style>
</head>
<body>

	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
	
		<c:if test="${fn:length(result) == 0}">
			<h2> No Results for "${keyword}"</h2>
		</c:if>
		
		<c:if test="${fn:length(result) > 0}">
			<div align="left" style="width: 80%; margin: 0 auto;">
				<center><h2>Results for "${keyword}": </h2></center> 
				
				<c:forEach items="${result}" var="book">
				
					<div>
					
						<div style="display: inline-block; margin: 20px; width: 10%" >
							<div align="left">
								<a href="view_book?id=${book.bookId}">
									<img src="data:image/jpg;base64, ${book.base64Image}" width="128" height="164">
								</a>
							</div>
		                </div>
		                
		                <div style="display: inline-block; margin: 20px; vertical-align: top; width: 60%", align="left">
							<div>
								<h2>
									<a href="view_book?id=${book.bookId}">
									<b>${book.title}</b>
								</a>
								</h2>
							</div>
							<div>Rating ***** </div>
							<div><i>by ${book.author}</i></div>
							<div><p>${fn:substring(book.description, 0, 100)} ... </p></div>
					    </div>
					    
					    <div style="display: inline-block; margin: 20px; vertical-align: top;">
					    	<h3>
					    		<div><b>$ ${book.price}</b></div>
					    		</br>
					    	 	<div><a href="">Add To Cart</a></div>		 
					    	</h3>
					    </div>
					
					</div>
						
				</c:forEach>
			</div>
		</c:if>
		
	</div>	
			
				
					
						
							
			                
								
					
		
		
	

	<jsp:directive.include file="footer.jsp"/>
	
</body>
</html>