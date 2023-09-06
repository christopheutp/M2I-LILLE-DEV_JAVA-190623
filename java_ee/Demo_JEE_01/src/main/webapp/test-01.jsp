<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/09/2023
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<!-- Test de commentaire HTML -->
<%! String prenom = "Albert"; %>
<jsp:useBean id="prenomB" type="java.lang.String" scope="request" />
<jsp:useBean id="prenoms" type="java.util.ArrayList<java.lang.String>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/bootstrapImports.html" %>
    <title>Test 01</title>
</head>
<body>
    <main>
        <h1>Test 01</h1>
        <hr>
        <p>
            Merci d'être sur la page de test n°01 !
        </p>
        <hr>
        <p>
            Le prénom de la personne déclaré depuis la JSP est <%= prenom %>
        </p>
        <hr>
        <p>
            Le prénom de la personne déclaré depuis le servlet en notation $ est ${blabla}
        </p>
        <hr>
        <p>
            Le prénom de la personne déclaré depuis le servlet avec useBean est <%= prenomB.toUpperCase() %>
        </p>
        <hr>
        <ul>
            <% for (String pre : prenoms) { %>
                <li><%= pre %></li>
            <% } %>
        </ul>
    </main>
</body>
</html>
