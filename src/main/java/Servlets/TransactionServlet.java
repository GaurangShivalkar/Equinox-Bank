package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import Dao.AccountDao;
import Dao.ConnectionDb;
import Dao.TransactionDao;
import Model.Transaction;

public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = ConnectionDb.getConnection(getServletContext());
		
		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");
		int userId = (int) session.getAttribute("userId");
	
		
		String sourceId = (String) session.getAttribute("sourceId");
			String transactionType = request.getParameter("transactionType");
			String description = request.getParameter("description");
			String destinationId = request.getParameter("destinationId");
			double amount = Double.parseDouble(request.getParameter("amount"));

			// Transaction transaction = new Transaction(transactionType, amount, userId);
			
			Transaction transaction = new Transaction(transactionType, userId, description, sourceId, destinationId, amount);					
			int rowsResult = TransactionDao.makeTransaction(transaction, con);
			
			if (rowsResult > 0) {
				//RequestDispatcher rd = request.getRequestDispatcher("transaction.jsp");
				 doGet(request, response);
			}
			else if(rowsResult == -1) {
				response.sendError(406,"The Balance cannot negative");
			}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection con = ConnectionDb.getConnection(getServletContext());
		int userId = (int) session.getAttribute("userId");
		
		
		String sourceId = (String) session.getAttribute("sourceId");
		
		
		double ogBalance = AccountDao.selectBalance(con, sourceId);
		int totalTransactions = TransactionDao.countTransactions(sourceId, con);
		int totalWithdrawal = TransactionDao.sumWithdrawal(sourceId, con);
		int totalDeposit = TransactionDao.sumDeposit(sourceId, con);
		
		
	
		
		request.setAttribute("ogBalance", ogBalance);
		request.setAttribute("totalTransactions", totalTransactions);
		request.setAttribute("totalWithdrawal", totalWithdrawal);
		request.setAttribute("totalDeposit", totalDeposit);
		
		List transactionListDetail = TransactionDao.showTransaction(sourceId, con);


		request.setAttribute("transactionList", transactionListDetail);
		RequestDispatcher rd = request.getRequestDispatcher("transaction.jsp");
		rd.forward(request, response);
	}

}
