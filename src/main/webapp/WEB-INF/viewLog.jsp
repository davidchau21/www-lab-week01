<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/10/2023
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%include file="dashboard_admin.jsp"%>
    <div class="container">
        <table>
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">account_id</th>
                <th scope="col">login_time</th>
                <th scope="col">logout_time</th>
                <th scope="col">notes</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listLogs}" var="log">
                <tr>
                    <td>${log.id}</td>
                    <td>${log.account_id}</td>
                    <td>${log.login_time}</td>
                    <td>${log.logout_time}</td>
                    <td>${log.notes}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
    <script>
        document.getElementById("log").classList.toggle("active");
        document.getElementById("welcome").style.display="none";
    </script>
</body>
</html>
