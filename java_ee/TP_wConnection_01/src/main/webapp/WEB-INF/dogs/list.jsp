<%@ page import="com.example.tp_wconnection_01.models.Dog" %><%--
  Created by IntelliJ IDEA.
  User: gharr
  Date: 9/7/2023
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="dogs" type="java.util.ArrayList<com.example.tp_wconnection_01.models.Dog>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapImports.html" %>
    <title>Dogs List</title>
</head>
<body>
    <main class="container">
        <div class="my-3 row">
            <div class="col-8 offset-2 text-bg-dark rounded p-3">
                <h1 class="fw-thin">- Dogs List -</h1>
                <hr>
                <% if (!dogs.isEmpty()) { %>
                    <table class="table table-dark text-center align-middle table-striped">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Breed</th>
                            <th>Birth date</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% for (Dog d : dogs) { %>
                        <tr>
                            <td><%= d.getId() %></td>
                            <td><%= d.getName() %></td>
                            <td><%= d.getBreed() %></td>
                            <td><%= d.getDateOfBirth() %></td>
                            <td>
                                <a href="<%= "details/" + d.getId() %>" class="btn btn-outline-info"><i class="bi bi-eye"></i> Details</a>
                                <a href="<%= "edit/" + d.getId() %>" class="btn btn-outline-warning"><i class="bi bi-pencil-square"></i> Edit</a>
                                <a href="<%= "delete/" + d.getId() %>" class="btn btn-outline-danger"><i class="bi bi-trash"></i> Delete</a>
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
