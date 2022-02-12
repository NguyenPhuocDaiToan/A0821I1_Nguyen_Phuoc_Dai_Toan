<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/6/2022
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
    <h1>Product Discount Calculator</h1>
    <form action="/calculator" method="post">
      <h3 class="lable-input">Product Description</h3>
      <input type="text" placeholder="Desc" name="desc">
      <h3 class="lable-input">List Price</h3>
      <input type="text" placeholder="Price" name="price">
      <h3 class="lable-input">Discount Percent</h3>
      <input type="text" placeholder="Discount Percent" name="discountPercent">
      <p></p>
      <input type="submit" value="Submit">
    </form>
  </body>
</html>
