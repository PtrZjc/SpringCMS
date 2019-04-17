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

    <form:form action="/categories/" method="post" modelAttribute="article">

        <table class="table table-striped border border-0">
            <form:input type="hidden" path="id"/>
            <tr>
                <td>title</td>

                <td><br>
                    <form:input path="title"/>
                    <form:errors path="title" cssClass="text-danger"/>
                </td>
            </tr>

            <tr>
                <td>description</td>
                <td>
                    <form:textarea path="content" rows="3" cols="20"/>
                    <form:errors path="content" cssClass="text-danger"/>
                </td>
            </tr>
            <tr>
                <td>Category</td>
                <td>

<%--                    TODO sypie mi tu skads data violation
                        trzeba tu zrobic request param by name i wziac sobie liste zaznaczen i recznie powczytywac autorów do nich-
                        i chyba trzeba bedzie jeszcze ogarnac ID od autora, a nie jego nazwe --%>

                    <c:forEach var="category" items="${allCategories}">
                        <form:checkbox value="${category.id}" path="categories"/><c:out value="${category.name}"/><br>
                    </c:forEach>
                    <form:errors path="categories" cssClass="text-danger"/>
                </td>
            </tr>
            <td>Author</td>
            <td><form:select path="author">
                <form:option value="-" label="--Wybierz autora--"/>
                <form:options items="${allAuthors}"/>
            </form:select>
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
