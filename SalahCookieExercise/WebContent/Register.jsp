<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>

	<%@page import="java.time.format.DateTimeFormatter"%>
	<%@page import="java.util.*"%>
	<%@page import="java.text.SimpleDateFormat"%>
	<%@page import="java.time.LocalDate" %>
	<%@page import="java.util.concurrent.TimeUnit"%>
	<% 
	String first = "";
	first = request.getParameter("username");
	if(first!=null) {
	
		String last = request.getParameter("password");
		String dob = request.getParameter("dob");
		String username = request.getParameter("username");
		String pass1 = request.getParameter("password");
		String pass2 = request.getParameter("password2");
		
		if(!pass1.equals(pass2)) {
			RequestDispatcher req = request.getRequestDispatcher("Register.jsp");
			req.include(request, response);
		}
		Cookie cFirst = new Cookie("firstName", first);
		Cookie cLast = new Cookie("lastName", last);
		Cookie cUser = new Cookie("username", username);
		Cookie cPass = new Cookie("password", pass1);
		
		int dayOfYear = LocalDate.now().getDayOfYear();
		LocalDate dobLD = LocalDate.parse(dob);
		int dayOfYearDOB = dobLD.getDayOfYear();
		int difference = 0;
		if(dayOfYearDOB < dayOfYear) {
			difference = dayOfYear - dayOfYearDOB;
		}
		else {
			difference = 365 - (dayOfYearDOB - dayOfYear);
		}
		Cookie cDiff = new Cookie("difference", Integer.toString(difference));
		
		response.addCookie(cFirst);
		response.addCookie(cLast);
		response.addCookie(cUser);
		response.addCookie(cPass);
		response.addCookie(cDiff);
		
		RequestDispatcher req = request.getRequestDispatcher("Login.jsp");
		req.forward(request, response);
	}
	%>




	<form>
        <label for="first name">first</label>
        <input type="text" name="first" />
        <br/> <br/>

        <label for="last name">last</label>
        <input type="text" name="last" />
        <br/> <br/>
        
        <label for="date of birth">DOB(MM/DD/YYYY)</label>
        <input type="date" name="dob" />
        <br/> <br/>
        
        <label for="username">Username</label>
        <input type="text" name="username" />
        <br/> <br/>

        <label for="password">Password</label>
        <input type="text" name="password" />
        <br/> <br/>
        
        <label for="confirm password">Password</label>
        <input type="text" name="password2" />
        <br/> <br/>
        
        
        
        <input type="submit" name="submit" value="register">
    </form>
</body>
</html>