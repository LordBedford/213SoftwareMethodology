/**
 * This class creates the Account Child: Savings.
 * @author Andrew Cater, Raymund Caringal
 */
public class Savings extends Account {

	private boolean isLoyal;

	/**
	 * Generates a Savings Account
	 * @param fname first name
	 * @param lname last name
	 * @param initDeposit initial account deposit
	 * @param day between 1 and 30, otherwise an invalid date
	 * @param month between 1 and 12, other wise an invalid date
	 * @param year between 0 and 10000, otherwise an invalid date
	 * @param loyal true if a customer uses the loyal customer promo, false otherwise
	 */
	public Savings(String fname, String lname, double initDeposit, int day, int month, int year, boolean loyal) {
		super(fname, lname, initDeposit, day, month, year);
		isLoyal = loyal;
	}

	/**
	 * The saving account's current monthly interest
	 * @return monthly interest as a double
	 */
	@Override
	public double monthlyInterest() {
		if(isLoyal) return this.getBalance()*0.0035;
		return this.getBalance()*0.0025;
	}

	/**
	 * The saving account's monthly fee if applicable
	 * @return 0 if balance is greater than 300, 5 otherwise
	 */
	@Override
	public double monthlyFee() {
		if(this.getBalance() >= 300)return 0;
		
		return 5;
	}

	/**
	 * Checks if a specified account matches the Savings account
	 * @param account to be checked
	 * @return true if the same, false otherwise
	 */
	@Override
	public boolean compare(Account account) {
		if(account instanceof Savings){
			Savings a = (Savings) account;
			return this.getProfile().compare(a.getProfile());
		}
		return false;
	}

	/**
	 * Used to verify class type
	 * @return 1 for Saving
	 */
	@Override
	public int classType() {
		// TODO Auto-generated method stub
		return 1;
	}

	/**
	 * Check whether a customer is loyal
	 * @return true if loyal, false otherwise
	 */
	public boolean getIsLoyal(){return isLoyal;}

	/**
	 * Prints the Savings account
	 * @return Savings account as a string
	 */
	@Override
	public String toString() {

		if(isLoyal)return ("*Savings" + super.toString()+"special Savings account*");
		return ("*Savings" + super.toString());
	}

}
