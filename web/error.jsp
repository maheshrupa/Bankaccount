<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        .container {
            margin-top: 50px;
        }
        h1 {
            color: #333;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
        <%
        if(session.getAttribute("username")==null){
            response.sendRedirect("login.jsp");
        }
        
        %>
    <div class="container">
        <h1>Invalid User</h1>
        <a href="login.jsp">Back To LogIn Page</a>
    </div>
</body>
</html>
