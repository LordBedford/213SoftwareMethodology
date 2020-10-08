/**
 * This class creates the Account Child: MoneyMarket.
 * @author Andrew Cater, Raymund Caringal
 */
public class MoneyMarket extends Account {
	private int withdrawals;

	/**
	 * Generates a Money Market Account
	 * @param fname first name
	 * @param lname last name
	 * @param initDeposit initial account deposit
	 * @param day between 1 and 30, otherwise an invalid date
	 * @param month between 1 and 12, other wise an invalid date
	 * @param year between 0 and 10000, otherwise an invalid date
	 */
	public MoneyMarket (String fname, String lname, double initDeposit, int day, int month, int year) {
		super(fname, lname, initDeposit, day, month, year);
		withdrawals = 0;

	}

	/**
	 * The money market account's current monthly interest
	 * @return monthly interest as a double
	 */
	@Override
	public double monthlyInterest() {
		return this.getBalance()*0.0065;
	}

	/**
	 * The monthly market account's monthly fee if applicable
	 * @return 0 if the number of withdrawals are less than 6 and balance is greater than 2500, 12 otherwise
	 */
	@Override
	public double monthlyFee() {
		if(this.getBalance() > 2500 && withdrawals <= 6) return 0;
		return 12;
	}

	/**
	 * Checks if a specified account matches the Money Market account
	 * @param account to be checked
	 * @return true if the same, false otherwise
	 */
	@Override
	public boolean compare(Account account) {
		if(account instanceof MoneyMarket){
			MoneyMarket a = (MoneyMarket) account;
			return this.getProfile().compare(a.getProfile());
		}
		return false;
	}

	/**
	 * Used to verify class type
	 * @return 2 for Money Market
	 */
	@Override
	public int classType() {
		// TODO Auto-generated method stub
		return 2;
	}

	/**
	 * Gets the current number of withdrawals
	 * @return number of withdrawals
	 */
	public int getWithdrawals(){return withdrawals;}

	/**
	 * Prints the Money Market account
	 * @return Money Market account as a string
	 */
	@Override
	public String toString() {
		return ("*Money Market" + super.toString()+withdrawals+" withdrawals*");
	}

	/**
	 * Increases the current number of withdrawals
	 */
	public void withdraw() {
		withdrawals++;
	}
}
