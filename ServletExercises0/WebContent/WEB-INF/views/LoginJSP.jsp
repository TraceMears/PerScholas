<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
		<% 	String error = null;
		if (request.getParameter("login") != null) {
			String userName = request.getParameter("userName");
			String userPassword = request.getParameter("userPassword");
			if (userName.equals("testUser") && userPassword.equals("testPassword")) {
				request.getRequestDispatcher("Success.jsp")
											.forward(request, response);
			} else {
				error = "Login unsuccessful.";
			}
		} %>
	</head>
</head>
<body>
		<h1>Login Form</h1>
	
		<% if (error != null) {%>
			<p style="color: red;"><%= error %></p>
		<% } %>
		
		<form method="post" >
			<label>User Name:&nbsp;<input type="text" name="userName" /></label>
			<label>Password:&nbsp;<input type="password" name="userPassword" /></label>
			<input type="submit" name="login" value="Login" />
		</form>

</body>
</html>