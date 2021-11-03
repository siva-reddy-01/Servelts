package skill_4;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/VeiwAdmin")
public class VeiwAdmin extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<table border=1 align=center>");
		out.println("<tr>");
		out.println("<th>name</th>");
		out.println("<th>gender</th>");
		out.println("<th>username</th>");
		out.println("<th>email</th>");
		out.println("<th>password1</th>");
		out.println("<th>mobileno</th>");
		out.println("<th>location</th>");
		out.println("</tr>");
		
		try {
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("Driver class Loaded..");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd","root","root");
			System.out.println("connection established..");
			
			PreparedStatement pstmt=con.prepareStatement("select * from admin");
			 
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				out.println("<tr>");
				 
				out.println("<td> "+rs.getString(1)+"</td>");
				out.println("<td> "+rs.getString(2)+"</td>");
				out.println("<td> "+rs.getString(3)+"</td>");
				out.println("<td> "+rs.getString(4)+"</td>");
				out.println("<td> "+rs.getString(5)+"</td>");
				out.println("<td> "+rs.getString(6)+"</td>");
				out.println("<td> "+rs.getString(7)+"</td>");
				 

				 
				out.println("</tr>");
			}
			
			 
		}
		catch(Exception e) 
		{
			out.println(e);
		}
		
	}
}