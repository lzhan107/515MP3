<%-- 
    Document   : login
    Created on : Nov 3, 2013, 9:00:59 PM
    Author     : Lei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
        <h1>Login page</h1>
        <form method="post" action="j_security_check">
                <div>
                    <label for="j_username">Username:</label>
                    <input type="text" name="j_username" />
                </div>
                <div>
                    <label for="j_password">Password:</label>
                    <input type="password" name="j_password" />
                </div>
                <input type="submit" value="Submit"/>
                <input type="reset" value="Reset"/>
        </form>
        
    </body>
</html>
