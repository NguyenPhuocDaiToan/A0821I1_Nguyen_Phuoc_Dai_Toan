<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit employee</title>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.css">

    <style>
        th {
            text-align: left;
        }
        input, select {
            width: 100%;
        }
    </style>
</head>

<body>
<div class="container">
    <h2 class="text-center mt-4 mb-4">Edit employee</h2>
    <c:if test="${mess != null}">
        <p>${mess}</p>
    </c:if>
    <form method="post">
        <table class="table table-striped bg-light">
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" required value="${employee.getName()}"/>
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="date" name="birthday" required value = "${employee.getBirthday()}"/>
                </td>
            </tr>
            <tr>
                <th>Card:</th>
                <td>
                    <input type="text" name="card" required  value = "${employee.getIdCard()}"/>
                </td>
            </tr>
            <tr>
                <th>Salary:</th>
                <td>
                    <input type="text" name="salary" required value = "${employee.getSalary()}"/>
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="phone" required value = "${employee.getPhone()}"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="email" name="email" required value = "${employee.getEmail()}"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" required value = "${employee.getAddress()}"/>
                </td>
            </tr>
            <tr>
                <th>Position:</th>
                <td>
                    <select name="positionId">
                        <c:forEach var="position" items="${positions}">
                            <c:if test="${position.getPosition_id() == employee.getPositionId()}">
                                <option value="${position.getPosition_id()}">${position.getPosition_name()}</option>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="position" items="${positions}">
                            <c:if test="${position.getPosition_id() != employee.getPositionId()}">
                                <option value="${position.getPosition_id()}">${position.getPosition_name()}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Division:</th>
                <td>
                    <select name="divisionId">
                        <c:forEach var="division" items="${divisions}">
                            <c:if test="${division.getDivision_id() == employee.getDivisionId()}">
                                <option value="${division.getDivision_id()}">${division.getDivision_name()}</option>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="division" items="${divisions}">
                            <c:if test="${division.getDivision_id() != employee.getDivisionId()}">
                                <option value="${division.getDivision_id()}">${division.getDivision_name()}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Education degree:</th>
                <td>
                    <select name="educationDegreeId">
                        <c:forEach var="ed" items="${educationDegrees}">
                            <c:if test="${ed.getEducation_degree_id() == employee.getEducationDegreeId()}">
                                <option value="${ed.getEducation_degree_id()}">${ed.getEducation_degree_name()}</option>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="ed" items="${educationDegrees}">
                            <c:if test="${ed.getEducation_degree_id() != employee.getEducationDegreeId()}">
                                <option value="${ed.getEducation_degree_id()}">${ed.getEducation_degree_name()}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <button type="submit" class="btn btn-success">Edit</button>
                    <a href="/employee" class="btn btn-dark">Back</a>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
