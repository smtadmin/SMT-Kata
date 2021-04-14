package com.smt.kata.math;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> BitwiseMathTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit tests for the Bitwise Math Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 6, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class BitwiseMathTest {

	// Members
	BitwiseMath bm = new BitwiseMath();
	
	/**
	 * Test method for {@link com.smt.kata.math.BitwiseMath#isOdd(int)}.
	 */
	@Test
	void testIsOdd() throws Exception {
		assertTrue(bm.isOdd(101));
		assertFalse(bm.isOdd(100));
	}

	/**
	 * Test method for {@link com.smt.kata.math.BitwiseMath#swapVars(int, int)}.
	 */
	@Test
	void testSwapVars() throws Exception {
		assertEquals(12, bm.swapVars(3, 12));
		assertEquals(3, bm.swapVars(12, 3));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.BitwiseMath#swapVars(int, int)}.
	 */
	@Test
	void testSwapVarsWithSign() throws Exception {
		assertEquals(12, bm.swapVars(-3, 12));
		assertEquals(-3, bm.swapVars(12, -3));
	}

	/**
	 * Test method for {@link com.smt.kata.math.BitwiseMath#doubleValue(int)}.
	 */
	@Test
	void testDoubleValue() throws Exception {
		assertEquals(12, bm.doubleValue(6));
		assertEquals(256, bm.doubleValue(128));
		assertEquals(0, bm.doubleValue(0));
		assertEquals(34, bm.doubleValue(17));
	}

	/**
	 * Test method for {@link com.smt.kata.math.BitwiseMath#multiply(int, int)}.
	 */
	@Test
	void testMultiply() throws Exception {
		assertEquals(36, bm.multiply(3, 12));
	}

	/**
	 * Test method for {@link com.smt.kata.math.BitwiseMath#add(int, int)}.
	 */
	@Test
	void testAdd() throws Exception {
		assertEquals(6, bm.add(2, 4));
		assertEquals(36, bm.add(12, 24));
	}

}
