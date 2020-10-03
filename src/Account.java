/**
 * This is an abstract class that defines the common features of all account types.
 * @author Andrew Cater, Raymund Caringal
 */
public abstract class Account {
	//private Profile holder;
	private double balance;
	//private Date dateOpen;
	
	public void debit(double amount) {
		
	}
	public void credit(double amount) {
		
	}
	public String toString() {
		return null;
	}
	public abstract double monthlyInterest ();
	public abstract double monthlyFee();
}
