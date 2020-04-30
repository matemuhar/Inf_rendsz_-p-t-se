<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Books</title>
    </head>
    <body>
        <table border="1">
            <td><a href="bookinfo.jsp">Book Info</a></td>
            <td><a href="allbooks.jsp">All Books</a></td>            
        </table>
        <br />
        <h3>List of Books</h3>
        <br />
        <table border="1">
            <th>Book ID</th>
            <th>Writer</th>
            <th>Title</th>
            <th>State</th>
            <c:forEach items="${requestScope.list}" var="book">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/GetBook?id=${book.bookID}">${book.bookID}</a></td>
                    <td>${book.writer}</td>
                    <td>${book.title}</td>
                    <td>${book.state}</td>
                </tr>
            </c:forEach>                 
        </table>
    </body>
</html>
