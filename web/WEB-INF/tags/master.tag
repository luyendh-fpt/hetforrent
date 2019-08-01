<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="content" fragment="true" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>

<div class="header">
    This is header
</div>

<div class="main">

    <div class="left-bar">
        This is menu
    </div>

    <jsp:invoke fragment="content"/>

</div>

<div class="footer">
    This is footer
</div>
<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script>
    $('.item').click(function () {
        alert(1);
    });
</script>
</body>
</html>
