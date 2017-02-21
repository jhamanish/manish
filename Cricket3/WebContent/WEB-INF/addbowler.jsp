<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>  
function validateform(){  
var name=document.myform.name.value;  
var bowling_style=document.myform.bowling_style.value;
var runs=document.myform.runs.value;
var maidens=document.myform.maidens.value;
var balls=document.myform.balls.value;
var fours=document.myform.fours.value;
var sixes=document.myform.sixes.value;
var overs=document.myform.overs.value;
var wides=document.myform.wides.value;
var noballs=document.myform.noballs.value;
var wickets=document.myform.sixes.value;
var economy=document.myform.economy.value;

  
if (name==null || name=="" || batting_style==null || batting_style=="" || runs==null || runs=="" || maidens==null || maidens=="" || balls==null || balls=="" || fours==null || fours=="" || sixes==null || sixes=="" || overs==null || overs==""|| wides==null || wides==""|| noballs==null || noballs==""|| wickets==null || wickets==""|| economy==null || economy==""){  
  alert("Enter Valid Details");  
  return false;  
}
}  
</script>
	<form action="addbowler" name="myform" onsubmit="return validateform()">
<table>
	<tr>
		<td>Bowler Name: </td><td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>Bowling Style: </td>
	<td>
		<input type="radio" id="bowling_style" name="bowling_style" value="rightarm"/>Right Arm<br>
              <input type="radio" id="bowling_style" name="bowling_style" value="leftarm"/>Left Arm<br> 
              </td>
	</tr>
	<tr>
		<td>Runs: </td><td><input type="text" name="runs"></td>
	</tr>
	<tr>
		<td>Maidens: </td><td><input type="text" name="maidens"></td>
	</tr>
	<tr>
		<td>Balls: </td><td><input type="text" name="balls"></td>
	</tr> 
	<tr>
		<td>Overs: </td><td><input type="text" name="overs"></td>
	</tr>
	<tr>
		<td>Fours: </td><td><input type="text" name="fours"></td>
	</tr>
	<tr>
		<td>Sixes: </td><td><input type="text" name="sixes"></td>
	</tr>
	<tr>
		<td>Wides: </td><td><input type="text" name="wides"></td>
	</tr>
	<tr>
		<td>Noballs: </td><td><input type="text" name="noballs"></td>
	</tr>
	<tr>
		<td>Wickets: </td><td><input type="text" name="wickets"></td>
	</tr>
	<tr>
		<td>Economy: </td><td><input type="text" name="economy"></td>
	</tr>
</table>
<input type="submit" value="Save">
</form>
</body>
</html>