package Services;

public class TransactionService {
	public static boolean balanceCheck(double ogBalance, double amount) {
		boolean res = true;
		if(ogBalance < 0 || ogBalance > amount) {
			res = false;
		}
		return res;
	}
}
