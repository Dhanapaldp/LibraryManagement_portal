<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue" >
<style>
tr
{
    border: 1px solid;
    margin-top: 10px ;
    padding: 10px;
}
</style>
<form action="./control/student">
<h1 style='text-align:center; color:brown'>STUDENT REGISTRATION FORM</h1>
<br/><br/>
   <table border='1' align='center' >
     <tr><th>STUDENT ID</th><td><input type='text' name='sid' /></td></tr>
     <tr><th>STUDENT NAME</th><td><input type='text' name='sname' /></td></tr>
     <tr><th>BRANCH</th><td><input type='text' name='branch' /></td></tr>
     <tr><th>MOBILE NUMBER</th><td><input type='text' name='mobile' /></td></tr>
     <tr><td><td><input type='submit' value ='Register' /></td></tr>
     
   </table>
</body>
</html>