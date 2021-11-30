<%-- 
    Document   : Profile
    Created on : Nov 30, 2021, 5:21:54 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="shortcut icon" href="img/favicon.png" type="">
        <title> UserProfile </title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="css/style-new.css" rel="stylesheet" type="text/css" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css" />
    </head>
    </head>
    <body>
        <div class="hero_area">
<!--            <div class="bg-box">
                <img src="img/hero-bg.jpg" alt="">
            </div>-->
       <jsp:include page="Header.jsp" />
       
        <section class="u-clearfix u-section-1 center" id="sec-955d">
            <div class="container">
                <div class="row">
                    <div class="col" style="font-size: 30px">User Profile</div>
                    <div class="col"><img src="../static/images/test.jpg" class="img-fluid rounded-circle" alt="NYC" style="width:140px;height:140px;"></div>
                    <div class="w-100 margin-21"></div>
                    <div class="col size-18">Full name</div>
                    <div class="col size-18 margin-left-74">${data.getUsername()}</div>
                    <div class="w-100 margin-21"></div>
                    <div class="col size-18">Email</div>
                    <div class="col size-18 margin-left-74">${data.getEmail()}</div>
                    <div class="w-100 margin-21"></div>
                    <div class="col size-18">Mobile</div>
                    <div class="col size-18 margin-left-74">${data.getPhone() == null ? "_" : data.getPhone() }</div>
                    <div class="w-100 margin-21"></div>
                    <div class="col size-18">Gender</div>
                    <div class="col size-18 margin-left-74">${data.getGender() == null ? "_" : data.getGender()}</div>
                    <div class="w-100 margin-21"></div>
                    <div class="col size-18">Address</div>
                    <div class="col size-18 margin-bottom-40 margin-left-74">${data.getAddress() == null ? "_" : data.getAddress()}</div>
                </div>
            </div>
        </section>
                <jsp:include page="Footer.jsp" />
    </body>
</html>
