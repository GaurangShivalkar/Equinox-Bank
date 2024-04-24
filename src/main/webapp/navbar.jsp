<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<%
//response.setHeader("Cache-Contorl", "no-cahe, no-store, must-revalidate");

if(session.getAttribute("userId")==null) {
	response.sendRedirect("login.jsp");
}

%>
	<nav class="bg-green-400 py-4">
    <div class="container mx-auto">
        <div class="flex justify-between items-center">
            <a class="text-white text-xl font-bold hidden lg:block" href="#">Banking App</a>
            <a class="text-white text-xl font-bold lg:hidden" href="#">Banking</a>
            <button class="block lg:hidden" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="hidden lg:block">
                <ul class="flex space-x-4">
                    <li class="nav-item">
                        <a class="text-white" aria-current="page" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="text-white" href="http://localhost:8080/BankingSystem/createAccount.jsp">Create Account</a>
                    </li>
                    <li class="nav-item">
                        <form action="account" method="get">
                            <button type="submit" class="text-white">View Account</button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="logout" method="POST">
                            <button type="submit" class="text-white ">Logout</button>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
</body>
</html>
