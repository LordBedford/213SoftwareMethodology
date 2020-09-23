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


	/**
	 * Increases bag size by 5
	 */
	private void grow() {
		GroceryItem[] temp = new GroceryItem[(bag.length + 5)];
		for(int i = 0; i <bag.length; i++){
			temp[i] = bag[i];
		}
		bag = temp;
	}

	/**
	 * Adds Item to the bag
	 * @param item to be added
	 */
	public void add(GroceryItem item) {
		if(size >= bag.length) {
			grow();
		}
		bag[size] = item;
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
			bag[index] = bag[size-1];
			bag[size-1] = null;
			size--;
			return true;
		}
		return false;
	}

	/**
	 * Finds the total cost of all bag items without tax
	 * @return the sum of all prices in the bag
	 */
	public float salesPrice() {
		float cost = 0;
		for(int i = 0; i < size; i++) {
			cost = cost + bag[i].getCost();
		}
		
		return cost;
	}

	/**
	 * Finds the total tax of items in the bag
	 * @return sum of the tax for all taxable items
	 */
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

	/**
	 * Returns the value of the private size Variable for use in RunProject1
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Displays all items within the bag.
	 */
	public void print() {
		for(int i = 0; i < size; i++) {
			System.out.println("."+bag[i].toString());
		}
		System.out.println("**End of list");
	}

	/**
	 * Empties the entire bag and resets the size
	 */
	public void emptyBag() {
		for(int i = 0; i < size; i++) {
			bag[i] = null;
		}
		size = 0;
	}
}

