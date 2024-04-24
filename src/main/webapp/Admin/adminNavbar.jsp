<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">

    <style>
        <%@include file="admin.css"%>
    </style>
<style>
    /* Custom styles */
    /* Navbar */
    .navbar {
        background-color: #10B981; /* Primary Color */
        position: fixed;
        top: 0;
        left: 0;
        bottom: 0;
        width: 200px;
       
        z-index: 999; /* Ensures it's above other content */
    }

    .nav-link {
        color: #D1FAE5; /* Accent Color */
    }

    .nav-link:hover {
        color: #A7F3D0; /* Tertiary Color */
    }

    /* Adjust body padding to avoid content being hidden behind fixed navbar */
    body {
        padding-left: 200px; /* Adjust as per navbar width */
        margin: 0; /* Remove default margin */
    }

    /* Logout button style */
    .logout-btn {
        color: #FFFFFF; /* Text color */
        background-color: #10B981; /* Button background color */
        border: none; /* Remove border */
        padding: 12px 24px; /* Padding */
        font-size: 16px; /* Font size */
        cursor: pointer; /* Cursor on hover */
        width: calc(100% - 32px); /* Full width minus padding */
        margin: 16px; /* Margin */
    }

    .logout-btn:hover {
        background-color: #065F46; /* Button background color on hover */
    }

    /* Adjust position of logout button */
    .logout-btn-container {
        position: absolute;
        bottom: 16px;
        left: 16px;
        width: calc(100% - 32px); /* Full width minus padding */
    }
</style>
</head>
<body>
<nav class="bg-green-400 h-screen p-4 navbar">
    <div class="text-white text-lg font-bold mb-5">Admin Panel</div>
    <ul>
        <li><a href="Admin/accountAdmin.jsp" class="block text-white py-2 px-4 nav-link">Accounts</a></li>
        <li><a href="Admin/userAdmin.jsp" class="block text-white py-2 px-4 nav-link">Users</a></li>
        <li><a href="Admin/transactionAdmin.jsp" class="block text-white py-2 px-4 nav-link">Transactions</a></li>
    </ul>
    <div class="logout-btn-container">
        <form action="logout" method="POST">
            <button type="submit" class="logout-btn">Logout</button>
        </form>
    </div>
</nav>

<!-- Add additional content here -->

</body>
</html>
