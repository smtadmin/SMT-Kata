package com.smt.kata.math;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.Map;

// Kata Libs
import com.smt.kata.math.PurchaseChange.Currency;

/****************************************************************************
 * <b>Title:</b> PurchaseChangeTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 2, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class PurchaseChangeTest {
	
	// Members
	PurchaseChange pc = new PurchaseChange();

	/**
	 * Test method for {@link com.smt.kata.math.PurchaseChange#calculate(double, double)}.
	 */
	@Test
	void testCalculate() throws Exception {
		Map<Currency, Integer> change = pc.calculate(1.06, 2.00);
		
		assertEquals(3, change.get(Currency.QUARTER));
		assertEquals(1, change.get(Currency.DIME));
		assertEquals(1, change.get(Currency.NICKEL));
		assertEquals(4, change.get(Currency.PENNY));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.PurchaseChange#calculate(double, double)}.
	 */
	@Test
	void testCalculateTooLittle() throws Exception {
		Map<Currency, Integer> change = pc.calculate(2.06, 2.00);
		assertEquals(0, change.size());
	}


	/**
	 * Test method for {@link com.smt.kata.math.PurchaseChange#calculate(double, double)}.
	 */
	@Test
	void testCalculateLarge() throws Exception {
		Map<Currency, Integer> change = pc.calculate(2.37, 20.00);
		assertEquals(1, change.get(Currency.TEN_DOLLAR));
		assertEquals(1, change.get(Currency.FIVE_DOLLAR));
		assertEquals(2, change.get(Currency.DOLLAR));
		assertEquals(2, change.get(Currency.QUARTER));
		assertEquals(1, change.get(Currency.DIME));
		assertEquals(3, change.get(Currency.PENNY));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.PurchaseChange#calculate(double, double)}.
	 */
	@Test
	void testCalculateAll() throws Exception {
		Map<Currency, Integer> change = pc.calculate(2.32, 20.00);
		assertEquals(1, change.get(Currency.TEN_DOLLAR));
		assertEquals(1, change.get(Currency.FIVE_DOLLAR));
		assertEquals(2, change.get(Currency.DOLLAR));
		assertEquals(2, change.get(Currency.QUARTER));
		assertEquals(1, change.get(Currency.DIME));
		assertEquals(1, change.get(Currency.NICKEL));
		assertEquals(3, change.get(Currency.PENNY));
	}
}
