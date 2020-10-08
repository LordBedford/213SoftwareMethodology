/**
 * This class defines the profile of an account holder.
 * @author Andrew Cater, Raymund Caringal
 */
public class Profile {
	private String fname;
	private String lname;

	/**
	 * Generates a Profile
	 * @param first name
	 * @param last name
	 */
	public Profile (String first, String last) {
		fname = first;
		lname = last;
	}

	/**
	 * Checks to see if the specified Profile is the current profile
	 * @param temp specified profile
	 * @return true if the specified profile is the current profile, false otherwise
	 */
	public boolean compare(Profile temp) {
		return((fname.equals(temp.getFname()))&&(lname.equals(temp.getLname())));
	}

	/**
	 * Gets the first name
	 * @return first name
	 */
	public String getFname () {
		return fname;
	}

	/**
	 * Gets the last name
	 * @return last name
	 */
	public String getLname () {
		return lname;
	}
	
}
