package com.smt.kata.distance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> OneFingerDistanceTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 30, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class OneFingerDistanceTest {
	
	// Members
	OneFingerDistance ofd = new OneFingerDistance();
	
	/**
	 * Test method for {@link com.smt.kata.distance.OneFingerDistance#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		assertEquals(0, ofd.calculate(""));
		assertEquals(0, ofd.calculate(null));
		assertEquals(0, ofd.calculate("A"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.OneFingerDistance#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculate() throws Exception {
		assertEquals(15, ofd.calculate("BOOST"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.OneFingerDistance#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateInvalidChars() throws Exception {
		assertEquals(0, ofd.calculate("BO OST"));
		assertEquals(0, ofd.calculate("BOO5ST"));
		assertEquals(0, ofd.calculate("BOO+ST"));
	}


	/**
	 * Test method for {@link com.smt.kata.distance.OneFingerDistance#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateMixedCase() throws Exception {
		assertEquals(15, ofd.calculate("BoOsT"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.OneFingerDistance#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateShort() throws Exception {
		assertEquals(10, ofd.calculate("AL"));
		assertEquals(0, ofd.calculate("XYZ"));
	}

	/**
	 * Test method for {@link com.smt.kata.distance.OneFingerDistance#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateLong() throws Exception {
		assertEquals(165, ofd.calculate("Thisisthetimeforallgoodmen"));
	}
}
