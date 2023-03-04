package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataTransferObjects.Librarian;
import service.ILibrarianService;
import servicefactory.LibrarianServiceFactory;
import dataTransferObjects.Librarian;



public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void  service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		ILibrarianService librarianService = null;

		if (request.getRequestURI().endsWith("addlibrarian")) {

			String librarianName = request.getParameter("lname");
			String password = request.getParameter("password");
			String mobile = request.getParameter("mobile");

			Librarian librarian=new Librarian();
			
			librarian.setName(librarianName);
			librarian.setPassword(password);
			librarian.setMobile(Long.parseLong(mobile));

			librarianService = LibrarianServiceFactory.getLibrarianService();
			String status = librarianService.addLibrarian(librarian);
			
            request.setAttribute("status", status);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../addresultlib.jsp");
			requestDispatcher.forward(request, response);
		}
		if (request.getRequestURI().endsWith("searchlibrarian")) {
			String id = request.getParameter("lid");

			librarianService = LibrarianServiceFactory.getLibrarianService();
			Librarian librarian = librarianService.searchLibrarian(Integer.parseInt(id));
            request.setAttribute("librarian",librarian);
			
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../searchlibresult.jsp");
			rd.forward(request, response);
			
		}
		if(request.getRequestURI().endsWith("updatelibrarian"))
		{
			String id = request.getParameter("lid");
			PrintWriter out = response.getWriter();
			librarianService = LibrarianServiceFactory.getLibrarianService();
			Librarian librarian = librarianService.searchLibrarian(Integer.parseInt(id));
            request.setAttribute("librarian",librarian);
			
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../editlib.jsp");
			rd.forward(request, response);
		
		}
		if(request.getRequestURI().endsWith("updaterecord"))
		{
			String id = request.getParameter("lid");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String mobile = request.getParameter("mobile");
			
			Librarian librarian=new Librarian();
			librarian.setId(Integer.parseInt(id));
			librarian.setName(name);
			librarian.setPassword(password);
			librarian.setMobile(Long.parseLong(mobile));
		
			librarianService = LibrarianServiceFactory.getLibrarianService();
			String status = librarianService.updateLibrarian(librarian);
			request.setAttribute("status", status);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../updatelibresult.jsp");
		    requestDispatcher.forward(request, response);
		}
		if(request.getRequestURI().endsWith("deletelibrarian"))
		{
			String id = request.getParameter("lid");
			librarianService = LibrarianServiceFactory.getLibrarianService();
			String status = librarianService.deleteLibrarian(Integer.parseInt(id));
			
			request.setAttribute("status", status);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../deletelibresult.jsp");
		    requestDispatcher.forward(request, response);
		}
		
	}

}
