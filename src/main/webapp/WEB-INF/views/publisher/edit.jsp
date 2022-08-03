<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 02.08.2022
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="publisher" type="pl.coderslab.publisher.Publisher"--%>
<form:form modelAttribute="publisher" cssClass="some-class" action="/publisher-form/update-publisher">
    <form:hidden path="id"/>
    <form:input path="name"/>
    <form:errors path="name"/>
    <form:input path="nip"/>
    <form:errors path="nip"/>
    <form:input path="regon"/>
    <form:errors path="regon"/>
    <input type="submit"/>
</form:form>
</body>
</html>
