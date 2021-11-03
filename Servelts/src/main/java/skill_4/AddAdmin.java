package skill_4;
import java.sql.*;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unused")
@WebServlet("/AddAdmin")
public class AddAdmin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
     
    public AddAdmin() {
        super();
        
    }
	
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String username=request.getParameter("username");
		String password1=request.getParameter("password1");
		String email=request.getParameter("email");
		String mobileno=request.getParameter("mobileno");
		String location=request.getParameter("location");
		
		 
 
		
		try {
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("Driver class loaded\n");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd","root","root");
			System.out.println("Connection established");
		
	String qry="insert into admin values(?,?,?,?,?,?,?)";	
	PreparedStatement pstmt=con.prepareStatement(qry);
	pstmt.setString(1, name);
	pstmt.setString(2, gender);
	pstmt.setString(3, username);
	pstmt.setString(4, email);
	pstmt.setString(5, password1);
	pstmt.setString(6, mobileno);
	pstmt.setString(7, location);
	
	int i=pstmt.executeUpdate();
	
	if(i>0) 
	{
		out.println("Theahter Manager successfully");
		
	}
		
			
			
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
	}
}