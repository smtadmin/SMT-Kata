package com.smt.kata.number;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> HarshadNumberTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit test for the HarshadNumber Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class HarshadNumberTest {

	// Members
	private HarshadNumber hn = new HarshadNumber();
	
	/**
	 * Test method for {@link com.smt.kata.number.HarshadNumber#isHarshad(int)}.
	 */
	@Test
	void testIsHarshad() throws Exception {
		assertTrue(hn.isHarshad(171));
	}

	/**
	 * Test method for {@link com.smt.kata.number.HarshadNumber#isHarshad(int)}.
	 */
	@Test
	void testIsHarshad75() throws Exception {
		assertFalse(hn.isHarshad(75));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.HarshadNumber#isHarshad(int)}.
	 */
	@Test
	void testIsHarshadZero() throws Exception {
		assertFalse(hn.isHarshad(0));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.HarshadNumber#isHarshad(int)}.
	 */
	@Test
	void testIsHarshadOne() throws Exception {
		assertTrue(hn.isHarshad(1));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.HarshadNumber#isHarshad(int)}.
	 */
	@Test
	void testIsHarshad481() throws Exception {
		assertTrue(hn.isHarshad(481));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.HarshadNumber#isHarshad(int)}.
	 */
	@Test
	void testIsHarshad89() throws Exception {
		assertFalse(hn.isHarshad(89));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.HarshadNumber#isHarshad(int)}.
	 */
	@Test
	void testIsHarshad516() throws Exception {
		assertTrue(hn.isHarshad(516));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.HarshadNumber#isHarshad(int)}.
	 */
	@Test
	void testIsHarshad200() throws Exception {
		assertTrue(hn.isHarshad(200));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.HarshadNumber#isHarshad(int)}.
	 */
	@Test
	void testIsHarshadNegative() throws Exception {
		assertTrue(hn.isHarshad(-200));
	}
}
