<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/25/2022
  Time: 3:50 PM
  To change this template use File | Settings | File Templates
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tờ khai y tế</title>
</head>
<body>
    <h1>TỜ KHAI Y TẾ</h1>
    <form:form action="/save" method="post" modelAttribute="res">
        <label>Họ tên: </label>
        <form:input type="text" path="name"/>
        <br>
        <label>Năm sinh: </label>
        <form:input type="date" path="birthday"/>
        <br>
        <label>Gender: </label>
        <form:radiobutton path="gender" value="true"/>Nam
        <form:radiobutton path="gender" value="false"/>Nữ
        <br>
        <label>Quốc tịch</label>
        <form:input type="text" path="country"/>
        <br>
        <label>CMND</label>
        <form:input type="text" path="CMND"/>
        <br>
        <label>Travel</label>
        <form:input type="text" path="travel"/>

        <input type="submit" value="Send">
    </form:form>
</body>
</html>