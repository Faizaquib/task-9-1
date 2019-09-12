<%@ page import="java.sql.*" %>
<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	String sql="Select distinct subject from books";
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
%>

<html>
<body>
<h3>Welcome</h3>
<h3>Select The Desired Subjects</h3>
<form action="BookListServlet">
<%
	while(rs.next()){
		String sub=rs.getString(1);
%>
<%-- <%=sub%><input type="checkbox" value="box"/> --%>
<input type="checkbox" name="subject" multiple="multiple" value=<%=sub %>> <%=sub %><br>
<%
	}
%>
<input type="submit" name="sub">
</form>
</body>
</html>