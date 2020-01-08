<%-- 
    Document   : signup
    Created on : 3 Jan, 2020, 6:57:31 PM
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
        <table>
            <tr>
                <td>
                    <h3 style = "margin-left: 25px; border:1px solid greenyellow;width: 65px">SignUp!</h3>
                </td>
                <td>
                    <h3><a href="index.jsp" style="margin-left: 5px;border:1px solid greenyellow;width:100px;color:black">Login!</a></h3>
                </td>
            </tr>
        </table>
        
        <form method="post" action="SignUpServlet">
            <table bgcolor="lightgreen" style="margin-left:20px">
                <tr>
                    <td>
                        Username
                    </td>
                    <td>
                        <input type="text" name="username" placeholder="Username">
                    </td>
                </tr>
                <tr>
                     <td>
                        Password
                    </td>
                    <td>
                        <input type="password" name="password" placeholder="Password">
                    </td>
                </tr>
                <tr>
                    <td>
                        Re-Enter Password
                    </td>
                    <td>
                        <input type="password" name="reptPassword" placeholder="Re-Enter Password">
                    </td>
                </tr>
                <tr>
                    <td>
                        
                    </td>
                    <td>
                        <%
                String err = (String) request.getAttribute("passMatch_err");
                if(err != null)
                    out.println(err + "<br>");
            %> 
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                         <input type="submit" value="Submit">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
