/**
 * This is an abstract class that defines the common features of all account types.
 * @author Andrew Cater, Raymund Caringal
 */
import java.text.DecimalFormat;
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
		DecimalFormat df = new DecimalFormat("0.00");
		
		return( "*"+holder.getFname() + " " + holder.getLname() + "* $" + df.format(balance) +"*"+dateOpen.toString()+"*");
		
	}
	public abstract double monthlyInterest ();
	public abstract double monthlyFee();
	public abstract boolean compare(Account account);
	public abstract int classType();
	public double getBalance () {
		return balance;
	}

	public Profile getProfile () {
		return holder;
	}

	public Date getDateOpen() {return dateOpen;}

	public void setBalance(double balance) {this.balance = balance;}
}
