<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 02.08.2022
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="student" cssClass="some-class">
    <form:input path="firstName"/><br/>
    <form:input path="lastName"/><br/>
    Male: <form:radiobutton path="gender" value="M"/><br/>
    Female: <form:radiobutton path="gender" value="F"/><br/>
    <form:select path="country" items="${countryItems}" /><br/>
    <form:textarea path="notes" rows="3" cols="20"/><br/>
    <form:checkbox path="mailingList"/><br/>
    <form:select path="programmingSkills" multiple="true"><br/>
        <form:options items="${programmingSkills}" />
    </form:select> <br/>
    <form:checkboxes path="hobbies" items="${hobbies}"/> <br/>
    <input type="submit"/><br/>
</form:form>