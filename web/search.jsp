<%-- 
    Document   : search
    Created on : Nov 4, 2024, 1:48:03 AM
    Author     : bebet
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>WanderWise</title>
        <meta name="description" content="WanderWise">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha384-DyZ88mC6Up2uqSg9leZI7FE7fd6E94z9RxbyZxl0/Zt3wxqFf5p54XXeByF3io8/+" crossorigin="anonymous">

        <style>
            * {
                box-sizing: border-box;
            }
            .column-3 {
                float: left;
                width: 33%;
                padding: 0 10px;
            }
            .column-2-3 {
                float: left;
                width: 25%;
                padding: 0 10px;
            }
            .column-2-9 {
                float: left;
                width: 75%;
                padding: 0 10px;
            }
            .row {
                margin: 0 -5px;
            }

            .row:after {
                content: "";
                display: table;
                clear: both;
            }
            @media screen and (max-width: 600px) {
                .column-3 {
                    width: 100%;
                    display: block;
                    margin-bottom: 20px;
                }
                .column-2-3 {
                    float: left;
                    width: 40%;
                    padding: 0 10px;
                }
                .column-2-9 {
                    float: left;
                    width: 60%;
                    padding: 0 10px;
                }
            }
            .card {
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
                padding: 16px;
                border-radius: 5px;
                transition: transform 0.2s, box-shadow 0.2s;
            }
            .card {
                position: relative;
                display: -ms-flexbox;
                display: flex;
                -ms-flex-direction: column;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 1px solid rgba(0, 0, 0, .125);
                border-radius: .25rem;
                min-height: 12rem;
            }

            .card:hover {
                transform: translateY(-5px);
                box-shadow: 0 8px 16px rgba(0, 0, 0, 0.4);
            }
            .card-image {
                width: 110%;
                height: auto;
                border-radius: 10%;
                margin-top: 10px;
                margin-right: 5px;
                overflow: hidden;
                display: block;
            }
            .text-container {
                overflow: hidden;
                text-overflow: ellipsis;
                display: -webkit-box;
                -webkit-line-clamp: 5;
                -webkit-box-orient: vertical;
                max-height: 100px;
                margin-right: 8px;
            }
            .text-container.expanded {
                max-height: none;
                -webkit-line-clamp: unset;
            }
            .card-title-container {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            a.title-link {
                text-decoration: none;
                color: black;
                font-size: 1.2rem;
            }
            .card-content {
                display: flex;
                align-items: center;
                margin-top: 10px;
                font-size: 14px;
                justify-content: space-between;
            }
            .card-price {
                margin-left: auto;
                font-weight: bold;
            }


            .card-action-button i.fa-trash-alt {
                color: #f34949;
            }
            .card-action-button a {
                margin-left: 8px;
                color: #007bff;
            }
            .card-action-button i.marked{
                color: #e67e22 !important;
            }
            .card-action-button i.fa-bookmark{
                color:#aeb6bf;
            }
            .card-image {
                max-height: 4rem;
                max-width: 4rem;
                min-height: 4rem;
                min-width: 4rem;
            }
            .card {
                position: relative;
                height: 30px;
            }

            .card-action-button {
                position: absolute;
                display: flex ;
                justify-content: flex-end;
                bottom: 6px;
                right: 10px;
            }
            div.author {
                position: absolute;
                left: 10px;
                min-width: max-content;
                font-size: 12px;
                bottom: 10px;
            }
        </style>
    </head>
    <body>

        <jsp:include page="navbar.jsp" />	

        <form action="PostController?COMMAND=SEARCH" method="post">
            <!-- Form Group (username)-->
            <div class="mb-4">
                <div class="row">
                    <div class="col-xl-9 mb-3">
                        <input class="form-control" type="text" name="keyword" value="${keyword}" style="width: 60%; margin-left: 28rem">
                    </div>
                    <div class="col-xl-3">
                        <button class="btn btn-primary" type="submit">Tìm kiếm</button>
                    </div>
                </div>
            </div>
        </form>
        <!-- Menu Section -->
        <c:if test="${postList!=null}">
            <section id="gtco-menu" class="section-padding">
                <div class="container">
                    <div class="section-content">
                        <div class="row">
                            <c:forEach var="post" items="${postList}">
                                <div class="column-3 mb-2">
                                    <div class="card">
                                        <div class="row">
                                            <div class="column-2-3">
                                                <img
                                                    class="card-image"
                                                    src="${post.postImg}"
                                                    alt="Egg Sandwich"
                                                    />
                                            </div>
                                            <div class="column-2-9">
                                                <a class="title-link" href="javascript:void(0);">
                                                    <div class="card-title-container">
                                                        <span class="card-title">${post.postTitle}</span>
                                                    </div>
                                                </a>
                                                <div class="card-content">
                                                    <span class="text-container">
                                                        ${post.tempContent}
                                                    </span>
                                                    <a href="javascript:void(0);">Xem thêm</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="author">
                                            <span> Tác giả: ${post.author} </span>
                                        </div>
                                        <div class="card-action-button">

                                            <c:if test="${sessionScope.username == post.author}">
                                                <a href="PostController?COMMAND=MARK_POST_IN_SEARCH_PAGE&postId=${post.postId}&isFavorite=${post.isFavorite}">
                                                    <c:choose>
                                                        <c:when test="${post.isFavorite}">
                                                            <i class="marked fa-solid fa-bookmark ml-1"></i>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <i class="fa-solid fa-bookmark ml-1"></i>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </a>

                                                <a href="PostController?COMMAND=VIEW_POST_TO_UPDATE&postId=${post.postId}"> <i class="fas fa-edit ml-1"></i></a>
                                                <a href="PostController?COMMAND=REMOVE_POST&postId=${post.postId}"> <i class="fas fa-trash-alt ml-1"></i></a>
                                                </c:if>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        </section>
                    </c:if>
                    </body>
                    </html>
