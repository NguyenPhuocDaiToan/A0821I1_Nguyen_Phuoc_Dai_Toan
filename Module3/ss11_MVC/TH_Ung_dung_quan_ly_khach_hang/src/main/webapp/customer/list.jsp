<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/10/2022
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
        <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.css">
</head>
<body>
    <div class="container">
        <h1 class="text-center mt-4 mb-4">Customers</h1>
        <p>
            <a href="/customers?action=create">Create new customer</a>
        </p>
        <table class="table table-striped table-bordered">
            <tr class="bg-dark text-white">
                <td>Name</td>
                <td>Email</td>
                <td>Address</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <c:forEach items='${customers}' var="customer">
                <tr>
                    <td><a href="/customers?action=view&id=${customer.getId()}">${customer.getId()}</a></td>
                    <td>${customer.getEmail()}</td>
                    <td>${customer.getAddress()}</td>
                    <td><a href="/customers?action=edit&id=${customer.getId()}">edit</a></td>
                    <td><a href="/customers?action=delete&id=${customer.getId()}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>