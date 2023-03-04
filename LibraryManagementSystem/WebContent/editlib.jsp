<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit page</title>
</head>
<body bgcolor="lightblue">

	<c:choose>
		<c:when test="${librarian ne null || ! empty librarian }">
		   <br/><br/><br/>
		<h1 style='color:red;text-align:center;'>EDIT FORM FOR LIBRARIAN</h1>
<br/>
<br/>
<br/>
		<form method='post' action='./updaterecord'>"
			<table border='3' align="center">
				<tr>
					<th>LIBRARIAN ID</th>
					<td> ${librarian.getId()}</td>
					<input type='hidden' name='lid' value='${librarian.getId()}' />
				</tr>
				<tr>
				    <th> NAME</th>
					<td><input type='text' name='name' value='${ librarian.getName()}' /></td>
				</tr>
				<tr>
				    <th>PASSWORD</th>
					<td><input type='text' name='password' value='${ librarian.getPassword()}' /></td>
				</tr>	
				<tr>
				    <th>MOBILE NUMBER</th>
					<td><input type='text' name='mobile' value='${ librarian.getMobile()}' /></td>
				</tr>
				<tr><td></td><td><input type='submit' value='update'/></td></tr>
			</table>
			
		</form>
		</c:when>
		<c:otherwise>	 
			<c:redirect url="../updatelib.html">Invalid Credentials</c:redirect>
		</c:otherwise>
	</c:choose>	

</body>
</html>