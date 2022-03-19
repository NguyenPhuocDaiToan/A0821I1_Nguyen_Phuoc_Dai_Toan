<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/19/2022
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="calculator" method="get">
    <input type="text" name="number1">
    <input type="text" name="number2">
    <p></p>

    <button type="submit" value="+" name="operator">Addition(+)</button>
    <button type="submit" value="-" name="operator">Subtraction(-)</button>
    <button type="submit" value="*" name="operator">Multiplication(X)</button>
    <button type="submit" value="/" name="operator">Division(/)</button>
  </form>
  <div>
    Result Division: ${result}
  </div>
  </body>
</html>
