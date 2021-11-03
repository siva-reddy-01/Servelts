package com.klef;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletdemo
 */
@WebServlet("/servletdemo")
public class servletdemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletdemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
			

			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
			{
			    response.setContentType("text/html");
			    PrintWriter out=response.getWriter();
			    
			    String name=request.getParameter("uname");
			    out.println("welcome:"+name);
			    
			    if(name.equals("siva"))
			    {
			    
			    RequestDispatcher rd=request.getRequestDispatcher("servlet2");
			    rd.forward(request, response);
			    }
			    
			}
			
		

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
