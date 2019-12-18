<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Servlets/JSP Project 1</title>
</head>
<body>
<%@ page import="java.util.*" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
	
	<% DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm a"); %>
	<h1>Welcome to this Web Page</h1>
	
	<h2>The current date and time is: <%=dtf.format(LocalDateTime.now()) %></h2>
	
</body>
</html>