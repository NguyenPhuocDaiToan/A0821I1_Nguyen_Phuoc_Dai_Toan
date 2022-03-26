<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/26/2022
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/">Back to form</a>
    <h1>Thông tin người dùng đã kê khai</h1>
    <h2>Họ và tên: ${people.name}</h2>
    <h2>Ngày sinh: ${people.birthday}</h2>
    <h2>Giới tính: ${people.gender ? "Name" : "Nữ"}</h2>
    <h2>Quốc tịch: ${people.country}</h2>
    <h2>CMND: ${people.CMND}</h2>
    <h2>Phương tiện: ${people.travel}</h2>
</body>
</html>
