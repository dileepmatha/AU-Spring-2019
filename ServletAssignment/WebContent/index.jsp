
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Login Form</title>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
           <h5 class="card-title text-center">Login In</h5>
            <form class="form-signin" method = "post" action = "LoginFromHandle">
              <div class="form-label-group">
                <input type="text" name="inputName" class="form-control" placeholder="Email address" required autofocus>
                <label for="inputEmail">User Name</label>
              </div>
              <div class="form-label-group">
                <input type="password" name="inputPassword" class="form-control" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>
              <div>
              	<label style="color: red;"> ${message} </label>
              </div>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>