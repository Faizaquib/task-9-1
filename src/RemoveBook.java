

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RemoveBook")
public class RemoveBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		HttpSession session=request.getSession();
		ArrayList<String> list=(ArrayList<String>) session.getAttribute("cart");
		list.remove(code);
		session.setAttribute("cart", list);
		response.sendRedirect("DisplayCart");
	}
}
