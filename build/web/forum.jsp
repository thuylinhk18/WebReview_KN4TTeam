<%-- 
    Document   : team
    Created on : Oct 30, 2024, 8:45:30 AM
    Author     : bebet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <!-- Menu Section -->
        <section id="gtco-menu" class="section-padding">
            <div class="container">
                <div class="section-content">
                    <div class="row mb-5">
                        <div class="col-md-12">
                            <div class="heading-section text-center">
                                <span class="subheading">
                                    Enjoy your journey
                                </span>
                            </div>  
                        </div>
                    </div>
                    <c:if test="${!empty sessionScope.username}">
                        <form id="filterForm" action="PostController" method="GET">
                            <select name="COMMAND" id="commandSelect" onchange="submitFormWithParams()" style="margin-bottom: 10px">
                                <option value="VIEW_FORUM">Tất cả</option>
                                <option value="VIEW_FAVORITE">Đã lưu</option>
                            </select>
                        </form>
                    </c:if>
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
                                                <a href="PostController?COMMAND=MARK_POST_IN_FORUM_PAGE&postId=${post.postId}&isFavorite=${post.isFavorite}">
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
                    <script>
                        function submitFormWithParams() {
                            const select = document.getElementById("commandSelect");
                            const form = document.getElementById("filterForm");

                            // Remove any existing 'isFavorite' input
                            const existingInput = document.querySelector("input[name='isFavorite']");
                            if (existingInput) {
                                existingInput.remove();
                            }

                            // Add 'isFavorite=true' if selected option has 'data-favorite' attribute
                            if (select.value === "VIEW_FAVORITE") {
                                const isFavoriteInput = document.createElement("input");
                                isFavoriteInput.type = "hidden";
                                isFavoriteInput.name = "isFavorite";
                                isFavoriteInput.value = "true";
                                form.appendChild(isFavoriteInput);
                            }

                            form.submit();
                        }
                    </script>
                    </body>
                    </html>
