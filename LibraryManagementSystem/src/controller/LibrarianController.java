package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataTransferObjects.Book;
import dataTransferObjects.IssueBookBean;
import dataTransferObjects.Student;
import service.IBookService;
import servicefactory.BookServiceFactory;

public class LibrarianController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IBookService bookService = null;

		if (request.getRequestURI().endsWith("addbook")) {

			String bookName = request.getParameter("bname");
			String bookAuthor = request.getParameter("bauthor");
			String quantity = request.getParameter("quantity");

			Book book=new Book();
			
			book.setBookName(bookName);
			book.setBookAuthor(bookAuthor);
			book.setBookQuantity(Integer.parseInt(quantity));

			bookService = BookServiceFactory.getBookService();
			String status = bookService.addBook(book);
			PrintWriter out = response.getWriter();

		    request.setAttribute("status", status);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../addbookresult.jsp");
		    requestDispatcher.forward(request, response);
		}
		if (request.getRequestURI().endsWith("searchbook")) {
			String id = request.getParameter("bid");

			bookService = BookServiceFactory.getBookService();
			Book book = bookService.searchBook(Integer.parseInt(id));
			
			request.setAttribute("book", book);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../searchbookresult.jsp");
		    requestDispatcher.forward(request, response);
		}
		if(request.getRequestURI().endsWith("updatebook"))
		{
			String id = request.getParameter("bid");
			PrintWriter out = response.getWriter();
			bookService = BookServiceFactory.getBookService();
			Book book = bookService.searchBook(Integer.parseInt(id));
            request.setAttribute("book",book);
			
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../editbook.jsp");
			rd.forward(request, response);
			
		}
		if(request.getRequestURI().endsWith("updaterecord"))
		{
			String id = request.getParameter("bid");
			String bookName = request.getParameter("bname");
			String bookAuthor = request.getParameter("bauthor");
			String quantity = request.getParameter("quantity");
			
			Book book=new Book();
			book.setBookId(Integer.parseInt(id));
			book.setBookName(bookName);
			book.setBookAuthor(bookAuthor);
			book.setBookQuantity(Integer.parseInt(quantity));
		
			bookService = BookServiceFactory.getBookService();
			String status = bookService.updateBook(book);
			request.setAttribute("status", status);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../updatebookresult.jsp");
		    requestDispatcher.forward(request, response);
		}
		if(request.getRequestURI().endsWith("deletebook"))
		{
			String id = request.getParameter("bid");
			bookService = BookServiceFactory.getBookService();
			String status = bookService.deleteBook(Integer.parseInt(id));
			
			request.setAttribute("status", status);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../deletebookresult.jsp");
		    requestDispatcher.forward(request, response);
			
		}
		
		if(request.getRequestURI().endsWith("issuebook"))
		{
			String bookId = request.getParameter("bid");
			String studentId = request.getParameter("sid");
			String studentName = request.getParameter("sname");
			String mobile= request.getParameter("mobile");
			
			IssueBookBean bookBean = new IssueBookBean();
			bookBean.setBookId(Integer.parseInt(bookId));
			bookBean.setSid(Integer.parseInt(studentId));
			bookBean.setSname(studentName);
			bookBean.setMobile(Long.parseLong(mobile));
			System.out.println(bookBean);
			bookService=BookServiceFactory.getBookService();
			String status = bookService.issueBook(bookBean);
	
			request.setAttribute("status", status);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../issuebookresult.jsp");
		    requestDispatcher.forward(request, response);
			
		}
		if(request.getRequestURI().endsWith("returnbook"))
		{
			String bookId = request.getParameter("bid");
			String studentId = request.getParameter("sid");
			bookService=BookServiceFactory.getBookService();
			String status = bookService.returnBook(Integer.parseInt(bookId),Integer.parseInt(studentId));
			
			request.setAttribute("status", status);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../returnbookresult.jsp");
		    requestDispatcher.forward(request, response);
		}
		if(request.getRequestURI().endsWith("student"))
		{

			String studentId = request.getParameter("sid");
			String studentName = request.getParameter("sname");
			String branch = request.getParameter("branch");
			String mobile= request.getParameter("mobile");

			Student student=new Student();
			student.setSid(Integer.parseInt(studentId));
			student.setSname(studentName);
			student.setSbranch(branch);
			student.setMobile(Long.parseLong(mobile));
			bookService=BookServiceFactory.getBookService();
			String status = bookService.registerStudent(student);
	
			request.setAttribute("status", status);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../studentregisterresult.jsp");
		    requestDispatcher.forward(request, response);
		}
	}
}


