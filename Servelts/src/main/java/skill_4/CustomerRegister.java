package skill_4;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CustomerRegister")
public class CustomerRegister extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
    public CustomerRegister() 
    {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String username=request.getParameter("username");
		String password1=request.getParameter("password1");
		String passwordrepeat=request.getParameter("passwordrepeat");
		
		try
		{
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd","root","root");
			System.out.println("connection established");
			
			String qry="insert into customer values(?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(qry);
			
			pstmt.setString(1,username);
			pstmt.setString(2, password1);
			pstmt.setString(3, passwordrepeat);
			int i = pstmt.executeUpdate();  
            if(i>0) 
            {
            out.print("You are successfully registered..."); 
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("customerhome.html");
			requestDispatcher.include(request, response);
            
          
            }

       
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
