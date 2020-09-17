/*
 This is the container class that defines the abstract data type for a shopping bag and its operations. A
shopping bag holds an array of grocery items. You CANNOT add other data members, and you CANNOT
change the signatures of the methods. -2 points for each violation. You must implement all the methods
listed, -2 points for each method not implemented or not used. You can add other methods if necessary. 
  
 You CANNOT do I/O in this class, except the print() method, -2 points for each violation.
  
 You MUST design the test cases for testing add(), remove(), grow() and salesTax() methods. The test
cases must be documented in a test document. You must follow the instructions in the “Test Specification”
section of the Software Development Ground Rules. You will lose 5 points if you do not submit the test
document, or not follow the format.

You must write a test bed main for this class to implement the test cases in the test document, -1 points
for each method not tested. In the testbed main, you MUST print out the results to the console showing
the test cases are passed.
*/

public class ShoppingBag {
	private GroceryItem[] bag;
	private int find(GroceryItem item) {
		return 0;//placeholder
	}
	private void grow() {
		
	}
	public void add(GroceryItem item) {
		
	}
	public boolean remove(GroceryItem item) {
		/*The remove() method calls the helper method find() and finds the index of the grocery item to be removed.
		Move the last item in the array to replace the removing item with the index, and set the reference of the
		last item to null.
		*/
		return false;//placeholder
	}
	public double salesPrice() {
		return 0;//placeholder
	}
	public double salesTax() {
		return 0;//placeholder
	}
	public void print() {
		
	}
}

