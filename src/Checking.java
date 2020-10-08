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
		return this.getBalance()*0.0005;
	}

	@Override
	public double monthlyFee() {
		if(this.getBalance() >= 1500 || directdeposit)return 0;
		
		return 25;
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
	@Override
	public String toString() {
		if(directdeposit)return ("*Checking" + super.toString()+"direct deposit account*");
		return ("*Checking" + super.toString());
		
	}

}

