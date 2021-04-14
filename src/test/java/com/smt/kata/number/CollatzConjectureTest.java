package com.smt.kata.number;

// Junit 5
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> CollatzConjectureTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b>  Unit tests for the CollatzConjecture Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 31, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class CollatzConjectureTest {
	
	// Members
	CollatzConjecture cc = new CollatzConjecture();

	/**
	 * Test method for {@link com.smt.kata.number.CollatzConjecture#CollatzConjecture()}.
	 */
	@Test
	void testCollatzConjecture() throws Exception {
		assertNotNull(cc);
	}

	/**
	 * Test method for {@link com.smt.kata.number.CollatzConjecture#calculate(int)}.
	 */
	@Test
	void testCalculate() throws Exception {
		assertEquals(9, cc.calculate(12));
	}

	/**
	 * Test method for {@link com.smt.kata.number.CollatzConjecture#calculate(int)}.
	 */
	@Test
	void testCalculateZero() throws Exception {
		assertEquals(0, cc.calculate(0));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CollatzConjecture#calculate(int)}.
	 */
	@Test
	void testCalculateLarge() throws Exception {
		assertEquals(111, cc.calculate(1234567));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CollatzConjecture#calculate(int)}.
	 */
	@Test
	void testCalculateLargeEven() throws Exception {
		assertEquals(245, cc.calculate(1234567808));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CollatzConjecture#calculate(int)}.
	 */
	@Test
	void testCalculateNegative() throws Exception {
		assertEquals(8, cc.calculate(-256));
	}
}
