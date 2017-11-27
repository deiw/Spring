<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 21.11.2017
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<h2>Shopping Cart</h2>
<form method="post" action="add">
    <input type="text" placeholder="Product name" name="product" required/><br/>
    <input type="submit" value="Add"/><br/>
</form>
<br/>
<c:if test="${not empty list.products}">
<c:forEach var="product" items="${list.products}">
    <c:out value="${product}"/><br/>
</c:forEach>
</c:if>
</body>
</html>
