<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 02.08.2022
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="author" type="pl.coderslab.author.Author"--%>
<form:form modelAttribute="author" cssClass="some-class">
    <form:hidden path="id"/>
    <form:input path="firstName"/>
    <form:errors path="firstName"/>
    <form:input path="lastName"/>
    <form:errors path="lastName"/>
    <form:input path="email"/>
    <form:errors path="email"/>
    <form:input path="pesel"/>
    <form:errors path="pesel"/>
    <input type="submit"/>
</form:form>
</body>
</html>
