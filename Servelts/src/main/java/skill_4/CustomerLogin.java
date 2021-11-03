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

@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public CustomerLogin() 
    {
        super();
        
    }
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username= request.getParameter("username");
	    String password1 = request.getParameter("password1");
		
		try
		{
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd","root","root");
			System.out.println("Connection established..");
			
			PreparedStatement pstmt=con.prepareStatement("select * from customer where username=? and password1=?");
			 
			pstmt.setString(1,username);
			pstmt.setString(2,password1);
			PrintWriter out =response.getWriter();
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("customerhome.html");
				rd.forward(request, response);
			}
			else
			{
				out.println("customer login again");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
