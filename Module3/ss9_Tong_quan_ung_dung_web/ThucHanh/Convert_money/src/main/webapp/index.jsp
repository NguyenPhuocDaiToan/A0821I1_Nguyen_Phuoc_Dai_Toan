<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/6/2022
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency Convert</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
    <div class="form_wraper">
      <h2>Currency Convert</h2>
      <form action="/convert" method="get">
        <lable>Rate</lable>
        <input type="text" name="rate" placeholder="RATE">
        <lable>USD</lable>
        <input type="text" name="USD" placeholder="USD">
        <input type="submit" id="submit" value="Convert">
      </form>
    </div>
  </body>
</html>
