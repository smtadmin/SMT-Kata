package com.smt.kata.word;

// Junit 5
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: WordRankTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 1, 2021
 * @updates:
 ****************************************************************************/
class WordRankTest {

	// Members
	private WordRank wr = new WordRank();	
	
	/**
	 * Test method for {@link com.smt.kata.word.WordRank#WordRank()}.
	 */
	@Test
	void testWordRank() throws Exception {
		assertNotNull(wr);
	}

	/**
	 * Test method for {@link com.smt.kata.word.WordRank#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		assertEquals("", wr.calculate(null));
		assertEquals("", wr.calculate(""));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.WordRank#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateFox() throws Exception {
		assertEquals("brown", wr.calculate("The quick brown fox"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.WordRank#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculatePretty() throws Exception {
		assertEquals("pretty", wr.calculate("Nancy is very pretty"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.WordRank#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateWednesday() throws Exception {
		assertEquals("Wednesday", wr.calculate("Wednesday is hump day"));
	}
}
