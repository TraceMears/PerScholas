<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

	<fieldset>
		<legend>Login</legend>
		<form:form action="${pageContext.request.contextPath}/login" method="post" modelAttribute="loginAttempt">
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
			<input type="submit" value="Login" />
		</form:form>
	</fieldset>
	
	
	
	<div> <a href="${pageContext.request.contextPath}/registration">Register user</a> </div>
	
</body>
</html>