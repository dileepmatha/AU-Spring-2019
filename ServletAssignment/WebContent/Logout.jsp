<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
       <label style="color: blue;"> ${message} </label>
    </div>
    <br />
	<form action="LogoutServlet" method="post">
  		<button type="submit" class="btn btn-primary">Logout</button>
 	</form>
</body>
</html>