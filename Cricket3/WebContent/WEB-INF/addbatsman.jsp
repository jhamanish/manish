<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- <script>
// function validateform(){  
// var name=document.myform.name.value;  
// var batting_style=document.myform.batting_style.value;
// var runs=document.myform.runs.value;
// var maidens=document.myform.maidens.value;
// var balls=document.myform.balls.value;
// var fours=document.myform.fours.value;
// var sixes=document.myform.sixes.value;
// if (name==null || name=="" || batting_style==null || batting_style=="" || runs==null || runs=="" || maidens==null || maidens=="" || balls==null || balls=="" || fours==null || fours=="" || sixes==null || sixes==""){  
//   alert("Enter Valid Details");  
//   return false;  
// } 
// }  
 </script> -->
<form action="addbatsman" ><!-- name="myform" onsubmit="return validateform()" -->
<table>
	<tr>
		<td>Batsman Name: </td><td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>Batting Style: </td>
	<td>
		<input type="radio" id="batting_style" name="batting_style" value="right"/>Right Handed<br>
              <input type="radio" id="batting_style" name="batting_style" value="left"/>Left Handed<br> 
              </td>
	</tr>
	<tr>
		<td>Runs: </td><td><input type="text" name="runs">
	</tr>
	<tr>
		<td>Maidens: </td><td><input type="text" name="maidens"></td>
	</tr>
	<tr>
		<td>Balls: </td><td><input type="text" name="balls"></td>
	</tr> 
	<tr>
		<td>Fours: </td><td><input type="text" name="fours"></td>
	</tr>
	<tr>
		<td>Sixes: </td><td><input type="text" name="sixes"></td>
	</tr>
</table>
<input type="submit" value="Save">
</form>
</body>
</html>