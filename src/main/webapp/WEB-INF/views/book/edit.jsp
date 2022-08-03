<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 02.08.2022
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="book" type="pl.coderslab.book.Book"--%>
<form:form modelAttribute="book" cssClass="some-class" action="/book-form/updateBook">
    <form:hidden path="id"/>
    <form:input path="title"/>
    <form:errors path="title"/>
    <form:input path="description"/>
    <form:errors path="description"/>
    <form:input path="pages"/>
    <form:errors path="pages"/>
    <form:select path="publisher">
        <form:options items="${publishers}" itemLabel="name" itemValue="id"/>
    </form:select>
    <input type="submit"/>
</form:form>
</body>
</html>
