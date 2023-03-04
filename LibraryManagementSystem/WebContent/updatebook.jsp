<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update form</title>
</head>
<body bgcolor="lightblue">
<form method="post" action="./control/updatebook">
<h1 style='text-align:center; color:brown'>TO UPDATE BOOK DETAILS</h1>
    <div style='padding-left:500px;'>
        <label for="id">BOOK ID </label> <br/> 
        </br> 
        <input type="text" id="id" name='bid'/> <br/> 
        </br>
        <input type='submit' value='Edit' />
    </div>
</form>
</body>
</html>