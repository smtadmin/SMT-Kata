package com.smt.kata.word;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: LongestCommonSequenceAgainTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> UNit tests for the Longest Common Sequence Again Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 12, 2021
 * @updates:
 ****************************************************************************/
class LongestCommonSequenceAgainTest {
	
	private LongestCommonSequenceAgain lcsa = new LongestCommonSequenceAgain();
	
	/**
	 * Test method for {@link com.smt.kata.word.LongestCommonSequenceAgain#getSequence(java.lang.String[])}.
	 */
	@Test
	void testGetSequenceArrayNull() throws Exception {
		assertEquals("", lcsa.getSequence(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.LongestCommonSequenceAgain#getSequence(java.lang.String[])}.
	 */
	@Test
	void testGetSequenceArrayAllNull() throws Exception {
		assertEquals("", lcsa.getSequence(new String[] {null, null }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.LongestCommonSequenceAgain#getSequence(java.lang.String[])}.
	 */
	@Test
	void testGetSequenceArrayAllEmpty() throws Exception {
		assertEquals("", lcsa.getSequence(new String[] {"", "" }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.LongestCommonSequenceAgain#getSequence(java.lang.String[])}.
	 */
	@Test
	void testGetSequenceArrayOneValid() throws Exception {
		assertEquals("", lcsa.getSequence(new String[] {"Test" }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.LongestCommonSequenceAgain#getSequence(java.lang.String[])}.
	 */
	@Test
	void testGetSequenceArrayOneValidWithNulls() throws Exception {
		assertEquals("", lcsa.getSequence(new String[] {"Test", null }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.LongestCommonSequenceAgain#getSequence(java.lang.String[])}.
	 */
	@Test
	void testGetSequenceSimple() throws Exception {
		assertEquals("at", lcsa.getSequence(new String[]{ "cat", "after", "another" }));
	}

	/**
	 * Test method for {@link com.smt.kata.word.LongestCommonSequenceAgain#getSequence(java.lang.String[])}.
	 */
	@Test
	void testGetSequence() throws Exception {
		assertEquals("eieio", lcsa.getSequence(new String[]{ "epidemiologist", "refrigeration", "believingmore" }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.LongestCommonSequenceAgain#getSequence(java.lang.String[])}.
	 */
	@Test
	void testGetSequenceMixedCase() throws Exception {
		assertEquals("eig", lcsa.getSequence(new String[]{ "EpidemiOlogist", "refrigErAtion", "bElievingmore" }));
	}

}
