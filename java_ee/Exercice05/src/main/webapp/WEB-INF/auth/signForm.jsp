<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<jsp:useBean id="user" type="com.example.exercice05.models.UserDTO" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapImports.html" %>
    <title><%= mode.equals("signIn") ? "Sign In" : "Register" %></title>
</head>
<body>
    <main class="container">
        <div class="row my-3">
            <div class="col-8 offset-2 p-3 rounded text-bg-dark">
                <h1 class="fw-light"><%= mode.equals("signIn") ? "Sign In" : "Register" %></h1>
                <hr>
                <form action="" method="post">
                    <% if (mode.equals("signUp")) { %>
                        <div class="mb-3">
                            <label for="firstname" class="form-label">Firstname:</label>
                            <input type="text" name="firstname" id="firstname" value="<%= user.getFirstname() %>" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="lastname" class="form-label">Lastname:</label>
                            <input type="text" name="lastname" id="lastname" value="<%= user.getLastname() %>" class="form-control" required>
                        </div>
                    <% } %>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email:</label>
                        <input type="email" name="email" id="email" value="<%= user.getEmail() %>" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password:</label>
                        <input type="password" name="password" id="password" value="<%= user.getPassword() %>" class="form-control" required>
                    </div>
                    <hr>
                    <div class="text-end">
                        <a href="<%= mode.equals("signIn") ? "signUp" : "signIn" %>" class="btn btn-outline-info me-2">Switch to <%= !mode.equals("signIn") ? "Sign In" : "Register" %></a>
                        <button class="btn btn-outline-light"><i class="bi bi-send"></i> Submit</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
</body>
</html>
