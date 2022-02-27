<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/12/2022
  Time: 12:45 PM
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
        .btn-link {
            background: #dc3545;
            color: #fff;
            padding: 6px 14px;
            border-radius: 3px;
        }
        .btn-link:hover {
            background: #c82333;
            color: #fff;
            text-decoration: none;
        }

        .search-and-add-user {
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
            background: #8fd19e;
            color: #000;
            margin-right: 80px;
        }
        .btn-link-sort:hover {
            background: #3cca60;
            color: #000;
        }

        #modal-delete-container {
            position: fixed;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            background: rgba(0, 0, 0, 0.3);
            display: none;
        }
        #modal-delete {
            position: relative;
            background: #fff;
            width: 500px;
            margin: 200px auto 0;
            padding: 20px;
            background: #e9d9a3;
            border-radius: 3px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
        }
        #modal-delete__heading {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding-bottom: 12px;
            background: #e9d9a3;
        }
        .heading-title {
            margin: 0;
        }
        .close-modal {
            font-size: 26px;
            font-weight: 600;
            cursor: pointer;
        }
        .close-modal:hover {
            color: rgba(0, 0, 0, 0.4);
        }
        #modal-delete__body {
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <header class="text-center mt-4 mb-4">
            <h1 class="title-heading">User Management</h1>
        </header>
        <div class="search-and-add-user">
            <%--    Add New User    --%>
            <a href="/users?action=create" class="btn-link">Add New User</a>

            <%--   Input Search  --%>
            <form action="/users?action=search" method="post" class="form-search">
                 <input type="text" placeholder="Search by name" name="name" required class="input-search">
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
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.country}</td>
                    <td class="text-center">
                        <a href="/users?action=edit&id=${user.id}" class="btn-link">Edit</a>
                        <button onclick="openModalDelete(${user.id}, '${user.name}', '${user.email}', '${user.country}')"
                                class="ml-3 btn btn-danger">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div class="sort-by-name">
            <a href="/users?action=sortByName" class="btn-link btn-link-sort">Sort by name</a>
        </div>
        
        
        <div id="modal-delete-container">
            <div id="modal-delete">
                <div id="modal-delete__heading">
                    <h3 class="heading-title">
                        Do you want to delete this user?
                    </h3>
                    <span class="close-modal">&times;</span>
                </div>
                <table id="modal-delete__body" class="table table-light table-bordered table-striped">

                </table>
            </div>
        </div>
    </div>
</body>
<script>
    let modalContainer = document.getElementById("modal-delete-container");
    let modalDelete = document.getElementById("modal-delete");
    let btnClose = document.querySelector(".close-modal");
    function openModalDelete(id, name, email, country) {
        let hrefDelete = "/users?action=delete&id=" + id;

        modalContainer.style.display = "block";

        document.getElementById("modal-delete__body").innerHTML = `
            <tr>
                <td width="40%">ID</td>
                <td>` + id +  `</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>` + name + `</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>` + email + `</td>

            </tr>
            <tr>
                 <td>Country</td>
                 <td>` + country + `</td>
            </tr>
            <tr>
                 <td colspan="2" align="right">
                    <a href=` + hrefDelete + ` class="btn-link">Delete</a>
                 </td>
            </tr>`
    }
    btnClose.onclick = function() {
        modalContainer.style.display = "none";
    }
    window.onclick = function(event) {
        if (event.target == modalContainer) {
            modalContainer.style.display = "none";
        }
    }
</script>
</html>