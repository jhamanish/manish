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
<title>OnlineShop - Results</title>
</head>
<body>
	<div class="jumbotron">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div class="container">
		<div class="row">
			<h3>
				<strong>${message}</strong>
			</h3>
			<br />
			<div>
				<h4>Order Summary :</h4>
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>OrderNo</th>
							<th>OrderType</th>
							<th>Order Details</th>
							<th>Total Amount</th>
							<th>Order Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${orders}">
							<tr>
								<td>${item.orderNo}</td>
								<td>${item.orderType}</td>
								<td>${item.productInfo}</td>
								<td>${item.totalAmount}</td>
								<td>${item.orderStatus}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<h4>
				<a href="${pageContext.request.contextPath}/getBarcode"
					class=" btn btn-sm btn-primary pull-right">Make another order</a>
			</h4>
			<h4>
				<a href="${pageContext.request.contextPath}/"
					class="btn btn-sm btn-primary  pull-right">Go Home</a>
			</h4>
		</div><br/>
		<hr />
	</div>
	<jsp:include page="footer.jsp"></jsp:include>


	<script src="static/js/lib/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="static/js/lib/bootstrap.js" type="text/javascript"></script>

</body>
</html>