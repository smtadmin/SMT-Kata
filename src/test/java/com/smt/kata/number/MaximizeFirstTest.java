package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> MaximizeFirstTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit Tests for the MaximizeFirst kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class MaximizeFirstTest {

	// Members
	MaximizeFirst mf = new MaximizeFirst();

	/**
	 * Test method for {@link com.smt.kata.number.MaximizeFirst#maxPossible(int, int)}.
	 */
	@Test
	void testMaxPossible() throws Exception {
		assertEquals(9658, mf.maxPossible(9328, 456));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaximizeFirst#maxPossible(int, int)}.
	 */
	@Test
	void testMaxPossibleZeros() throws Exception {
		assertEquals(0, mf.maxPossible(0, 0));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaximizeFirst#maxPossible(int, int)}.
	 */
	@Test
	void testMaxPossibleZero() throws Exception {
		assertEquals(7, mf.maxPossible(0, 317));
	}

	/**
	 * Test method for {@link com.smt.kata.number.MaximizeFirst#maxPossible(int, int)}.
	 */
	@Test
	void testMaxPossible4Digits() throws Exception {
		assertEquals(9655, mf.maxPossible(9132, 5564));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaximizeFirst#maxPossible(int, int)}.
	 */
	@Test
	void testMaxPossibleAgain() throws Exception {
		assertEquals(763, mf.maxPossible(523, 76));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaximizeFirst#maxPossible(int, int)}.
	 */
	@Test
	void testMaxPossibleLarge() throws Exception {
		assertEquals(9755, mf.maxPossible(8732, 91255));
	}
}
