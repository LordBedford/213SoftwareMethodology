import java.util.Scanner;

/**
 * This class is the user interface class that handles the input commands, output data and messages.
 * @author Andrew Cater, Raymund Caringal
 */
public class Shopping {
	/**
	 * Runs the shopping simulation
	 */
	public void run() {
		boolean shopping = true;
		char command = ' ';
		Scanner scan = new Scanner(System.in);
		ShoppingBag bag = new ShoppingBag();
		System.out.println("Let's start shopping!");
		while(shopping) {
			command = scan.next().charAt(0);
			String name;
			switch (command) {
				case 'A' :{
					name = scan.next();
					bag.add(new GroceryItem(name, scan.nextFloat(), scan.nextBoolean()));
					System.out.println(name + " added to the bag");
				}
				break;
				
				case 'R' :{ 
					name = scan.next();
					bag.remove(new GroceryItem(name, scan.nextFloat(), scan.nextBoolean()));
				}
				break;
				
				case 'P' : printBag(bag);
				break;
				
				case 'C' :	checkout(bag);
				break;
				
				case 'Q' : {
						if(bag.getSize() > 0) {
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

	/**
	 * Checks out all items within the shopping bag, emptying, listing, and summing all the items.
	 * @param bag to be checked out and emptied
	 */
	private void checkout(ShoppingBag bag) {
		int size = bag.getSize();
		if(size > 0) {
			System.out.println("Checking out " + size + " items!");
			bag.print();
			System.out.println("Sales Total: $" + bag.salesPrice());
			System.out.printf("Sales tax: $"+"%.2f" , bag.salesTax());
			System.out.println();
			System.out.printf("Total Amount Paid: $"+("%.2f") , (bag.salesPrice() + bag.salesTax()));
			System.out.println();
			bag.emptyBag();
		}
		else {
			System.out.println("Unable to check out, the bag is empty!");
				
		}
	}

	/**
	 * Displays all items within the bag.
	 * @param bag to be displayed
	 */
	private void printBag(ShoppingBag bag) {
		int size = bag.getSize();
		if(size > 0) {
			System.out.println("You have " + size + " items in the bag.");
			bag.print();
			
		}
		else {
			System.out.println("Bag is Empty!");
				
		}
	}
}
