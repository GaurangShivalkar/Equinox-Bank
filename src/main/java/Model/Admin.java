package Model;

public class Admin {
	int totalTransactions, totalAccounts, totalUsers;

	public Admin(int totalTransactions, int totalAccounts, int totalUsers) {
		
		this.totalTransactions = totalTransactions;
		this.totalAccounts = totalAccounts;
		this.totalUsers = totalUsers;
	}

	public int getTotalTransactions() {
		return totalTransactions;
	}

	public void setTotalTransactions(int totalTransactions) {
		this.totalTransactions = totalTransactions;
	}

	public int getTotalAccounts() {
		return totalAccounts;
	}

	public void setTotalAccounts(int totalAccounts) {
		this.totalAccounts = totalAccounts;
	}

	public int getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(int totalUsers) {
		this.totalUsers = totalUsers;
	}
}
