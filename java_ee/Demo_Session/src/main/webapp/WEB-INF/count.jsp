<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 08/09/2023
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="count" type="java.lang.Integer" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <main>
        <p>
            Le compteur vaut : <b><%= count %></b>
        </p>

        <hr>

        <form action="" method="post">
            <input type="number" name="count" style="display: none;" readonly value="<%= count %>">
            <button>Submit</button>
        </form>
    </main>
</body>
</html>
