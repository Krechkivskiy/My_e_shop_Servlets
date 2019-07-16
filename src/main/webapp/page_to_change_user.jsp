<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09.07.2019
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/admin/editUser" method="post" name="myForm">
    <input value="${id}" name="id" type="hidden">
    new email<br><input type="text" name="email"><br>
    new password<br> <input type="password" name="password"> <br>
    <select name="role">
        <option>admin</option>
        <option>user</option>
    </select>
    <input type="submit" name="btn"></form>
</body>
<a href="/logout">Выйти</a>
</html>
