package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            PrintWriter out = response.getWriter();
		
		if (request.getRequestURI().endsWith("admin"))
		{
			String adminId = request.getParameter("adminid");
			String password = request.getParameter("password");
			//Authenciate the Admin verification
			if(adminId.equals("root") && password.equals("root123"))
			{
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminpage.jsp");
				requestDispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/errorAdmin.jsp");
			    requestDispatcher.forward(request, response);	
			}
		}
	}

}
