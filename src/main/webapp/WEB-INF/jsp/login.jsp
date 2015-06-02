<%--
  Created by
  User: Hasan TEKGÜL
  Date: 6/2/2015
  Time: 4:33 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form:form action="/login" method="POST" modelAttribute="form">
        <form:errors path="" element="div" />
        <input type="hidden" name="${_csrf.paramaterName}" value="${_csrf.token}"/>
        <div>
            <form:label path="email">Email address</form:label>
            <form:input path="email" />
            <form:errors path="email" />
        </div>
        <div>
            <form:label path="password">Password</form:label>
            <form:input path="password" />
            <form:errors path="password" />
        </div>
        <div>
            <form:checkbox label="Remember me" path="remember-me" />
            <form:errors path="email" />
        </div>
        <div>
            <button type="submit">Sign in</button>
        </div>
    </form:form>
</body>
</html>
