package Model;

public class Transaction {

	int transactionId;
	String transactionType;
	int userId;
	String description;
	String sourceAccountId;
	String destinationAccountId;
	double amount;
	String timeStamp;
	double changedBalance;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSourceAccountId() {
		return sourceAccountId;
	}

	public void setSourceAccountId(String sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}

	public String getDestinationAccountId() {
		return destinationAccountId;
	}

	public void setDestinationAccountId(String destinationAccountId) {
		this.destinationAccountId = destinationAccountId;
	}

	public double getChangedBalance() {
		return changedBalance;
	}

	public void setChangedBalance(double changedBalance) {
		this.changedBalance = changedBalance;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Transaction(int transactionId, String transactionType, double amount, String timeStamp,
			double changedBalance, int userId) {
		this.changedBalance = changedBalance;
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.amount = amount;

		this.timeStamp = timeStamp;

		this.userId = userId;
	}

	public Transaction(int transactionId, String transactionType, int userId, String description, String sourceAccountId,
			String destinationAccountId, double amount, String timeStamp, double changedBalance) {
		
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.userId = userId;
		this.description = description;
		this.sourceAccountId = sourceAccountId;
		this.destinationAccountId = destinationAccountId;
		this.amount = amount;
		this.timeStamp = timeStamp;
		this.changedBalance = changedBalance;
	}
	
	public Transaction(String transactionType, int userId, String description, String sourceAccountId,
			String destinationAccountId, double amount) {
		super();
		this.transactionType = transactionType;
		this.userId = userId;
		this.description = description;
		this.sourceAccountId = sourceAccountId;
		this.destinationAccountId = destinationAccountId;
		this.amount = amount;
	}

	public Transaction(String transactionType, double amount, int userId) {

		this.transactionType = transactionType;
		this.amount = amount;
		this.userId = userId;
	}

}
