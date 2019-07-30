<%@ page import="entity.Article" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-07-30
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Article article = (Article)request.getAttribute("article");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><%= article.getTitle()%></h1>
    <p>Category: <%= article.getCategory().get().getName()%></p>
</body>
</html>
