<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="static/css/lib/bootstrap.css" rel="stylesheet"
	type="text/css" />
<link href="static/css/lib/bootstrap-theme.css" rel="stylesheet"
	type="text/css" />
<link href="static/css/style.css" rel="stylesheet" type="text/css" />

<title>OnlineShop - Home</title>
</head>
<body>
	<div class="jumbotron">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div class="container">
		<h3>
			<a href="getBarcode">Search Products</a>
		</h3>
		<h3>
			<a href="allUsers">See all users</a>
		</h3>
		<h3>
			<a href="products">See all Products</a>
		</h3>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	

	<script src="static/js/lib/bootstrap.js" type="text/javascript"></script>
	<script src="static/js/lib/jquery-2.0.0.js" type="text/javascript"></script>
	<script src="static/js/lib/angular-1.6.0/angular.js"
		type="text/javascript"></script>
	<script src="static/js/lib/angular-1.6.0/angular-route.js"
		type="text/javascript"></script>
	<script src="static/js/main/application.js" type="text/javascript"></script>
	<script src="static/js/controller/homeController.js"
		type="text/javascript"></script>
	<script src="static/js/controller/restController.js"
		type="text/javascript"></script>
	<script src="static/js/controller/P1Controller.js"
		type="text/javascript"></script>


</body>
</html>