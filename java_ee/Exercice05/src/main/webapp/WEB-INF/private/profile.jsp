<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="user" type="com.example.exercice05.models.User" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapImports.html" %>
    <title>User Profile</title>
</head>
<body>
    <main class="container">
        <div class="row my-3">
            <div class="col-8 offset-2 rounded text-bg-dark p-3">
                <h1 class="fw-light">User Profile</h1>
                <hr>
                <ul>
                    <li><b>Firstname: </b><%= user.getFirstname() %></li>
                    <li><b>Lastname: </b><%= user.getLastname() %></li>
                    <li><b>Email: </b><%= user.getEmail() %></li>
                </ul>
            </div>
        </div>
    </main>
</body>
</html>
