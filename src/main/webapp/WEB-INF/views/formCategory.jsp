<%--
  Created by IntelliJ IDEA.
  User: goddy
  Date: 19.01.19
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Home</title>
    <%@ include file="includes/bootstrap.jspf" %>
</head>
<body>
<%@ include file="includes/header.jspf" %>
<div class="container">

    <form:form action="${val ? '/valbk/':'/books/'}" method="post" modelAttribute="book">
        <form:input type="hidden" path="id"/>
        <table class="table table-striped border border-0">

            <tr>
                <td>title</td>

                <td><form:input path="name"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </td>
            </tr>

            <tr>
                <td>description</td>
                <td>
                    <form:textarea path="description" rows="3" cols="20"/>
                    <form:errors path="description" cssClass="text-danger"/>
                </td>
            </tr>
            <tr>
                <td>articles from list</td>
                <td><form:checkboxes items="${allArticles}" path="articles"/>
                    <form:errors path="articles" cssClass="text-danger"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>

    <%@ include file="includes/footer.jspf" %>
</div>
</body>
</html>
