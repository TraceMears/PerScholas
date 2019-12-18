<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<%@page import="classes.Student"%>
	<% if (request.getParameter("signup") != null) {
	Student student = new Student();
	student.setName(request.getParameter("name"));
	student.setPassword(request.getParameter("password"));
	student.setCourse(request.getParameter("course"));
	request.setAttribute("student", student);
	request.getRequestDispatcher("Success.jsp").forward(request, response);
 } %>		
<body>

	<h1>Sign Up Page</h1>
	<form method="post">
		<p>Name: <input type="text" name="name" /></p>
		<p>Password: <input type="text" name="password" /></p>
		<p>Course: <select name="course">
			<option value="ASM">Application Support Management</option>
			<option value="DE">Data Engineering</option>
			<option value="QEA">Quality Engineering &amp; Assurance</option>
		</select></p>
		<p><input type="submit" name="signup" value="Sign Up"/></p>
	</form>

</body>
</html>