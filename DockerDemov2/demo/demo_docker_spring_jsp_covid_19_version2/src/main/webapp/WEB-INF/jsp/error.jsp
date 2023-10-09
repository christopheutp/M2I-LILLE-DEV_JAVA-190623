<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<title>Error</title>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/covid.png">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/images/covid.png');
	background-repeat: no-repeat; background-attachment: fixed; background-size: cover;">
	<div style="height: 10em; display: flex; align-items: center; justify-content: center; margin-top: 200px;">
		<div class="card text-white bg-dark border-light mb-3" id="card"
			style="margin: 10px; max-width: 35rem; display: inline-block; width: 500px;">
			<div class="card-header">Page Not Found!</div>
			<div class="card-body">
				<h4 class="card-title"></h4>
				<p class="card-text">Looks like you've followed a broken link or
					entered a URL that doesn't exist on this site.</p>
				<form action="http://localhost:8080/all" style="margin-left: 308px;">
					<button type="submit" class="btn btn-primary">Back to home page</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>