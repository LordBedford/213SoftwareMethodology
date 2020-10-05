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
					case 'O':{//This is probably not optimal but its probably gonna work
						switch (accountType) {
							case 'C':{
								if(accounts.add(new Checking(scan.next(),scan.next(),scan.nextDouble(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextBoolean()))) {
									System.out.println("Success!");
								}
								else {
									System.out.println("Failure");
								}
								
							}
							break;
							case 'S': {
								if(accounts.add(new Savings(scan.next(),scan.next(),scan.nextDouble(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextBoolean()))) {
									System.out.println("Success!");
								}
								else {
									System.out.println("Failure");
								}
								
							}
							break;
							case 'M': {
								if(accounts.add(new MoneyMarket(scan.next(),scan.next(),scan.nextDouble(),scan.nextInt(),scan.nextInt(),scan.nextInt()))) {
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
					break;
					case 'C': {
						
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
}
