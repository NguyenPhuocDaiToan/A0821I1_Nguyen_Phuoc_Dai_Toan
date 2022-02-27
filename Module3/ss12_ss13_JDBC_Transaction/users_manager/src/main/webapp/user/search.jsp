<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/12/2022
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.css">
    <style>
        .search-and-back-to-home {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .form-search {
            display: flex;
            align-items: center;
        }
        .input-search {
            padding: 5px 0 5px 5px;
            margin-right: 8px;
        }
        .sort-by-name {
            text-align: right;
        }
        .btn-link-sort {
            padding: 6px 14px;
            border-radius: 3px;
            background: #8fd19e;
            color: #000;
            margin-right: 80px;
        }
        .btn-link-sort:hover {
            background: #3cca60;
            color: #000;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container">
    <header class="text-center mt-4 mb-4">
        <h1 class="title-heading">Search Users By Country</h1>
    </header>
    <div class="search-and-back-to-home">
        <%--    Add New User    --%>
        <button class="btn btn-danger">
            <a href="/users" class="text-white text-decoration-none">Back to home</a>
        </button>

        <%--   Input Search  --%>
        <form action="/users?action=search" method="post" class="form-search">
            <input type="text" placeholder="Search by country" name="country" required class="input-search">
            <input type="submit" value="Search" class="btn btn-danger">
        </form>
    </div>
    <table class="table table-hover table-bordered">
        <h2 class="text-center mt-2 mb-2">List of Users</h2>
        <tr class="bg-info">
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th class="text-center">Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td class="text-center">
                    <button class="btn btn-danger">
                        <a href="/users?action=edit&id=${user.id}" class="text-white text-decoration-none">Edit</a>
                    </button>
                    <button class="btn btn-danger ml-4">
                        <a href="/users?action=delete&id=${user.id}" class="text-white text-decoration-none">Delete</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="sort-by-name">
        <a href="/users?action=sortByName&country=${country}" class="btn-link btn-link-sort">Sort by name</a>
    </div>
</div>
</body>
</html>
