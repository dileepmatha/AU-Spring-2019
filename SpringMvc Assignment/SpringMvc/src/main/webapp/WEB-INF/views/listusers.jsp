<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.accolite.springmvc.model.UserDetails"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
	List of users
</h1>

<% List<UserDetails> users=(List<UserDetails>)request.getAttribute("users"); %>
		 <% if(users!=null){ %>
			<table>
				<tr>
					<th>UserName</th>
					<th>Age</th>
					<th>Email</th>
					<th></th>
				</tr>
				<% for(UserDetails user:users){ %>
				<tr>
					<td><%=user.getUserName() %></td>
					<td><%=user.getAge() %></td>
					<td><%=user.getEmail() %></td>
				</tr>
				<%}%>
			</table>
		
		<%}%>
		
<a href="listtologin">Go to Login</a>
</body>
</html>