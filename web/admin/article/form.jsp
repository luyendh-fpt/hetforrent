<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-07-30
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Article form</title>
</head>
<body>
    <h1>Article form</h1>
    <c:set var = "salary" scope = "session" value = "${2000*2}"/>
    <c:out value = "${salary}"/>
    <form action="/admin/article/add" method="post">
        <div>
            Slug <input type="text" name="url">
        </div>
        <div>
            Category
            <select name="categoryId">
                <c:forEach var="cate" items="${categories}">
                    <option value="${cate.id}"><c:out value = "${cate.name}"/></option>
                </c:forEach>
            </select>
        </div>
        <div>
            Title <input type="text" name="title">
        </div>
        <div>
            Description <input type="text" name="description">
        </div>
        <div>
            Content
<%--            ckeditor--%>
            <textarea rows="3" cols="3"></textarea>
        </div>
        <div>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
    </form>

</body>
</html>
