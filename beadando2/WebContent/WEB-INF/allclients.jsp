<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Clients</title>
    </head>
    <body>
        <table border="1">
            <td><a href="clientinfo.jsp">Client Info</a></td>
            <td><a href="allclients.jsp">All Clients</a></td>            
        </table>
        <br />
        <h3>List of Clients</h3>
        <br />
        <table border="1">
            <th>Client ID</th>
            <th>Client Name</th>
            <th>Phone Number</th>
            <th>Address</th>
            <c:forEach items="${requestScope.list}" var="client">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/GetClient?id=${client.clientID}">${client.clientID}</a></td>
                    <td>${student.name}</td>
                    <td>${student.phonenumber}</td>
                    <td>${student.address}</td>
                </tr>
            </c:forEach>                 
        </table>
    </body>
</html>
