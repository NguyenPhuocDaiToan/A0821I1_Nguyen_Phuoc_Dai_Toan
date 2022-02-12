<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/12/2022
  Time: 3:40 PM
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
        .main {
            width: 600px;
            margin: 0 auto;
            background: cornsilk;
            padding: 20px;
            margin-top: 50px;
        }
        .form-control-edit {
            width: 100%;
        }
        .input-info {
            width: 100%;
        }
        .btn-link {
            background: #343a40;
            padding: 6px 14px;
            border-radius: 3px;
        }
    </style>
</head>
<body>
    <div class="main">
        <header class="text-center">
            <h1>User Management</h1>
        </header>
        <div class="content">
            <a href="users?action=users" class="text-white text-decoration-none btn-link">Back to home</a>
            <h2 class="title-table text-center">
                Edit User
            </h2>
            <form method="post" class="form-control-edit">
                <table class="table table-striped bg-light">
                    <c:if test="${user != null}">
                        <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
                    </c:if>
                    <tr>
                        <th>User Name:</th>
                        <td>
                            <input type="text" name="name" class="input-info"
                                   value="<c:out value='${user.name}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>User Email:</th>
                        <td>
                            <input type="text" name="email" class="input-info"
                                   value="<c:out value='${user.email}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Country:</th>
                        <td>
                            <input type="text" name="country" class="input-info"
                                   value="<c:out value='${user.country}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <input type="submit" value="Save"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>