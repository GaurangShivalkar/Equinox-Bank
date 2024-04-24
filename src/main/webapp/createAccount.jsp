<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Account Page</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <style>
    <%@include file ="css/login.css"%>
    
    </style>
</head>
<body class="bg-green-100">
<%@include file="navbar.jsp"%>
        <div class="min-h-screen flex justify-center items-center">
            <div class="form-container p-8 max-w-md w-full">
                <h2 class="text-3xl font-semibold text-center mb-6 heading">Create Account</h2>
                <form action="account" method="POST" class="form space-y-4">
                    <input type="hidden" name="action" value="account"/>
                    <input type="hidden" name="userId" value="<%= session.getAttribute("userId") %>"/>
 
                    <div class="mb-6">
                        <label for="accountType"class="block font-medium text-gray-600">Select the account type:</label>
                        <select class="form-select mt-1 block w-full px-3 py-2 rounded-md" name="accountType">
                            <option value="">Select</option>
                            <option value="current">Current</option>
                            <option value="saving">Saving</option>
                        </select>
                    </div>
                    
                    <div class="mb-6">
                        <label for="balance" class="block font-medium text-gray-600">Enter the starting balance:</label>
                        <input type="number" class="mt-1 block w-full px-3 py-2 rounded-md" name="balance">
                    </div>
                     
                    
                    <div class="flex items-center justify-center">
                        <button class="w-full py-2 px-4 rounded-md hover:bg-green-600 focus:outline-none focus:ring-2 focus:ring-green-500 focus:ring-offset-2 focus:ring-offset-gray-100">
                        	Setup Account
                        </button>
                    </div>
                </form>
            </div>
        </div>
</body>
</html>
