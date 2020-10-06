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

	/**
	 * Depostis money to an account within the account database
	 * @param account to deposit too
	 * @param amount to be depsoited
	 * @return true if account exists and amount is deposited, false is the account does not exist
	 */
	public boolean deposit(Account account, double amount) {
		int index = find(account);
		if(index< 0){
			return  false;
		}
		double balance = accounts[index].getBalance();
		accounts[index].setBalance(balance+amount);
		return  true;
	}

	/**
	 * Withdraws money from an account within the account database
	 * @param account to withdraw from
	 * @param amount to be withdrawn
	 * @return 0 if withdrawal is successful, 1 if there are insufficient funds, and -1 if account doesn’t exist
	 */
	public int withdrawal(Account account, double amount) {
		int index = find(account);
		if(index< 0){
			return -1;
		}
		double balance = accounts[index].getBalance();
		if(amount > balance){
			return 1;
		}
		accounts[index].setBalance(balance-amount);
		return 0;
	}

	/**
	 * Uses Bubble Sort to sort all accounts in Account Database in Ascending Order by date
	 */
	private void sortByDateOpen() {
		for (int x = 0; x < size; x++) {
			for (int y = x + 1; y < size; y++) {
				Account tmp;
				if (accounts[x].getDateOpen().compareTo(accounts[y].getDateOpen()) < 0) {
					tmp = accounts[x];
					accounts[x] = accounts[y];
					accounts[y] = tmp;
				}
			}
		}
	}

	/**
	 * Uses Bubble Sort to sort all accounts in Account Database in Ascending Order by Last Name
	 */
	private void sortByLastName() {
		for (int x = 0; x < size; x++) {
			for (int y = x + 1; y < size; y++) {
				Account tmp;
				if (accounts[x].getProfile().getLname().compareTo(accounts[y].getProfile().getLname()) > 0) {
					tmp = accounts[x];
					accounts[x] = accounts[y];
					accounts[y] = tmp;
				}
			}
		}
	}
	public void printByDateOpen() { 
		
	}
	public void printByLastName() { 
		
	}
	public void printAccounts() { 
		
	}
}
