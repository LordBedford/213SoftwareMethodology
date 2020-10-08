/**
 * This is the user interface class that handles the transactions and displays the
 * results on the console.
 * @author Andrew Cater, Raymund Caringal
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class TransactionManager {
	public void run() {
		AccountDatabase accounts = new AccountDatabase();
		String command = "";
		char action=' ';
		char accountType;
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		System.out.println("Transaction processing starts...");
		while(running) {
			command = scan.next();
			if(command.length()  > 2) {
				System.out.println("Command '" + command +"' is not supported!");
				scan.nextLine();
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
					scan.nextLine();
					}
				}
					
			}

			//To clear Scanner if there's anything left over
			//if(action != 'Q' && scan.hasNext()){
				//scan.nextLine();}
		}
	}
	/**
	 * Helper method or facilitate the creation of accounts after the char C is entered.
	 * @param accounts: passes the accounts variable to allow for addition to it
	 * @param scan: scan is passed to save resources so multiple scanners don't need to be made.
	 * @param command: is passed for simplicity and is used to determine the type of account to create.
	 */
	private void createAccount(AccountDatabase accounts, Scanner scan, String command) {
		char accountType;
		String fname;
		String lname;
		double deposit;
		String date;
		String[] dateSplit;
		int day;
		int month;
		int year;
		try {
			accountType = command.charAt(1);
			fname = scan.next();
			lname = scan.next();
			deposit = scan.nextDouble();
			date = scan.next();
			dateSplit  = date.split("/");
			day = Integer.parseInt(dateSplit[0]);
			month = Integer.parseInt(dateSplit[1]);
			year = Integer.parseInt(dateSplit[2]);
		}
		catch(InputMismatchException e) {
			System.out.println("Input data type mismatch.");
			scan.nextLine();
			return;
		}
		Date test = new Date(day,month,year);
		if(!(test.isValid())) {
			System.out.println(test.toString() + " is not a valid date!");
			scan.nextLine();
			return;
		}
		switch (accountType) {
		case 'C':{
			boolean temp = false;
			try {
				temp = scan.nextBoolean();
			}
			catch(InputMismatchException e){
				System.out.println("Input data type mismatch.");
				scan.nextLine();
				return;
			}
			if(accounts.add(new Checking(fname,lname,deposit,day,month,year,temp))) {
				System.out.println("Account opened and added to the database.");
			}
			else {
				System.out.println("Account is already in the database.");
			}
			
		}
		break;
		case 'S': {
			boolean temp = false;
			try {
				temp = scan.nextBoolean();
			}
			catch(InputMismatchException e){
				System.out.println("Input data type mismatch.");
				scan.nextLine();
				return;
			}
			if(accounts.add(new Savings(fname,lname,deposit,day,month,year,temp))) {
				System.out.println("Account opened and added to the database.");
			}
			else {
				System.out.println("Account is already in the database.");
			}
			
		}
		break;
		case 'M': {
			if(accounts.add(new MoneyMarket(fname,lname,deposit,day,month,year))) {
				System.out.println("Account opened and added to the database.");
			}
			else {
				System.out.println("Account is already in the database.");
			}
			
		}
		break;
		default:{
			System.out.println("Command '" + command +"' is not supported!");
			scan.nextLine();
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
		char accountType;
		String fname;
		String lname;
		int day;
		int month;
		int year;
		try {
			accountType = command.charAt(1);
			fname = scan.next();
			lname = scan.next();
		}
		catch(InputMismatchException e) {
			System.out.println("Input data type mismatch.");
			scan.nextLine();
			return;
		}
		String temp;
		switch (accountType) {
			case 'C':{
				if(accounts.remove(new Checking(fname, lname, 0,1,1,2000, true))) {
					System.out.println("Account closed and removed from the database.");
				}
				else {
					System.out.println("Account does not exist.");
				}
			}
			break;
			case 'S': {
				if(accounts.remove(new Savings(fname, lname, 0,1,1,2000, true))) {
					System.out.println("Account closed and removed from the database..");
				}
				else {
					System.out.println("Account does not exist.");
				}

			}
			break;
			case 'M': {
				if(accounts.remove(new MoneyMarket(fname, lname, 0,1,1,2000))){
					System.out.println("Account closed and removed from the database.");
				}
				else {
					System.out.println("Account does not exist.");
				}

			}
			break;
			default:{
				System.out.println("Command '" + command +"' is not supported!");
				scan.nextLine();
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
		String fname="";
		String lname="";
		double amount=0;
		Account account;
		try {
			fname = scan.next();
			lname = scan.next();
			amount = scan.nextDouble();
		}
		catch (InputMismatchException e) {
			System.out.println("Input data type mismatch.");
			scan.nextLine();
			return;
		}

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
				scan.nextLine();
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
				System.out.println(amount + " withdrawn from account");
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
