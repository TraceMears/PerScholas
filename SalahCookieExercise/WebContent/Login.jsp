<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<form action="Welcome.jsp">
        <label for="username">Username</label>
        <input type="text" name="username" />
        <br/> <br/>

        <label for="password">Password</label>
        <input type="text" name="password" />
        <br/> <br/>
        
        
        <input type="submit" name="submit" value="login">
    </form>
    <br>
    <form action="Register.jsp">
    	<button type="submit" value="register" name="register">Register</button>
    </form>
    <br> <br>
    
	<%
	
	Cookie[] cookies = request.getCookies();
    if (cookies.length > 1){
		String userCheck = cookies[2].getValue();
		String passCheck = cookies[3].getValue();
		
		if (request.getParameter("login") != null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if(username.equals(userCheck) && password.equals(passCheck)){
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Welcome.jsp");
				requestDispatcher.forward(request, response);
			}		
		}
		if (request.getParameter("register") != null) {
			RequestDispatcher req = request.getRequestDispatcher("Register.jsp");
			req.forward(request, response);
			
		} 
	}
	%>	

</body>
</html>