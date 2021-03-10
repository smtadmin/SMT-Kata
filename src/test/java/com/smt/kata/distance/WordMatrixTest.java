package com.smt.kata.distance;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: WordMatrixTest.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Unit test for the WorMatrix kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 10, 2021
 * @updates:
 ****************************************************************************/
class WordMatrixTest {
	
	// Members
	private WordMatrix wm = new WordMatrix();

	/**
	 * Test method for {@link com.smt.kata.distance.WordMatrix#WordMatrix()}.
	 */
	@Test
	void testWordMatrix() throws Exception {
		assertNotNull(wm);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.WordMatrix#contains()}.
	 */
	@Test
	void testContainsEmpty() throws Exception {
		assertFalse(wm.contains(""));
		assertFalse(wm.contains(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.WordMatrix#contains()}.
	 */
	@Test
	void testContainsStringFoam() throws Exception {
		assertTrue(wm.contains("foam"));
	}

	/**
	 * Test method for {@link com.smt.kata.distance.WordMatrix#contains()}.
	 */
	@Test
	void testContainsString() throws Exception {
		assertTrue(wm.contains("mass"));
	}

	/**
	 * Test method for {@link com.smt.kata.distance.WordMatrix#contains()}.
	 */
	@Test
	void testContainsStringPartial() throws Exception {
		assertTrue(wm.contains("ass"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.WordMatrix#contains()}.
	 */
	@Test
	void testContainsStringMissing() throws Exception {
		assertFalse(wm.contains("hello"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.WordMatrix#contains()}.
	 */
	@Test
	void testContainsStringBackwards() throws Exception {
		assertTrue(wm.contains("AN"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.WordMatrix#contains()}.
	 */
	@Test
	void testContainsStringBackwardsAgain() throws Exception {
		assertTrue(wm.contains("ssam"));
	}
}
