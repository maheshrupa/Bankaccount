<%@page import="InstallmentDAO.InstallmentDAOImp"%>
<%@page import="InstallmentDTO.InstallmentDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Installment Premium Screen</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #e0f7fa; /* Light cyan background for the body */
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: white;
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
    </style>
</head>
<body>
<div class="container">
    <h1>Installment Premium Screen</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>User ID</th>
            <th>Gross Premium</th>
            <th>Commission %</th>
            <th>Commission Amount</th>
            <th>Net Premium</th>
            <th>Final Amount</th>
            <th>Tax</th>
            <th>Actions</th>
        </tr>
        <%
            // Use InstallmentDAOImpl class to fetch installment data
            InstallmentDAOImp InstallmentDAOImp = new InstallmentDAOImp();
            List<InstallmentDTO> installments = InstallmentDAOImp.getAllInstallments(); // Fetch all installment records
            double totalGrossPremium = 0.0;
            
            if (installments != null && !installments.isEmpty()) {
                for (InstallmentDTO installment : installments) {
                    totalGrossPremium += installment.getGrossPremium(); // Summing gross premiums
        %>
        <tr>
            <td><%= installment.getInstallmentId() %></td>
            <td><%= installment.getUserId() %></td>
            <td><%= installment.getGrossPremium() %></td>
            <td><%= installment.getCommissionPercentage() %></td>
            <td><%= installment.getCommissionAmount() %></td>
            <td><%= installment.getNetPremium() %></td>
            <td><%= installment.getFinalAmount() %></td>
            <td><%= installment.getTax() %></td>
            <td class="action-buttons">
                <!-- Edit form -->
                <form action="EditInstallment" method="post">
                    <input type="hidden"  id="<%= installment.getUserId()%>" name="installmentId" value="<%= installment.getInstallmentId() %>" />
                    <button type="submit">Edit</button>
                </form>
                <!-- Delete form with confirmation -->
                <form action="deleteInstallment" method="post" onsubmit="return confirm('Are you sure you want to delete this installment?');">
                    <input type="hidden" id="<%= installment.getUserId() %>" name="installmentId" value="<%= installment.getInstallmentId() %>" />
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="9">No installments found.</td>
        </tr>
        <% 
            }
        %>
    </table>
    <div class="summary">
        <p>Total Gross Premium: <%= totalGrossPremium %></p> <!-- Display total gross premium -->
    </div>
    <div>
        <button class="styled-button" onclick="redirectToHome()">Back</button>
    </div>
</div>

<script>
    function redirectToHome() {
        window.location.href = "HomePageBank.jsp"; // Replace with your actual home page URL
    }
</script>
</body>
</html>
