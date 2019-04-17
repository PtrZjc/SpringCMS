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

    <form:form action="/authors/" method="post" modelAttribute="author">

        <table class="table table-striped border border-0">
            <form:input type="hidden" name="id" path="id"/>
            <tr>
                <td>title</td>

                <td>
                    <form:input path="firstName"/>
                    <form:errors path="firstName" cssClass="text-danger"/>
                </td>
            </tr>

            <tr>
                <td>description</td>
                <td>
                    <form:input path="lastName"/>
                    <form:errors path="lastName" cssClass="text-danger"/>
                </td>
            </tr>

                <%--            <tr>--%>
                <%--                <td>articles from list</td>--%>
                <%--                <td>--%>
                <%--                    <table>--%>

                <%--                    <c:forEach var="article" items="${allArticles}">--%>
                <%--                        <tr> <td> <form:checkbox value="${article.id}" path="articles"/><c:out value="${article.title}"/></td> </tr>--%>
                <%--                    </c:forEach>--%>
                <%--                    <form:errors path="articles" cssClass="text-danger"/>--%>

                <%--                    </table>--%>
                <%--                </td>--%>
                <%--            </tr>--%>
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
