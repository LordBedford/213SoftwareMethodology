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

		return this.getBalance()*0.0065;
	}

	@Override
	public double monthlyFee() {
		if(this.getBalance() > 2500 && withdrawals <= 6) return 0;
		return 12;
	}

	@Override
	public boolean compare(Account account) {
		if(account instanceof MoneyMarket){
			MoneyMarket a = (MoneyMarket) account;
			return this.getProfile().compare(a.getProfile());
		}
		return false;
	}

	@Override
	public int classType() {
		// TODO Auto-generated method stub
		return 2;
	}

	public int getWithdrawals(){return withdrawals;}
	
	@Override
	public String toString() {
		return ("*Money Market" + super.toString()+withdrawals+" withdrawls*");
	}
	public void withdraw() {
		withdrawals++;
	}
}
