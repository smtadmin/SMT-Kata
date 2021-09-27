package com.smt.kata.word;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: StringHalvesTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test fo rthe String Halves Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 7, 2021
 * @updates:
 ****************************************************************************/
class StringHalvesTest {
	
	// Members
	StringHalves sh = new StringHalves();
	
	/**
	 * Test method for {@link com.smt.kata.word.StringHalves#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateNull() throws Exception {
		assertFalse(sh.calculate(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.StringHalves#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		assertFalse(sh.calculate(""));
	}

	/**
	 * Test method for {@link com.smt.kata.word.StringHalves#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateShort() throws Exception {
		assertFalse(sh.calculate("S"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.StringHalves#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateOdd() throws Exception {
		assertFalse(sh.calculate("Start"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.StringHalves#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateBook() throws Exception {
		assertTrue(sh.calculate("book"));
	}

	/**
	 * Test method for {@link com.smt.kata.word.StringHalves#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateTextBook() throws Exception {
		assertFalse(sh.calculate("textbook"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.StringHalves#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateXmas() throws Exception {
		assertFalse(sh.calculate("MerryChristmas"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.StringHalves#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateMixed() throws Exception {
		assertTrue(sh.calculate("AbCdEfGh"));
	}
}
