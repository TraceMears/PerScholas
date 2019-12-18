<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Page</title>
</head>
<body>
	<h1>Student</h1>
	<h2>Name: ${student.name}<span style = "color:red;">${errorMessage}</span></h2>
	<h3>Courses</h3>
	<c:forEach items = "${student.courses}" var = "course">
		<p>${course}</p>
	</c:forEach>
</body>
</html>