<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Librarian Record</title>
</head>
<body bgcolor="lightblue">
<h1 style='color:red;text-align:center;'>LIBRARIAN DETAILS </h1>
<br/>
<br/>
<br/>
	<c:choose>
		<c:when test='${librarian ne null || ! empty librarian }'>
			<table border='3' align="center">
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>PASSWORD</th>
					<th>MOBILE</th>
				</tr>
				<tr>
					<td>${librarian.id }</td>
					<td>${librarian.name }</td>
					<td>${librarian.password }</td>
					<td>${librarian.mobile }</td>
				</tr>	
			</table>
		</c:when>
		<c:otherwise>	 
			<h1 style='color:red; text-align: center;'>RECORD NOT AVAILABLE FOR THE GIVEN ID </h1>
		</c:otherwise>
	</c:choose>	
	<br/>
<div style='text-align:center;'>  
 <a href="../adminpage.jsp" ><button>Home</button></a>&nbsp &nbsp
 <a href="../index.jsp"><button>Exit</button></a>
</div>	
</body>
</html>