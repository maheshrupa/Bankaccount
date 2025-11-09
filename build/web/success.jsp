<%-- 
    Document   : success
    Created on : 9 Apr, 2024, 4:51:55 PM
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
        <h1>success fully created bank account</h1>
        <a href="HomePageBank.jsp">Back to Home page</a>
        
    </body>
</html>
