package skill_4;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings({ "unused", "serial" })
@WebServlet("/VeiwThere")
public class VeiwThere extends HttpServlet
{
	
		public void service(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException
		{
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			
			out.println("<table border=1 align=center>");
			out.println("<tr>");
			out.println("<th>Name</th>");
			out.println("<th>Established Year</th>");
			out.println("<th>Address</th>");
			out.println("<th>Pincode</th>");
			out.println("<th>Capacity</th>");
			out.println("<th>TicketPrice</th>");
			out.println("</tr>");
			
			 
			
			try {
				Connection con=null;
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.print("Driver class loaded");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd","root","root");
				System.out.println("connection established");
				
				PreparedStatement pstmt=con.prepareStatement("select * from theatre");
				 
				ResultSet rs=pstmt.executeQuery();
				
				while(rs.next()) {
					out.println("<tr>");
					 
					out.println("<td> "+rs.getString(1)+"</td>");
					out.println("<td> "+rs.getString(2)+"</td>");
					out.println("<td> "+rs.getString(3)+"</td>");
					out.println("<td> "+rs.getString(4)+"</td>");
					out.println("<td> "+rs.getString(5)+"</td>");
					out.println("<td> "+rs.getString(6)+"</td>");
				    out.println("</tr>");
				    out.println("<a href='customerhome.html'> Back.? </a>");
				}
				
				 
			}
			catch(Exception e) 
			{
				out.println(e);
			}
			
		}
	}

	