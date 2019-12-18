<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cookies</title>
</head>
<body>
	<h1>Cookies</h1>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for(Cookie c : cookies){
				if(c.getName().equals("myFavoriteCookie"))
					out.print(c.getValue());
			}
		}
	%>
	<br/>
	<a href="${pageContext.request.contextPath}/CookieJarServlet">Cookie Jar</a>
</body>
</html>