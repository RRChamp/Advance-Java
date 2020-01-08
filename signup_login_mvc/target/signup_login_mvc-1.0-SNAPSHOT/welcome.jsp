<%-- 
    Document   : welcome
    Created on : 3 Jan, 2020, 12:57:52 PM
    Author     : KHATRI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><h1>Welcome!
            <% out.println(request.getParameter("username"));%></h1>
        </p>
    </body>
</html>
