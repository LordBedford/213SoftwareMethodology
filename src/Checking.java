/**
 * This class creates the Account Child: Checking.
 * @author Andrew Cater, Raymund Caringal
 */
public class Checking extends Account {
	private boolean directdeposit;

	/**
	 * Generates a Checking Account
	 * @param fname first name
	 * @param lname last name
	 * @param initDeposit initial account deposit
	 * @param day between 1 and 30, otherwise an invalid date
	 * @param month between 1 and 12, other wise an invalid date
	 * @param year between 0 and 10000, otherwise an invalid date
	 * @param isDirectdeposit true if the account is a direct deposit, false otherwise
	 */
	public Checking(String fname, String lname, double initDeposit, int day, int month, int year, boolean isDirectdeposit) {
		super(fname, lname, initDeposit, day, month, year);
		directdeposit = isDirectdeposit;
	}

	/**
	 * The checking account's current monthly interest
	 * @return monthly interest as a double
	 */
	@Override
	public double monthlyInterest() {
		return this.getBalance()*0.0005;
	}

	/**
	 * The checking account's monthly fee if applicable
	 * @return 0 if a direct deposit, 25 if the current balance is greater than 1500
	 */
	@Override
	public double monthlyFee() {
		if(this.getBalance() >= 1500 || directdeposit)return 0;
		
		return 25;
	}

	/**
	 * Checks if a specified account matches the current checking account
	 * @param account to be checked
	 * @return true if the same, false otherwise
	 */
	@Override
	public boolean compare(Account account) {
		if(account instanceof Checking){
			Checking a = (Checking) account;
			return this.getProfile().compare(a.getProfile());
		}
		return false;
	}

	/**
	 * Used to verify class type
	 * @return 0 for Checking
	 */
	@Override
	public int classType() {
		return 0;
	}

	/**
	 * Returns direct deposit
	 * @return true if it's a direct deposit, false otherwise
	 */
	public boolean getDirectDeposit(){return directdeposit;}

	/**
	 * Prints the Checking Account
	 * @return Checking account as a string
	 */
	@Override
	public String toString() {
		if(directdeposit)return ("*Checking" + super.toString()+"direct deposit account*");
		return ("*Checking" + super.toString());
		
	}

}

