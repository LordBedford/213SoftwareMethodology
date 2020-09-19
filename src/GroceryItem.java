import java.util.Objects;

/**
 * An abstract data type to encapsulate the data fields and methods of a grocery item.
 * @author Andrew Cater, Raymund Caringal
 */
public class GroceryItem {
	private String name;
	private float price;
	private boolean taxable;

	/**
	 * Generates Grocery Item Details
	 * @param item the name
	 * @param cost the price
	 * @param isTaxable whether or not the item is taxable
	 */
	public GroceryItem(String item, float cost, boolean isTaxable) {
		name  = item;
		price = cost;
		taxable = isTaxable;
	}

	/**
	 * Checks for equality between obj and the current GroceryItem
	 * @param obj the obj to be compared
	 * @return true if the object is equal to the current GroceryItem, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(this == null || (!(obj instanceof GroceryItem)))
			return false;
		GroceryItem item = (GroceryItem) obj;
		return Objects.equals(name, item.name) && Objects.equals(price, item.price) && Objects.equals(taxable, item.taxable);
	}

	/**
	 * 	Grocery Item variables
	 * @return itemName: $xx.xx : tax free
	 */
	@Override
	public String toString() {
		String ret = name;
		ret  = ret.concat(": $" + price + " : ");
		if(taxable) {
			ret = ret.concat("is taxable");
		}
		else {
			ret = ret.concat("tax free");
		}
		return ret;
	}
	/**
	 * Returns the price of the GroceryItem
	 */
	public float getCost() {
		return price;
	}
	/**
	 * Returns the boolean taxable
	 */
	public boolean getTaxable() {
		return taxable;
	}
}
