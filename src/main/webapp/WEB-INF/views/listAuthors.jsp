<%--
  Created by IntelliJ IDEA.
  User: goddy
  Date: 19.01.19
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Detailed solution</title>
    <%@ include file="includes/bootstrap.jspf" %>
</head>
<body>


<%@ include file="includes/header.jspf" %>
<div class="container">
    <table class="table table-striped border border-0">
        <tr>
            <th>id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${allAuthors}" var="aut">
            <tr>
                <td>${aut.id}</td>
                <td>${aut.firstName}</td>
                <td>${aut.lastName}</td>
                <td>
                    <form action="edit" method="post">
                        <input type="hidden" name="id" value="${aut.id}">
                        <input class="btn btn-primary" type="submit" value="Edit">
                    </form>
                    <form action="delete" method="post">
                        <input type="hidden" name="id" value="${aut.id}">
                        <input type="submit" class="btn btn-danger"  value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>
    <%@ include file="includes/footer.jspf" %>
</div>
</body>
</html>
