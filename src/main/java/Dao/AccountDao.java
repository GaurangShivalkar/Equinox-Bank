package Dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Constants.QueryConstant;
import Model.Account;
import Model.Transaction;
import Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Random;
public class AccountDao {
	public static int account(Account account, Connection con) throws ServletException, IOException {
		int rowUpdate = 0;
		double balance = 0;
		try {
			int userId = account.getUserId();
			String accountNumber = account.getAccountNumber();
			String accountType = account.getAccountType();
			balance = account.getBalance();
			if(accountType.equals("current") && balance < 0 ) {
				balance = 0;
			}
			else if(accountType.equals("saving")&& balance < 2000) {
				rowUpdate =-1;
			}
			else {
			if (userId != 0 && !accountNumber.isEmpty() && !accountType.isEmpty() ) {
				PreparedStatement pst = con.prepareStatement(QueryConstant.INSERTACCOUNT);
				pst.setInt(1, userId);
				pst.setString(2, accountNumber);
				pst.setString(3, accountType);
				pst.setDouble(4, balance);
				rowUpdate = pst.executeUpdate();

			}
			}

			// response.sendRedirect("/login.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}

		return rowUpdate;
	}

	public static double selectBalance(Connection con, String accountNumber) throws ServletException, IOException {
		double ogBalance = 0;
		try {
		PreparedStatement pstBalance = con.prepareStatement(QueryConstant.SELECTBALANCE);

		pstBalance.setString(1, accountNumber);

		ResultSet rsBalance = pstBalance.executeQuery();
	
		if (rsBalance.next()) {
			ogBalance = rsBalance.getDouble("Balance");
		}
		
		} catch(Exception e) {
			
		}
		return ogBalance;
	}

	public static void updateBalance(Connection con, String accountNumber, double updatedBalance)
			throws ServletException, IOException, SQLException {
		PreparedStatement pstUpdate = con.prepareStatement(QueryConstant.UPDATEBALANCE);
		pstUpdate.setDouble(1, updatedBalance);
		pstUpdate.setString(2, accountNumber);
		pstUpdate.executeUpdate();
	}

	public static List showAccount(int userId, Connection con) throws ServletException, IOException {
		List<Account> accountList = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(QueryConstant.SELECTACCOUNT);
			pst.setInt(1, userId);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int accountId = rs.getInt("AccountId");
				int UserId = rs.getInt("UserId");
				String accountNumber = rs.getString("accountNumber");
				String accountType = rs.getString("accountType");

				double balance = rs.getDouble("balance");
				String customerId = rs.getString("CustomerId");
				Account accountData = new Account(accountId, UserId, accountNumber, accountType, balance, customerId);
				accountList.add(accountData);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return accountList;
	}
	
	public static int deleteAccount(String delAccount, Connection con) throws ServletException, IOException {
		int rowDeleted = 0;
		try {
			
				PreparedStatement pst = con.prepareStatement(QueryConstant.DELETEACCOUNT);	
				pst.setString(1, delAccount);
				rowDeleted = pst.executeUpdate();
			// response.sendRedirect("/login.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}
		return rowDeleted;
	}
	
	public static int countAccounts(int userId, Connection con) throws ServletException, IOException {
		int accountCount= 0;
		try {	
				PreparedStatement pst = con.prepareStatement(QueryConstant.COUNTACCOUNT);	
				pst.setInt(1, userId);
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()) {
					accountCount = rs.getInt("TotalAccounts");
				}
				
		} catch (Exception e) {
			System.out.println(e);
		}
		return accountCount;
	}
	

	public static  void insertCustomerId(String customerId, int userId, Connection con) throws ServletException, IOException {
	
		try {	
				PreparedStatement pst = con.prepareStatement(QueryConstant.INSERTCUSTOMERID);	
				pst.setString(1, customerId);
				pst.setInt(2, userId);
			
				pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}