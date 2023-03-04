<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Record</title>
</head>
<body bgcolor="lightblue">
<h1 style='color:red;text-align:center;'>BOOK DETAILS </h1>
<br/>
<br/>
<br/>
	<c:choose>
		<c:when test="${book ne null || ! empty book }">
			<table border='3' align="center">
				<tr>
					<th>BOOK ID</th>
					<th>BOOK NAME</th>
					<th>BOOK AUTHOR</th>
					<th>QUANTITY</th>
				</tr>
				<tr>
					<td>${book.getBookId() }</td>
					<td>${book.getBookName() }</td>
					<td>${book.getBookAuthor() }</td>
					<td>${book.getBookQuantity() }</td>
				</tr>	
			</table>
		</c:when>
		<c:otherwise>
			<h1 style='color:red; text-align: center;'>RECORD NOT AVAILABLE FOR THE GIVEN ID </h1>
		</c:otherwise>
	</c:choose>	
	<br/>
<div style='text-align:center;'>  
 <a href="../librarianpage.jsp" ><button>Home</button></a>&nbsp &nbsp
 <a href="../index.jsp"><button>Exit</button></a>
</div>	
</body>
</html>