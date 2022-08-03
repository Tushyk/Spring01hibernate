<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 03.08.2022
  Time: 09:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>field</th>
        <th>error</th>

    </tr>
    <c:forEach items="${errors}" var="error">
        <tr>
            <td>${error.getPropertyPath()}</td>
            <td>${error.getMessage()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
