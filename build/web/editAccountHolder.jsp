<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Account Holder</title>
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
    input[type="text"], input[type="email"], input[type="tel"], input[type="date"] {
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
    <h1>Edit Account Holder</h1>
    <c:choose>
        <c:when test="${not empty bankAccountHolder}">
            <form action="updateAccountHolder" method="post" onsubmit="return validateForm()">
                <input type="hidden" id="accountId" name="accountId" value="${bankAccountHolder.accountNumber}">
                
                <label for="fullName">Full Name:</label>
                <input type="text" id="fullName" name="fullName" value="${bankAccountHolder.fullName}" required>

                <label for="email">Email Address:</label>
                <input type="email" id="email" name="email" value="${bankAccountHolder.email}" required>

                <label for="phone">Phone Number:</label>
                <input type="tel" id="phone" name="phone" value="${bankAccountHolder.phone}" required>

                <label for="dob">Date of Birth:</label>
                <input type="date" id="dob" name="dob" value="${bankAccountHolder.dob}" required>

                <input type="submit" value="Update Account">

                <button type="button" class="styled-button" onclick="redirectToHome()">Back</button>
            </form>
        </c:when>
        <c:otherwise>
            <p>No account information found. Please try again.</p>
        </c:otherwise>
    </c:choose>
</div>
<script>
    function validateForm() {
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
        window.location.href = "HomePageBank.jsp"; // Replace with your actual home page URL
    }
</script>
</body>
</html>
