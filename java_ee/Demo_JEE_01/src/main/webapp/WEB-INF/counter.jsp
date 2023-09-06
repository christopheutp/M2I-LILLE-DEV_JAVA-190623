<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/09/2023
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="numberBis" type="java.lang.Integer" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Counter</title>
</head>
<body>
<main>
    <h1>My Counter</h1>
    <hr>
    <p>Current value: <b>${number.toString()}</b></p>
    <p>Current value: <b>${numberBis}</b></p>
    <p>Current value: <b><%= numberBis %></b></p>
</main>
</body>
</html>
