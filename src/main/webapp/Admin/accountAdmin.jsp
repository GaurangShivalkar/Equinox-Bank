<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="Model.Account" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admin Account Page</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <style>
        /* Include any additional custom styles here */
        <%@include file="admin.css"%>
    </style>
</head>
<body class="bg-gray-100">
    <!-- Account Table -->
    <%@include file="adminNavbar.jsp"%>
    <div id="accounts-table" class="container mx-auto px-4 py-8">
        <h1 class="text-2xl font-semibold mb-4">Account List</h1>
        <div class="-mx-4">
            <table class="w-full bg-white shadow-lg rounded-lg overflow-hidden">
                <thead class="bg-green-400 text-white">
                    <tr>
                        <th class="px-4 py-2 text-center">Account ID</th>
                        <th class="px-4 py-2 text-center">User ID</th>
                        <th class="px-4 py-2 text-center">Account Number</th>
                        <th class="px-4 py-2 text-center">Account Type</th>
                        <th class="px-4 py-2 text-center">Balance</th>
                        <th class="px-4 py-2 text-center">Action</th>
                    </tr>
                </thead>
                <tbody class="divide-y divide-gray-200">
                    <%
                    List<Account> accountListAdmin = (List<Account>) session.getAttribute("accountListAdmin");
                    if (accountListAdmin != null) {
                        for (Account account : accountListAdmin) {
                    %>
                    <tr>
                        <td class="px-4 py-2 text-center"><%=account.getAccountId()%></td>
                        <td class="px-4 py-2 text-center"><%=account.getUserId()%></td>
                        <td class="px-4 py-2 text-center"><%=account.getAccountNumber()%></td>
                        <td class="px-4 py-2 text-center"><%=account.getAccountType()%></td>
                        <td class="px-4 py-2 text-center"><%=account.getBalance()%></td>
                        <td class="px-4 py-2 text-center">
                            <form action="deleteAccount" method="POST">
                                <input type="hidden" name="action" value="deleteAccount" />
                                <input type="hidden" name="delAccountNo" value="<%=account.getAccountNumber()%>">
                                <button type="submit" id="deleteButton"
                                    class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded-full">Delete
                                    Account</button>
                            </form>
                        </td>
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
