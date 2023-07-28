<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<div>
		<img src="images/BookstoreLogo.png" />
	</div>
	
	<div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text" name="keyboard" size="50"/>
		<input type="button" value="Search"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="login">Sign In</a> |
		<a href="register">Register</a> |
		<a href="view_cart">Cart</a>
	</div>
	<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
	<div>
		<c:forEach var="category" items="${listCategory}" varStatus="status">
		<a href="view_category?id=${category.categoryId}">
			<b>
				<font size="+1">
					<c:out value="${category.name}"></c:out>
				</font>
			</b>
		</a>
		<c:if test="${not status.last}">
			&nbsp; | &nbsp;
		</c:if>
		</c:forEach>
	</div>
		
</div>


