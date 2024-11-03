<%-- 
    Document   : reservation
    Created on : Oct 30, 2024, 8:44:57 AM
    Author     : bebet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>WanderWise</title>
        <meta name="description" content="WanderWise">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <!-- Reservation Section -->
        <section
            style="background-image: url(https://thuthuatnhanh.com/wp-content/uploads/2020/09/hinh-nen-co-xanh-diu-mat-cho-desktop.jpg); padding-top: 50px; padding-bottom: 200px;">
            <div class="container">
                <div class="section-content bg-white p-5 shadow"  style="margin-left: 25%;width: 50%">
                    <div id="logreg-forms">
                        <form class="form-signin" action="HomeController" method="post">
                            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Đăng Nhập</h1>
                            <p class="text-danger">
                                ${message}
                            </p>

                            <input name="username"  type="text" id="inputEmail" class="form-control" placeholder="Tên đăng nhập" value="${cookie.name.value}" required="" autofocus="">
                            <input name="password"  type="password" id="inputPassword" class="form-control" placeholder="Mật khẩu"  value="${cookie.pass.value}" required="">

                            <div class="form-group form-check">
                                <input type="checkbox" 
                                       ${(cookie.rem!=null?'checked':'')}
                                       name="rememberMe" value="ON"/>                                
                                <label>Lưu tài khoản</label>
                            </div>

                            <input type="hidden" name="COMMAND" value="LOGIN">
                            <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Đăng nhập</button>
                            <hr>
                        </form>
                        <form action="HomeController" method="post" style="margin-top: -60px">
                            <input type="hidden" name="COMMAND" value="REGISTER_FORM">
                            <button class="btn btn-primary btn-block" type="submit" id="btn-signup"><i class="fas fa-user"></i> Đăng ký</button>
                        </form>
                        <br>
                    </div>
                </div>
            </div>
        </section>


    </body>
</html>
