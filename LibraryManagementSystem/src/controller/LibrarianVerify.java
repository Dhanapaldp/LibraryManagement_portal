package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LibrarianServiceImpl;

public class LibrarianVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String librarianId=request.getParameter("librarianid");
	    String password=request.getParameter("password");
	   
	    if(LibrarianServiceImpl.authenticate(Integer.parseInt(librarianId), password))
	   	{ 
	    	HttpSession session = request.getSession();
			session.setAttribute("librarian", "true");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/librarianpage.jsp");
			requestDispatcher.forward(request, response);
	   	}
	    else
	    {
	    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/errorlibrarian.jsp");
			requestDispatcher.forward(request, response);
	    }
	}

}
