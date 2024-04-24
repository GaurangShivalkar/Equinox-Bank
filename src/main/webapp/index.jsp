<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Banking System</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
          integrity="sha512-oX56/JzRjxNXXrZjOjVvePrb3Gmm9C5z+Sm3okGs/ju/5ABMHhyV3mXmPtb9wL8N3v2JjvhGZpHNa5/Zbq+Gcg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">

<%@include file="navbar.jsp"%>

<div class="section-container">
    <section class="hero-section text-center py-5 bg-gradient-to-r from-blue-300 to-blue-600 text-white">
        <div class="container mx-auto">
            <h1 class="mb-4 text-4xl font-bold">Welcome to Our Online Banking System</h1>
            <p class="mb-4 text-lg">Manage your finances securely and conveniently.</p>
            <a href="#" class="btn btn-primary learn-more-btn bg-blue-700 hover:bg-blue-800 px-6 py-3 rounded-full font-semibold">Learn More</a>
        </div>
    </section>

    <!-- Section 2 -->
    <section class="py-5">
        <div class="container mx-auto">
            <h2 class="text-2xl font-semibold mb-4">Secure Transactions</h2>
            <p class="mb-4">Our online banking system ensures that all your transactions are secure. We use the latest encryption technologies to protect your financial information.</p>
            <p>With our secure platform, you can transfer funds, pay bills, and manage your accounts with confidence.</p>
        </div>
    </section>

    <!-- Section 3 -->
    <section class="py-5 bg-gray-100">
        <div class="container mx-auto">
            <h2 class="text-2xl font-semibold mb-4">24/7 Access</h2>
            <p class="mb-4">Enjoy 24/7 access to your accounts from anywhere in the world. Whether you're at home, at work, or on the go, our online banking system is always available.</p>
            <p>Check your account balances, view transaction history, and make payments whenever it's convenient for you.</p>
        </div>
    </section>

    <!-- Section 4 -->
    <section class="py-5">
        <div class="container mx-auto">
            <h2 class="text-2xl font-semibold mb-4">Personalized Services</h2>
            <p class="mb-4">Experience personalized banking services tailored to your needs. Our team of experts is here to assist you with any inquiries or assistance you may require.</p>
            <p>From setting up automatic payments to applying for loans, we're dedicated to providing you with exceptional service every step of the way.</p>
        </div>
    </section>
</div>

<footer class="footer text-center py-4 bg-gray-900 text-white">
    <p>&copy; 2024 Online Banking System. All rights reserved.</p>
</footer>

</body>
</html>
