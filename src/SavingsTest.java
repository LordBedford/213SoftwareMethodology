import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SavingsTest {
	/**
	 * Initiates sav as a new Save object
	 */
private static Savings sav;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sav = new Savings("John","Doe",500,1,1,2010,true);
	}
	@Before
	static void setUpBefore() throws Exception {
		sav = new Savings("John","Doe",500,1,1,2010,true);
	}
	/**
	 * Tests to see if monthly interest is calculated properly.
	 */
	@Test
	void testMonthlyIntrest() {
		assertTrue(sav.monthlyInterest()==1.75);//This test is done on a special savings account and expects a 0.35% interest rate
		sav = new Savings("John","Doe",500,1,1,2010,false);
		assertTrue(sav.monthlyInterest()==1.25);//This test is done on a non special savings account and expects a 0.25% interest rate
	}
	/**
	 * Tests to see if monthly fee is calculated properly.
	 */
	@Test
	void testMonthlyFee() {
		assertTrue(sav.monthlyFee()==0);//Account is >300 so it should have a fee of 0
		sav = new Savings("John","Doe",200,1,1,2010,false);
		assertTrue(sav.monthlyFee()==5);//Account now has < 300 so it should have a fee of 5
	}
}
