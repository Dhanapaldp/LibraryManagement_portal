<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Library portal</title>
<style>
body{
   background-image:url("img/index.jpg");
   background-size:cover;
   background-repeat:no-repeat;
   }
</style>
</head>
<body>
<jsp:include page="adminheader.html"></jsp:include>
<h1 style='padding-left:150px; '><u>e-Library</u></h1><br/>
<div style='padding-left:200px;'>
    <form method="get" action="./librarian">
    <h3> Librarian login</h3> 
        <label for="id">Librarian Id: </label> <br/>  
        <input type="text" id="id" name='librarianid'/> <br/>  
        </br>
        <label for="password">Password: </label>  </br>
        <input type="text" id="password" name='password'/> <br/>  
            <br/>
        <input type='submit' value='Login' />
</form>  
<br/>
<form method="get" action="./admin">
    <h3>Admin login</h3> 
         <label for="id">Admin Id: </label> <br/>  
         <input type="text" id="id" name='adminid'/> <br/>  
         </br>
         <label for="password">Password: </label>  </br>
         <input type="text" id="password" name='password'/> <br/>  
              <br/> 
         <input type='submit' value='Login' /><p style='color:red;'>Invalid Credentials</p>
</form>  
</div>
</body>
</html>