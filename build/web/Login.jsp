<%-- 
    Document   : Login
    Created on : 30-11-2021, 13:13:03
    Author     : This PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="images/fevicon.ico.png" type="image/x-icon" />
        <link rel="stylesheet" href="./css/service.css">
        <style>
            .contain {
                height: 100vh;
                width: 100vw;
                background-image: url("img/backgroundlogin.jpg"), linear-gradient(rgba(255, 255, 255, 0.5),
                    rgba(255, 255, 255, 0.5));

                background-size: cover;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .wrapper {
                padding: 25px;
                width: 40%;
                background-color: rgba(255, 255, 255, 0.8);

            }

            form {
                display: flex;
                flex-direction: column;
            }

            h1 {
                font-size: 24px;
                font-weight: 300;
                text-align: center;
            }

            input {
                flex: 1;
                min-width: 40%;
                margin: 10px 0px;
                padding: 10px;
            }

            button {
                width: 100%;
                border: none;
                padding: 15px 20px;
                background-color: teal;
                color: white;
                cursor: pointer;
                font-weight: 700;
                margin-bottom: 10px;
            }

            a {
                margin: 5px 0px;
                font-size: 12px;
                text-decoration: underline;
                cursor: pointer;
            }
            @media (max-width :1023px){ 
                .wrapper {
                    width: 100% !important;
                }
            }
        </style>
        <title>Login Page</title>
    </head>
    <body>
        <div class="contain">
            <div class="wrapper">
                <form action="login" method="post">
                    <h1>LOGIN</h1>
                    <p class="text-danger">${mess}</p>
                    <input placeholder="USERNAME" type="text" name="adUser"/>
                    <input id="pass" placeholder="PASSWORD" type="password" name="adPass" minlength="8"/>
                    <img onclick="myFunction()" src="img/eye2.jpg" width="30" height="30">
                    <button>LOGIN</button>
                    <a href="register">CREATE A NEW ACCOUNT</a>
                    <a href="preResetPassword">FORGET PASSWORD?</a>
                </form>
            </div>
        </div>

        <script type="text/javascript">
            var x = true;
            function myFunction() {
                if (x) {
                    document.getElementById('pass').type = "text";
                    x = false;
                } else {
                    document.getElementById('pass').type = "password";
                    x = true;
                }
            }
        </script>
    </body>
</html>
