<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>The new Page</title>
</head>
<body>
	<div class="jumbotron">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div class="container">
		<div class="row">
			<h3>New Page</h3>
		</div>
		<br />

	</div>
	<form action="hierarchy" method="get">
		<div class="form-group">
			<label>Enter Country :</label> <input type="text" name="country" />
		</div>
		<div class="form-group">
			<label>Enter State :</label> <input type="text" name="state" />
		</div>
		<div class="form-group">
			<label>Enter City :</label> <input type="text" name="city" />
		</div>
		<br /> <input type="submit" value="Add" class="btn btn-primary btn-sm" />
	</form>
	<br />
	<br />
	<hr />
	${list}
	<%-- <div>
		<c:forEach var="item" items="${list}">
			<p>${item.country}</p>
			<p>${item.state}</p>
			<p>${item.city}</p>
		</c:forEach>
	</div> --%>


	<script src="static/js/lib/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="static/js/lib/bootstrap.js" type="text/javascript"></script>

</body>
</html>