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

    <form:form action="/articles/" method="post" modelAttribute="article">

        <table class="table table-striped border border-0">
            <form:input type="hidden" name="id" path="id"/>
            <tr>
                <td>title</td>
                <td>
                    <form:input path="title"/>
                    <form:errors path="title" cssClass="text-danger"/>
                </td>
            </tr>

            <tr>
                <td>description</td>
                <td>
                    <form:textarea path="content" rows="5" cols="40"/>
                    <form:errors path="content" cssClass="text-danger"/>
                </td>
            </tr>
            <tr>
                <td>Category</td>
                <td>
                    <form:select path="category">
                        <form:options itemValue="id" itemLabel="name" items="${allCategories}"/>
                    </form:select>
                    <form:errors path="category" cssClass="text-danger"/>
                </td>
            </tr>
            <td>Author</td>
            <td>
<%--            jeśli tu będzie path="author.id", to zadziała--%>
                <form:select path="author">
                    <form:options itemValue="id" itemLabel="firstName" items="${allAuthors}"/>
                </form:select>
                <form:errors path="author" cssClass="text-danger"/>
            </td>
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
