<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 29/9/2023
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard Admin</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</head>
<body>
<div>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">David Chau</a>
            </div>
            <ul class="nav navbar-nav">
                <li id="account"><a href="/lab_week01/ViewAccount">Manager Account</a></li>
                <li id="log"><a href="/lab_week01/ViewLogCtrl">Manager Log</a></li>
                <li ><a href="/lab_week01/LogoutControl"><i class="fas fa-sign-out-alt"></i> LogOut</a></li>
            </ul>
        </div>
    </nav>
    <div id="welcome">
        <h1>Welcome, ${account.full_name}</h1>
        <p>Info user: ${account}</p> <br>
    </div>
</div>
</body>
</html>
