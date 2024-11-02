<%-- 
    Document   : change-password
    Created on : Nov 2, 2024, 3:19:57 PM
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="css/profile.css"/>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <div class="container-xl px-4 mt-4">

            <div style="width: 60%;margin-left: 22%" >
                <!-- Account details card-->
                <div class="card mb-4">
                    <div class="card-header">Đổi mật khẩu</div>
                    <div class="card-body">
                        <form action="HomeControl?COMMAND=CHANGE_PASSWORD" method="post">
                            <!-- Form Group (username)-->
                            <div class="mb-3">
                                <input class="form-control" type="password" placeholder="Mật khẩu cũ" name="oldPass">
                            </div>
                            <div class="mb-3">
                                <input class="form-control" type="password" placeholder="Mật khẩu mới" name="newPass">
                            </div>
                            <div class="mb-3">
                                <input class="form-control" type="password" placeholder="Xác nhận mật khẩu" name="reNewPass">
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
    </body>
</html>
