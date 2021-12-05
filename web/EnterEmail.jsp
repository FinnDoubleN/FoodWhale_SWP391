<%-- 
    Document   : EnterEmail
    Created on : 05-12-2021, 07:41:11
    Author     : This PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter username</title>
    </head>
    <body>
        <form method="POST" action="preResetPassword">
            <input type="text" name="email" value="" placeholder="ENTER YOUR USERNAME"/>
            <p>${mess}</p>
            <button type="submit">Send</button>
        </form>
    </body>
</html>
