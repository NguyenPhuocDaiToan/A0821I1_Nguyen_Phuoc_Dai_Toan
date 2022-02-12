<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/10/2022
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
    <link rel="stylesheet" href="/asset/css/base.css">
    <style>
        h3 {
            margin-top: 0;
        }
        .heading {
            padding: 20px 0;
        }
    </style>
</head>
<body>
    <div class="main">
        <h1 class="heading">Delete customer</h1>
        <button class="back-to-home">
            <a href="/products" class="back-to-home-link">Back to products list</a>
        </button>
        <form method="post">
            <h3>Are you sure delete product?</h3>
            <fieldset>
                <legend>Product information</legend>
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
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Delete product" class="btn-submit-form"></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</body>
</html>
