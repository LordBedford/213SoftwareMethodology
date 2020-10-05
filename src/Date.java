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

	/**
	 * Checks date provided against current date, does not check for date validity
	 * @param date to be checked
	 * @return 0 if dates are equal, -1 if date is before then current date, 1 if date is after the current date
	 */
	public int compareTo(Date date) {
		if(year == date.getYear()){
			if(month == date.getMonth()){
				if(day == date.getDay()){
					return 0;
				}else if(day < date.getDay()){
					return -1;
				}
			}else if(month < date.getMonth()){
				return -1;
			}
		}else if(year < date.getYear()){
			return -1;
		}
		return 1;
	}

	/**
	 * Prints the current date
	 * @return the date
	 */
	@Override
	public String toString() {
		return  month + "/" +day + "/" + year;
	}

	/**
	 * Checks if current date is a real date
	 * @return true if a valid date, false otherwise
	 */
	public boolean isValid() {
		if( (month > 0 && month < 13) && (day > 0 && day < 31) && (year > 0 && year < 10000)){
			return  true;
		}
		return false;
	}

	public int getYear() {return year;}
	public int getMonth() {return month;}
	public int getDay() {return day;}

}
