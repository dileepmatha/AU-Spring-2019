<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1> Update file </h1>
<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
           <h5 class="card-title text-center">Login In</h5>
            <form class="form-signin" method = "post" action = "update">
              <div class="form-label-group">
                <input type="text" name="userName" class="form-control" placeholder="user name" required autofocus>
                <label for="inputEmail">User Name</label>
              </div>
              <div class="form-label-group">
                <input type="password" name="age" class="form-control" placeholder="Age" required>
                <label for="inputPassword">Age</label>
              </div>
              <div class="form-label-group">
                <input type="password" name="email" class="form-control" placeholder="Email" required>
                <label for="inputPassword">Email</label>
              </div>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Update</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<a href="lusers">List of Users</a>
</body>
</html>