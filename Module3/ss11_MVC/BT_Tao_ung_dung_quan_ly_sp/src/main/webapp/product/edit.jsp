<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/10/2022
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
    <link rel="stylesheet" href="/asset/css/base.css">
    <link rel="stylesheet" href="/asset/css/save.css">
</head>
<body>
    <div class="main">
        <h1 class="heading">Edit Product</h1>
        <p>
            <c:if test='${message != null}'>
        <p class="message">${message}</p>
        </c:if>
        </p>
        <button class="back-to-home">
            <a href="/products" class="back-to-home-link">Back to products list</a>
        </button>
        <form method="post">
            <fieldset>
                <legend>Product infomation</legend>
                <table>
                    <tr>
                        <td>Name: </td>
                        <td><input type="text" name="name" placeholder="Name" class="input-data"></td>
                    </tr>
                    <tr>
                        <td>Price: </td>
                        <td><input type="text" name="price" placeholder="Price" class="input-data"></td>
                    </tr>
                    <tr>
                        <td>Description: </td>
                        <td><input type="text" name="desc" placeholder="Description" class="input-data"></td>
                    </tr>
                    <tr>
                        <td>Manufacture: </td>
                        <td><input type="text" name="manufacture" placeholder="Manufacture" class="input-data"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Create product" class="btn-submit-form"></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</body>
</html>
