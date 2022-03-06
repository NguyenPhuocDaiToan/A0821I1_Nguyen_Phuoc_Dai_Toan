<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-sm navbar-dark position-fixed w-100 fixed-top">
    <!-- Brand -->
    <a class="navbar-brand" href="admin/home.jsp">Furama Đà Nẵng</a>

    <!-- Links -->
    <ul class="navbar-nav d-flex flex-grow-1">
        <li class="nav-item">
            <a class="nav-link" href="admin/home.jsp">Trang chủ</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Đặt Phòng</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Liên hệ</a>
        </li>

        <!-- Dropdown -->
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                Tuyển dụng
            </a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Link 1</a>
                <a class="dropdown-item" href="#">Link 2</a>
                <a class="dropdown-item" href="#">Link 3</a>
            </div>
        </li>
    </ul>

    <%--  Login/Logout     --%>
    <ul class="navbar-nav">
        <c:if test="${sessionScope.account == null}">
            <li class="nav-item">
                <a class="nav-link" href="login.jsp">Login</a>
            </li>
        </c:if>
        <c:if test="${sessionScope.account != null}">
            <li class="nav-item d-flex align-items-center">
                Hello, <c:out value = "${sessionScope.account.userName}"/>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
            </li>
        </c:if>
    </ul>
</nav>