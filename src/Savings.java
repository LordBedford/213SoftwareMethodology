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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double monthlyFee() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean compare(Account account) {
		if(account instanceof Savings){
			Savings a = (Savings) account;
			return this.getProfile().compare(a.getProfile()) && this.getBalance() == a.getBalance() && this.getDateOpen() == a.getDateOpen() && this.isLoyal == a.getIsLoyal();
		}
		return false;
	}

	@Override
	public int classType() {
		// TODO Auto-generated method stub
		return 1;
	}
	public boolean getIsLoyal(){return isLoyal;}

}
