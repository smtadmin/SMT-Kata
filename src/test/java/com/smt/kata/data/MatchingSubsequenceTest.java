package com.smt.kata.data;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: MatchingSubsequenceTest.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Unit Test for the Matching Subsequence Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 24, 2021
 * @updates:
 ****************************************************************************/
class MatchingSubsequenceTest {
	
	// Members
	MatchingSubsequence ms = new MatchingSubsequence();

	/**
	 * Test method for {@link com.smt.kata.data.MatchingSubsequence#match(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testMatchNullWords() throws Exception {
		assertEquals(0, ms.match("abcde", null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.MatchingSubsequence#match(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testMatchEmptyWords() throws Exception {
		assertEquals(0, ms.match("abcde", new String[0]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.MatchingSubsequence#match(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testMatchNullSource() throws Exception {
		assertEquals(0, ms.match(null, new String[] {"a","bb","acd","ace"}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.MatchingSubsequence#match(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testMatchEmptySource() throws Exception {
		assertEquals(0, ms.match("", new String[] {"a","bb","acd","ace"}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.MatchingSubsequence#match(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testMatchThree() throws Exception {
		assertEquals(3, ms.match("abcde", new String[] {"a","bb","acd","ace"}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.MatchingSubsequence#match(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testMatchTwo() throws Exception {
		assertEquals(2, ms.match("ahjpjau", new String[] {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.MatchingSubsequence#match(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testMatchAllMixedCase() throws Exception {
		assertEquals(5, ms.match("SiliConMountain", new String[] {"SiliConMountain","SLOT","SLIM","MOUNT", "contAiN"}));
	}

	/**
	 * Test method for {@link com.smt.kata.data.MatchingSubsequence#match(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testMatchNullMiddle() throws Exception {
		assertEquals(4, ms.match("SiliConMountain", new String[] {"SiliConMountain",null,"SLIM","MOUNT", "contAiN"}));
	}
}
