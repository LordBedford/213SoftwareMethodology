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

/**
 * A shopping bag to hold all grocery items. Contains all methods to add and remove items into/within the container.
 * @author Andrew Cater, Raymund Caringal
 */
public class ShoppingBag {
	private GroceryItem[] bag;
	private int size;
	public ShoppingBag() { 
		bag = new GroceryItem[5];
		size = 0;
	}

	/**
	 * Finds the index of grocery item to be removed
	 * @param item to be found
	 * @return index of grocery item, otherwise -1
	 */
	private int find(GroceryItem item) {
		for(int i = 0; i < size; i++){
			if(item.equals(bag[i])){
				return i;
			}
		}
		return -1;
	}


	//Increase the bag size by 5
	private void grow() {
		GroceryItem[] temp = new GroceryItem[(bag.length + 5)];//makes a new array that is 5 larger than bag
		for(int i = 0; i <bag.length; i++){
			temp[i] = bag[i];//Puts everything in bag in the temp array
		}
		bag = temp;//Bag is set to the temp array
	}

	/**
	 * Adds Item to the bag
	 * @param item to be added
	 */
	public void add(GroceryItem item) {
		if(size >= bag.length) {//Checks to see if the bag is currently full
			grow();//If full call the grow function
		}
		bag[size] = item;//Adds item to the bag and increments size by 1
		size++;
	}

	/**
	 * Remove an item from the bag. Find the index of the item to be removed and move the last item in the array to replace the item using the index.
	 * @param item to be removed
	 * @return true if item was found, false otherwise
	 */
	public boolean remove(GroceryItem item) {
		int index = find(item);
		if(index >= 0){
			for(; index < size; index++){
				bag[index] = bag[index+1];
			}
			bag[index] = null;
			size--;
		}else{
			System.out.println("Unable to remove, this item is not in the bag.");
		}
		/*The remove() method calls the helper method find() and finds the index of the grocery item to be removed.
		Move the last item in the array to replace the removing item with the index, and set the reference of the
		last item to null.
		*/
		return false;
	}
	public float salesPrice() {
		float cost = 0;
		for(int i = 0; i < size; i++) {
			cost = cost + bag[i].getCost();
		}
		
		return cost;
	}
	public float salesTax() {
		float cost = 0;
		for(int i = 0; i < size; i++) {
			if(bag[i].getTaxable()) {
				cost = cost + bag[i].getCost();
			}
		}
		cost = (float)(cost * 0.06625);
		return (float)cost;
	}
	//Returns the value of the private size Variable for use in RunProject1
	public int getSize() {
		return size;
	}
	public void print() {
		for(int i = 0; i < size; i++) {
			System.out.println(bag[i].toString());
		}
		System.out.println("**End of list");
	}
	public void emptyBag() {
		for(int i = 0; i < size; i++) {
			bag[i] = null;
		}
		size = 0;
	}
}

