<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Create New User </title>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<div align="center">
		<h2> Create New User </h2>
	</div>
	
	<div align="center">
		<form action="create_user" method="post" onsubmit="return validateFormInput()">
			<table>
				<tr>
					<td align="right">Email: </td>
					<td align="left"><input type="text" id="email" name="email" size="20"></td>
				</tr>
				<tr>
					<td align="right">Full Name: </td>
					<td align="left"><input type="text" name="fullname" size="20"></td>
				</tr>
				<tr>
					<td align="right">Password: </td>
					<td align="left"><input type="password" name="password" size="20"></td>
				</tr>
				<tr><td>&nbsp<td></tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Save">
						<input type="button" value="Cancel">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:directive.include file="footer.jsp"/>
</body>
<script type="text/javascript">
	function validateFormInput(){
		var fieldEmail = document.getElementById("email");
		if(fieldEmail.value.length == 0){
			alert("Email is required!");
			fieldEmail.focus();
			return false;
		}
	}
</script>
</html>