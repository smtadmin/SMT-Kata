package com.smt.kata.math;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> NoOpDivisionTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit Tests for the NoOpDivision Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 6, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class NoOpDivisionTest {

	// Members
	NoOpDivision nod = new NoOpDivision();
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testDivide() throws Exception {
		assertEquals(3, nod.divide(10, 3));
	}

	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testDivideEven() throws Exception {
		assertEquals(4, nod.divide(120, 30));
	}

	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testDivideOneNeg() throws Exception {
		assertEquals(-4, nod.divide(-120, 30));
	}

	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testDivideBothNeg() throws Exception {
		assertEquals(4, nod.divide(-120, -30));
	}

	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testDivideZeroDividend() throws Exception {
		assertEquals(0, nod.divide(0, 30));
	}

	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testDivideZeroDivisoe() throws Exception {
		assertEquals(0, nod.divide(30, 0));
	}
}
