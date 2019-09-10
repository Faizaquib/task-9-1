
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String subject = request.getParameter("subject");

		Map<String, Integer> map = new HashMap<String, Integer>();
		session.setAttribute("map", map);

		
		
		
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdata", "root", "root");
			String sql = "SELECT bcode,btitle from books where subject=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, subject);
			ResultSet rs = ps.executeQuery();
			out.println("<html>");
			out.println("<html><body>");
			out.println("<h3>Select The Desired Title</h3>");
			out.println("<hr>");
			while (rs.next()) {
				String code = rs.getString(1);
				String title = rs.getString(2);

				// out.println("<a href=BookDetailsServlet?code="+code+">");
				out.println("<a href=BookDetailsServlet?code=" + code + "&bookname="
						+ title + ">");
				out.println(title);
				out.println("</a><br>");
			}
			out.println("<hr>");
			out.println("<a href=SubjectPageServlet>Subject-Page</a>");
			out.println("<a href=buyerpage.jsp>Buyer-Page</a>");
			out.println("</body></html>");

		} catch (Exception e) {
			out.println(e);
		}
	}
}