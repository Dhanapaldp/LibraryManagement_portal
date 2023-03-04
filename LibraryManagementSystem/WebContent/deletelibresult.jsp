<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
         <c:when test="${status eq 'success' }">
              <h1 style='color:green; text-align:center;'>LIBRARIAN DETAILS DELETED SUCCESSFULLY</h1>   
         </c:when>
         <c:otherwise>
             <h1 style='color:green; text-align:center;'>LIBRARIAN ID NOT FOUND</h1>
         </c:otherwise>

</c:choose>
<div style='text-align:center;'>  
 <a href="../adminpage.jsp" ><button>Home</button></a>&nbsp &nbsp
 <a href="../index.jsp"><button>Exit</button></a>
</div>