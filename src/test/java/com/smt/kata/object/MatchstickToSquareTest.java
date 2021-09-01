package com.smt.kata.object;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: MatchstickToSquareTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Match Sstick to Square Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 26, 2021
 * @updates:
 ****************************************************************************/
class MatchstickToSquareTest {
	
	// Members
	MatchstickToSquare mts = new MatchstickToSquare();

	/**
	 * Test method for {@link com.smt.kata.object.MatchstickToSquare#canFormSquare(int[])}.
	 */
	@Test
	void testCanFormSquareThree() throws Exception {
		assertFalse(mts.canFormSquare(new int[] {4,2,2} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.object.MatchstickToSquare#canFormSquare(int[])}.
	 */
	@Test
	void testCanFormSquarenull() throws Exception {
		assertFalse(mts.canFormSquare(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.object.MatchstickToSquare#canFormSquare(int[])}.
	 */
	@Test
	void testCanFormSquareEmpty() throws Exception {
		assertFalse(mts.canFormSquare(new int[0]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.object.MatchstickToSquare#canFormSquare(int[])}.
	 */
	@Test
	void testCanFormSquareDouble() throws Exception {
		assertTrue(mts.canFormSquare(new int[] {1,1,2,2,2} ));
	}

	/**
	 * Test method for {@link com.smt.kata.object.MatchstickToSquare#canFormSquare(int[])}.
	 */
	@Test
	void testCanFormSquareTriple() throws Exception {
		assertFalse(mts.canFormSquare(new int[] {3,3,3,3,4} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.object.MatchstickToSquare#canFormSquare(int[])}.
	 */
	@Test
	void testCanFormSquareTripleMatching() throws Exception {
		assertTrue(mts.canFormSquare(new int[] {3,3,3,1,1,1,4} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.object.MatchstickToSquare#canFormSquare(int[])}.
	 */
	@Test
	void testCanFormSquareQuadMatching() throws Exception {
		assertTrue(mts.canFormSquare(new int[] {4,4,2,2,1,1,1,1} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.object.MatchstickToSquare#canFormSquare(int[])}.
	 */
	@Test
	void testCanFormSquareQuadAgain() throws Exception {
		assertTrue(mts.canFormSquare(new int[] {4,4,1,1,1,2,1,2} ));
	}
}
