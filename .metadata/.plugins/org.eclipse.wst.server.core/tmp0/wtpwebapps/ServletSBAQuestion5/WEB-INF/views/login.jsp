<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="LoginServlet">
        <label for="username">Username</label>
        <input type="text" name="username" />
        <br/> <br/>

        <label for="password">Password</label>
        <input type="text" name="password" />
        <br/> <br/>
        
        <input type="submit" name="submit" value="Log in">
    </form>
    
    <form method='post' action="ToRegisterServlet">
    	<button type="submit" value="register" name="register">Register</button>
    </form>
</body>
</html>