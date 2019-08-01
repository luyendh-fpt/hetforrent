<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:master>
    <jsp:attribute name="content">
        <h1>Article list</h1>
        <ul>
            <c:forEach var="article" items="${articles}">
                <li class="item"><c:out value="${article.title}"/> - <c:out value="${article.category.get().name}"/> - <c:out
                        value="${article.category.get().id}"/></li>
            </c:forEach>
        </ul>
    </jsp:attribute>
</mt:master>