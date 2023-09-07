<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 07/09/2023
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a Person</title>
</head>
<body>
    <main>
        <form action="form" method="post">
            <div>
                <label for="firstname">Firstname: </label>
                <input type="text" name="firstname" id="firstname">
            </div>
            <div>
                <label for="lastname">Lastname: </label>
                <input type="text" name="lastname" id="lastname">
            </div>
            <div>
                <label for="age">Age: </label>
                <input type="number" min="0" max="200" step="0.5" name="age" id="age">
            </div>
            <hr>
            <% if (mode.equals("edit") || mode.equals("add")) { %>
                <button>Submit</button>
            <% } %>

            <% if (request.getParameter("titi").equals("toto")) { %>
                <p>Paramètre titi = toto !</p>
            <% } %>
        </form>
    </main>
</body>
</html>
