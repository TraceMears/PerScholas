<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cookie Jar</title>
</head>
<body>
	<h1>Cookie Jar</h1>
		<%
		Cookie[] cookies = request.getCookies();
		
		for(Cookie c : cookies){
			if(c.getName().equals("myFavoriteCookie"))
				out.print(c.getValue() + "\n");
		}
	%>
	<br/>
	<a href="${pageContext.request.contextPath}/CookiesServlet">Cookies</a>
</body>
</html>