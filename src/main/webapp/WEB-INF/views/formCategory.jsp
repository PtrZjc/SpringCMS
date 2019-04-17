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

    <form:form action="/categories/" method="post" modelAttribute="category">

        <table class="table table-striped border border-0">
            <form:input type="hidden" name="id" path="id"/>
            <tr>
                <td>title</td>

                <td><br>
                    <form:input path="name"/>
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
                <td></td>
                <td><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>

    <%@ include file="includes/footer.jspf" %>
</div>
</body>
</html>
