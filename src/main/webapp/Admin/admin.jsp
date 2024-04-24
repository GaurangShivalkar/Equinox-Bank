<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="Model.*" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Page</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <style>
        <%@include file="admin.css"%>
    </style>
</head>

<body class="bg-gray-100">

    <div class="flex">
        <!-- Vertical Navbar -->
        <%@include file="adminNavbar.jsp"%>

        <!-- Main Content -->
        <div class="w-4/5 p-8">
            <!-- Dashboard Cards -->
            <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-4">
                <!-- Total Bank Amount Card -->
                <div class="bg-green-200 p-6 rounded-xl shadow-md">
                    <h3 class="text-lg font-semibold text-green-900 mb-2">Total Bank Amount</h3>
                    <p class="text-xl font-bold text-green-900">11</p>
                    <!-- Replace with actual value -->
                </div>

                <!-- Total Transactions Card -->
                <div class="bg-green-300 p-6 rounded-xl shadow-md">
                    <h3 class="text-lg font-semibold text-green-900 mb-2">Total Transactions</h3>
                    <p class="text-xl font-bold text-green-900"><%=session.getAttribute("totalTransactions")%></p>
                    <!-- Replace with actual value -->
                </div>

                <!-- Total Accounts Card -->
                <div class="bg-green-400 p-6 rounded-xl shadow-md">
                    <h3 class="text-lg font-semibold text-green-900 mb-2">Total Accounts</h3>
                    <p class="text-xl font-bold text-green-900"><%=session.getAttribute("totalAccounts")%></p>
                    <!-- Replace with actual value -->
                </div>

                <!-- Total Users Card -->
                <div class="bg-green-500 p-6 rounded-xl shadow-md">
                    <h3 class="text-lg font-semibold text-green-900 mb-2">Total Users</h3>
                    <p class="text-xl font-bold text-green-900"><%=session.getAttribute("totalUsers")%></p>
                    <!-- Replace with actual value -->
                </div>
                
                <!-- Additional Cards (you can add more as needed) -->
                <!-- Card 1 -->
                <div class="bg-green-300 p-6 rounded-xl shadow-md">
                    <h3 class="text-lg font-semibold text-green-900 mb-2">New Transactions Today</h3>
                    <p class="text-xl font-bold text-green-900">25</p>
                    <!-- Replace with actual value -->
                </div>
                
                <!-- Card 2 -->
                <div class="bg-green-400 p-6 rounded-xl shadow-md">
                    <h3 class="text-lg font-semibold text-green-900 mb-2">Pending Accounts</h3>
                    <p class="text-xl font-bold text-green-900">8</p>
                    <!-- Replace with actual value -->
                </div>

                <!-- Graph Card -->
   
                <div class="bg-green-200 p-6 rounded-xl shadow-md">
                    <h3 class="text-lg font-semibold text-green-900 mb-2">Transaction Overview</h3>
                    <!-- Bar Graph -->
                    
                </div>
    
            </div><br>
                                     <div class="bg-white p-4 rounded-lg shadow-md">
                        <canvas id="transactionChart" ></canvas>
                    </div>
        </div>
    </div>

    <!-- Chart.js Library -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <!-- Script for Bar Graph -->
    <script>
        var ctx = document.getElementById('transactionChart').getContext('2d');
        var transactionChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ['January', 'February', 'March', 'April', 'May', 'June'],
                datasets: [{
                    label: 'Number of Transactions',
                    data: [12, 19, 3, 5, 2, 3],
                    backgroundColor: '#10B981', // Primary Color
                    borderColor: '#10B981', // Primary Color
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    </script>

</body>

</html>
