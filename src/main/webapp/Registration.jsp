<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">

    <form action="/register" method="post" name="myForm">
        email<br><input type="text" name="email" value=${email}><br>
        password<br> <input type="password" name="password"> <br>
        repeat password <br> <input name="rpassword" type="password"><br>
        <input type="submit" name="btn">
    </form>
    <h3>if you want to add product click here</h3>
    <a href="/productSave">add product</a>
</div>
</body>
</html>
