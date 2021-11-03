package com.klef;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public Loginservlet() 
    {
       super();
        
    }

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username").trim();
		String password=request.getParameter("password").trim();
		
		if(username==null || username.equals("") || password==null || password.equals(""))
		{
			out.println("Please enter both username " +"and password. <br/><br/>");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("login.html");
		}
		else if(username.equals("siva") && password.equals("1431"))
		{
			out.println("welcome to servlets");
		}
		else
		{
			out.println("Wrong username or password. <br/><br/>");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("login.html");
			requestDispatcher.include(request, response);
		}
	}

}
