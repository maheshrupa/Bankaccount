<%-- 
    Document   : deleteSuccess
    Created on : 1 Jun, 2024, 5:02:33 PM
    Author     : mahes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <%

        if(session.getAttribute("username")==null){
            response.sendRedirect("login.jsp");
        }
        
        %>
        <h1>The Account holder is deleted success fully thank you</h1>
        <a href="listOfEmployees.jsp"> Click To List Of Account Holders </a>
    </body>
</html>
