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
		<c:when test="${book ne null || ! empty book }">
		   <br/><br/><br/>
		<h1 style='color:red;text-align:center;'>EDIT FORM FOR BOOK</h1>
<br/>
<br/>
<br/>
		<form method='post' action='./updaterecord'>"
			<table border='3' align="center">
				<tr>
					<th>BOOK ID</th>
					<td> ${book.getBookId()}</td>
					<input type='hidden' name='bid' value='${book.getBookId()}' />
				</tr>
				<tr>
				    <th>BOOK NAME</th>
					<td><input type='text' name='bname' value='${ book.getBookName()}' /></td>
				</tr>
				<tr>
				    <th>BOOK AUTHOR</th>
					<td><input type='text' name='bauthor' value='${ book.getBookAuthor()}' /></td>
				</tr>	
				<tr>
				    <th>QUANTITY</th>
					<td><input type='text' name='quantity' value='${ book.getBookQuantity()}' /></td>
				</tr>
				<tr><td></td><td><input type='submit' value='update'/></td></tr>
			</table>
			
		</form>
		</c:when>
		<c:otherwise>	 
			<c:redirect url="../updatebook.jsp"/>
		</c:otherwise>
	</c:choose>	

</body>
</html>