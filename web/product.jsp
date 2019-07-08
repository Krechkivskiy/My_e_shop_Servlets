<%@ page import="dao.ProductDAO" %>
<%@ page import="factory.ProductDaoFactory" %>
<%@ page import="model.Product" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%
    PrintWriter printWriter = response.getWriter();
    ProductDAO instance = ProductDaoFactory.getInstance();
    List<Product> productList = instance.getAll();
    printWriter.write("<br><br>");
    printWriter.write("<table border=\"1\">");
    printWriter.write("<tr>");
    printWriter.write("<th>Наименование</th>");
    printWriter.write("<th>Описание</th>");
    printWriter.write("<th>Цена</th>");
    printWriter.write("</tr>");
    if (!productList.isEmpty()) {
        for (Product product : productList) {
            printWriter.write("<tr>");
            printWriter.write("<td>" + product.getName() + "</td>");
            printWriter.write("<td>" + product.getDescriptional() + "</td>");
            printWriter.write("<td>" + product.getPrice() + "</td>");
            printWriter.write("</tr>");
        }
    }
    printWriter.write("</table>");
%>
</body>
</html>
