<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee Manager</title>
    <link rel="stylesheet" href="../bootstrap4.6.0/css/bootstrap.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="../css/base.css">

    <style>
        .content {
            min_height: var(--height_content);
            margin-top: 60px;
        }
    </style>
</head>
<body>
<div class="container-fluid px-0">
    <%@include file="nav.jsp" %>

    <div class="row px-0 mx-0 content">
        <div class="col-2 px-0">
            <%@include file="sidebar.jsp" %>
        </div>

        <div class="col-10 px-0">
            <div class="container mb-5">
                <h1 class="text-center mt-4">Employee Manager</h1>

                <div class="content">
                    <div class="d-flex justify-content-between align-items-center">
                        <a class="btn btn-info" href="/employee?action=create">Add new employee</a>
                        <form class="search form-inline" method="post" action="/employee?action=search">
                            <input type="text" placeholder="Search by name" name="name">
                            <input type="submit" value="Search" class="ml-2">
                        </form>
                    </div>

                    <div class="content-body">
                        <h2 class="text-center">List employee</h2>
                        <table class="table table-hover table-bordered">
                            <tr class="bg-info text-center">
                                <th>ID</th>
                                <th>Name</th>
                                <th>Birthday</th>
                                <th>Card</th>
                                <th>Salary</th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Address</th>
                                <th>Position</th>
                                <th>Education degree</th>
                                <th>Division</th>
                                <th>Username</th>
                                <th>Action</th>
                            </tr>
                            <c:forEach var="employee" items="${employees}">
                                <tr>
                                    <td>${employee.getId()}</td>
                                    <td>${employee.getName()}</td>
                                    <td>${employee.getBirthday()}</td>
                                    <td>${employee.getIdCard()}</td>
                                    <td>${employee.getSalary()}</td>
                                    <td>${employee.getPhone()}</td>
                                    <td>${employee.getEmail()}</td>
                                    <td>${employee.getAddress()}</td>
                                    <td>${employee.getPositionName()}</td>
                                    <td>${employee.getEducationDegreeName()}</td>
                                    <td>${employee.getDivisionName()}</td>
                                    <td>${employee.getUserName()}</td>
                                    <td class="text-center d-flex">
                                        <a class="btn btn-danger" href="/employee?action=edit&id=${employee.getId()}">Edit</a>
                                        <button class="btn btn-danger ml-2" data-toggle="modal" data-target="#myModal" data-id="${employee.getId()}">Delete</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>

                <!-- The Modal -->
                <div class="modal fade" id="myModal">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Do you want to delete this employee?</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
                                <a href="/employee?action=delete&id=">
                                    <button type="button" class="btn btn-danger">Yes</button>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer class="d-flex align-items-center justify-content-center text-white position-fixed fixed-bottom">
        © Nguyễn Phước Đại Toàn 2022
    </footer>
</div>
<script>
    $('#myModal').on('show.bs.modal', function (e) {
        let productId = $(e.relatedTarget).attr('data-id');
        document.querySelector("a[href^='/employee?action=delete&id=']").href = '/employee?action=delete&id=' + productId;
    });
</script>
</body>
</html>

