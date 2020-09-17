/*
 * This class is the user interface class that handles the input commands, output data and messages.
 */
import java.util.Scanner;

public class Shopping {
	public void run() {
		//Initializing Variables for shopping. 
		boolean shopping = true;
		char command = ' ';
		Scanner scan  = new Scanner(System.in);
		ShoppingBag bag = new ShoppingBag();
		
		//Begin shopping run
		System.out.println("Let's start shopping!");
		while(shopping) {
			//Scan in the item
			command = scan.next().charAt(0);
			String name;
			//Process command
			switch (command) {
				case 'A' :{
					name = scan.next();
					bag.add(new GroceryItem(name, scan.nextFloat(), scan.nextBoolean()));//Adds Item to cart
					System.out.println(name + "  added to the bag");
				}
				break;
				
				case 'R' :{ 
					name = scan.next();
					bag.remove(new GroceryItem(name, scan.nextFloat(), scan.nextBoolean()));//Removes Item from cart
				}
				break;
				
				case 'P' : bag.print(); //Calls the print command in ShoppingBag
				break;
				
				case 'C' :	checkout(bag);//Calls the private method checkout
				break;
				
				case 'Q' : { //Checks bag size, if not empty it calls the private method checkout
						if(bag.getSize() >0) {
							checkout(bag);
						}
						System.out.println("Have a great day!");
						shopping = false;
				}
				break;
				default : System.out.println("Invalid Command!");
							scan.nextLine();
				break;	
			}
		}
	}

	private void checkout(ShoppingBag bag) {//Helper method to process checking out
		int size = bag.getSize();
		if(size > 0) {
			System.out.println("Checking out " + size + " items!");
			bag.print();
			
		}
		else {
			System.out.println("Unable to check out, the bag is empty!");
				
		}
	}
}
