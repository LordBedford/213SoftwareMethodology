/**
 * This class creates the Account Child: Checking.
 * @author Andrew Cater, Raymund Caringal
 */
public class Checking extends Account {
	private boolean directdeposit;
	
	public Checking(String fname, String lname, double initDeposit, int day, int month, int year, boolean isDirectdeposit) {
		this.setProfile(fname, lname);
		this.setDateOpen(day, month, year);
		this.debit(initDeposit);
		directdeposit = isDirectdeposit;
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
		return(this.getProfile().compare(account.getProfile()));//Not finished but I'll get to it later
	}
}
