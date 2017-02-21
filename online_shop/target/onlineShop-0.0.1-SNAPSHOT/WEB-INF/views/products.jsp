<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
<title>Billing Systems - Products and Orders</title>
</head>
<body>
	<div class="jumbotron">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div class="container">
		<div class="row">
			<h4 class="text-danger text-center">
				<span>${message}</span>
			</h4>
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
				<div class="down">
					<h3 class="text-center text-primary">Search Products</h3>
					<form action="findBarcode" method="GET">
						<input type="text" name="barcode" class="form-control"><br />
						<input type="submit" class="btn btn-sm btn-primary"
							value="Add to Cart">
					</form>
					<br />
				</div>
			</div>
			<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
				<h3 class="text-center text-primary">Product Details</h3>
				<div>
					<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>ProductID</th>
								<th>Barcode</th>
								<th>Product Name</th>
								<th>Quantity</th>
								<th>Price</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${productList}">
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
			</div>
		</div>
		<br /> <a href="generateOrder"
			class="btn btn-lg btn-warning pull-right">Confirm Order</a><br /> <br />
		<hr />
		<div class="row">
			<h3 class="text-danger">Order Details</h3>
			<br />
			<div class="col-lg-5 col-md-5 col-sm-5 col-xs-12"></div>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
				<form:form method="POST" commandName="orderDetails"
					action="takeOrder">
					<div class="form-group">
						<label>Customer ID :</label>
						<form:input path="customerId" type="text" class="form-control"
							placeholder="Enter CustomerID" required="true" />
					</div>
					<br />
					<div class="form-group">
						<label>Order No. :</label>
						<form:input path="orderNo" type="text" class="form-control"
							placeholder="Order Number" required="true" />
					</div>
					<br />
					<div class="form-group">
						<label>Order Type :</label>
						<form:select path="orderType" class="form-control">
							<form:option value="cash" label="Cash" />
							<form:option value="card" label="Card" />
						</form:select>
					</div>
					<br />
					<div class="form-group">
						<label>Product Details :</label>
						<form:input path="productInfo" type="text" class="form-control"
							value="${productInfo}" required="true" readonly="true" />

					</div>
					<br />
					<div class="form-group">
						<label>Total Amount :</label>
						<form:input path="totalAmount" type="text" class="form-control"
							value="${totalAmount}" required="true" readonly="true" />
					</div>
					<br />
					<div class="form-group">
						<label>Order Status</label>
						<form:select path="orderStatus" class="form-control">
							<form:option value="paid" label="Paid" />
							<form:option value="balance" label="Balance" />
						</form:select>
					</div>
					<br />
					<div>
						<input type="submit" value="Place Order"
							class="btn btn-lg btn-warning pull-right" />
					</div>
				</form:form>
			</div>
		</div>
		<br />
	</div>
	<br />
	<jsp:include page="footer.jsp"></jsp:include>


	<script src="static/js/lib/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="static/js/lib/bootstrap.js" type="text/javascript"></script>

</body>
</html>