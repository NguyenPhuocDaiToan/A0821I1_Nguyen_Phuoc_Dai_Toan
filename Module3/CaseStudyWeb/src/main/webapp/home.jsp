<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/1/2022
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Furama Resort</title>
    <link rel="stylesheet" href="../bootstrap4.6.0/css/bootstrap.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="css/base.css">

</head>
<body>
<div class="container-fluid px-0">
    <%@include file="nav.jsp" %>

    <div class="row px-0 mx-0 content">
        <img src="img/furama.jpg" alt="Furama Resort" style="width: 100%; height: 100%; object-fit: cover">
        <div class="container mt-4 mb-4">
            <div class="row">
                <div class="col-4" style="font-size: 24px; color: #cbbe73; font-weight: 600">
                    KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI, FURAMA ĐÀ NẴNG, NỔI TIẾNG LÀ KHU NGHỈ DƯỠNG ẨM THỰC TẠI VIỆT NAM.
                </div>
                <div class="col-4">
                    <img src="img/place1.jpg" alt="Place 1" style="width: 100%; height: 100%; object-fit: cover">
                </div>
                <div class="col-4 text-justify">
                    Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort Đà Nẵng là cửa ngõ đến với 3 di sản văn hoá thế giới: Hội An (20 phút), Mỹ Sơn (90 phút) và Huế (2 tiếng. 196 phòng hạng sang cùng với 70 căn biệt thự từ hai đến bốn phòng ngủ có hồ bơi riêng đều được trang trí trang nhã, theo phong cách thiết kế truyền thống của Việt Nam và kiến trúc thuộc địa của Pháp, biến Furama thành khu nghỉ dưỡng danh giá nhất tại Việt Nam – vinh dự được đón tiếp nhiều người nổi tiếng, giới hoàng gia, chính khách, ngôi sao điện ảnh và các nhà lãnh đạo kinh doanh quốc tế.
                </div>
            </div>

            <div class="row mt-4 mb-4 d-flex justify-content-center" style="font-size: 24px; color: #cbbe73; font-weight: 600;">
                CÁC LOẠI PHÒNG
            </div>
            <div class="row mb-4">
                Khu nghỉ dưỡng có 196 phòng được thiết kế theo phong cách truyền thống Việt Nam kết hợp với phong cách Pháp, 2 tòa nhà 4 tầng có hướng nhìn ra biển, nhìn ra hồ bơi trong xanh và những khu vườn nhiệt đới xanh tươi mát. Ngoài ra, khu nghỉ dưỡng Furama còn cung cấp các liệu pháp spa, phòng xông hơi ướt, phòng xông hơi khô, dịch vụ mát-xa cạnh hồ bơi, các dịch vụ thể thao dưới nước và các lớp tập yoga và Thái Cực Quyền trên bãi biển.
            </div>
        </div>
    </div>

    <footer class="d-flex align-items-center justify-content-center text-white">
        © Nguyễn Phước Đại Toàn 2022
    </footer>
</div>
</body>
</html>
