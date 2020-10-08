import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateTest {

	private static Date date;
	@BeforeAll
	
	/**
	 * Initializes date as a new Date object
	 */
	static void setUpBeforeClass(){
		date = new Date(1,1,2010);
	}

	/**
	 * Tests the isValid function of date
	 */
	@Test
	void testisValid() {
		assertTrue(date.isValid());//Date is valid
		date = new Date(1,1,-777);
		assertFalse(date.isValid());//Negative years are always invalid
		date = new Date(1,41,2010);
		assertFalse(date.isValid());//Years over 10000 are always invalid
		date = new Date(1,1,20100);
		assertFalse(date.isValid());//Day numbers over 31 are always invalid
		date = new Date(21,1,2010);
		assertFalse(date.isValid());//Months over 12 are always invalid
		date = new Date(2,31,2010);
		assertFalse(date.isValid());//Day number over total possible for said month is invalid
		date = new Date(1,31,2010);
		assertTrue(date.isValid());//Date is valid
		date = new Date(2,29,2010);
		assertFalse(date.isValid());//Febuary can only have 29 days on a leap year
		date = new Date(2,29,2012);
		assertTrue(date.isValid());//Date is valid
	}

}
