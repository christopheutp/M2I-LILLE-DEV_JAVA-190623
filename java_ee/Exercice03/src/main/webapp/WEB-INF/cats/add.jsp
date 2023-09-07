<%@ page import="com.example.exercice03.models.Cat" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 07/09/2023
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="name" type="java.lang.String" scope="request" />
<jsp:useBean id="breed" type="java.lang.String" scope="request" />
<jsp:useBean id="favMeal" type="java.lang.String" scope="request" />
<jsp:useBean id="dateOfBirth" type="java.lang.String" scope="request" />
<jsp:useBean id="confirmation" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="errors" type="java.util.List<java.lang.String>" scope="request" />
<jsp:useBean id="cats" type="java.util.ArrayList<com.example.exercice03.models.Cat>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../bootstrapImports.html" %>
    <title>Add a Cat</title>
</head>
<body>
    <main class="container">
        <div class="row my-3">
            <div class="col-8 offset-2 rounded text-bg-dark p-3">
                <h1 class="fw-light">- Add a Cat -</h1>
                <hr>
                <form action="${pageContext.request.contextPath}/cats/add" method="post">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name:</label>
                        <input type="text" class="form-control" name="name" id="name" value="<%= name %>" required>
                    </div>
                    <div class="mb-3">
                        <label for="breed" class="form-label">Breed:</label>
                        <input type="text" class="form-control" name="breed" id="breed" value="<%= breed %>" required>
                    </div>
                    <div class="mb-3">
                        <label for="favMeal" class="form-label">Favorite meal:</label>
                        <input type="text" class="form-control" name="favMeal" id="favMeal" value="<%= favMeal %>" required>
                    </div>
                    <div class="mb-3">
                        <label for="dateOfBirth" class="form-label">Birth date:</label>
                        <input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth" value="<%= dateOfBirth %>" required>
                    </div>
                    <hr>
                    <div class="text-end">
                        <button class="btn btn-outline-light"><i class="bi bi-send"></i> Send</button>
                    </div>
                </form>
                <hr>
                <% if (confirmation) { %>
                    <p>Chat ajouté avec succès !</p>
                <% } else if (!errors.isEmpty()) { %>
                    <ul>
                        <% for(String err : errors) { %>
                            <li class="text-danger"><%= err %></li>
                        <% } %>
                    </ul>
                <% } %>
                <hr>
                <% if (!cats.isEmpty()) { %>
                <ul>
                    <% for(Cat cat : cats) { %>
                    <li><%= cat.getName() %></li>
                    <% } %>
                </ul>
                <% } %>
            </div>
        </div>
    </main>
</body>
</html>
