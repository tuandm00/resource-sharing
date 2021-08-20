<%-- 
    Document   : register
    Created on : May 24, 2021, 4:09:16 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <h2>Register Account</h2>
    <body>
        <form action="RegisterController" method="post">
            <table>
            <thead>
                <tr>
                    User ID<input type="text" name="userID"/><br/>
                    Password<input type="password" name="password"/><br/>
                    Name<input type="text" name="name"/><br/>
                    Phone<input type="text" name="phone"/><br/> 
                    Address<input type="text" name="address"/><br/>
                    Email<input type="text" name="email"/><br/>
                    <h2 style="color: red">${err}</h2>
                    <input type="submit" name="action" value="Register"/><br/>
                </tr>
            </thead>
        </table>
        </form>
        
    </body>
</html>
