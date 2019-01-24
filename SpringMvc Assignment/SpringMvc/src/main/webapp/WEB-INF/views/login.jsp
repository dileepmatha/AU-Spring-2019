<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
           <h5 class="card-title text-center">Login In</h5>
            <form class="form-signin" method = "post" action = "login1">
              <div class="form-label-group">
                <input type="text" name="userName" class="form-control" placeholder="Email address" required autofocus>
                <label for="inputEmail">User Name</label>
              </div>
              <div class="form-label-group">
                <input type="password" name="password" class="form-control" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>
              <label color="red">${ message}</label>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
            </form>
            <br />
            <form class="form-signin" method="get" action = "register">
            	<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">register</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>