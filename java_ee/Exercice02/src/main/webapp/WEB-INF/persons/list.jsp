<%@ page import="com.example.exercice02.models.Person" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/09/2023
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="persons" type="java.util.ArrayList<com.example.exercice02.models.Person>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <title>Persons - List</title>
</head>
<body>
    <main class="container">
        <div class="row my-3">
            <div class="col-8 offset-2 text-bg-dark rounded p-3">
                <h1 class="fw-light">- Persons List -</h1>
                <hr>
                <table class="table table-dark text-center align-middle">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Firstname</th>
                            <th>Lastname</th>
                            <th>Age</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (int i = 0; i < persons.size(); i++) { %>
                            <tr>
                                <td><%= i %></td>
                                <td><%= persons.get(i).getFirstname() %></td>
                                <td><%= persons.get(i).getLastname() %></td>
                                <td><%= persons.get(i).getAge() %></td>
                                <td>
                                    <a href="persons/details/<%= i %>" class="btn btn-outline-light">Details</a>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
</body>
</html>
