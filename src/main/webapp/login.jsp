<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <!-- Tailwind CSS -->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <style><%@include file="css/login.css"%></style>
</head>

<body class="bg-green-100 flex justify-center items-center h-screen">
    <div class="form-container p-8 max-w-md w-full">
        <h2 class="text-3xl font-semibold text-center mb-6 heading">Welcome Back!</h2>
        <form action="login" method="POST" class="form space-y-4">
            <div>
                <label for="email" class="block font-medium text-gray-600">Email address</label>
                <input type="email" id="email" name="email" placeholder="Enter your email" class="mt-1 block w-full px-3 py-2 rounded-md">
            </div>
            <div>
                <label for="password" class="block font-medium text-gray-600">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" class="mt-1 block w-full px-3 py-2 rounded-md">
            </div>
            <input type="hidden" name="action" value="login"/>
            <div>
                <button type="submit" class="w-full py-2 px-4 rounded-md hover:bg-green-600 focus:outline-none focus:ring-2 focus:ring-green-500 focus:ring-offset-2 focus:ring-offset-gray-100">Login</button>
            </div>
        </form>
        <div class="text-center">
            <p class="text-gray-600">Don't have an account? <a href="http://localhost:8080/BankingSystem/registration.jsp" class="font-medium link hover:text-green-500">Sign Up</a></p>
        </div>
    </div>
    <!-- Optional: Add an image -->
    <div class="absolute bottom-0 text-center w-full pb-8">
        <img src="banking_logo.png" alt="Banking Logo" class="mx-auto w-24">
    </div>
</body>

</html>
