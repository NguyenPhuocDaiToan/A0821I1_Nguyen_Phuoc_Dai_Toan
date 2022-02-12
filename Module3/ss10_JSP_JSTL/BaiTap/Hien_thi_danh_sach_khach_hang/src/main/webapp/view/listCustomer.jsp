<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/8/2022
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.css">
</head>
<body>
    <h1 class="text-center mb-2 mt-2">Danh sách khách hàng</h1>
    <div class="container">
        <table class="table">
            <tr class="bg-dark text-white">
                <th>Tên</th>
                <th>Ngày Sinh</th>
                <th>Địa Chỉ</th>
                <th>Ảnh</th>
            </tr>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.name}</td>
                    <td>${customer.date}</td>
                    <td>${customer.address}</td>
                    <td><img src="${customer.srcImg}" alt="Image" width="80px"></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
