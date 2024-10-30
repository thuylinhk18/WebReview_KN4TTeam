<%-- 
    Document   : about
    Created on : Oct 30, 2024, 8:44:28 AM
    Author     : bebet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/style.min.css"/>
<!DOCTYPE html>

<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>WanderWise</title>
        <meta name="description" content="WanderWise">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    </head>
    <body>
        <!-- navbar -->
        <jsp:include page="navbar.jsp" />
        <!-- Welcome Section -->
        <section id="gtco-welcome" class="bg-white section-padding">
            <div class="container">
                <div class="section-content">
                    <div class="row">
                        <div class="col-sm-5 img-bg d-flex shadow align-items-center justify-content-center justify-content-md-end img-2" style="background-image: url(img/hero-2.jpg);">

                        </div>
                        <div class="col-sm-7 py-5 pl-md-0 pl-4">
                            <div class="heading-section pl-lg-5 ml-md-5">
                                <h2>
                                    Welcome to WanderWise
                                </h2>
                            </div>
                            <div class="pl-lg-5 ml-md-5">
                                <p>WanderWise là nơi khởi đầu cho những hành trình mới, nơi những đánh giá chân thực về các điểm đến được chia sẻ và cảm hứng được khơi dậy. Tại đây, các thành viên có thể khám phá góc nhìn độc đáo từ nhiều chuyến đi, trao đổi kinh nghiệm, gợi ý những địa điểm hấp dẫn và hỗ trợ những ai có chung niềm đam mê du lịch. Mỗi bài đăng, mỗi bình luận đều góp phần xây dựng một cộng đồng du lịch gắn kết, nơi mỗi hành trình trở thành một câu chuyện đáng nhớ.</p>
                                <h4 class="mt-5"><b>Những đánh giá chân thực và cuốn hút,</b></h4>
                                <h4><b>Các cuộc thảo luận sôi nổi</b></h4>
                                <h4><b>& Tìm kiếm nhanh chóng</b></h4>
                                <br/>
                                




                                <h4>        ...tất cả đều có tại WanderWise</h4>
                            </div> 
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End of Welcome Section -->		<footer class="mastfoot pb-5 bg-white section-padding pb-0">
            <div class="col-lg-4">
                <div class="footer-widget pl-lg-5 pl-0">
                    <form action="HomeControl" method="post">
                        <button type="submit" class="btn btn-primary w-100" style="margin-left: 170%; margin-top: -40px" >Tham gia ngay!</button>
                         <input type="hidden" name="COMMAND" value="JOIN">
                    </form>
                </div>

        </footer>	</div>
</div>
</body>
</html>

