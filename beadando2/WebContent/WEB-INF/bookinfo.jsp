<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Information</title>
    </head>
    <body>
        <table border="1">
            <td><a href="bookinfo.jsp">Book Info</a></td>
            <td><a href="${pageContext.request.contextPath}/AllBooks">All Books</a></td>            
        </table>
        <br />

        <form action="${pageContext.request.contextPath}/BookServlet" method="POST">
            <table>
                <tr>
                    <td>Book ID:</td>
                    <td><input type="text" name="id" value="${bokk.bookID}"/></td>
                </tr>
                <tr>
                    <td>Writer:</td>
                    <td><input type="text" name="writer" value="${book.writer}"/></td>
                </tr>
                <tr>
                    <td>Title:</td>
                    <td><input type="text" name="title" value="${book.title}" /></td>
                </tr>
                <tr>
                    <td>State:</td>
                    <td><input type="text" name="state" value="${book.state}" /></td>
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
