<%--
  Created by IntelliJ IDEA.
  User: gharr
  Date: 9/8/2023
  Time: 6:17 AM
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="mode" type="java.lang.Integer" scope="request" />
<jsp:useBean id="dog" type="com.example.tp_wconnection_01.models.DogDTO" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/bootstrapImports.html"%>
    <title><%= mode == 4 ? "Delete" : mode == 3 ? "Edit" : mode == 2 ? "View" : "Add" %> a Dog</title>
</head>
<body>
    <main class="container">
        <div class="row my-3">
            <div class="col-8 offset-2 rounded p-3 text-bg-dark">
                <form action="<%= request.getContextPath() + "/dogs/" + (mode == 4 ? "delete/" + dog.getId() : mode == 3 ? "edit/" + dog.getId() : mode == 2 ? "details/" + dog.getId() : "add") %>" method="post">
                    <h1 class="fw-light">- <%= mode == 4 ? "Delete" : mode == 3 ? "Edit" : mode == 2 ? "View" : "Add" %> a Dog -</h1>
                    <hr>
                    <input type="number" class="d-none" name="id" value="<%= dog.getId() %>" readonly>
                    <div class="mb-3">
                        <label for="name" class="form-label">Name:</label>
                        <input type="text" class="form-control" name="name" id="name" <% if(mode % 2 == 0) { %> readonly <% } else { %> required <% } %> value="<%= dog.getName() %>">
                    </div>
                    <div class="mb-3">
                        <label for="breed" class="form-label">Breed:</label>
                        <input type="text" class="form-control" name="breed" id="breed" <% if(mode % 2 == 0) { %> readonly <% } else { %> required <% } %> value="<%= dog.getBreed() %>">
                    </div>
                    <div class="mb-3">
                        <label for="dateOfBirth" class="form-label">Birth date:</label>
                        <input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth" <% if(mode % 2 == 0) { %> readonly <% } else { %> required <% } %> value="<%= dog.getDateOfBirth() %>">
                    </div>
                    <hr>
                    <div class="text-end">
                        <% if (mode == 2) { %>
                            <a href="<%= request.getContextPath() + "/dogs/list" %>" class="btn btn-outline-secondary"><i class="bi bi-arrow-counterclockwise"></i> Return</a>
                        <% } else { %>
                            <button class="btn <%= mode == 4 ? "btn-outline-danger" : mode == 3 ? "btn-outline-warning" : mode == 1 ? "btn-outline-success" : "" %>"><i class="bi <%= mode == 4 ? "bi-trash" : mode == 3 ? "bi-pencil-square" : mode == 1 ? "bi-plus-circle" : "" %>"></i> <%= mode == 4 ? "Confirm" : mode == 3 ? "Edit" : mode == 1 ? "Add" : "" %></button>
                        <% } %>
                    </div>
                </form>
            </div>
        </div>
    </main>
</body>
</html>
