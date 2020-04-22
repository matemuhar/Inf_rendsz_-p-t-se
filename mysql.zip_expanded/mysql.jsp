<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String DRIVER = "org.gjt.mm.mysql.Driver";
	Class.forName(DRIVER).newInstance();

	Connection con = null;
	ResultSet rst = null;
	Statement stmt = null;

	try {
		int i = 1;
		con = DriverManager.
				getConnection("jdbc:mysql://localhost/mysql?user=root&password=");
		stmt = con.createStatement();
		rst = stmt.executeQuery("select * from user ");
		%>
		<table border="1">
		<%
		while (rst.next()) {
				%>
				<tr>
					<td><%=i%>.</td>
					<td><%=rst.getString("Host")%></td>
				</tr>
				<%
		i++;		
		}
		rst.close();
		stmt.close();
		con.close();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
%>
</table>
</body>
</html>