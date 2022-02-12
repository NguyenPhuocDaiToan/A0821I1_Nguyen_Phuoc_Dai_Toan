<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/11/2022
  Time: 12:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product</title>
    <link rel="stylesheet" href="/asset/css/base.css">
    <style>
        table {
            padding: 0 20px 20px;
        }
    </style>
</head>
<body>
    <div class="main">
        <h1 class="heading">Product details</h1>
        <button class="back-to-home">
            <a href="/products" class="back-to-home-link">Back to products list</a>
        </button>
        <table>
            <tr>
                <td>Name: </td>
                <td>${product.getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${product.getPrice()}</td>
            </tr>
            <tr>
                <td>Description: </td>
                <td>${product.getDesc()}</td>
            </tr>
            <tr>
                <td>Manufacture: </td>
                <td>${product.getManufacture()}</td>
            </tr>
        </table>
    </div>
</body>
</html>
