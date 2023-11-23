<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">

  <style>
    body {
      background-color: #f8f9fa;
    }

    .container {
      background-color: #ffffff;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      border-radius: 10px;
      padding: 30px;
      margin-top: 50px;
    }

    h2 {
      color: #008b6b;
    }

    .form-group {
      margin-bottom: 20px;
    }

    .form-control {
      border-radius: 5px;
    }

    .btn-success {
      background: #008b6b;
      color: white;
      border-color: #00078b;
    }

    .btn-success:hover {
      background: #006a4e;
    }
  </style>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
          integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
          integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
          integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
          crossorigin="anonymous"></script>

  <script>
    document.addEventListener("DOMContentLoaded", function () {
      let arrCookie = document.cookie.split(";");
      let alertShown = false;

      function checkCookie() {
        for (let i in arrCookie) {
          let keyAndValue = arrCookie[i].split("=");
          let key = keyAndValue[0];
          let value = keyAndValue[1];
          if (key == "state_login" && value == "user_null") {
            alert("User not found. Please login again!");
            alertShown = true;
          }
          if (key == "state_login" && value == "user_pwd_fail") {
            alert("Incorrect password. Please login again!");
            alertShown = true;
          }
        }
      }

      document.getElementById("loginForm").addEventListener("submit", function (event) {
        let accountId = document.getElementById("accountId").value;
        let password = document.getElementById("pwd").value;

        if (accountId === "" || password === "") {
          alert("Please enter both Account and Password!");
          event.preventDefault();
        } else {
          if (!alertShown) {
            checkCookie();
          }
        }
      });

      checkCookie();
    });
  </script>
</head>

<body>
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <h2 class="text-center">Login</h2>
      <form class="form-horizontal" action="ControlServlet" id="loginForm">
        <div class="form-group">
          <label class="control-label" for="accountId">Account:</label>
          <input class="form-control" id="accountId" placeholder="Enter Account" name="accountId">
        </div>
        <div class="form-group">
          <label class="control-label" for="pwd">Password:</label>
          <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
        </div>
        <div class="form-group text-center">
          <button type="submit" class="btn btn-success">Login</button>
        </div>
      </form>
    </div>
  </div>
</div>
</body>

</html>
