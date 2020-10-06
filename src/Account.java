/**
 * This is an abstract class that defines the common features of all account types.
 * @author Andrew Cater, Raymund Caringal
 */
public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;

	public Account(String fname, String lname, double initDeposit, int day, int month, int year){
		holder = new Profile(fname, lname);
		dateOpen = new Date(day,month,year);
		balance = initDeposit;
	}

	public void debit(double amount) {
		balance -= amount;
	}
	public void credit(double amount) { balance += amount;	}
	public String toString() {
		return null;
	}
	public abstract double monthlyInterest ();
	public abstract double monthlyFee();
	public abstract boolean compare(Account account);
	public abstract int classType();
	public double getBalance () {
		return balance;
	}
	/*public void setProfile(String fname, String lname) {
		holder = new Profile(fname, lname);
	}*/
	public Profile getProfile () {
		return holder;
	}
	/*public void setDateOpen (int day, int month, int year) {
		dateOpen = new Date(day,month,year);
	}
	 */
}
