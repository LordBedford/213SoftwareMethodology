/*
Things to remember: 
1) No reading or printing to console in this class

*/


import java.util.Objects;

/**
 * An abstract data type to encapsulate the data fields and methods of a grocery item.
 * @author Andrew Cater, Raymund Caringal
 */
public class GroceryItem {
	private String name;
	private float price;
	private boolean taxable;
	public GroceryItem(String item, float cost, boolean isTaxable) {
		name  = item;
		price = cost;
		taxable = isTaxable;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(this == null || (!(obj instanceof GroceryItem)))
			return false;
		GroceryItem item = (GroceryItem) obj;
		return Objects.equals(name, item.name) && Objects.equals(price, item.price) && Objects.equals(taxable, item.taxable);
	}

	@Override
	public String toString() {
		//Return Style should mimic: itemName: $xx.xx : tax free
		String ret = name;
		ret  = ret.concat(": $" + price + " : ");
		if(taxable) {
			ret = ret.concat("is taxable");
		}
		else {
			ret = ret.concat("tax free");
		}
		return ret;//placeholder
	}
}
