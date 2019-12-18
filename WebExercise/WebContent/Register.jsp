<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" />
        <br /><br />
        <label for="lastName">Last Name:</label>
         <input type="text" name="lastName" />
        <br /><br />
        <label for="country">Country:</label>         
        <select name="country">
            <option>Select one</option>
            <option>Brazil</option>
            <option>France</option>
            <option>Germany</option>
            <option>India</option>
            <option>Turkey</option>
            <option>United Kingdom</option>
            <option>Panama</option>
            <option>China</opton>
            <option>Iran</option>
            <option>Pakistan</option>
            <option>United States of America</option>
        </select>
        <br /><br />
        <label for="gender">Gender:</label>
        <br />
        <input type="radio" name="gender" value="Female"> Female
        <input type="radio" name="gender" value="Male"> Male
        <input type="radio" name="gender" value="Other"> Other
        <br /><br />
        <label for="favoriteLanguage">Favorite programming language:</label>
        <br />
        <input type="checkbox" name="favoriteLanguage" value="Java"> Java
        <input type="checkbox" name="favoriteLanguage" value="C#"> C#
        <input type="checkbox" name="favoriteLanguage" value="JavaScript"> JavaScript
        <input type="checkbox" name="favoriteLanguage" value="Paython"> Python
        <br /><br />
        <input type="submit" value="Register" />
    </form>
</body>
</html>