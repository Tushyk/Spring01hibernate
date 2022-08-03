<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 02.08.2022
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/publisher-form/add/"/>">add</a>
<table>
  <tr>
    <th>Id</th>
    <th>name</th>
    <th>action</th>
  </tr>
  <c:forEach items="${publishers}" var="publisher">
    <tr>
      <td>${publisher.id}</td>
      <td>${publisher.name}</td>
      <td>
        <a href="<c:url value="/publisher-form/confirm-delete/${publisher.id}"/>">delete</a>
        <a href="<c:url value="/publisher-form/update/${publisher.id}"/>">update</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
