<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
		<% 
		Cookie[] cookies = request.getCookies();
		
		out.println("Welcome, " + cookies[1].getValue() + " "+ cookies[2].getValue());
		out.println("You have " + cookies[5].getValue() + " until your birthday");
		
		%>
</body>
</html>