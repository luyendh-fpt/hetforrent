<%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-07-30
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category form</title>
</head>
<body>
    <h1>Category form</h1>
    <form action="/admin/category/add" method="post">
        <div>
            Name <input type="text" name="name">
        </div>
        <div>
            Description <input type="text" name="description">
        </div>
        <div>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
    </form>

</body>
</html>
