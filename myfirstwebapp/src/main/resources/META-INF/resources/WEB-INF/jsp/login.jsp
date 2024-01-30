<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
</head>
<body>
<div class="login-container">
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
</html>
