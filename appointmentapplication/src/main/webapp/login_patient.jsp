<html>
<body bgcolor="gray">
<%@page import="java.sql.*" %>
<%
Connection connection=null;
PreparedStatement ps=null;
Class.forName("com.mysql.cj.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/appointment";
String user="root";
String pass="4009";
connection=DriverManager.getConnection(url,user,pass);	
String username=request.getParameter("username");
String password=request.getParameter("password");
String sql="select * from patient where name=? and password=?";
ps=connection.prepareStatement(sql);
ps.setString(1, username);
ps.setString(2, password);
ResultSet rs=ps.executeQuery();
if(rs.next())
	response.sendRedirect("./patient_home.html");
%>
<h1 align="center">Login successful</h1>
</body>
</html>