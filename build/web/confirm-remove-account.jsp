<%-- 
    Document   : confirm-remove-account
    Created on : Nov 2, 2024, 5:32:30 PM
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

            <div style="width: 40%;margin-left: 30%" >
                <!-- Account details card-->
                <div class="card" style="margin-top: 120px">
                    <div class="card-header" style="text-align: center">Bạn chắc chắn muốn xóa tài khoản chứ?</div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-xl-6">
                                <form action="HomeController?COMMAND=REMOVE_ACCOUNT" method="post">
                                    <button class="btn btn-primary " type="submit" style="width: 40%;margin-left: 60%">Có</button>
                                </form>
                            </div>
                            <div class="col-xl-6">
                                <button class="btn btn-primary ml-3"  style="width: 40%" onclick="window.location.href = 'home.jsp'">Không</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
