package Constants;

public class QueryConstant {
	//Users
	public static String INSERTUSER = "INSERT INTO USERS(UserName, Password, Email, Role)  VALUES (?,?,?,?)";
	public static String SELECTUSER = "SELECT * FROM USERS WHERE Email = ? AND Password = ?";
	public static String DELETEUSER = "DELETE FROM USERS WHERE UserId = ?";
	
	public static String INSERTCUSTOMERID = "INSERT INTO USERS(CustomerId) VALUES (?) WHERE UserId = ?";
	//Accounts
	public static String INSERTACCOUNT = "INSERT INTO ACCOUNTS(UserId, AccountNumber, AccountType, Balance) values (?,?,?,?)";
	public static String SELECTACCOUNT = "SELECT * FROM ACCOUNTS WHERE UserId = ?";
	public static String DELETEACCOUNT = "DELETE FROM ACCOUNTS WHERE AccountNumber = ?";
	public static String COUNTACCOUNT = "SELECT COUNT(AccountId)AS TotalAccounts FROM ACCOUNTS WHERE userId = ?";
	
	//Balance of Accounts
	public static String UPDATEBALANCE = "UPDATE ACCOUNTS SET BALANCE = ? WHERE AccountNumber =?";
	public static String SELECTBALANCE = "SELECT Balance FROM ACCOUNTS WHERE AccountNumber = ?";
	
	
	//Transactions
	public static String INSERTTRANSACTION = "INSERT INTO TRANSACTIONS(TransactionType, Amount, UserId, Description, SourceAccountID, DestinationAccountID, changedBalance)VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static String SELECTTRANSACTION = "SELECT * FROM TRANSACTIONS WHERE SourceAccountID = ?";
	public static String TOTALTRANSACTIONS = "SELECT COUNT(TransactionId) AS TotalTransactions FROM TRANSACTIONS WHERE SourceAccountId=?";
	public static String TOTALWITHDRAWAL = "SELECT SUM(Amount) FROM TRANSACTIONS WHERE SourceAccountID=? AND TransactionType = 'withdrawal'";
	public static String TOTALDEPOSIT = "SELECT SUM(Amount) FROM TRANSACTIONS WHERE SourceAccountID=? AND TransactionType IN('deposit','transfer')";
	
	//Admin
	public static String TOTAlBALANCE_ADMIN = "SELECT SUM(Balance) FROM ACCOUNTS";
	public static String TOTALTRANSACTIONS_ADMIN = "SELECT COUNT(TransactionId) FROM TRANSACTIONS";
	public static String TOTALACCOUNTS_ADMIN = "SELECT COUNT(AccountId) FROM ACCOUNTS";
	public static String TOTALUSERS_ADMIN = "SELECT COUNT(Users) FROM USERS";
	
	public static String ACCOUNTSDATA = "SELECT * FROM ACCOUNTS";
	public static String TRANSACTIONSDATA = "SELECT * FROM TRANSACTIONS";
	public static String USERSDATA = "SELECT * FROM USERS";
	
	public static String TOTALSADMIN ="SELECT (SELECT COUNT(*) FROM Transactions) AS TotalTransactions, (SELECT COUNT(*) FROM Accounts) AS TotalAccounts,(SELECT COUNT(*) FROM Users) AS TotalUsers;";

	public static String DEPOSIT_TIME="SELECT Transactions.TransactionId, Transactions.Amount, Transactions.Description, Transactions.Timestamp, Users.UserName"
			+ "FROM Transactions\r\n"
			+ "INNER JOIN Users ON Transactions.UserId = Users.UserId\r\n"
			+ "WHERE Transactions.TransactionType = 'deposit'\r\n"
			+ "AND Transactions.Timestamp >= 'start_date' AND Transactions.Timestamp <= 'end_date';\r\n";
			

	public static String BALANCEOF_USER="SELECT Users.UserId, Users.UserName, Users.Email, SUM(Accounts.Balance) AS Total_Balance\r\n"
			+ "FROM Users\r\n"
			+ "INNER JOIN Accounts ON Users.UserId = Accounts.UserId\r\n"
			+ "GROUP BY Users.UserId;\r\n"
			+ "";
}
