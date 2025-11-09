<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            text-align: center;
            background-image: url('images/bank-icon-27.jpg');
            background-size: cover;
        }
        form {
            width: 300px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        input[type="text"],
        input[type="password"],
        button {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Login Page</h1>
    <form action="userCheck" method="post" onsubmit="return validateForm()">
        <label for="username">Username</label>
        <input id="username" type="text" name="username" required>
        <br>
        <label for="password">Password</label>
        <input id="password" type="password" name="password" required>
        <br>
        <button type="submit">Login</button>
    </form>
    
    <script>
        function validateForm() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            if (username === "" || password === "") {
                alert("Username and password are required");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>
