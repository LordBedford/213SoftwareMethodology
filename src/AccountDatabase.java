/**
 * This is an array-based container class with an initial capacity of 5.
 * @author Andrew Cater, Raymund Caringal
 */
public class AccountDatabase {
	private Account[] accounts;
	private int size;
	public AccountDatabase() {
		size = 0;
		accounts = new Account[5];
	}
	
	private int find (Account account) {
		return 0;
	}
	private void grow () {
		Account[] temp = new Account[accounts.length+5];
		for(int i = 0; i < size; i++) {
			temp[i] = accounts[i];
		}
		accounts = temp;
	}
	public boolean add (Account account) {
		for(int i = 0; i < size; i++){
			if(accounts[i].getClass().equals(account.getClass())) {//Not sure if this is allowed but I can change it if its not
				return false;
			}
		}
		if(size == accounts.length){
			grow();
		}
		accounts[size] = account;
		return true;
	}
	public boolean remove(Account account) { 
		return false;
	} //return false if account doesn’t exist
	public boolean deposit(Account account, double amount) {
		return false;
	}
	//return 0: withdrawal successful, 1: insufficient funds, -1 account doesn’t exist
	public int withdrawal(Account account, double amount) { 
		return 0;
	}
	private void sortByDateOpen() {
		
	} //sort in ascending order
	private void sortByLastName() {
		
	} //sort in ascending order
	public void printByDateOpen() { 
		
	}
	public void printByLastName() { 
		
	}
	public void printAccounts() { 
		
	}
}
