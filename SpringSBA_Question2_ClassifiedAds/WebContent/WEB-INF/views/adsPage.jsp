<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classified Ads</title>
</head>
<body>
	<h1>Classified ads</h1>
	<h2>Welcome ${displayName}!</h2>
	
	<fieldset>
		<legend>Add Item</legend>
		<form:form action="${pageContext.request.contextPath}/addItem" method="post" modelAttribute="item">
			<div>
				<label for="name">Name</label>
				<div>
					<form:input path="name" />
					<p style="color:red;">
						<form:errors path="name" class="error"></form:errors>
					</p>
				</div>				
			</div>
			<div>
				<label for="price">Price</label>
				<div>
					<form:input path="price" />
					<p style="color:red;">
						<form:errors path="price" class="error"></form:errors>
					</p>
				</div>				
			</div>
			<input type="submit" value="Add Item" />
		</form:form>
	</fieldset>
	
	<fieldset>
		<legend>Item List</legend>
		<table>
			<tr>
				<th>Item id</th>
				<th>Item name</th>
				<th>Price</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${allItems}" var="item">
				<tr>
					<td>${item.itemId}</td>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td>
						<c:if test="${item.status == 0}">
							<a href="${pageContext.request.contextPath}/orderItem/${item.itemId}">Order</a>
						</c:if>
						<c:if test="${item.status == 1}">
							<a href="${pageContext.request.contextPath}/cancelOrder/${item.itemId}">Cancel Order</a>
						</c:if>						
					</td>
					<td>
						<c:if test="${item.status == 0}">
							
						</c:if>
						<c:if test="${item.status == 1}">
							<p style="color:red;">Sold out!</p>
						</c:if>		
					</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
	
	
</body>
</html>