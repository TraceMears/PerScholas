<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Students</title>
</head>
<body>
	<h1>All Students</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Courses</th>
		</tr>
		<c:forEach items="${allStudents.values()}" var = "student" >
			<tr>
				<td>${student.studentId}</td>
				<td>${student.name}</td>
				<td>
					<c:forEach items = "${student.courses}" var = "course">
						<p>${course}</p>
					</c:forEach>
				</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>