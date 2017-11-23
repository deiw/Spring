<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 23.11.2017
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<c:if test="${not empty article}">
    <h1><c:out value="${article.title}"/></h1><br/>
    <p>
        <c:out value="${article.content}"/>
    </p>
    <c:if test="${not empty article.tags}">
        <c:forEach items="${article.tags}" var="tag">
            <c:out value="${tag}"/>
        </c:forEach>
    </c:if>
</c:if>
</body>
</html>
