package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.mail.*;

import Constants.MailConstant;
import Dao.AccountDao;
import Dao.ConnectionDb;

import Model.Account;
import Services.AccountService;
import Services.EmailUtility;

public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;

	
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = ConnectionDb.getConnection(getServletContext());
		HttpSession session = request.getSession();
		
		double balance = 0;
		int userId;
		String action, accountNumber, accountType, subject,recipient,content, customerId;
		
		userId = (int) session.getAttribute("userId");
		
		action = request.getParameter("action");
		if (action.equals("account")) {
		accountNumber = AccountService.generateAccountNumber();
		accountType = request.getParameter("accountType");
		
		int countAccount = AccountDao.countAccounts(userId, con);

		if(countAccount == 0) {
			String customerIdInput = AccountService.generateCustomerId();
			AccountDao.insertCustomerId(customerIdInput, userId, con);
			customerId  = customerIdInput;
		}
		else {
			customerId  = (String) session.getAttribute("customerId");
		}
		if(request.getParameter("balance") != null ) {
			balance = Double.parseDouble(request.getParameter("balance"));
		}
		else {
			response.sendError(400, "The Values is empty");
		}
		Account account = new Account(userId, accountNumber, accountType, balance, customerId);

		int rowResult = AccountDao.account(account, con);
		if (rowResult > 0) {
			 subject = MailConstant.SUBJECT_ACCOUNT;
	         recipient = (String) session.getAttribute("email");
	         content = MailConstant.MESSAGE_ACCOUNT +"\nYour Account Number is: "+accountNumber+"\nYour intial balance is: "+balance;
	         
	      
	         boolean emailSent = EmailUtility.sendEmail(host, port, user, pass, recipient, subject, content);
	         if (emailSent) {
	             // Email sent successfully
	             // You can redirect or display a success message to the user
	             response.sendRedirect("index.jsp");
	         } 
	         else {
	             // Failed to send email
	             // You can redirect or display an error message to the user
	             response.sendRedirect("login.jsp");
	         }
		}
		else if(rowResult == -1){
			response.sendError(406, "Please enter the amount above 2000");
		}

		else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("The Fields cannot be empty");
		}
		}
		else if(action.equals("deleteAccount")) {
			String delAccount = request.getParameter("delAccountNo");
			
			int rowDeletedResult = AccountDao.deleteAccount(delAccount, con);
			if(rowDeletedResult > 0) {
				PrintWriter out =  response.getWriter();
				response.setContentType("text/html");
				out.println("The account is sucessfully deleted");
			}
			else {
				
				PrintWriter out =  response.getWriter();
				response.setContentType("text/html");
				out.println("Something went wrong " + delAccount);
			}
		
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = ConnectionDb.getConnection(getServletContext());
		HttpSession session = request.getSession();

		int userId = (int) session.getAttribute("userId");
		List accountList = AccountDao.showAccount(userId, con);

		session.setAttribute("accountList", accountList);
		RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
		rd.forward(request, response);
	}
}
