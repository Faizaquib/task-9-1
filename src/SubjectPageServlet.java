

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpContext;

/**
 * Servlet implementation class SubjectPageServlet
 */
@WebServlet("/SubjectPageServlet")
public class SubjectPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		
		
		
		
		if(username == null)
		{
			response.sendRedirect("index.jsp");
		}
		
		Cookie ck[] = request.getCookies();
		String s = "";
		if(ck!=null)
		{
			for(Cookie c:ck)
			{
				String name = c.getName();
				if(name.equals("subject"))
					{
						s = name;
					}
			}
		}
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		String sql="SELECT distinct subject from books";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		
		
		
		out.println("welcome "+username);
		out.println("<html>");
		out.println("<body>");
		if(s=="")
			out.println("<marquee><h4>Attractive Offers On All Books</h4></marquee>");
		else
			out.println("<marquee><h4>Attractive Offers On "+s+" Books</h4></marquee>");
		out.println("<h3>Select The Desired Subject</h3>");
		out.println("<hr>");
		while(rs.next()){
			String sub=rs.getString(1);
			out.println("<a href=BookListServlet?subject="+sub+">");
			out.println(sub);
			out.println("</a><br>");
		}
		out.println("<hr>");
		out.println("<a href=buyerpage.jsp>Buyer-Page</a>");
		out.println("</body></html>");
		
		
		
		}catch(Exception e){
			out.println(e);
		}
	}

}