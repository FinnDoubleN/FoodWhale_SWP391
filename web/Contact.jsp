<%-- 
    Document   : Contact
    Created on : Dec 14, 2021, 9:38:57 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact</title>
        <link href="css/contact.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container">  
            <form id="contact" action="Contact" method="post">
                <h3>Quick Contact</h3>
                <h4>Contact us today, and get reply with in 24 hours!</h4>
                <fieldset>
                    <input placeholder="Enter your name" name="name" type="text" tabindex="1" required autofocus>
                </fieldset>
                <fieldset>
                    <input placeholder="Enter your Email" name="email" type="email" tabindex="2" required>
                </fieldset>
                <fieldset>
                    <textarea placeholder="Type your Message Here...." name="massage" tabindex="5" required></textarea>
                </fieldset>
                <fieldset>
                    <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
                </fieldset>
            </form>


        </div>
    </body>
</html>
