<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 23.11.2017
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2><c:out value="${helloMessage}"/></h2>
<form method="post" action="add">
    <input name="title" placeholder="Title"/><br/>
    <textarea name="content">Content here...</textarea><br/>
    <input name="tags" placeholder="tag1,tag2,tag3"/><br/>
    <input type="submit" value="Add"/>
</form>
</body>
</html>
