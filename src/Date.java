/**
 * This class defines how dates are represented and compared
 * @author Andrew Cater, Raymund Caringal
 */
public class Date implements Comparable<Date> {
	private int year;
	private int month;
	private int day;
	public Date (int newDay, int newMonth, int newYear) {
		day= newDay;
		month = newMonth;
		year = newYear;
	}
	public int compareTo(Date date) {
		return 0;
	}
	public String toString() {
		return null;
	}
	public boolean isValid() {
		return false;
	}
}
