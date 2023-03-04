<%@ page language="java" import="service.IBookService ,servicefactory.BookServiceFactory  " contentType="text/html" %>
<%@ page import="java.util.*, dataTransferObjects.IssueBookBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"  %>
<html>
<body bgcolor="lightblue">

<%
	IBookService bookService=BookServiceFactory.getBookService();
	List<IssueBookBean> bookUsers = bookService.viewBookUsers();
	request.setAttribute("usersList", bookUsers);
%>
<h1 align='center'> ISSUED BOOK DETAILS</h1>
<table border='1' align='center'>
  <tr>
    <th>BOOK ID</th>
    <th>STUDENT ID</th>
    <th>STUDENT NAME</th>
    <th>MOBILE NO</th>
    <th>ISSUED DATE</th>
    <th>RETURN DATE</th>
    <th>FINE AMOUNT</th>
  </tr>
  
     <a:forEach var="user" items="${ usersList}">
         <tr>
         <td>${user.getBookId()}</td>
         <td>${user.getSid()}</td>
         <td>${user.getSname()}</td>
         <td>${user.getMobile()}</td>
         <td>${user.getIssueDate()}</td>
         <td>${user.getReturnDate()}</td>
         <td>${user.getFineAmount()}</td>
         </tr>
     </a:forEach>

</table>
<br/>
<div style='text-align:center;'>  
 <a href="librarianpage.jsp" ><button>Home</button></a>&nbsp &nbsp
 <a href="index.jsp"><button>Exit</button></a>
</div>
</body></html>

     


  