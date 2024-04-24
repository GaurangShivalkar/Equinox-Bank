<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="Model.Account"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Page</title>
<!-- Tailwind CSS -->
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body class="bg-green-50">
<%@include file="navbar.jsp"%>
<div class="flex justify-center">
    <div class="container mt-5">
        <h2 class="text-2xl font-semibold text-gray-800">Account List</h2>
        <div class="mt-4">
            <table class="min-w-full divide-y divide-gray-200">
                <thead class="bg-gray-50">
                    <tr>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Account Type</th>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Account Number</th>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Balance</th>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Action</th>
                    </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                    <%
                        List<Account> accountList = (List<Account>) session.getAttribute("accountList");
                        if (accountList != null) {
                            for (Account account : accountList) {
                    %>
                    <tr>
                        <td class="px-6 py-4 whitespace-nowrap"><%=account.getAccountType()%> A/c</td>
                        <td class="px-6 py-4 whitespace-nowrap"><%=account.getAccountNumber()%></td>
                        <td class="px-6 py-4 whitespace-nowrap"><%=account.getBalance()%></td>
                        <td class="px-6 py-4 whitespace-nowrap">
                            <form action="SessionsServlet" method="GET">
                                <input type="hidden" name="accountNumber" value="<%=account.getAccountNumber()%>">
                                <button type="submit" class="inline-flex items-center px-4 py-2 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-green-600 hover:bg-green-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-green-500">View Transaction</button>
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
        <hr class="my-8">
        <h2 class="text-2xl font-semibold text-gray-800">Delete Account</h2>
        <form action="deleteAccount" method="POST">
            <div class="mt-4">
                <input type="hidden" name="action" value="deleteAccount"/>
                <label for="delAccountNo" class="block text-sm font-medium text-gray-700">Enter Account Number to Delete:</label>
                <input type="text" id="delAccountNo" name="delAccountNo" required class="mt-1 focus:ring-green-500 focus:border-green-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
            </div>
            <div class="mt-4">
                <button type="submit" id="deleteButton" class="inline-flex items-center px-4 py-2 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-red-600 hover:bg-red-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-red-500">Delete Account</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
