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
<title>OnlineShop - Customers</title>
</head>
<body>
	<div class="jumbotron">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"></div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div>
					<h3 class="text-center text-primary">List of Customers</h3>
					<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>CustomerID</th>
								<th>Customer Name</th>
								<th>Customer Email</th>
								<th>Customer Contact</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${allCustomers}">
								<tr>
									<td><c:out value="${item.customerId}"></c:out></td>
									<td><c:out value="${item.customerName}"></c:out></td>
									<td><c:out value="${item.customerEmail}"></c:out></td>
									<td><c:out value="${item.customerContact}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<hr />
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"></div>
		</div>
		<hr />
	</div>
	<jsp:include page="footer.jsp"></jsp:include>


	<script src="static/js/lib/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="static/js/lib/bootstrap.js" type="text/javascript"></script>

</body>
</html>