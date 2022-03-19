<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/19/2022
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>Sandwich Condiments</h1>
    <form action="/sandwich" method="post">
      <span>
      <input type="checkbox" name="condiment" value="Lettuce">
      <span>Lettuce</span>
    </span>
      <span>
      <input type="checkbox" name="condiment" value="Tomato">
      <span>Tomato</span>
    </span>
      <span>
      <input type="checkbox" name="condiment" value="Mustard">
      <span>Mustard</span>
    </span>
      <span>
      <input type="checkbox" name="condiment" value="Sprouts">
      <span>Sprouts</span>
    </span>
      <p>
        <input type="submit" value="Save">
      </p>
    </form>
  <p>Choices: ${choices}</p>
  </body>
</html>
