<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<title>All Data</title>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/covid.png">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<style>
tr th:first-child {
	width: 65%;
}
</style>
</head>
<body style="background-image: url('${pageContext.request.contextPath}/images/covid.png');
	background-repeat: no-repeat; background-attachment: fixed; background-size: cover;">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">
			<img src="${pageContext.request.contextPath}/images/covid.png" width="30" height="30" 
				class="d-inline-block align-top" alt="">
				&nbsp;&nbsp;Covid-19 World Data Tracker
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarColor02"
				aria-controls="navbarColor02" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarColor02">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link active" href="http://localhost:8080/all">All</a>
					</li>
					<li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
						href="#" role="button" aria-haspopup="true" aria-expanded="false">Continents</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="http://localhost:8080/continent/North America">North America</a> 
							<a class="dropdown-item" href="http://localhost:8080/continent/Asia">Asia</a>
							<a class="dropdown-item" href="http://localhost:8080/continent/South America">South America</a> 
							<a class="dropdown-item" href="http://localhost:8080/continent/Europe">Europe</a>
							<a class="dropdown-item" href="http://localhost:8080/continent/Africa">Africa</a> 
							<a class="dropdown-item" href="http://localhost:8080/continent/Australia-Oceania">Australia-Oceania</a>
						</div>
					</li>
					<li class="nav-item"><a class="nav-link" href="http://localhost:8080/countries">Countries</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="http://localhost:8080/states">States</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div
		style="width: 100%; max-width: 960px; margin: 0 auto; margin-top: 25px;">
		<c:forEach items="${allData}" var="item">
			<div class="card text-white bg-dark border-light mb-3" id="card"
				style="display: inline-block; width: 460px; height: 320px;">
				<div class="card-header" style="text-align: center;">TODAY</div>
				<div class="card-body">
					<p class="card-text">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Cases</th>
								<th scope="col">${item.todayCases}</th>
							</tr>
							<tr>
								<th scope="col">Deaths</th>
								<th scope="col">${item.todayDeaths}</th>
							</tr>
							<tr>
								<th scope="col">Recovered</th>
								<th scope="col">${item.todayRecovered}</th>
							</tr>
							<tr>
								<th scope="col">&nbsp;</th>
								<th scope="col">&nbsp;</th>
							</tr>
							<tr>
								<th scope="col">&nbsp;</th>
								<th scope="col">&nbsp;</th>
							</tr>
							<tr>
								<th scope="col">&nbsp;</th>
								<th scope="col">&nbsp;</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			<div class="card text-white bg-dark border-light mb-3" id="card"
				style="display: inline-block; width: 460px; height: 320px;">
				<div class="card-header" style="text-align: center;">TOTAL</div>
				<div class="card-body">
					<p class="card-text">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Cases</th>
								<th scope="col">${item.cases}</th>
							</tr>
							<tr>
								<th scope="col">Deaths</th>
								<th scope="col">${item.deaths}</th>
							</tr>
							<tr>
								<th scope="col">Recovered</th>
								<th scope="col">${item.recovered}</th>
							</tr>
							<tr>
								<th scope="col">Active</th>
								<th scope="col">${item.active}</th>
							</tr>
							<tr>
								<th scope="col">Critical</th>
								<th scope="col">${item.critical}</th>
							</tr>
							<tr>
								<th scope="col">Tests</th>
								<th scope="col">${item.tests}</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			<div class="card text-white bg-dark border-light mb-3" id="card"
				style="display: inline-block; width: 460px; height: 320px;">
				<div class="card-header" style="text-align: center;">PER ONE
					MILLION</div>
				<div class="card-body">
					<p class="card-text">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Cases</th>
								<th scope="col">${item.casesPerOneMillion}</th>
							</tr>
							<tr>
								<th scope="col">Deaths</th>
								<th scope="col">${item.deathsPerOneMillion}</th>
							</tr>
							<tr>
								<th scope="col">Recovered</th>
								<th scope="col">${item.recoveredPerOneMillion}</th>
							</tr>
							<tr>
								<th scope="col">Active</th>
								<th scope="col">${item.activePerOneMillion}</th>
							</tr>
							<tr>
								<th scope="col">Ctitical</th>
								<th scope="col">${item.criticalPerOneMillion}</th>
							</tr>
							<tr>
								<th scope="col">Tests</th>
								<th scope="col">${item.testsPerOneMillion}</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			<div class="card text-white bg-dark border-light mb-3" id="card"
				style="display: inline-block; width: 460px; height: 320px;">
				<div class="card-header" style="text-align: center;">INFO</div>
				<div class="card-body">
					<p class="card-text">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Population</th>
								<th scope="col">${item.population}</th>
							</tr>
							<tr>
								<th scope="col">Affected Countries</th>
								<th scope="col">${item.affectedCountries}</th>
							</tr>
							<tr>
								<th scope="col">&nbsp;</th>
								<th scope="col">&nbsp;</th>
							</tr>
							<tr>
								<th scope="col">&nbsp;</th>
								<th scope="col">&nbsp;</th>
							</tr>
							<tr>
								<th scope="col">&nbsp;</th>
								<th scope="col">&nbsp;</th>
							</tr>
							<tr>
								<th scope="col">&nbsp;</th>
								<th scope="col">&nbsp;</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>