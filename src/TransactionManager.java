/**
 * This is the user interface class that handles the transactions and displays the
 * results on the console.
 * @author Andrew Cater, Raymund Caringal
 */
import java.util.Scanner;
public class TransactionManager {
	public void run() {
		AccountDatabase accounts = new AccountDatabase();
		String command = "";
		char action;
		char accountType;
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		System.out.println("Transaction processing starts...");
		while(running) {
			command = scan.next();
			if(command.length()  > 2) {
				System.out.println("Command '" + command +"' is not supported!");
			}
			else {
				action = command.charAt(0);
				if(command.length() == 2)accountType = command.charAt(1);
				
				switch (action) {
					case 'O':{
						createAccount(accounts, scan, command);
					}
					break;
					case 'C': {
						closeAccount(accounts, scan,command);
					}
					break;
					case 'D': {
						accountDirector(accounts,scan,command,'D');
					}
					break;
					case 'W': {
						accountDirector(accounts,scan,command,'W');
					}
					break;
					case 'P': {
						printHelper(accounts, scan,command);
					}
					break;
					case 'Q': { System.out.println("Transaction processing completed.");
						running = false;
					}
					break;
					default : { System.out.println("Command '" + command +"' is not supported!");
					}
				}
					
			}

			//To clear Scanner if there's anything left over
			if(scan.hasNext()){
				scan.nextLine();}
		}
	}
	/**
	 * Helper method or facilitate the creation of accounts after the char C is entered.
	 * @param accounts: passes the accounts variable to allow for addition to it
	 * @param scan: scan is passed to save resources so multiple scanners don't need to be made.
	 * @param command: is passed for simplicity and is used to determine the type of account to create.
	 */
	private void createAccount(AccountDatabase accounts, Scanner scan, String command) {
		char accountType = command.charAt(1);
		String fname = scan.next();
		String lname = scan.next();
		double deposit = scan.nextDouble();
		String date = scan.next();
		String[] dateSplit  = date.split("/");
		int day = Integer.parseInt(dateSplit[0]);
		int month = Integer.parseInt(dateSplit[1]);
		int year = Integer.parseInt(dateSplit[2]);
		String temp;
		switch (accountType) {
		case 'C':{
			temp = scan.next();
			if(accounts.add(new Checking(fname,lname,deposit,day,month,year,Boolean.parseBoolean(temp)))) {
				System.out.println("Success!");
			}
			else {
				System.out.println("Failure");
			}
			
		}
		break;
		case 'S': {
			temp = scan.next();
			if(accounts.add(new Savings(fname,lname,deposit,day,month,year,Boolean.parseBoolean(temp)))) {
				System.out.println("Success!");
			}
			else {
				System.out.println("Failure");
			}
			
		}
		break;
		case 'M': {
			if(accounts.add(new MoneyMarket(fname,lname,deposit,day,month,year))) {
				System.out.println("Success!");
			}
			else {
				System.out.println("Failure");
			}
			
		}
		break;
		default:{
			System.out.println("Command '" + command +"' is not supported!");
		}
	}
	}
	/**
	 * Helper method or facilitate the removal of accounts after the char C is entered.
	 * @param accounts: passes the accounts varible to allow for addition to it
	 * @param scan: scan is passed to save reasourses so multiple scanners don't need to be made.
	 * @param command: is passed for simplicity and is used to determine the type of account to create.
	 */
	private void closeAccount(AccountDatabase accounts, Scanner scan, String command) {
		char accountType = command.charAt(1);
		String fname = scan.next();
		String lname = scan.next();
		double deposit = scan.nextDouble();
		String date = scan.next();
		String[] dateSplit  = date.split("/");
		int day = Integer.parseInt(dateSplit[0]);
		int month = Integer.parseInt(dateSplit[1]);
		int year = Integer.parseInt(dateSplit[2]);
		String temp;
		switch (accountType) {
			case 'C':{
				temp = scan.next();
				if(accounts.remove(new Checking(fname,lname,deposit,day,month,year,Boolean.parseBoolean(temp)))) {
					System.out.println("Success!");
				}
				else {
					System.out.println("Failure");
				}

			}
			break;
			case 'S': {
				temp = scan.next();
				if(accounts.remove(new Savings(fname,lname,deposit,day,month,year,Boolean.parseBoolean(temp)))) {
					System.out.println("Success!");
				}
				else {
					System.out.println("Failure");
				}

			}
			break;
			case 'M': {
				if(accounts.remove(new MoneyMarket(fname,lname,deposit,day,month,year))) {
					System.out.println("Success!");
				}
				else {
					System.out.println("Failure");
				}

			}
			break;
			default:{
				System.out.println("Command '" + command +"' is not supported!");
			}
		}
	}

	/**
	 * Helper method to deposit/withdraw to the proper account
	 * @param accounts the account database
	 * @param scan commandline scanner for user input
	 * @param command the account type
	 * @param type W if withdrawing, D if Depositing
	 */
	private void accountDirector(AccountDatabase accounts, Scanner scan, String command, char type){
		char accountType = command.charAt(1);
		String fname = scan.next();
		String lname = scan.next();
		double amount = scan.nextDouble();
		Account account;

		//Accounts here use dummy input as we're only looking for the name
		switch (accountType) {
			case 'C':{
				account = new Checking(fname, lname, 0,1,1,2000, true);
			}
			break;
			case 'S': {
				account = new Savings(fname, lname, 0,1,1,2000, true);
			}
			break;
			case 'M': {
				account = new MoneyMarket(fname, lname, 0,1,1,2000);
			}
			break;
			default:{
				System.out.println("Command '" + command +"' is not supported!");
				return;
			}
		}
		if(type == 'D'){
			if(accounts.deposit(account, amount)){
				System.out.println(amount + " deposited to account");
			}else{
				System.out.println("Account does not exist");
			}
		}else{
			int status = accounts.withdrawal(account, amount);
			if(status == 0){
				System.out.println(amount + " deposited to account");
			}else if(status == 1) {
				System.out.println("Insufficient funds");
			}else{
				System.out.println("Account does not exist");
			}
		}
	}
	private void printHelper(AccountDatabase accounts, Scanner scan, String command) {
		char type = command.charAt(1);
		switch (type) {
			case 'A': {
				accounts.printAccounts();
			}
			break;
			case 'D': {
				accounts.printByDateOpen();
			}
			break;
			case 'N':{
				accounts.printByLastName();
			}
			break;
			default:{
				
			}
		}
	}
}
