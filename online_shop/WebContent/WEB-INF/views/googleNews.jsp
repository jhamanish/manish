<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Google News Demo</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="static/css/lib/bootstrap.css" rel="stylesheet"
	type="text/css" />
<link href="static/css/lib/bootstrap-theme.css" rel="stylesheet"
	type="text/css" />
<script src="static/js/chart.js" type="text/javascript"></script>

</head>
<body>
	<div class="container-fluid">
		<div class="jumbotron">
			<h2 class="text-primary text-center">Google News</h2>
		</div>
		<div class="row">
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
				<h3 class="text-danger">News</h3>
				<ul class="list-group">
					<li class="list-group-item">News first</li>
					<li class="list-group-item">Recent Happenings</li>
					<li class="list-group-item">Sports News</li>
					<li class="list-group-item">Wrestling World</li>
					<li class="list-group-item">Wild Life</li>
				</ul>

			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<c:forEach var="item" items="${newsList}">
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
							<img src="${item.imagePath}" alt="Image"
								class="img-thumbnail img-responsive">
						</div>

						<div class="col-lg-10 col-md-10 col-sm-10 col-xs-12 ">

							<h3 class="text-primary">
								<a href="#"> <c:out value="${item.headline}"></c:out></a>
							</h3>
							<p>
								<c:out value="${item.content}"></c:out>
							</p>

						</div>
					</div>
					<br />
					<hr />
				</c:forEach>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
				<div>
					<div>
						<div class="progress-bar" role="progressbar" aria-valuenow="0"
							aria-valuemin="0" aria-valuemax="100"></div>
					</div>
					<div class="progress">
						<div class="progress-bar progress-bar-striped active"
							role="progressbar" aria-valuenow="10" aria-valuemin="0"
							aria-valuemax="100" style="width: 100%">100%</div>
					</div>
				</div>
				<br />
				<hr />
				<div id="chartContainer" style="height: 300px; width: 100%;"></div>
			</div>
		</div>
	</div>


	<script src="static/js/lib/jquery-2.0.0.js" type="text/javascript"></script>
	<script src="static/js/lib/jquery.canvasjs.min.js"
		type="text/javascript"></script>
	<script src="static/js/lib/progressbar.min.js" type="text/javascript"></script>
	<script src="static/js/lib/bootstrap.js" type="text/javascript"></script>
</body>
</html>