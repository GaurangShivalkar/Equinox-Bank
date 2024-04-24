<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="Model.Transaction"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>Transaction Page</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>

<body class="bg-gray-100">
    <%@include file="navbar.jsp"%>
    <div class="container mx-auto p-6">
        <h1 class="text-3xl font-bold mb-4">Transaction page</h1>
        <div class="grid grid-cols-1 gap-4 md:grid-cols-3">
            <!-- Total Balance -->
            <div class="bg-white rounded-md shadow-md p-4">
                <h3 class="text-xl font-semibold mb-2">Total Balance</h3>
                <p class="text-lg text-gray-800">Rs. <%=request.getAttribute("ogBalance") %></p>
            </div>
            <!-- Total Transactions -->
            <div class="bg-white rounded-md shadow-md p-4">
                <h3 class="text-xl font-semibold mb-2">Total Transactions</h3>
                <p class="text-lg text-gray-800"><%=request.getAttribute("totalTransactions") %></p>
            </div>
            <!-- Total Debits -->
            <div class="bg-white rounded-md shadow-md p-4">
                <h3 class="text-xl font-semibold mb-2">Total Debits</h3>
                <p class="text-lg text-gray-800"><%=request.getAttribute("totalDeposit") %></p>
            </div>
        </div>
        <hr class="my-6">
        <!-- Transaction Form -->
        <div class="bg-white rounded-md shadow-md p-6">
            <h2 class="text-xl font-semibold mb-4">Make a transaction</h2>
            <form action="transaction" method="post">
                <div class="grid grid-cols-1 gap-4 md:grid-cols-3">
                   <div class="mb-4">
					    <label for="description" class="block font-medium text-gray-600">Description</label>
					    <input type="text" id="description" name="description" placeholder="Enter description" class="mt-1 block w-full px-3 py-2 rounded-md border-gray-300 focus:ring-green-500 focus:border-green-500 bg-gray-100 placeholder-gray-400">
				   </div>
					<div class="mb-4">
					    <label for="amount" class="block font-medium text-gray-600">Amount (Rs)</label>
					    <input type="number" id="amount" name="amount" step="0.01" min="0" placeholder="0.00" class="mt-1 block w-full px-3 py-2 rounded-md border-gray-300 focus:ring-green-500 focus:border-green-500 bg-gray-100 placeholder-gray-400">
					</div>
				<div class="mb-4">
				    <label for="transactionType" class="block font-medium text-gray-600">Transaction Type</label>
				    <select id="transactionType" name="transactionType" class="mt-1 block w-full px-3 py-2 rounded-md border-gray-300 focus:ring-green-500 focus:border-green-500 bg-gray-100 text-gray-900 placeholder-gray-400">
				        <option value="withdrawal">Withdrawal</option>
				        <option value="deposit">Deposit</option>
				        <option value="transfer">Transfer</option>
				    </select>
				</div>
                <div class="grid grid-cols-1 gap-4 mt-4">
                    <div>
                        <input type="hidden" name="accountNumber" value="<%=request.getParameter("accountNumber")%>">
                     	<label for="destinationId" class="block font-medium text-gray-600">To Account No.</label>
   						<input type="text" id="destinationId" name="destinationId" placeholder="Enter destination account number" class="mt-1 block w-full px-3 py-2 rounded-md border-gray-300 focus:ring-green-500 focus:border-green-500 bg-gray-100 placeholder-gray-400">
					</div>
                    <div class="col-span-2 flex justify-end">
                        <button type="submit" class="inline-flex items-center px-4 py-2 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-green-600 hover:bg-green-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-green-500">Save</button>
                    </div>
                </div>
            </form>
        </div>
        <hr class="my-6">
        <!-- Transaction Table -->
        <div class="bg-white rounded-md shadow-md p-6">
            <h2 class="text-xl font-semibold mb-4">Transaction History</h2>
			
			    <form action="SessionsServlet" method="POST" class="mb-4">
			        <button type="submit" class="inline-flex items-center px-4 py-2 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-red-600 hover:bg-red-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-red-500">Close transaction</button>
			    </form>
		
            <p class="mb-4"><strong>Sort Transactions by:</strong> <select class="form-select">
                    <option value=''>All</option>
                    <option value='credit'>Deposit</option>
                    <option value='debit'>Withdraw</option>
                </select></p>
            <table class="min-w-full divide-y divide-gray-200">
                <thead class="bg-gray-50">
                    <tr>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Type</th>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Amount</th>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Description</th>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Time Period</th>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Balance</th>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">To</th>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">From</th>
                    </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                    <%
                    List<Transaction> transactionList = (List<Transaction>) request.getAttribute("transactionList");
                    if (transactionList != null) {
                        for (Transaction transaction : transactionList) {
                    %>
                    <tr>
                        <td class="px-6 py-4 whitespace-nowrap"><%=transaction.getTransactionType()%></td>
                        <td class="px-6 py-4 whitespace-nowrap"><%=transaction.getAmount()%></td>
                        <td class="px-6 py-4 whitespace-nowrap"><%=transaction.getDescription()%></td>
                        <td class="px-6 py-4 whitespace-nowrap"><%=transaction.getTimeStamp()%></td>
                        <td class="px-6 py-4 whitespace-nowrap"><%=transaction.getChangedBalance()%></td>
                        <td class="px-6 py-4 whitespace-nowrap"><%=transaction.getDestinationAccountId()%></td>
                        <td class="px-6 py-4 whitespace-nowrap"><%=transaction.getSourceAccountId()%></td>
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
