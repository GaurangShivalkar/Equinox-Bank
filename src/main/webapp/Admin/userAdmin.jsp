<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="Model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Admin Page</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <style>
        /* Include any additional custom styles here */
        <%@include file="admin.css"%>
    </style>
</head>
<body class="bg-gray-100">
    <%@include file="adminNavbar.jsp"%>
    <!-- Users Table -->
    <div id="users-table" class="container mx-auto px-4 py-8">
        <h1 class="text-2xl font-semibold mb-4">User List</h1>
        <div class="-mx-4">
            <table class="w-full bg-white shadow-lg rounded-lg overflow-hidden">
                <thead class="bg-green-400 text-white">
                    <tr>
                        <th class="px-4 py-2">User ID</th>
                        <th class="px-4 py-2">Name</th>
                        <th class="px-4 py-2">Email</th>
                        <th class="px-4 py-2">Role</th>
                    </tr>
                </thead>
                <tbody class="divide-y divide-gray-200">
                    <%
                    List<User> userListAdmin = (List<User>) session.getAttribute("userListAdmin");
                    if (userListAdmin != null) {
                        for (User user : userListAdmin) {
                    %>
                    <tr>
                        <td class="px-4 py-2 text-center"><%=user.getUserId()%></td>
                        <td class="px-4 py-2 text-center"><%=user.getUsername()%></td>
                        <td class="px-4 py-2 text-center"><%=user.getEmail()%></td>
                        <td class="px-4 py-2 text-center"><%=user.getRole()%></td>
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
