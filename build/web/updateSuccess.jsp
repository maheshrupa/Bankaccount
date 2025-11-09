<%-- 
    Document   : updateSuccess
    Created on : 25 Jun, 2024, 11:57:53 PM
    Author     : mahes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
                    button {
            padding: 5px 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        </style>
    </head>
    <body>
        <%

        if(session.getAttribute("username")==null){
            response.sendRedirect("login.jsp");
        }
        
        %>
        <h1>Hello World!</h1>
        <h2>employee details updated successfully thank you</h2>
        <button onclick="redirectToHome()">Back To Home</button>
        <script>
    function redirectToHome() {
        window.location.href = "HomePageBank.jsp"; // Replace "home.jsp" with the actual URL of your home page
    }
</script>
    </body>
</html>
