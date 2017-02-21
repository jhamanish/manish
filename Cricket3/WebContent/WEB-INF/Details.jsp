<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="batsman">
<input type="submit" value="Add Batsman">
</form><br>

<form action="bowler">
<input type="submit" value="Add Bowler">
</form>
<h3>Batsman Details</h3>
<table border=1>
<tr>
<th>Name</th><th>Batting Style</th><th>Runs</th><th>Maidens</th><th>Balls</th><th>Fours</th><th>Sixes</th>
</tr>
<c:forEach items="${bat}" var="bat">
<tr>
			<td>${bat.name}</td>
			<td>${bat.batting_style}</td>
			<td>${bat.runs}</td>
			<td>${bat.maidens}</td>
			<td>${bat.balls}</td>
			<td>${bat.fours}</td>
			<td>${bat.sixes}</td>
<!-- 			<td>Quantity<input type="text" name="quantity"></td> -->
			</tr>
		</c:forEach>
</table>
<h3>Bowler Details</h3>
<table border=1>
<tr>
<th>Name</th><th>Bowling Style</th><th>Runs</th><th>Maidens</th><th>Balls</th><th>Overs</th><th>Fours</th><th>Sixes</th>
<th>No Balls</th><th>Wides</th><th>Wickets</th><th>Economy</th>
</tr>
<c:forEach items="${bowler}" var="bowler">
<tr>
			<td>${bowler.name}</td>
			<td>${bowler.bowling_style}</td>
			<td>${bowler.runs}</td>
			<td>${bowler.maidens}</td>
			<td>${bowler.balls}</td>
			<td>${bowler.overs}</td>
			<td>${bowler.fours}</td>
			<td>${bowler.sixes}</td>
			<td>${bowler.noballs}</td>
			<td>${bowler.wides}</td>
			<td>${bowler.wickets}</td>
			<td>${bowler.economy}</td>
			</tr>
		</c:forEach>
</table>
</body>
</html>