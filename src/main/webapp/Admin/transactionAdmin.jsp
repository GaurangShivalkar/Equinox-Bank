<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="Model.Transaction" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Transaction Admin Page</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <style>
        /* Include any additional custom styles here */
        <%@include file="admin.css"%>
    </style>
</head>
<body class="bg-gray-100">
    <%@include file="adminNavbar.jsp"%>
    <!-- Transactions Table -->
    <div id="transactions-table" class="container mx-auto px-4 py-8">
        <h1 class="text-2xl font-semibold mb-4">Transaction List</h1>
        <div class="-mx-4">
            <table class="w-full bg-white shadow-lg rounded-lg overflow-hidden">
                <thead class="bg-green-400 text-white">
                    <tr>
                        <th class="px-4 py-2">Transaction ID</th>
                        <th class="px-4 py-2">Transaction Type</th>
                        <th class="px-4 py-2">Amount</th>
                        <th class="px-4 py-2">User ID</th>
                        <th class="px-4 py-2">Description</th>
                        <th class="px-4 py-2">Source Account</th>
                        <th class="px-4 py-2">Destination Account</th>
                        <th class="px-4 py-2">Timestamp</th>
                        <th class="px-4 py-2">New Balance</th>
                    </tr>
                </thead>
                <tbody class="divide-y divide-gray-200">
                    <%
                    List<Transaction> transactionListAdmin = (List<Transaction>) session.getAttribute("transactionListAdmin");
                    if (transactionListAdmin != null) {
                        for (Transaction transaction : transactionListAdmin) {
                    %>
                    <tr>
                        <td class="px-4 py-2 text-center"><%=transaction.getTransactionId()%></td>
                        <td class="px-4 py-2 text-center"><%=transaction.getTransactionType()%></td>
                        <td class="px-4 py-2 text-center"><%=transaction.getAmount()%></td>
                        <td class="px-4 py-2 text-center"><%=transaction.getUserId()%></td>
                        <td class="px-4 py-2 text-center"><%=transaction.getDescription()%></td>
                        <td class="px-4 py-2 text-center"><%=transaction.getSourceAccountId()%></td>
                        <td class="px-4 py-2 text-center"><%=transaction.getDestinationAccountId()%></td>
                        <td class="px-4 py-2 text-center"><%=transaction.getTimeStamp()%></td>
                        <td class="px-4 py-2 text-center"><%=transaction.getChangedBalance()%></td>
                    </tr>
                    <%
                        }
                    }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
