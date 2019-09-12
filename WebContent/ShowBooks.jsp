<%
Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
String sql = "select * from books";
java.sql.PreparedStatement ps = con.prepareStatement(sql);
java.sql.ResultSet rs = ps.executeQuery();


%>




<html>
<head>
<title>Insert title here</title>
</head>

<body>


<h3>book-list</h3>
<table>
</table>
</body>
</html>
