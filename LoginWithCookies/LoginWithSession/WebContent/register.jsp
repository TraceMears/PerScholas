<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

	<%
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
		
		if(request.getParameter("submit") != null){
			if(password.equals(passwordConfirm)){
				Cookie usernameCookie = new Cookie("username", request.getParameter("username"));
				Cookie passwordCookie = new Cookie("password", request.getParameter("password"));
				Cookie birthdayCookie = new Cookie("birthday", request.getParameter("bday"));
				
				response.addCookie(usernameCookie);
				response.addCookie(passwordCookie);
				response.addCookie(birthdayCookie);
				
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
			
		}
		
		
	%>

</head>
<body>
	<form>
		First Name: <input type="text" name="firstName"><br>
		Last Name: <input type="text" name="lastName"><br>
		Birthday: <input type="date" name="bday">
		Username: <input type="text" name="username"><br>
		Password: <input type="password" name="password"><br>
		Confirm Password: <input type="password" name="passwordConfirm"><br>
		<input type="submit" value="submit" name="submit">
	</form>
</body>
</html>