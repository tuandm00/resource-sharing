<%-- 
    Document   : captcha
    Created on : May 25, 2021, 9:29:16 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="CaptchaController" method="POST">
            <h1>Input your captcha</h1>
        <input type="hidden" name="userID" value="${LOGIN_USER.userID}"/>
        <input type="submit" name="action" value="Continue"/>
        
        <input type="text" name="captcha"/>
        <h2 style="color: red">${error}</h2>
        
        </form>
        
    </body>
</html>
