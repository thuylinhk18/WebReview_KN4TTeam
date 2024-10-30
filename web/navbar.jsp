<%-- 
    Document   : navbar.jsp
    Created on : Oct 31, 2024, 12:43:44 AM
    Author     : bebet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <a class="nav-link" href="post-publishing.jsp">Đăng bài nhanh</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Đăng nhập</a>
                </li>
            </div>
            <li class="nav-item">
                <a id="side-search-open" class="nav-link" href="#">
                    <span class="lnr lnr-magnifier"></span>
                </a>
            </li>
        </ul>
    </div>
</div>
</nav>
