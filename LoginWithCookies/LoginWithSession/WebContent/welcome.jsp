<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDate" %>
<%@page import="java.util.concurrent.TimeUnit"%>	

	<%
		Cookie[] cookies = request.getCookies();
		String bday = cookies[3].getValue();
		
		LocalDate now = LocalDate.now();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		
		Date todayDate = sdf.parse(now.toString());
		Date bdayDate = sdf.parse(bday);
		
		calendar.setTime(bdayDate);
		
		int bdayMonth = calendar.get(Calendar.MONTH);
		int bdayDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		calendar.setTime(todayDate);
		
		int todayMonth = calendar.get(Calendar.MONTH);
		int todayDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		int monthDif = bdayMonth - todayMonth;
		int dayDif = bdayDay - todayDay;
		
		calendar.add(Calendar.MONTH, monthDif);
		calendar.add(Calendar.DAY_OF_MONTH, dayDif);
		
		long milli = Math.abs(todayDate.getTime() - calendar.getTimeInMillis());
		long daysTill = TimeUnit.DAYS.convert(milli, TimeUnit.MILLISECONDS);
	
		request.setAttribute("daysTillBirthday", daysTill);
	%>

</head>
<body>
	<h1>Welcome ${username} you've logged on to an illegal site an you're going to prison! YAY :D</h1>
	<h1>At least your birthday is in ${daysTillBirthday} days!</h1>
</body>
</html>