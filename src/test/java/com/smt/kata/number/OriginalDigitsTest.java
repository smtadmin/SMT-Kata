package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: OriginalDigitsTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Original Digits Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 9, 2021
 * @updates:
 ****************************************************************************/
class OriginalDigitsTest {
	
	// Members
	OriginalDigits od = new OriginalDigits();
	
	/**
	 * Test method for {@link com.smt.kata.number.OriginalDigits#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateNull() throws Exception {
		assertEquals("", od.calculate(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.OriginalDigits#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		assertEquals("", od.calculate(""));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.OriginalDigits#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateNone() throws Exception {
		assertEquals("", od.calculate("ogtr"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.OriginalDigits#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateZeroOneTwo() throws Exception {
		assertEquals("012", od.calculate("owoztneoer"));
	}

	/**
	 * Test method for {@link com.smt.kata.number.OriginalDigits#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateFourFive() throws Exception {
		assertEquals("45", od.calculate("fviefuro"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.OriginalDigits#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateMixed() throws Exception {
		assertEquals("45", od.calculate("fvIEfurO"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.OriginalDigits#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateAll() throws Exception {
		assertEquals("0123456789", od.calculate("twzeneooveiernhisgesfvnoiteninetofeurx"));
	}
}
