/**
 * This class creates the Account Child: MoneyMarket.
 * @author Andrew Cater, Raymund Caringal
 */
public class MoneyMarket extends Account {
	private int withdrawals;

	public MoneyMarket (String fname, String lname, double initDeposit, int day, int month, int year) {
		super(fname, lname, initDeposit, day, month, year);
		withdrawals = 0;

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
		return 2;
	}

}
