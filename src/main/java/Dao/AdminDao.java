package Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Constants.QueryConstant;
import Model.Account;
import Model.Admin;
import Model.Transaction;
import Model.User;
import jakarta.servlet.ServletException;

public class AdminDao {
	public static List showTransaction(Connection con) throws ServletException, IOException {
		List<Transaction> transactionListAdmin = new ArrayList<>();
		try {
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(QueryConstant.TRANSACTIONSDATA);
			while (rs.next()) {
				int transactionId = rs.getInt("TransactionID");
				String transactionType = rs.getString("TransactionType");
				String description = rs.getString("description");
				double amount = rs.getDouble("Amount");
				String timeStamp = rs.getString("TimeStamp");
				double changedBalance = rs.getDouble("ChangedBalance");
				int UserId = rs.getInt("UserId");
				String sourceId = rs.getString("SourceAccountId");
				String destinationId = rs.getString("DestinationAccountId");
				Transaction transaction = new Transaction(transactionId, transactionType, UserId, description, sourceId,
						destinationId, amount, timeStamp, changedBalance);
				transactionListAdmin.add(transaction);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return transactionListAdmin;
	}

	public static List showAccount(Connection con) throws ServletException, IOException {
		List<Account> accountListAdmin = new ArrayList<>();
		try {
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(QueryConstant.ACCOUNTSDATA);
			while (rs.next()) {
				int AccountId = rs.getInt("AccountId");
				int UserId = rs.getInt("UserId");
				String AccountNumber = rs.getString("AccountNumber");
				String AccountType = rs.getString("AccountType");
				double Balance = rs.getDouble("Balance");
				String CustomerId = rs.getString("CustomerId");
 				Account account = new Account(UserId, UserId, AccountNumber, AccountType, Balance, CustomerId);
				accountListAdmin.add(account);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return accountListAdmin;
	}

	public static List showUser(Connection con) throws ServletException, IOException {
		List<User> userListAdmin = new ArrayList<>();
		try {
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(QueryConstant.USERSDATA);
			while (rs.next()) {
				int UserId = rs.getInt("UserId");
				String Username = rs.getString("UserName");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				String Role = rs.getString("Role");
				User user = new User(UserId, Username, Password, Email, Role);
				userListAdmin.add(user);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return userListAdmin;
	}

	public static Admin totalData(Connection con) {
		int totalTransactions, totalAccounts, totalUsers;
		Admin adminTotal = null;
		try {
			PreparedStatement pstBalance = con.prepareStatement(QueryConstant.TOTALSADMIN);

			ResultSet rs = pstBalance.executeQuery();

			if (rs.next()) {
				totalTransactions = rs.getInt("TotalTransactions");
				totalAccounts = rs.getInt("totalAccounts");
				totalUsers = rs.getInt("TotalTransactions");
				adminTotal = new Admin(totalTransactions, totalAccounts, totalUsers);
			}

		} catch (Exception e) {

		}
		return adminTotal;
	}

}
