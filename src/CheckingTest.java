import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckingTest {
	private static Checking che;
	@BeforeAll
	/**
	 * Initializes che as a checking object
	 */
	static void setUpBeforeClass(){
		che = new Checking("John","Doe",500,1,1,2010,true);
	}

	/**
	 * Tests to see if monthly interest is calculated properly.
	 */
	@Test
	void testMonthlyIntrest() {
		assertTrue(che.monthlyInterest()==0.25);//This test has a balance of 500 and expects a 0.05% interest rate or 0.25
		che = new Checking("John","Doe",1000,1,1,2010,true);
		assertTrue(che.monthlyInterest()==0.5);//This test has a balance of 1000 and expects a 0.05% interest rate or 0.5
	}
	/**
	 * Tests to see if monthly fee is calculated properly.
	 */
	@Test
	void testMonthlyFee() {
		che = new Checking("John","Doe",1000,1,1,2010,true);
		assertTrue(che.monthlyFee()==0);//This test has direct deposit and expects a fee of 0
		che = new Checking("John","Doe",1000,1,1,2010,false);
		assertTrue(che.monthlyFee()==25);//This test has no direct deposit and expects a fee of 25
		che = new Checking("John","Doe",2000,1,1,2010,false);
		assertTrue(che.monthlyFee()==0);//This test has direct deposit a balance of 2000 and expects a fee of 0
		
	}

}
