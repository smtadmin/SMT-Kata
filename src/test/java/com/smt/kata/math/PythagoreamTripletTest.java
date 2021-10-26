package com.smt.kata.math;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: PythagoreamTripletTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Pythagoream Triplet Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 22, 2021
 * @updates:
 ****************************************************************************/
class PythagoreamTripletTest {
	
	// Members
	private PythagoreamTriplet pt = new PythagoreamTriplet();
	
	/**
	 * Test method for {@link com.smt.kata.math.PythagoreamTriplet#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchNull() throws Exception {
		assertFalse(pt.hasMatch(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.PythagoreamTriplet#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchEmpty() throws Exception {
		assertFalse(pt.hasMatch(new int[0]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.PythagoreamTriplet#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchTooSmall() throws Exception {
		assertFalse(pt.hasMatch(new int[] { 1, 2 }));
	}

	/**
	 * Test method for {@link com.smt.kata.math.PythagoreamTriplet#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchInOrder() throws Exception {
		assertTrue(pt.hasMatch(new int[] { 1, 2, 3, 4, 5 }));
	}

	/**
	 * Test method for {@link com.smt.kata.math.PythagoreamTriplet#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchBackwards() throws Exception {
		assertTrue(pt.hasMatch(new int[] { 5, 4, 3, 2, 1 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.PythagoreamTriplet#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchSmall() throws Exception {
		assertTrue(pt.hasMatch(new int[] { 3, 4, 5 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.PythagoreamTriplet#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchMixed() throws Exception {
		assertTrue(pt.hasMatch(new int[] { 10, 3, 4, 7, 5, 2, 1, 3 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.PythagoreamTriplet#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchNone() throws Exception {
		assertFalse(pt.hasMatch(new int[] { 10, 3, 4, 7, 12, 2, 1, 3 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.PythagoreamTriplet#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchMixedNegative() throws Exception {
		assertTrue(pt.hasMatch(new int[] { -10, -3, -4, -7, -5, -2, -1, -3 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.PythagoreamTriplet#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchMixedSomeNegative() throws Exception {
		assertTrue(pt.hasMatch(new int[] { -10, 3, -4, -7, -5, 2, -1, -3 }));
	}
}
