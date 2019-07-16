<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15.07.2019
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/confirm" method="post">
    <input type="text" name="code" >
    <input type="submit">
</form>
<h2>${errorMsg}</h2>


</body>
</html>
