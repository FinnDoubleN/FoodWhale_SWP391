<%-- 
    Document   : Register
    Created on : 30-11-2021, 13:10:24
    Author     : This PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- Site Metas -->
        <title>Register Page</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/fevicon.ico.png" type="image/x-icon" />
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Site CSS -->
        <link rel="stylesheet" href="style.css">
        <!-- Colors CSS -->
        <link rel="stylesheet" href="css/colors.css">
        <!-- ALL VERSION CSS -->
        <link rel="stylesheet" href="css/versions.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">
        <!-- Modernizer for Portfolio -->
        <script src="js/modernizer.js"></script>

        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="./img/logo_web.png" type="image/x-icon">
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./css/service.css">
        <!-- [if lt IE 9] -->

        <link rel="stylesheet" href="./css/register.css">      
    </head>
    <body>
        


       

        <div class="main-w3layouts wrapper" >
            <h1>Register Form</h1>
            <div class="main-agileinfo">
                <div class="agileits-top">
                    <form action="register" method="post">
                        <p class="text-danger">${mess1}</p>
                        <p class="text-danger">${mess2}</p>
                        
                        <input class="text" type="text" name="username" placeholder="Username" required="">
                        <input id="pass" class="text" type="password" name="password" minlength="8" placeholder="Password" required="">
                        <img onclick="myFunction1()" src="img/eye2.jpg" width="30" height="30">
                        <input id="pass1"  type="password" name="confirm" minlength="8" placeholder="Confirm Password" required="">
                        <img onclick="myFunction2()" src="img/eye2.jpg" width="30" height="30">
                        <div class="enter">
                            <h2 style="color: white">Gender :</h2>
                            <div style="color: white" class="p-t-10">
                                <label class="radio-container m-r-45">Male
                                    <input type="radio" name="gender" value="1">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">Female
                                    <input type="radio" name="gender" value="0">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
                        <input class="text " type="email" name="email" placeholder="Email" required="">
                        <input class="text" type="text" name="phonenumber" placeholder="Phone Number" required="">
                        <h2 style="color: white">Date of birth :</h2>
                        <input class="text" type="date" name="age" placeholder="Date of birth" required="">
                        <input class="text" type="text" name="image" placeholder="Image" required="">
                        <input class="text" type="text" name="address" placeholder="Address" required="">
                        <div class="wthree-text">
                            <label class="anim">
                                <input type="checkbox" class="checkbox" required="">
                                <span>I Agree To The Terms & Conditions</span>
                            </label>
                            <div class="clear"> </div>
                        </div>
                        
                        <input type="submit" value="SIGN UP">
                        <a href="login" style="color:white">ALREADY HAVE AN ACCOUNT? SIGN IN</a>
                    </form>
                </div>
            </div>
        </div>
                        

        
        <a href="#home" data-scroll class="dmtop global-radius"><i class="fa fa-angle-up"></i></a>
        <!-- all js files -->
        <script src="js/all.js"></script>
        <!-- all plugins -->
        <script src="js/custom.js"></script>
        <!-- map -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCNUPWkb4Cjd7Wxo-T4uoUldFjoiUA1fJc&callback=myMap"></script>

        <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
        <script src="https://unpkg.com/scrollreveal"></script>
        <script src="./js/main.js"></script>

        <script type="text/javascript">
                            var x = true;
                            function myFunction1() {
                                if (x) {
                                    document.getElementById('pass').type = "text";
                                    x = false;
                                } else {
                                    document.getElementById('pass').type = "password";
                                    x = true;
                                }
                            }
        </script>
        <script type="text/javascript">
            var x = true;
            function myFunction2() {
                if (x) {
                    document.getElementById('pass1').type = "text";
                    x = false;
                } else {
                    document.getElementById('pass1').type = "password";
                    x = true;
                }
            }
        </script>
    </body>
</html>
