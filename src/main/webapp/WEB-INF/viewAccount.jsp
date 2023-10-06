<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 6/10/2023
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Account</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</head>
<body>
    <%@include file="dashboard_admin.jsp"%>
    <div class="container">
        <table>
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Password</th>
                <th scope="col">Phone</th>
                <th scope="col">Statue</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="$listAccount" var="account">
                <tr>
                   <td>${account.account_id}</td>
                    <td>${account.full_name}</td>
                    <td>${account.email}</td>
                    <td>${account.password}</td>
                    <td>${account.phone}</td>
                    <td>${account.status}</td>
                    <td>
                        <a href="/lab_week01/DelAccountCtrl?id=${account.account_id}"><i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <form action="/lab_week01/AddAccountCtrl">
                    <td><input style="width: 100px" type="text" name="id"></td>
                    <td><input style="width: 200px" type="text" name="name"></td>
                    <td><input style="width: 200px" type="text" name="email"></td>
                    <td><input style="width: 200px" type="text" name="pwd"></td>
                    <td><input style="width: 200px" type="text" name="phone"></td>
                    <td><input style="width: 50px" type="text" name="statue"></td>
                    <td>
                        <input class="btn-success" type="submit" value="create"></input>
                    </td>
                </form>
            </tr>
            </tbody>
        </table>

    </div>
    <script>
        document.getElementById("account").classList.toggle("active");
        document.getElementById("welcome").style.display="none";
    </script>
</body>
</html>
