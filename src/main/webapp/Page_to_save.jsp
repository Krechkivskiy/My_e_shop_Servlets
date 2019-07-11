<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/userForm"><h1> To save new user please enter</h1></a>
<table border="1">
    <tr>
        <c:forEach var="user" items="${userDB}">
    <tr>
        <td>${user.value.email}</td>
        <td>${user.value.password}</td>
        <td><a href="/changeUser?id=${user.value.id}">Change</a></td>
        <td><a href="/deleteUser?id=${user.value.id}">Delete</a></td>
    </tr>
    </c:forEach>

    </tr>
</table>

<h1><a href="/productSave"> add product </a></h1>
</body>
</html>
