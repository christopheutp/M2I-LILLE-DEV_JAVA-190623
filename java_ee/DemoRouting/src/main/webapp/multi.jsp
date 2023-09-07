<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 07/09/2023
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="prenom" type="java.lang.String" scope="request" />
<jsp:useBean id="pathInfoB" type="java.lang.String" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main>
    <h1>Bienvenue sur le servlet multiRoutesServlet!</h1>
    <hr>
    <p>La valeur de pathInfo est : <%= pathInfoB %></p>
    <p>Le prénom trouvé est : <%= prenom %></p>
</main>

</body>
</html>
