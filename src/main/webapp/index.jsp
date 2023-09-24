<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Login</title>
</head>
<body>
<div class="container">
  <h1>Login</h1>
  <form action="control-servlet" method="post" onsubmit="return validateForm()">
    <div class="form-group">
      <label for="email">Username:</label>
      <input type="email" class="form-control" id="email" name="email">
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" name="password">
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
    <a href="register.jsp" class="btn btn-link">Register</a>
    <input type="hidden" name="action" value="logon">
  </form>
</div>
</body>
</html>