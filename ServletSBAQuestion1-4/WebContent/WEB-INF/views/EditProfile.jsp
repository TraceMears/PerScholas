<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
</head>
<body>
	<form method="post" action="EditProfileServlet">
        <label for="username">Enter new Username</label>
        <input type="text" name="username" />
        <br/> <br/>

        <label for="password">Enter new Password</label>
        <input type="text" name="password" />
        <br/> <br/>
        
        <input type="submit" name="submit" value="submit">
    </form>
</body>
</html>