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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UserProfile</title>
    </head>
    <body>
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
    </body>
</html>
