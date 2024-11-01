<%-- 
    Document   : register
    Created on : Nov 1, 2024, 12:34:47 PM
    Author     : bebet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <form action="HomeControl" method="post">
                            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Đăng ký</h1>
                            <input name="fullname" type="text" class="form-control" placeholder="Họ và tên" required="" autofocus="">
                            <input name="username" type="text" class="form-control" placeholder="Tên đăng nhập" required="" autofocus="">
                            <input name="password" type="password"  class="form-control" placeholder="Mật khẩu" required autofocus="">
                            <input name="repassword" type="password"  class="form-control" placeholder="Xác nhận mật khẩu" required autofocus="">
                            <input name="email" type="email" class="form-control" placeholder="Email" required autofocus="">

                            <p class="text-danger">
                                ${message}
                            </p>
                            <input type="hidden" name="COMMAND" value="REGISTER">
                            <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user"></i> Đăng ký</button>
                            <a href="login.jsp" id="cancel_signup"><i class="fas fa-angle-left"></i> Đăng nhâp</a>
                        </form>
                        <br>

                    </div>
                </div>
            </div>
        </section>


    </body>
</html>