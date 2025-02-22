<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Admin Page</title>
</head>
<body>
	
	<h1>Admin options</h1>
	
	<br>
	
	<form action="${pageContext.request.contextPath}/updateDB" method="get" >
			<button type="submit">Update Database</button>
	</form>
		
	<br><br><br>
	
	<div>
	Ban User:
	<br>
	
	<form action="${pageContext.request.contextPath}/banUser" method="post" >
		<select name="Ban_User">
			<option value="">Select User</option>
		    <c:forEach items="${allUsers}" var="user">
		        <option value="${user.id}">${user.username}</option>
		    </c:forEach>
	    </select>
	    <br>
	    <input type="submit" value="Ban User"/>
	</form>
	
	</div>
	
	<c:choose>
	    <c:when test="${bannedUser.username == null}">
	    	
	    </c:when>
	    <c:otherwise>
	        <c:out value="${bannedUser.username}" /> HAS BEEN BANNED!
	    </c:otherwise>
	</c:choose>
	
	<br><br><br>
	
	<div> <a href="${pageContext.request.contextPath}/logout">Log out</a> </div>
		
		
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>	
</body>
</html>