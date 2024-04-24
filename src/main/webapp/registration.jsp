<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css"
	rel="stylesheet">
<style>
<%@include file ="css/login.css"%>
</style>
</head>
<body class="bg-green-100 flex justify-center items-center h-screen">


	<div class="form-container p-8 max-w-md w-full">
		<h2 class="text-3xl font-semibold text-center mb-6 heading">Sign in</h2>

		<form action="registration" method="post" class="form space-y-4">
			<div>
				<label for="username" class="block font-medium text-gray-600">Username</label>
				<input type="text" class="mt-1 block w-full px-3 py-2 rounded-md"
					name="username">
			</div>
			<div>
				<label for="email" class="block font-medium text-gray-600">Email
					address</label> <input type="email"
					class="mt-1 block w-full px-3 py-2 rounded-md" name="email">
			</div>
			<div>
				<label for="password" class="block font-medium text-gray-600">Password</label>
				<input type="password" class="mt-1 block w-full px-3 py-2 rounded-md" name="password">
			</div>
			<div>
				<label for="role" class="block font-medium text-gray-600">Select the role:</label> 
				<select class="form-select mt-1 block w-full px-3 py-2 rounded-md"	name="role">
					<option value="">Select</option>
					<option value="user">User</option>
					<option value="admin">Admin</option>
				</select>
			</div>
			<input type="hidden" name="action" value="registration" />
			<div>
				<button
					class="w-full py-2 px-4 rounded-md hover:bg-green-600 focus:outline-none focus:ring-2 focus:ring-green-500 focus:ring-offset-2 focus:ring-offset-gray-100"
					type="submit">Sign in</button>
			</div>
		</form>
		<div class="text-center">
			<p class="text-gray-600">
				Already have an account? <a
					href="http://localhost:8080/BankingSystem/login.jsp"
					class="font-medium link hover:text-green-500"> Login </a>
			</p>
		</div>
	</div>

</body>
</html>