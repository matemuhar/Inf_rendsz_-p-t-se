<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client Information</title>
    </head>
    <body>
        <table border="1">
            <td><a href="clientinfo.jsp">Client Info</a></td>
            <td><a href="${pageContext.request.contextPath}/AllClients">All Clients</a></td>          
        </table>
        <br />

        <form action="${pageContext.request.contextPath}/ClientServlet" method="POST">
            <table>
                <tr>
                    <td>Client ID:</td>
                    <td><input type="text" name="id" value="${client.clientID}"/></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" value="${client.name}"/></td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td><input type="text" name="phonenumber" value="${client.phonenumber}" /></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address" value="${client.address}" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="Submit" name="operation" value="Add" />
                    <input type="Submit" name="operation" value="Edit" />
                    <input type="Submit" name="operation" value="Delete" />
                    <input type="Submit" name="operation" value="Search" /></td>
                </tr>                
            </table>
        </form>
    </body>
</html>
