<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Home Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
        }
        nav {
            background-color: #007bff;
            color: white;
            text-align: center;
            padding: 10px 0;
        }
        nav a {
            color: white;
            text-decoration: none;
            margin: 0 10px;
        }
        .container {
            margin: 20px auto;
            padding: 20px;
            max-width: 800px;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        form {
            margin-bottom: 20px;
        }
        input[type="text"], input[type="password"], select {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
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
    <header>
            <h1>Welcome To The <%= session.getAttribute("username") %></h1>
    </header>
    <nav>
        <a href="">Home</a>
        <a href="AccountHolderCreatePage.jsp">Create Account Holder</a>
        <a href="listOfEmployees.jsp">list of Account holders</a>
        <a href="UserLogOut?action=logout" action="logout">Logout</a>
        <a href="UserLogOut?action=premium" action="Premium">Premium Screen</a>
        
    </nav>
</body>
</html>
