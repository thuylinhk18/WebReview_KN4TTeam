<%-- 
    Document   : reservation
    Created on : Oct 30, 2024, 8:44:57 AM
    Author     : bebet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--
        Resto by GetTemplates.co
        URL: https://gettemplates.co
-->
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Resto - Restaurant Bootstrap 4 Template by GetTemplates.co</title>
        <meta name="description" content="Resto">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <!-- Reservation Section -->
        <section
            style="background-image: url(https://thuthuatnhanh.com/wp-content/uploads/2020/09/hinh-nen-co-xanh-diu-mat-cho-desktop.jpg); padding-top: 50px; padding-bottom: 200px;">
            <div class="container">
                <div class="section-content bg-white p-5 shadow"  style="margin-left: 25%;width: 50%">
                    <div class="heading-section text-center">
                        <h2>
                            Đăng nhập
                        </h2>
                    </div>
                    <c:set var="cookie" value="${pageContext.request.cookies}"/>

                    <form method="post" name="contact-us" action="HomeControl">

                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" name="name" placeholder="Tên đăng nhập" 
                                   value="${cookie.name.value}"
                                   required>
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="password" class="form-control"  name="password" placeholder="Mật khẩu"
                                   value="${cookie.pass.value}"
                                   required>
                        </div>
                        <input type="checkbox" 
                               ${(cookie.rem!=null?'checked':'')}
                               name="rememberMe" value="ON" style="margin-left: 18px;"/> Remember me 
                        <br/>
                        <h3 style="color: red">${requestScope.message}</h3>
                        <div class="col-md-12 form-group"> 
                            <button class=" btn btn-shadow btn-lg" type="submit" style="margin-left: 38%;background-color: #f34949;color: white">Đăng nhập</button>
                            <input type="hidden" name="COMMAND" value="LOGIN">
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </body>
</html>
