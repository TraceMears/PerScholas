<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Servlet Excercise 1</h1>
	<!--  {$pageContext.request.contextPath}/ -->
	<form method="post" action="${pageContext.request.contextPath}/HomeServlet">
        <label for="username">Username</label>
        <input type="text" name="username" />
        <br/> <br/>

        <label for="password">Password</label>
        <input type="text" name="password" />
        <br/> <br/>
        
        <input type="submit" name="submit" value="Log in">
    </form>
</body>
</html>