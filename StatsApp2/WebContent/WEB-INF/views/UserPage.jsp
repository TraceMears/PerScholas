<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>User page</title>
</head>
<body style="background-color:#ebebeb">

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <a class="navbar-brand" href="#">UFC Stats</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="${pageContext.request.contextPath}/userPage">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          User Options
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="${pageContext.request.contextPath}/updatePage">Update Password</a>
	          <a class="dropdown-item" href="${pageContext.request.contextPath}/deletePage">Delete Account</a>
	          <div class="dropdown-divider"></div>
	          <a class="dropdown-item" style="color: red" href="${pageContext.request.contextPath}/logout">Log out</a>
	        </div>
	      </li>
	     
	  </div>
	</nav>
	
	<hr style="margin: 0px; border-top: 12px solid red; border-color: #b20101">

	<h1>Welcome ${loggedUser.username}!</h1>	
	
	<!--  
	<div> <a href="${pageContext.request.contextPath}/updatePage">Update Password</a> </div>
	<div> <a href="${pageContext.request.contextPath}/deletePage">Delete Account</a> </div>
	<div> <a href="${pageContext.request.contextPath}/logout">Log out</a> </div>
	-->
	
	<br><br>
	
	<form action="${pageContext.request.contextPath}/addToFavorites" method="post" >
		<select name="Add_Fighter">
			<option value="">Select Fighter</option>
		    <c:forEach items="${allFighters}" var="fighter">
		        <option value="${fighter.id}">${fighter.name}</option>
		    </c:forEach>
	    </select>
	    <br>
	    <input type="submit" value="Add to Favorites"/>
	</form>
	
	
	<br>
	
	<fieldset>
		<legend>Favorite List</legend>
		<table>
			<tr>
				<th>Fighter Name</th>				
				<th></th>
			</tr>
			<c:forEach items="${favoriteFightersList}" var="fighter">
				<tr>
					<td>${fighter.name}</td>
					<td>
						<a href="${pageContext.request.contextPath}/removeFavorite/${fighter.id}">Remove favorite</a>	
					</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
	
	<br>
	<div> <a href="${pageContext.request.contextPath}/tableView">Go to table view</a> </div>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>