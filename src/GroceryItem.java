/*
Things to remember: 
1) No reading or printing to console in this class

*/



public class GroceryItem {
	//default variables and methods copied from handout
	private String name;
	private double price;
	private boolean taxable;
	public GroceryItem(String item, float cost, boolean isTaxable) {
		name  = item;
		price = cost;
		taxable = isTaxable;
	}
	public boolean equals(Object obj) {
		//only returns true if all data fields are the same
		return false;//placeholder
	}
	public String toString() {
		//Return Style should mimic: itemName: $xx.xx : tax free
		return null;//placeholder
	}
}
