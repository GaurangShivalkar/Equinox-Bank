package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import Model.Admin;
import Dao.AdminDao;
import Dao.ConnectionDb;
import Dao.TransactionDao;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = ConnectionDb.getConnection(getServletContext());
		HttpSession session = request.getSession();

		Admin adminData = AdminDao.totalData(con);
				
		session.setAttribute("totalTransactions", adminData.getTotalTransactions());
		session.setAttribute("totalAccounts", adminData.getTotalAccounts());
		session.setAttribute("totalUsers", adminData.getTotalUsers());
		
		
		List accountListAdmin = AdminDao.showAccount(con);
		List transactionListAdmin = AdminDao.showTransaction(con);
		List userListAdmin = AdminDao.showUser(con);

		session.setAttribute("accountListAdmin", accountListAdmin);
		session.setAttribute("transactionListAdmin", transactionListAdmin);
		session.setAttribute("userListAdmin", userListAdmin);
//		RequestDispatcher rd = request.getRequestDispatcher("transaction.jsp");
//		rd.forward(request, response);

		
		RequestDispatcher rd = request.getRequestDispatcher("Admin/admin.jsp");
		rd.forward(request, response);
		
	}

}
