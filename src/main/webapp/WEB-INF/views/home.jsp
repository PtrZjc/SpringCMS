<%--
  Created by IntelliJ IDEA.
  User: goddy
  Date: 19.01.19
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Home</title>
    <%@ include file="includes/bootstrap.jspf" %>
</head>
<body>
<%@ include file="includes/header.jspf" %>
<div class="container">
    <p>Hi! here are 5 last articles:</p>
    <table class="table table-striped border border-0">
        <tr>
            <th>id</th>
            <th>Category</th>
            <th>Title</th>
            <th>Content</th>
            <th>Issued</th>
            <th>Author</th>
        </tr>
        <c:forEach items="${recentArticles}" var="article">
            <tr>
                <td>${article.id}</td>
                <td>${article.category.name}</td>
                <td>${article.title}</td>
                <td>${article.content}</td>
                <td>${article.created}</td>
                <td>${article.author.firstName} ${article.author.lastName}</td>
            </tr>
        </c:forEach>

    </table>

    <%@ include file="includes/footer.jspf" %>
</div>
</body>
</html>
