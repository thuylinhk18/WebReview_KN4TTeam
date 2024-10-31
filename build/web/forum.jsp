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
            }
            .card-price {
                margin-left: auto;
                font-weight: bold;
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
                                    Specialties
                                </span>
                                <h2>
                                    Our Menu
                                </h2>
                            </div>  
                        </div>
                    </div>
                    <div class="row">
                        <c:forEach var="post" items="${postList}">
                            <div class="column-3">
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
                                                    Lorem ipsum dolor sit amet, consectetur...
                                                </span>
                                                <a href="javascript:void(0);">Read more</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    </body>
                    </html>
