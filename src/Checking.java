/**
 * This class creates the Account Child: Checking.
 * @author Andrew Cater, Raymund Caringal
 */
public class Checking extends Account {
	private boolean directdeposit;
	
	public Checking(String fname, String lname, double initDeposit, int day, int month, int year, boolean isDirectdeposit) {
		super(fname, lname, initDeposit, day, month, year);
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
		if(account instanceof Checking){
			Checking a = (Checking) account;
			return this.getProfile().compare(a.getProfile());
		}
		return false;
	}

	@Override
	public int classType() {
		return 0;
	}

	public boolean getDirectDeposit(){return directdeposit;}

}

