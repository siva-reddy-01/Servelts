package com.klef;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class First implements Servlet 
{
	ServletConfig config=null;
	
	public void init(ServletConfig config)
	{
		this.config=config;
		System.out.println("servlet is initlization");
	}
	
	public void service(ServletRequest request,ServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		out.println("<p>Welcome to servlet</p>");
		out.println("</body></html>");
		out.close();
	}
	
	public void destory()
	{
		System.out.println("servlet is destroyed");
	}
	
	public ServletConfig getServletConfig()
	{
		return config;
	}
	
	public String getServletInfo()
	{
		return "copy right";
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}


	