<%@ page language="java" import="service.IBookService ,servicefactory.BookServiceFactory  " contentType="text/html" %>
<%@ page import="java.util.*, dataTransferObjects.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"  %>
<body bgcolor="lightblue">
<%
	IBookService bookService=BookServiceFactory.getBookService();
	List<Book> books = bookService.viewBooks();
	request.setAttribute("books", books);
%>
<h1 align='center'> LIST OF BOOKS</h1>
<table border='1' align='center'>
  <tr>
    <th>BOOK ID</th>
    <th>BOOK NAME</th>
    <th>BOOK AUTHOR</th>
    <th>BOOK QUANTITY</th>
  </tr>
  
     <a:forEach var="book" items="${ books}">
         <tr>
         <td>${book.getBookId()}</td>
         <td>${book.getBookName()}</td>
         <td>${book.getBookAuthor()}</td>
         <td>${book.getBookQuantity()}</td>
         </tr>
     </a:forEach>

</table>
<br/>
<div style='text-align:center;'>  
 <a href="librarianpage.jsp" ><button>Home</button></a>&nbsp &nbsp
 <a href="index.jsp"><button>Exit</button></a>
</div>

     
</body>
