<%@page import="AccountDTO.BankAccountDTO"%>
<%@page import="AccountDAO.BankAccountDAOImpl"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Accounts</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #dddddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .action-buttons {
            display: flex;
            justify-content: flex-start;
        }
        .action-buttons form {
            margin-right: 10px;
        }
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
        .total-row {
            font-weight: bold;
        }
        .dob-column {
            width: 150px; /* Increase the width of the DOB column */
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
    <h1>List of Accounts</h1>
    <table>
        <tr>
            <th>Account Number</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Date of Birth</th>
            <th>Created Date</th>
            <th>Actions</th>
        </tr>
        <% 
            BankAccountDAOImpl bankAccountDAOImpl = new BankAccountDAOImpl();
            List<BankAccountDTO> accountHolders = bankAccountDAOImpl.getAllAccountHolders();
            double total = 0.0;
            if (accountHolders != null && !accountHolders.isEmpty()) {
                for (BankAccountDTO accountHolder : accountHolders) {
                    total += accountHolder.getAccountNumber(); // Assuming account number is a numeric value
        %>
        <tr>
            <td><%= accountHolder.getAccountNumber() %></td>
            <td><%= accountHolder.getFullName() %></td>
            <td><%= accountHolder.getEmail() %></td>
            <td class="dob-column"><%= accountHolder.getDob() %></td>
            <td class="dob-column"><%= accountHolder.getCreatedDate() %></td>
            <td class="action-buttons">
                <form action="editAccountHolder" method="post">
                    <input type="hidden" name="accountNumber" value="<%= accountHolder.getAccountNumber() %>" />
                    <button type="submit">Edit</button>
                </form>
                <form action="deleteAccountUser" method="post" onsubmit="return confirm('Are you sure you want to delete this account?');">
                    <input type="hidden" name="accountNumber" value="<%= accountHolder.getAccountNumber() %>" />
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
        <% 
                }
            } else {
        %>
        <tr>
            <td colspan="6">No account holders found.</td>
        </tr>
        <% 
            }
        %>
        
    </table>
    <div>
        <button class="styled-button" onclick="redirectToHome()">Back</button>
    </div>
</div>
<script>
    function redirectToHome() {
        window.location.href = "HomePageBank.jsp"; // Replace "home.jsp" with the actual URL of your home page
    }
</script>
</body>
</html>
