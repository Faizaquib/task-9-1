
<%
	String s = session.getId();
	long val = session.getMaxInactiveInterval();
	String username = (String) session.getAttribute("user");
	if (username == null) {
		response.sendRedirect("index.jsp");
	}
%>




<html>
<body>
	<%=s%>
	<%=val%>
	<h3>
		DashBoard-For-<%=username%></h3>
	<hr>
	<pre>
		<a href="SubjectPageServlet">Explore-Store</a>
		<a href="">Search-Book</a>
		<a href="DisplayCart">View-Cart</a>
		<a href="">Trace-Order</a>
		<a href="">Logout</a>
	</pre>
	<hr>
</body>
</html>