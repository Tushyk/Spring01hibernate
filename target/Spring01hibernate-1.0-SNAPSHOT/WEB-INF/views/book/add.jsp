<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@elvariable id="book" type="pl.coderslab.book.Book"--%>
<form:form modelAttribute="book" cssClass="some-class">
    <form:hidden path="id"/>
    <form:input path="title"/>
    <form:errors path="title"/>
    <form:input path="description"/>
    <form:errors path="description"/>
    <form:input path="rating"/>
    <form:errors path="rating"/>
    <form:input path="pages"/>
    <form:errors path="pages"/>
    <form:select path="publisher">
        <form:options items="${publishers}" itemLabel="name" itemValue="id"/>
    </form:select>
    <form:select path="category">
        <form:options items="${categories}" itemLabel="name" itemValue="id"/>
    </form:select>
    <form:checkboxes path="authors" items="${authors}" itemLabel="lastName" itemValue="id"/>
    <input type="submit"/>
</form:form>

</body>
</html>
