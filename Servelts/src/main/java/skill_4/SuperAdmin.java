package skill_4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SuperAdmin")
public class SuperAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public SuperAdmin() {
        super();
       
    }
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username").trim();
		String password=request.getParameter("password").trim();
		System.out.println("data requested");
		if(username==null || username.equals("") || password==null || password.equals(""))
		{
			out.println("<h1>Please enter both username " +"and password. <br/><br/></h1>");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("login1.html");
		}
		else if(username.equals("siva") && password.equals("1431"))
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("superadmin.html");
			requestDispatcher.forward(request, response);
		}
		else
		{
			out.println("Wrong username or password. <br/><br/>");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("login1.html");
			requestDispatcher.include(request, response);
		}
	}

}
