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

@SuppressWarnings("serial")
@WebServlet("/BookTickets")
public class BookTickets extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("customerhome.html");
		rd.include(request,response);

		
		
		
HttpSession session=request.getSession(false);
		
		String uname=(String)session.getAttribute("uname");
		out.println("<h1 align=right>Welcome "+uname+"</h1>");
		
		
		
		out.println("<h2 align=center><u>Ticket Booking</u></h2>");
		
		out.println("<center>");
		
		out.println("<form method='post' action='booktickets1'>");
		
		out.println("<table>");
		
		
		out.println("<tr>");
		
		out.println("<td><b>UserName</b></td>");
		out.println("<td>"+uname+"</td>");
		
		out.println("</tr>");
		
		try {
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc,Driver");
			System.out.print("Driver class loaded\n\n");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd","root","root");
			System.out.println("Connection established.");
			
			String qry="select * from movie";
			
			PreparedStatement pstmt=con.prepareStatement(qry);
			 
			ResultSet rs=pstmt.executeQuery();
			
			out.println("<tr>");
			
			out.println("<td><b>Select Movie Name</b></td>");
			
			out.println("<td><select name='movieid'>");
			
			out.println("<option value=''>--Select --</option>");
			
			
			
			 while(rs.next()) 
			 {
				 
				 out.println("<option value="+rs.getString("movieid")+">");
				 out.println(rs.getString("name"));
				 
				 out.println("</option>");
				 
			 }
			 out.println("</select>");
			 
			 out.println("</td>");
			 
			 out.println("</tr>");
		}
		catch(Exception e) {
			out.println(e);
		}
		
		try {
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc,Driver");
			System.out.print("Driver class loaded\n\n");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd","root","root");
			System.out.println("Connection established.");
			
			String qry="select * from theatre";
			PreparedStatement pstmt=con.prepareStatement(qry);
			 
			ResultSet rs=pstmt.executeQuery();
			
			out.println("<tr>");
			
			out.println("<td><b>Theatre</b></td>");
			
			out.println("<td><select name='theatreid'>");
			
			out.println("<option value=''>--Select --</option>");
			
			
			
			 while(rs.next()) 
			 {
				 
				 out.println("<option value="+rs.getString("theatreid")+">");
				 out.println(rs.getString("name"));
				 
				 out.println("</option>");
				 
			 }
			 out.println("</select>");
			 
			 out.println("</td>");
			 
			 out.println("</tr>");
		}
		catch(Exception e) {
			out.println(e);
		}
		
		
		
				out.println("<tr>");
			
				out.println("<td><b>Show Date</b></td>");
				out.println("<td><input type='date' name='showdate' required></td>");
		
				out.println("</tr>");
		
		
		
				out.println("<tr>");
				
				out.println("<td><b>Show Slot</b></td>");
				out.println("<td><select  name='showslot'>");
				
				out.println("<option value=''>--Select--</option>");
				out.println("<option value='9AM'>9AM</option>");
				out.println("<option value='1PM'>1PM</option>");
				out.println("<option value='6:30PM'>6:30PM</option>");
				out.println("<option value='9:30PM'>9:30PM</option>");
				out.println("<td>");
				out.println("</tr>");
				
				
				out.println("<tr>");
				out.println("<td><b>No of Tickets</b></td>");
				out.println("<td><input type='number' name='ticketscount' required></td>");
				out.println("</tr>");
				
				out.println("<tr>");
				
				out.println("<td><input type='submit' value='proceed' required></td>");
				
				out.println("</tr>");
				

		
		
		out.println("</table>");
		
		out.println("</form>");
		
		out.println("</center>");
		
		 
	}
}