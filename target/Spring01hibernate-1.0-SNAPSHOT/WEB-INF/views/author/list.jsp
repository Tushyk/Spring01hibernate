<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 02.08.2022
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/author-form/add/"/>">add</a>
<table>
    <tr>
        <th>Id</th>
        <th>first name</th>
        <th>last name</th>
        <th>action</th>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>
                <a href="<c:url value="/author-form/confirm-delete/${author.id}"/>">delete</a>
                <a href="<c:url value="/author-form/update/${author.id}"/>">update</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
