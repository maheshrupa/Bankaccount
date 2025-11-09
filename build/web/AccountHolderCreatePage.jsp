<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bank Account Application</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .container {
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }
    input[type="text"], input[type="email"], input[type="tel"], input[type="password"], input[type="date"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
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
    .styled-button {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .styled-button:hover {
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
<div class="container">
    <h1>Bank Account Application</h1>
    <form action="accountHolderCreatePage" method="post" onsubmit="return validateForm()">
        <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" required>

        <label for="email">Email Address:</label>
        <input type="email" id="email" name="email" required>

        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" name="phone" required>

        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>

        <!-- Hidden input field for created date -->
        <input type="hidden" id="createdDate" name="createdDate" value="<%=java.time.LocalDate.now()%>">

        <input type="submit" value="Submit Application">

        <button class="styled-button" onclick="redirectToHome()">Back</button>
    </form>
</div>
<script>
    function validateForm() {
        var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("confirmPassword").value;
        if (password !== confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        
        var dob = new Date(document.getElementById("dob").value);
        var currentDate = new Date();
        var fiveYearsAgo = new Date();
        fiveYearsAgo.setFullYear(currentDate.getFullYear() - 5);
        
        if (dob > currentDate) {
            alert("Date of birth cannot be a future date.");
            return false;
        }
        if (dob > fiveYearsAgo) {
            alert("Date of birth should be at least five years ago.");
            return false;
        }
        
        return true;
    }
            function redirectToHome() {
            window.location.href = "HomePageBank.jsp"; // Replace "home.jsp" with the actual URL of your home page
        }
</script>
</body>
</html>
