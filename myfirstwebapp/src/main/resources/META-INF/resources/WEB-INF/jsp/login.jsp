<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
  </head>
  <body>
  <div class="container">
    <h2>Login</h2>
    <div>
      <pre>${errorMsg}</pre>
    </div>
    <form method="post">
      <div>
        <label for="username">Username</label>
        <input type="text" name="username" id="username" placeholder="Username" required/>
      </div>
      <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" placeholder="Password" required/>
      </div>
      <input type="submit" value="Enter">
    </form>
  </div>
  </body>
  <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</html>
