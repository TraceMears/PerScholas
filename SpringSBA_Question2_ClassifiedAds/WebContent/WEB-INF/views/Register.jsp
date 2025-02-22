<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>

	<h1>Register Page</h1>
	
	<fieldset>
		<legend>Register</legend>
		<form:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="user">
			<div>
				<label for="username">Username</label>
				<div>
					<form:input path="username" />
					<p style="color:red;">
						<form:errors path="username" class="error"></form:errors>
					</p>
				</div>				
			</div>
			<div>
				<label for="password">Password</label>
				<div>
					<form:input path="password" />
					<p style="color:red;">
						<form:errors path="password" class="error"></form:errors>
					</p>
				</div>				
			</div>
			<input type="submit" value="Register User" />
		</form:form>
	</fieldset>
	
	<div> <a href="${pageContext.request.contextPath}/">Cancel registration</a> </div>
</body>
</html>