<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Servlet Page</title>
</head>
<body>
		<h1>Java Servlet page intro</h1>
		<% String s = "Trace Mears"; %>
		<h2>Welcome <% System.out.print(s); %></h2>
</body>
</html>