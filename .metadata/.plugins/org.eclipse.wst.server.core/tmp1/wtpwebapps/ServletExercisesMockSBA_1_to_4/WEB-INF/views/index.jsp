<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exercise 1</title>
</head>
<body>
	<h1>Servlet Exercise 1</h1>
	<form action="${pageContext.request.contextPath}/HomeServlet" method="POST">
	<table style="width:50%s">
		<tr>
			<td><label>User Name:</label></td>
			<td><input type="text" name="username" placeholder="username" required/></td>
		</tr>
		<tr>
			<td><label>Password:</label></td>
			<td><input type="password" name="password" required/></td>
		</tr>
		<tr>
			<td><input type="submit" name="submitLogin" value="Submit"></td>
		</tr>
	</table>
	</form>
	<h1>${message}</h1>
</body>
</html>