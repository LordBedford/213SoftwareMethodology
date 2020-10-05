/**
 * This class creates the Account Child: Savings.
 * @author Andrew Cater, Raymund Caringal
 */
public class Savings extends Account {

	private boolean isLoyal;
	
	public Savings(String fname, String lname, double initDeposit, int day, int month, int year, boolean loyal) {
		this.setProfile(fname, lname);
		this.setDateOpen(day, month, year);
		this.debit(initDeposit);
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
		return(this.getProfile().compare(account.getProfile()));//Not finished but I'll get to it later, only compares names currently
	}

	@Override
	public int classType() {
		// TODO Auto-generated method stub
		return 1;
	}

}
