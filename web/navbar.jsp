<%-- 
    Document   : navbar.jsp
    Created on : Oct 31, 2024, 12:43:44 AM
    Author     : bebet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- External CSS -->
<link rel="stylesheet" href="vendor/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="vendor/select2/select2.min.css">
<link rel="stylesheet" href="vendor/owlcarousel/owl.carousel.min.css">
<link rel="stylesheet" href="https://cdn.rawgit.com/noelboss/featherlight/1.7.13/release/featherlight.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/brands.css">
<!-- Fonts -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700|Josefin+Sans:300,400,700">
<link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<!-- CSS -->
<link rel="stylesheet" href="css/style.min.css">
<style>
    /* Style cho biểu tượng và dropdown */
    .user-dropdown {
        position: relative;
        display: inline-block;
        cursor: pointer;
    }

    /* Danh sách dropdown */
    .dropdown-content {
        display: none; /* Ẩn mặc định */
        position: absolute;
        top: 100%;
        right: 0;
        background-color: white;
        min-width: 200px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
        border-radius: 5px;
    }

    /* Các mục trong dropdown */
    .dropdown-content a {
        color: black;
        padding: 10px 15px;
        text-decoration: none;
        display: block;
    }

    /* Hiệu ứng khi hover vào mục */
    .dropdown-content a:hover {
        background-color: #f1f1f1;
    }
</style>

<nav id="navbar-header" class="navbar navbar-expand-lg">
    <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
        <ul class="navbar-nav d-flex justify-content-between">
            <li>
            </li>
            <div class="d-flex flex-lg-row flex-column">
                <li class="nav-item active">
                    <a class="nav-link" href="home.jsp">Trang Chủ<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="forum.jsp">Diễn đàn</a>
                </li>
            </div>
        </ul>

        <a class="navbar-brand navbar-brand-center d-flex align-items-center only-desktop" href="home.jsp">
            <h2>WanderWise</h2>
        </a>
        <ul class="navbar-nav d-flex justify-content-between">
            <div class="d-flex flex-lg-row flex-column">
                <li class="nav-item active">
                    <a class="nav-link" href="post-publishing.jsp">Đăng bài nhanh </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Tìm kiếm</a>
                </li>
            </div>
            <c:choose>
                <c:when test="${empty sessionScope.username}">
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Đăng nhập</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <div class="user-dropdown" onclick="toggleDropdown()">
                            <i class="fas fa-user"></i> <!-- Biểu tượng user -->
                            <div class="dropdown-content" id="userDropdown">
                                <a href="HomeControl?COMMAND=VIEW_PROFILE">Chỉnh sửa thông tin</a>
                                <a href="change-password.jsp">Đổi mật khẩu</a>
                                <a href="#favorites">Bài viết yêu thích</a>
                                <a href="#my-posts">Bài viết đã đăng</a>
                                <a href="HomeControl?COMMAND=REMOVE_ACCOUNT">Xóa tài khoản</a>
                                <a href="HomeControl?COMMAND=LOGOUT">Đăng xuất</a>

                            </div>
                        </div>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
    <script>
        function toggleDropdown() {
            const dropdown = document.getElementById("userDropdown");
            dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
        }

        // Đóng dropdown nếu click bên ngoài
        window.onclick = function (event) {
            if (!event.target.matches('.user-dropdown, .user-dropdown *')) {
                const dropdown = document.getElementById("userDropdown");
                if (dropdown.style.display === "block") {
                    dropdown.style.display = "none";
                }
            }
        };
    </script>
</nav>
