<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="RegisterServlet">       
        
        <label for="username">Username</label>
        <input type="text" name="username" />
        <br/> <br/>

        <label for="password">Password</label>
        <input type="text" name="password" />
        <br/> <br/>
        
        <label for="confirm password">Confirm Password</label>
        <input type="text" name="password2" />
        <br/> <br/>
        
        <label for="date of birth">DOB(MM/DD/YYYY)</label>
        <input type="date" name="dob" />
        <br/> <br/>   
        
        
        <input type="submit" name="submit" value="register">
    </form>
    
</body>
</html>