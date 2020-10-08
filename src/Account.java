import java.text.DecimalFormat;
/**
 * This is an abstract class that defines the common features of all account types.
 * @author Andrew Cater, Raymund Caringal
 */
public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;

	/**
	 * Generates an Account Object
	 * @param fname first name
	 * @param lname last name
	 * @param initDeposit initial account deposit
	 * @param day between 1 and 30, otherwise an invalid date
	 * @param month between 1 and 12, other wise an invalid date
	 * @param year between 0 and 10000, otherwise an invalid date
	 */
	public Account(String fname, String lname, double initDeposit, int day, int month, int year){
		holder = new Profile(fname, lname);
		dateOpen = new Date(day,month,year);
		balance = initDeposit;
	}

	/**
	 * Decrease balance by amount
	 * @param amount to be removed
	 */
	public void debit(double amount) {
		balance -= amount;
	}

	/**
	 * Increase balance by amount
	 * @param amount to be added
	 */
	public void credit(double amount) { balance += amount;	}

	/**
	 * Prints the Account
	 * @return Account as a string
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return( "*"+holder.getFname() + " " + holder.getLname() + "* $" + df.format(balance) +"*"+dateOpen.toString()+"*");
		
	}
	public abstract double monthlyInterest ();
	public abstract double monthlyFee();
	public abstract boolean compare(Account account);
	public abstract int classType();

	/**
	 * Get account balance
	 * @return acount's balance as a double
	 */
	public double getBalance () {
		return balance;
	}

	/**
	 * Get First name and Last name of account
	 * @return Name as a Profile
	 */
	public Profile getProfile () {
		return holder;
	}

	/**
	 * Get's the date the account was open
	 * @return Date object
	 */
	public Date getDateOpen() {return dateOpen;}

	/**
	 * Sets balance to specified amount
	 * @param balance the specified amount
	 */
	public void setBalance(double balance) {this.balance = balance;}
}
