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

	/**
	 * Finds an account within the account database
	 * @param account to be found
	 * @return index of account, -1 if account not found
	 */
	private int find (Account account) {
		for(int i = 0; i < size; i++){
			if(account.compare(accounts[i])){
				return i;
			}
		}
		return -1;
	}

	/**
	 * Increases database size by 5
	 */
	private void grow () {
		Account[] temp = new Account[accounts.length+5];
		for(int i = 0; i < size; i++) {
			temp[i] = accounts[i];
		}
		accounts = temp;
	}
	/**
	 * Adds an account to the accounts array if it does not already exist.
	 * @param account
	 * @return False if the account already exists in the array. True if it does not.gi
	 */
	public boolean add (Account account) {
		for(int i = 0; i < size; i++){
			if(accounts[i].classType() == account.classType()) {//Checks to see if the accounts are of the same class
				if(accounts[i].compare(account)) {//Runs the abstract compare method to see if the accounts are the same
					return false;//If they are the same return false, otherwise continue
				}
			}
		}
		if(size == accounts.length){//If the array is full, call grow to increase array size by 5.
			grow();
		}
		accounts[size] = account;
		size++;
		return true;
	}
	/**
	 * Removes an account from the account database
	 * @param account to be deleted
	 * @return true if account removed, false otherwise
	 */
	public boolean remove(Account account) {
		int index = find(account);
		if(index >= 0){
			accounts[index] = accounts[size-1];
			accounts[size-1] = null;
			size--;
			return true;
		}
		return false;
	}
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
