<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
</head>
<body>
<%@ page import="servlets.project03.User" %>

	<h1>User Profile</h1>
	Username: <%= ( (User) request.getSession().getAttribute("user") ).getUserName() %>
	<br>
	Password: <%= ( (User) request.getSession().getAttribute("user") ).getPassword() %>
	
	
	<form method="post" action="UserProfileServlet">
        <input type="submit" name="Edit Profile" value="Edit Profile">
    </form>
    
</body>
</html>