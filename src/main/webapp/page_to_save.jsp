<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/admin/register"><h1> To save new user please enter</h1></a>
<table border="1">
    <tr>
        <c:forEach var="user" items="${userDatabase}">
    <tr>
        <td>${user.email}</td>
        <td>${user.password}</td>
        <td><a href="/admin/editUser?id=${user.id}">Change</a></td>
        <td><a href="/admin/deleteUser?id=${user.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </tr>
</table>
<h1><a href="/admin/productSave"> add product </a></h1>
<a href="/logout">Выйти</a>
</body>
</html>
