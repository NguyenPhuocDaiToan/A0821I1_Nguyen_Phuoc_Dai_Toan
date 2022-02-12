<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/10/2022
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.css">
    <link rel="stylesheet" href="asset/css/list.css">
    <style>
        .back-to-home-link {
            color: #000;
        }
        .back-to-home-link:hover {
            color: #fff;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <h1 class="text-center mt-4 mb-4">Products Manage</h1>
        <div class="input-search-wrapper">
            <a href="/products?action=create" target="_blank" class="btn btn-info creat-product-link">Create new customer</a>
            <div>
                <form action="/products?action=searchByName" method="post">
                    <input type="text" placeholder="Tìm kiếm sản phẩm theo tên" name="nameProduct" class="input-search">
                    <input type="submit" value="Tìm kiếm">
                </form>
            </div>
        </div>
        <c:if test='${message == "searchByName"}'>
            <button class="btn btn-danger mb-3">
                <a href="/products" class="back-to-home-link">Back to home</a>
            </button>
        </c:if>
        <table class="table table-striped">
            <tr class="bg-info text-dark">
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Manufacture</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items = "${products}" var = "product">
                <tr>
                    <td><a href="/products?action=view&id=${product.getId()}">${product.getId()}</a></td>
                    <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
                    <td>${product.getPrice()}</td>
                    <td>${product.getDesc()}</td>
                    <td>${product.getManufacture()}</td>
                    <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>
                    <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
