<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Register</title>
</head>
<body>

	<h1>Registration Page</h1>
	
	<fieldset>
		<legend>Register</legend>
		<form:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="user">
			<div>
				<label for="username">Username</label>
				<div>
					<form:input path="username" />
					<!--  
					<p style="color:red;">
						<form:errors path="username" class="error"></form:errors>
					</p>
					-->
				</div>				
			</div>
			<div>
				<label for="password">Password</label>
				<div>
					<form:password path="password" />
					<!-- 
					<p style="color:red;">
						<form:errors path="password" class="error"></form:errors>
					</p>
					 -->
				</div>				
			</div>
			<input type="submit" value="Register User" />
		</form:form>
	</fieldset>
	
	<div> <a href="${pageContext.request.contextPath}/">Cancel registration</a> </div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>