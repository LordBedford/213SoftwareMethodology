import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyMarketTest {

	private static MoneyMarket mar;
	/**
	 * Initiates mar as a new MoneyMarket object
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		mar = new MoneyMarket("John","Doe",500,1,1,2010);
	}
	/**
	 * Tests to see if monthly interest is calculated properly.
	 */
	@Test
	void testMonthlyIntrest() {
		assertTrue(mar.monthlyInterest()==3.25);//This test has a balance of 500 and expects a 0.65% interest rate/3.25
		mar = new MoneyMarket("John","Doe",2800,1,1,2010);
		assertTrue(mar.monthlyInterest()==18.2);//This test has a balance of 2800 and expects a 0.65% interest rate/18.2
	}
	/**
	 * Tests to see if monthly Fee is calculated properly.
	 */
	@Test
	void testMonthlyFee() {
		System.out.println(mar.getBalance());
		assertTrue(mar.monthlyFee()==0);//This test has a balance of 2800 and expects a fee of 0
		for(int i = 0; i < 7; i++) mar.withdraw();//sets the withdrawal variable to 7
		assertTrue(mar.monthlyFee()==12);//This test has a balance of 2800 and 7 withdrawals. It expects a fee of 12
		mar = new MoneyMarket("John","Doe",500,1,1,2010);
		assertTrue(mar.monthlyFee()==12);//This test has a balance of 500 and expects a fee of 12
		
	}

}
