<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1> Welcome to Webpage</h1>
	<br>
	<form method="post" action="WelcomeServlet">
		<input type="submit" value="Login" name="login">
		<br> <br>
		<input type="submit" value="Register" name="register">
		<br> <br>
		<input type="submit" value="Update Password" name="updatePass">
		<br> <br>
		<input type="submit" value="Delete Account" name="delete">
		
	</form>
</body>
</html>