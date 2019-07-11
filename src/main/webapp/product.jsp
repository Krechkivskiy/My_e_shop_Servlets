<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1></h1>
<div align="center">
    <form action="/productSave" method="post">
        Name <br> <input type="text" name="name"> <br>
        Description <br> <input type="text" name="description"><br>
        Price <br> <input type="text" name="price"><br>
        <button><h1>Add product</h1></button>
    </form>
</div>
<div align="right"><h2><a href="/signin"> пользователи </a></h2></div>
<table border="1">
    <tr>
        <c:forEach var="product" items="${productDB}">
    <tr>
        <td>${product.value.name}</td>
        <td>${product.value.description}</td>
        <td>${product.value.price}</td>
        <td><a href="/changeProduct?id=${product.value.id}">Change</a></td>
        <td><a href="/deleteProduct?id=${product.value.id}">Delete</a></td>
    </tr>
    </c:forEach>

    </tr>
</table>
</body>
</html>
