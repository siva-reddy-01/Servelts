package skill_4;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings({ "serial", "unused" })
@WebServlet("/AddTheatre")
public class AddTheatre extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String name=req.getParameter("name");
		String establishedyear=req.getParameter("establishedyear");
		String address=req.getParameter("address");
		String  pincode=req.getParameter("pincode");
		String capacity=req.getParameter("capacity");
		String ticketprice=req.getParameter("ticketprice");
		  
		 
		
		try {
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("Driver Class Loaded\n\n");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd","root","root");
			System.out.println("Connection Done");
		
	String qry="insert into theatre values(?,?,?,?,?,?)";		
	PreparedStatement pstmt=con.prepareStatement(qry);
	pstmt.setString(1, name);
	pstmt.setString(2, establishedyear);
	pstmt.setString(3, address);
	pstmt.setString(4, pincode);
	pstmt.setString(5, capacity);
	pstmt.setString(6, ticketprice);  
	
	int i=pstmt.executeUpdate();
	if(i>0) 
	{
		  out.println("Theahter added successfully");
		  out.println("<a href='addtheatres.html'> Add Another Theatre </a>");
    }
			
			
		}
		catch(Exception e) 
		{
			out.println(e);
		}
		
	}
}