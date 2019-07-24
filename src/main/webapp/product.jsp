<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1></h1>
<div align="center">
    <form action="/admin/productSave" method="post">
        Name <br> <input type="text" name="name"> <br>
        Description <br> <input type="text" name="description"><br>
        Price <br> <input type="text" name="price"><br>
        <input type="submit">
    </form>
    ${priceError}
</div>
<table border="1">
    <tr>
        <c:forEach var="product" items="${productDatabase}">
    <tr>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.price}</td>
        <td><a href="/admin/editProduct?id=${product.id}">Change</a> ${product.id}</td>
        <td><a href="/admin/deleteProduct?id=${product.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </tr>
</table>

<a href="/register">${role}</a>
<a href="/logout">Выйти</a>
</body>
</html>
