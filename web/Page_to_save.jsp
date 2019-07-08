<%@ page import="dao.impl.UserDaoImpl" %>
<%@ page import="factory.UserServiceFactory" %>
<%@ page import="model.User" %>
<%@ page import="service.UserService" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/userForm"><h1> To save new user please enter</h1></a>
<%
    UserDaoImpl userDao = new UserDaoImpl();
    UserService userService = UserServiceFactory.getInnstance();
    List<User> userList = userService.getAllUsers();
    PrintWriter printWriter = response.getWriter();
    printWriter.write("<form action=\"/register\" method=\"get\">\n" +
            "<input type=\"submit\" value=\"Добавить пользователя\">\n" +
            "</form>");
    printWriter.write("<table border=\"1\">");
    printWriter.write("<tr>");
    printWriter.write("<th>Email</th>");
    printWriter.write("<th>Password</th>");
    printWriter.write("</tr>");
    if (!userList.isEmpty()) {
        for (User user : userList) {
            printWriter.write("<tr>");
            printWriter.write("<td>" + user.getEmail() + "</td>");
            printWriter.write("<td>" + user.getPassword() + "</td>");
            printWriter.write("</tr>");
        }
    }%>

<h1> <a href="/productSave"> add product </a> </h1>
</body>
</html>
