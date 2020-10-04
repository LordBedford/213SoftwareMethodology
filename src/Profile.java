/**
 * This class defines the profile of an account holder.
 * @author Andrew Cater, Raymund Caringal
 */
public class Profile {
	private String fname;
	private String lname;
	public Profile (String first, String last) {
		fname = first;
		lname = last;
	}
	public boolean compare(Profile temp) {
		return((fname.equals(temp.getFname()))&&(lname.equals(temp.getLname())));
	}
	
	public String getFname () {
		return fname;
	}
	
	public String getLname () {
		return lname;
	}
	
}
