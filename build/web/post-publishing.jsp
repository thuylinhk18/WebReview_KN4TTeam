<%-- 
    Document   : post-publishing
    Created on : Oct 30, 2024, 9:13:11 AM
    Author     : bebet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
        Resto by GetTemplates.co
        URL: https://gettemplates.co
-->
<html>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>WanderWise</title>
        <meta name="description" content="WanderWise">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <style>
            p.small {
                font-size: 10px;
                text-align: left;
                padding-top: 8px;
                padding-left: 4.2rem;
                margin: 0px !important;
            }
        </style>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />	
        <!-- Reservation Section -->
        <section 
            style="background-image: url(https://media.self.com/photos/5f0885ffef7a10ffa6640daa/4:3/w_5240,h_3929,c_limit/travel_plane_corona.jpeg);">
            <div class="container">
                <div class="section-content bg-white p-5 shadow" style="margin-left: 25%; width: 50%;">
                    <div class="heading-section text-center">
                        <h2>
                            Bài đăng của bạn
                        </h2>
                    </div>
                    <form action="PostController?COMMAND=CREATE_POST" method="post" enctype="multipart/form-data" >
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <input type="text" class="form-control" name="title" placeholder="Tiêu đề">
                            </div>
                            <div class="col-md-12 form-group">
                                <textarea class="form-control" name="content" rows="10" placeholder="Nội dung"></textarea>
                            </div>
                             <div>
                                <input type="file" name="image" accept="image/*" onchange="validateFileSize()">
                                <p class="small font-italic text-muted mb-4">Hình ảnh không lớn hơn 5 MB</p>
                            </div>
                            <div class="col-md-12 form-group"> 
                                <button class=" btn btn-shadow btn-lg" type="submit" style="margin-left: 38%;background-color: #f34949;color: white">Đăng bài</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    <script>
        const MAX_FILE_SIZE = 5 * 1024 * 1024; // 2 MB

        function validateFileSize() {
            const fileInput = document.getElementById("image");
            const file = fileInput.files[0];

            if (file && file.size > MAX_FILE_SIZE) {
                alert("File is too large. Maximum size is 2MB.");
                fileInput.value = ""; // Clear the file input
            }
        }
    </script>
    </body>
</html>

