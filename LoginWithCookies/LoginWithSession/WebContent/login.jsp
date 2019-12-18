<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
	
	<%
	Cookie[] cookies = request.getCookies();
	String validUsername = cookies[1].getValue();
	String validPassword = cookies[2].getValue();
	
		if(request.getParameter("login") != null){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if(username.equals(validUsername) && password.equals(validPassword)){
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome.jsp");
				request.setAttribute("username", username);
				requestDispatcher.forward(request, response);
			}
		}
	
		if(request.getParameter("register") != null){
			response.sendRedirect("register.jsp");
		}
	%>

</head>
<body>
	<h1>Login</h1>
	
	<form>
		Username: <input type="text" name="username"><br>
		Password <input type="password" name="password"><br>
		<button type="submit" name="register">Register</button><input type="submit" name="login" value="login">
	</form>
</body>
</html>