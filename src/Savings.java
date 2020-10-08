/**
 * This class creates the Account Child: Savings.
 * @author Andrew Cater, Raymund Caringal
 */
public class Savings extends Account {

	private boolean isLoyal;
	
	public Savings(String fname, String lname, double initDeposit, int day, int month, int year, boolean loyal) {
		super(fname, lname, initDeposit, day, month, year);
		isLoyal = loyal;
	}

	@Override
	public double monthlyInterest() {
		if(isLoyal) return this.getBalance()*0.0035;
		return this.getBalance()*0.0025;
	}

	@Override
	public double monthlyFee() {
		if(this.getBalance() >= 300)return 0;
		
		return 5;
	}

	@Override
	public boolean compare(Account account) {
		if(account instanceof Savings){
			Savings a = (Savings) account;
			return this.getProfile().compare(a.getProfile());
		}
		return false;
	}

	@Override
	public int classType() {
		// TODO Auto-generated method stub
		return 1;
	}
	public boolean getIsLoyal(){return isLoyal;}
	
	@Override
	public String toString() {

		if(isLoyal)return ("*Savings" + super.toString()+"special Savings account*");
		return ("*Savings" + super.toString());
	}

}
