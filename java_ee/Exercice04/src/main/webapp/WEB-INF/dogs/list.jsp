<%@ page import="com.example.exercice04.models.Dog" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="dogs" type="java.util.ArrayList<com.example.exercice04.models.Dog>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapImports.html" %>
    <title>Dogs List</title>
</head>
<body>
    <main class="container">
        <div class="row my-3">
            <div class="col-8 offset-2 rounded text-bg-dark p-3">
                <h1 class="fw-light">- Dogs List -</h1>
                <hr>
                <% if (!dogs.isEmpty()) { %>
                    <table class="table table-dark align-middle table-striped text-center">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Breed</th>
                                <th>Birth date</th>
                                <th>Sterilized?</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Dog d : dogs) { %>
                                <tr>
                                    <td><%= d.getId() %></td>
                                    <td><%= d.getName() %></td>
                                    <td><%= d.getBreed() %></td>
                                    <td><%= d.getBirthDate().toString() %></td>
                                    <td><%= d.getSterilized() ? "Yes" : "No" %></td>
                                    <td>
                                        <a href="/dogs/details/<%= d.getId() %>" class="btn btn-outline-info"><i class="bi bi-eye"></i> Details</a>
                                    </td>
                                </tr>
                            <% } %>
                        </tbody>
                    </table>
                <% } else { %>
                    <p>There is no dog in the database yet!</p>
                <% } %>
                <hr>
                <div class="text-end">
                    <a href="${pageContext.request.contextPath}/dogs/add" class="btn btn-outline-success"><i class="bi bi-plus-circle"></i> Add a Dog</a>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
