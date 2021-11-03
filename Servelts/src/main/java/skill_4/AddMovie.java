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

@SuppressWarnings({ "unused", "serial" })
@WebServlet("/AddMovie")
public class AddMovie extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String name=req.getParameter("name");
		String language=req.getParameter("language");
		String genre=req.getParameter("genre");
		String director=req.getParameter("director");
		String producer=req.getParameter("producer");
		String cast=req.getParameter("cast");
		String release_date=req.getParameter("release_date");
		String censor_report=req.getParameter("censor_report");
		  
		 
		
		try {
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("Driver class loaded\n");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd","root","root");
			System.out.println("Connection established");
		
	String qry="insert into movie values(?,?,?,?,?,?,?,?)";	
	PreparedStatement pstmt=con.prepareStatement(qry);
	pstmt.setString(1, name);
	pstmt.setString(2, language);
	pstmt.setString(3, genre);
	pstmt.setString(4, director);
	pstmt.setString(5, producer);
	pstmt.setString(6, cast);
	pstmt.setString(7, release_date);
	pstmt.setString(8, censor_report);
	
	int i=pstmt.executeUpdate();
	
	if(i>0)
	{
		  out.println("Movie added successfully");
		  out.println("<a href='addmovie.html'> Add Another movie </a>");
	}
			
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
	}
}