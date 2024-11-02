<%-- 
    Document   : edit-profile
    Created on : Nov 2, 2024, 12:57:31 AM
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="css/profile.css"/>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <div class="container-xl px-4 mt-4">
            <div class="row">
                <div class="col-xl-4">
                    <!-- Profile picture card-->
                    <div class="card mb-4 mb-xl-0">
                        <div class="card-header">Hình đại diện</div>
                        <div class="card-body text-center">
                            <!-- Profile picture image-->
                            <img class="img-account-profile rounded-circle mb-2" src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="">
                            <!-- Profile picture help block-->
                            <div class="small font-italic text-muted mb-4">JPG hoặc PNG không lớn hơn 5 MB</div>
                            <!-- Profile picture upload button-->
                            <button class="btn btn-primary" type="button">Chọn hình ảnh</button>
                        </div>
                    </div>
                </div>
                <div class="col-xl-8">
                    <!-- Account details card-->
                    <div class="card mb-4">
                        <div class="card-header">Thông tin của tôi</div>
                        <div class="card-body">
                            <form action="HomeControl?COMMAND=EDIT_PROFILE" method="post">
                                <!-- Form Group (username)-->
                                <div class="mb-3">
                                    <input class="form-control" type="text" placeholder="Họ và tên" name="fullname" value="${user.fullname}">
                                </div>
                                <div class="mb-3">
                                    <input class="form-control" type="text" placeholder="Tên tài khoản" name="username" value="${user.username}">
                                </div>
                                <div class="mb-3">
                                    <input class="form-control" type="email" placeholder="Email" name="email" value="${user.email}">
                                </div>
                                <!-- Save changes button-->
                                <c:if test="${!empty message}">
                                    <span class="text-danger">${message}</span>
                                </c:if>
                                <br>
                                <button class="btn btn-primary mt-2" type="submit">Lưu thay đổi</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
