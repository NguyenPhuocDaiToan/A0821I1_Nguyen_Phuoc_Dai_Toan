<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/10/2022
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
    <h1>Edit customer</h1>
    <c:if test = '${message} != null'>
        <p class="message">${message}</p>
    </c:if>

    <p>
        <a href="/customers">Back to customer list</a>
    </p>

    <form method="post">
        <fieldset>
            <legend>Customer information</legend>
            <table>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" id="name" value="${customer.getName()}"></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><input type="text" name="email" id="email" value="${customer.getEmail()}"></td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td><input type="text" name="address" id="address" value="${customer.getAddress()}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update customer"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
