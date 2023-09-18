<%--
  Created by IntelliJ IDEA.
  User: gharr
  Date: 9/7/2023
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="email" type="java.lang.String" scope="request" />
<jsp:useBean id="password" type="java.lang.String" scope="request" />
<jsp:useBean id="errors" type="java.util.List<java.lang.String>" scope="request" />
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapImports.html"%>
    <title>Sign Up</title>
</head>
<body>
<main class="container">
    <div class="my-3 row">
        <div class="col-8 offset-2 rounded text-bg-dark p-3">
            <form action="${pageContext.request.contextPath}/auth/signUp" method="post">
                <h2 class="fw-light">- Sign Up -</h2>
                <hr>
                <% if (!errors.isEmpty()) { %>
                <ul class="mb-3">
                    <% for (String e : errors) { %>
                    <li class="text-warning"><%= e %></li>
                    <% } %>
                </ul>
                <% } %>
                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" name="email" id="email" class="form-control" value="${email}" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" name="password" id="password" class="form-control" value="${password}" required>
                </div>
                <hr>
                <div class="text-end">
                    <button class="btn btn-outline-light"><i class="bi bi-send"></i> Submit</button>
                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>
