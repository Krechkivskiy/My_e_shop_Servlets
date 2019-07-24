<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15.07.2019
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>${resultOrder}</h2>
<table border="1">
    <tr>
        <c:forEach var="product" items="${productDatabase}">
    <tr>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.price}</td>
        <td><a href="/addToBox?id=${product.id}">Add to box </a></td>
    </tr>
    </c:forEach>
    </tr>
</table>
<a href="/buy"> Елементов в корзине   ${box}</a>
<a href="/logout">Выйти</a>

</body>
</html>
