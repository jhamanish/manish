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
<title>OnlineShop - Products</title>
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
					<h3 class="text-center text-primary">List of products</h3>
					<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>ProductID</th>
								<th>Barcode</th>
								<th>Product Name</th>
								<th>Quantity</th>
								<th>Product Price</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${allProducts}">
								<tr>
									<td><c:out value="${item.productId}"></c:out></td>
									<td><c:out value="${item.barcode}"></c:out></td>
									<td><c:out value="${item.productName}"></c:out></td>
									<td><c:out value="${item.quantity}"></c:out></td>
									<td><c:out value="${item.productPrice}"></c:out></td>
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