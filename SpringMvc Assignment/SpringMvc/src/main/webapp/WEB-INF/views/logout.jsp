<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String str= (String)request.getAttribute("message"); %>
<% if(str.length()!=0){ %>
	<h1><%= str %> </h1>
	<%} %>
	
<form action="logout" method="get">
	<input type="submit" value="Logout">
</form>
</body>
</html>