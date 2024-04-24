package Dao;

import java.io.IOException;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Constants.QueryConstant;
import Model.Transaction;
import Services.TransactionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;

public class TransactionDao {
	public static int makeTransaction(Transaction transaction, Connection con) throws ServletException, IOException {
		int rowsUpdate = 0;
		double amount;
		int userId;
		String transactionType, description, sourceId, destinationId;
		try {

			transactionType = transaction.getTransactionType();
			amount = transaction.getAmount();
			 userId = transaction.getUserId();
			description = transaction.getDescription();
			 sourceId = transaction.getSourceAccountId();
			 destinationId = null;
				
			// select balance
			double ogBalance = AccountDao.selectBalance(con, sourceId);
			if(ogBalance < 0 || ogBalance < amount && transactionType.equals("withdrawal") || ogBalance < amount && transactionType.equals("transfer")) {
				rowsUpdate = -1;
			}
			else {
			// check balance
			double updatedBalance = ogBalance;
			

			if (transactionType.equals("withdrawal") || transactionType.equals("transfer")) {

	
				updatedBalance = ogBalance - amount;
			

			} 
			else if (transactionType.equals("deposit")) {


				updatedBalance = ogBalance + amount;

			}
			
			if(transactionType.equals("transfer")) {
				destinationId = transaction.getDestinationAccountId();
			}
			//update receiver amount if transferring

			
			// insert transaction
			PreparedStatement pst = con.prepareStatement(QueryConstant.INSERTTRANSACTION);
			pst.setString(1, transactionType);
			pst.setDouble(2, amount);
			pst.setInt(3, userId);
			pst.setString(4, description);
			pst.setString(5, sourceId);
			pst.setString(6, destinationId);
			pst.setDouble(7, updatedBalance);
			rowsUpdate = pst.executeUpdate();
			
			
	
			// update balance
			AccountDao.updateBalance(con, sourceId, updatedBalance);
			
			//update receiver balance
			if(transactionType.equals("transfer")) {
				
				double RecieverBalance = AccountDao.selectBalance(con, destinationId);
				double updatedRecieverBalance = RecieverBalance +amount;
				PreparedStatement receieverPst = con.prepareStatement(QueryConstant.INSERTTRANSACTION);
				receieverPst.setString(1, transactionType);
				receieverPst.setDouble(2, amount);
				receieverPst.setInt(3, userId);
				receieverPst.setString(4, description);
				receieverPst.setString(5, destinationId);
				receieverPst.setString(6, sourceId);
				receieverPst.setDouble(7, updatedBalance);
				receieverPst.executeUpdate();
				
				
				AccountDao.updateBalance(con, destinationId, updatedRecieverBalance);
			}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return rowsUpdate;
	}

	public static List showTransaction(String sourceAccountId, Connection con) throws ServletException, IOException {
		List<Transaction> transactionList = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(QueryConstant.SELECTTRANSACTION);
			pst.setString(1, sourceAccountId);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int transactionId = rs.getInt("TransactionID");
				String transactionType = rs.getString("TransactionType");
				String description = rs.getString("description");
				double amount = rs.getDouble("Amount");
				Timestamp sqlTimestamp = rs.getTimestamp("timestamp");
				LocalDate localDate = sqlTimestamp.toLocalDateTime().toLocalDate();
				String timeStamp = localDate.toString();
				// Convert SQL timestamp to java.time.LocalDate
				
				int UserId = rs.getInt("UserId");
				String sourceId = rs.getString("SourceAccountId");
				String destinationId =rs.getString("DestinationAccountId");
				double changedBalance = rs.getDouble("ChangedBalance");
				Transaction transaction = new Transaction(transactionId, transactionType, UserId, description, sourceId,
					destinationId, amount, timeStamp, changedBalance);
				transactionList.add(transaction);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return transactionList;
	}
	

	public static int countTransactions(String sourceId, Connection con) throws ServletException, IOException {
		int totalTransactions =0;
		try {
			PreparedStatement pst = con.prepareStatement(QueryConstant.TOTALTRANSACTIONS);
			pst.setString(1, sourceId);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				totalTransactions = rs.getInt("TotalTransactions");
			}
			
		} catch(Exception e) {}
		
		return totalTransactions;
		
	}
	
	public static int sumWithdrawal(String sourceId, Connection con) throws ServletException, IOException {
		int totalWithdrawal =0;
		try {
			PreparedStatement pst = con.prepareStatement(QueryConstant.TOTALWITHDRAWAL);
			pst.setString(1, sourceId);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				totalWithdrawal = rs.getInt("TotalTransactions");
			}
			
		} catch(Exception e) {}
		
		return totalWithdrawal;
		
	}
	
	public static int sumDeposit(String sourceId, Connection con) throws ServletException, IOException {
		int totalDeposit =0;
		try {
			PreparedStatement pst = con.prepareStatement(QueryConstant.TOTALDEPOSIT);
			pst.setString(1, sourceId);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				totalDeposit = rs.getInt("TotalTransactions");
			}
			
		} catch(Exception e) {}
		
		return totalDeposit;
		
	}


}
