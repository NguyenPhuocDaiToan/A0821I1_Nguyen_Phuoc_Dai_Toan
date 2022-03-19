<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/16/2022
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/convert" method="get">
        <p>
            USD
            <input type="text" name="USD">
        </p>
        <p>
            RATE:
            <input type="text" name="rate">
        </p>
        <input type="Submit" value="Convert">
    </form>
</body>
</html>
