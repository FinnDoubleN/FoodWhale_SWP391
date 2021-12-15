<%-- 
    Document   : Profile
    Created on : Nov 30, 2021, 5:21:54 PM
    Author     : ADMIN
--%>

<%@page import="model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Order_Detail"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="shortcut icon" href="img/favicon.png" type="">
        <title> Profile </title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="css/style-new.css" rel="stylesheet" type="text/css" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css" />
        <link href="css/user-cart.css" rel="stylesheet" type="text/css" />
        <link href="css/profile.css" rel="stylesheet" type="text/css"/>
        <%
            ArrayList<Order> orderdetail = (ArrayList<Order>) request.getAttribute("orderdetail");
            User u = (User) request.getAttribute("userdetail");
            Cookie cookie = null;
            Cookie[] cookies = request.getCookies();
            String ROLE = "";
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equalsIgnoreCase("ROLE")) {
                    ROLE = cookie.getValue().toString();
                }
            }
        %>
    </head>
    <body class="sub_page">
        <div class="hero_area">
            <div class="bg-box">
                <img src="img/hero-bg.jpg" alt="">
            </div>
            <header class="header_section">
                <div class="container">
                    <nav class="navbar navbar-expand-lg custom_nav-container ">
                        <a class="navbar-brand" href="${pageContext.request.contextPath}">
                            <span>
                                FoodWhale
                            </span>
                        </a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class=""> </span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav  mx-auto ">
                                <li class="nav-item active">
                                    <a class="nav-link" href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/Recipe">Recipe</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/Ingredient">Ingredient</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/About">About</a>
                                </li>
                                <%
                                    if (ROLE.equalsIgnoreCase("") || ROLE.equalsIgnoreCase("user")) {
                                    } else if (ROLE.equalsIgnoreCase("admin") || ROLE.equalsIgnoreCase("staff")) {
                                %>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/Dashboard">Dashboard</a>
                                </li>
                                <%
                                    }
                                %>
                            </ul>
                            <div class="user_option">
                                <%
                                    if (ROLE.equalsIgnoreCase("") || ROLE.equalsIgnoreCase("user") || ROLE.equalsIgnoreCase("staff")) {
                                %>
                                <a class="user_link" href="${pageContext.request.contextPath}/Profile">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </a>
                                <%
                                    if (!ROLE.equalsIgnoreCase("staff")) {
                                %>
                                <a class="cart_link" href="${pageContext.request.contextPath}/Cart">
                                    <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 456.029 456.029" style="enable-background:new 0 0 456.029 456.029;" xml:space="preserve">
                                    <g>
                                    <g>
                                    <path d="M345.6,338.862c-29.184,0-53.248,23.552-53.248,53.248c0,29.184,23.552,53.248,53.248,53.248
                                          c29.184,0,53.248-23.552,53.248-53.248C398.336,362.926,374.784,338.862,345.6,338.862z" />
                                    </g>
                                    </g>
                                    <g>
                                    <g>
                                    <path d="M439.296,84.91c-1.024,0-2.56-0.512-4.096-0.512H112.64l-5.12-34.304C104.448,27.566,84.992,10.67,61.952,10.67H20.48
                                          C9.216,10.67,0,19.886,0,31.15c0,11.264,9.216,20.48,20.48,20.48h41.472c2.56,0,4.608,2.048,5.12,4.608l31.744,216.064
                                          c4.096,27.136,27.648,47.616,55.296,47.616h212.992c26.624,0,49.664-18.944,55.296-45.056l33.28-166.4
                                          C457.728,97.71,450.56,86.958,439.296,84.91z" />
                                    </g>
                                    </g>
                                    <g>
                                    <g>
                                    <path d="M215.04,389.55c-1.024-28.16-24.576-50.688-52.736-50.688c-29.696,1.536-52.224,26.112-51.2,55.296
                                          c1.024,28.16,24.064,50.688,52.224,50.688h1.024C193.536,443.31,216.576,418.734,215.04,389.55z" />
                                    </g>
                                    </g>
                                    </svg>
                                </a>
                                <%
                                    }
                                %>
                                <%
                                    } else if (ROLE.equalsIgnoreCase("admin")) {
                                    }
                                %>
                                <%
                                    if (ROLE == null || ROLE.equalsIgnoreCase("")) {
                                %>
                                <a href="${pageContext.request.contextPath}/Login" class="order_online">
                                    Login
                                </a>
                                <%
                                } else {
                                %>
                                <a href="${pageContext.request.contextPath}/Logout" class="order_online">
                                    Logout
                                </a>
                                <%
                                    }
                                %>
                            </div>
                        </div>
                    </nav>
                </div>
            </header>
        </div>
        <section class="food_section layout_padding-bottom" style="padding-top: 90px;">
            <div class="container">
                <div class="main-body">
                    <nav aria-label="breadcrumb" class="main-breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}">FoodWhale</a></li>
                            <li class="breadcrumb-item active" aria-current="page">User Profile</li>
                        </ol>
                    </nav>
                    <div class="row gutters-sm">
                        <div class="col-md-2 mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex flex-column align-items-center text-center">
                                        <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="User" class="rounded-circle" width="150">

                                    </div>
                                </div>
                            </div>
                            <div class="mt-3 option">
                                <div class="user-option user-option--open">
                                    <div class="profile-header">
                                        <a class="profile-link">
                                            <div class="profile-img">
                                                <img src="https://cf.shopee.vn/file/ba61750a46794d8847c3f463c5e71cc4">
                                            </div>
                                            <div class="profile-text">
                                                <span class="_text">My Account</span>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="profile-body profile-body--open">
                                        <div class="profile-body-container">
                                            <a class="profile select">
                                                <span class="profile-option">Profile</span>
                                            </a>
                                            <a class="profile">
                                                <span class="profile-option">Change Password</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="user-option">
                                    <div class="profile-header">
                                        <a class="profile-link">
                                            <div class="profile-img">
                                                <img src="https://cf.shopee.vn/file/f0049e9df4e536bc3e7f140d071e9078" >
                                            </div>
                                            <div class="profile-text">
                                                <span class="_text" >Order History</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="card mt-3">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                        Activity <i class="fa fa-dashboard fa-1x"></i>
                                    </li>
                                    <li class="list-group-item text-right"><span class="pull-left"><strong>Shares</strong></span> 125</li>
                                    <li class="list-group-item text-right"><span class="pull-left"><strong>Likes</strong></span> 13</li>
                                    <li class="list-group-item text-right"><span class="pull-left"><strong>Posts</strong></span> 37</li>
                                    <li class="list-group-item text-right"><span class="pull-left"><strong>Followers</strong></span> 78</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-10">

                            <div class="card mb-3 profile-info">
                                <div class="wrap-profile-info col-md-8">
                                    <form class="card-body col-md-12">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Username</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                <input type="text" class="form__field" value="<%=u.getUsername()%>" placeholder="Your Username" readonly />
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Email</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                <input type="email" class="form__field" value="<%=u.getEmail()%>" placeholder="Your E-Mail Address" />
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Mobile</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                <input type="text" class="form__field" value="<%=u.getPhone()%>" placeholder="Your Phone Number" />
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Address</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                <input type="text" class="form__field" value="<%=u.getAddress()%>" placeholder="Your Address" />
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Gender</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                <%
                                                    String gender = u.getGender();
                                                    if (gender.equalsIgnoreCase("m")) {
                                                %>
                                                <input type="checkbox" name="gender" value="m" checked /> Male&emsp;
                                                <input type="checkbox" name="gender" value="f" /> Female&emsp;
                                                <input type="checkbox" name="gender" value="g" /> Else
                                                <%
                                                } else if (gender.equalsIgnoreCase("f")) {
                                                %>
                                                <input type="checkbox" name="gender" value="m" /> Male&emsp;
                                                <input type="checkbox" name="gender" value="f" checked /> Female&emsp;
                                                <input type="checkbox" name="gender" value="g" /> Else
                                                <%
                                                } else {
                                                %>
                                                <input type="checkbox" name="gender" value="m" /> Male&emsp;
                                                <input type="checkbox" name="gender" value="f" /> Female&emsp;
                                                <input type="checkbox" name="gender" value="g" checked /> Else
                                                <%
                                                    }
                                                %>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Date of Birth</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                <input type="date" class="form__field" value="<%=u.getDate()%>" placeholder="1979-01-01" />
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <a class="btn btn-success " target="__blank" href="https://www.bootdey.com/snippets/view/profile-edit-data-and-skills">Save</a>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="img-frame">
                                    <div class="profile-avatar">
                                        <div class="avatar-frame">
                                            <div class="avatar-img">
                                                <svg enable-background="new 0 0 15 15" viewBox="0 0 15 15" x="0" y="0" class="shopee-svg-icon _17Joz7 icon-headshot">
                                                <g>
                                                <circle cx="7.5" cy="4.5" fill="none" r="3.8" stroke-miterlimit="10"></circle>
                                                <path d="m1.5 14.2c0-3.3 2.7-6 6-6s6 2.7 6 6" fill="none" stroke-linecap="round" stroke-miterlimit="10"></path>
                                                </g>
                                                </svg>
                                            </div>
                                        </div>
                                        <input class="file-img" type="file">
                                        <button type="button" class="btnn btn--light btn--m btn--inline">Upload Image</button>
                                    </div>
                                </div>
                            </div>
                            <div class="card mb-3 change-password hidden">
                                <form>
                                    <div class="wrap-change-password">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Current Password</h6>
                                            </div>
                                            <div class="col-sm-6 text-secondary">
                                                <input type="password" class="form__field" value="<%=u.getUsername()%>" placeholder="Your Username" />
                                            </div>
                                            <button class="btn-forgot">Forgot password ?</button>
                                        </div>
                                        <div class="col-md-12 flexible hidden">
                                            <div class="error current-password">
                                                Password must be at least 6 characters
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">New Password</h6>
                                            </div>
                                            <div class="col-sm-6 text-secondary">
                                                <input type="password" class="form__field" value="<%=u.getUsername()%>" placeholder="Your Username" />
                                            </div>
                                        </div>
                                        <div class="col-md-12 flexible hidden">
                                            <div class="error new-password">
                                                Passwords must be 8-16 characters long, contain at least one uppercase and one lowercase character, and contain only regular letters, numbers, or punctuation
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Confirm Password</h6>
                                            </div>
                                            <div class="col-sm-6 text-secondary">
                                                <input type="password" class="form__field" value="<%=u.getUsername()%>" placeholder="Your Username" />
                                            </div>
                                        </div>
                                        <div class="col-md-12 flexible hidden">
                                            <div class="error retype-password">
                                                Passwords must be 8-16 characters long, contain at least one uppercase and one lowercase character, and contain only regular letters, numbers, or punctuation
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3"></div>
                                            <div class="col-sm-6">
                                                <button class="btnn btn--heavy btn--m btn--inline">Confirm</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="card mb-3 history hidden">
                                <div class="wrap-profile-info col-md-8">
                                    <table class="table " border="1">
                                        <thead>
                                            <tr>
                                                <th>Order ID</th>
                                                <th>Username</th>
                                                <th>User Address</th>
                                                <th>Date</th>
                                                <th>Total</th>
                                                <th></th>


                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (Order od : orderdetail) {%>
                                            <tr>
                                                <td><%=od.getoID()%></td>
                                                
                                                <td><%=od.getuName()%></td>
                                                <td>$<%=od.getuAddress()%></td>

                                                <td><%=od.getDate()%></td>
                                                <td><%=od.getTotal()%></td>
                                                <td>
                                                        <form action="OrderHistory" method="post">
                                                            <input type="hidden" name="oID" value="<%=od.getoID()%>">
                                                            <input class="btn-sm app-btn-secondary" name="submit" type="submit" value="View">
                                                            
                                                </form></td>
                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <footer class="footer_section">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 footer-col">
                        <div class="footer_contact">
                            <h4>
                                Contact Us
                            </h4>
                            <div class="contact_link_box">
                                <a href="">
                                    <i class="fa fa-map-marker" aria-hidden="true"></i>
                                    <span>
                                        Location
                                    </span>
                                </a>
                                <a href="">
                                    <i class="fa fa-phone" aria-hidden="true"></i>
                                    <span>
                                        Call +01 1234567890
                                    </span>
                                </a>
                                <a href="">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                    <span>
                                        demo@gmail.com
                                    </span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 footer-col">
                        <div class="footer_detail">
                            <a href="" class="footer-logo">
                                Feane
                            </a>
                            <p>
                                Necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with
                            </p>
                            <div class="footer_social">
                                <a href="">
                                    <i class="fa fa-facebook" aria-hidden="true"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-twitter" aria-hidden="true"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-linkedin" aria-hidden="true"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-instagram" aria-hidden="true"></i>
                                </a>
                                <a href="">
                                    <i class="fa fa-pinterest" aria-hidden="true"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 footer-col">
                        <h4>
                            Opening Hours
                        </h4>
                        <p>
                            Everyday
                        </p>
                        <p>
                            10.00 Am -10.00 Pm
                        </p>
                    </div>
                </div>
                <div class="footer-info">
                    <p>
                        &copy; <span id="displayYear"></span> All Rights Reserved By
                        <a href="https://html.design/">Free Html Templates</a>
                    </p>
                </div>
            </div>
        </footer>
        <script src="js/profile.js"></script>
        <script src="js/user-cart.js" type="text/javascript"></script>
    </body>
</html>
