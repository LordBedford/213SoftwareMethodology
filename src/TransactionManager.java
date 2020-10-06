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
			if(command.length()  != 2) {
				System.out.println("Command '" + command +"' is not supported!");
			}
			else {
				action = command.charAt(0);
				accountType = command.charAt(1);
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
						
					}
					break;
					case 'W': {
						
					}
					break;
					case 'P': {
						
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
			
		}
	}
	/**
	 * Helper method or facilitate the creation of accounts after the char C is entered.
	 * @param accounts: passes the accounts varible to allow for addition to it
	 * @param scan: scan is passed to save reasourses so multiple scanners don't need to be made.
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
}
