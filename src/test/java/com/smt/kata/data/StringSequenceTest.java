package com.smt.kata.data;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> StringSequenceTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit test for the String Sequence Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 26, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class StringSequenceTest {
	
	// Members
	private StringSequence sq = new StringSequence();

	/**
	 * Test method for {@link com.smt.kata.data.StringSequence#hasSequence(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testHasSequence() throws Exception {
		assertNotNull(sq);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.StringSequence#hasSequence(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testHasSequenceEmpty() throws Exception {
		assertFalse(sq.hasSequence("", ""));
		assertFalse(sq.hasSequence("", "123"));
		assertFalse(sq.hasSequence("123", ""));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.StringSequence#hasSequence(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testHasSequenceNull() throws Exception {
		assertFalse(sq.hasSequence(null, null));
		assertFalse(sq.hasSequence(null, "123"));
		assertFalse(sq.hasSequence("123", null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.StringSequence#hasSequence(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testHasSequenceRotate() throws Exception {
		assertTrue(sq.hasSequence("abcde", "cdeab"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.StringSequence#hasSequence(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testHasSequenceSimple() throws Exception {
		assertTrue(sq.hasSequence("abcde", "abcde"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.StringSequence#hasSequence(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testHasSequencePartial() throws Exception {
		assertTrue(sq.hasSequence("abc", "123abcde"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.StringSequence#hasSequence(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testHasSequencePartialWrap() throws Exception {
		assertTrue(sq.hasSequence("abcde", "cde123ab"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.StringSequence#hasSequence(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testHasSequenceDupStartletter() throws Exception {
		assertTrue(sq.hasSequence("aabcde", "cde123aab"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.StringSequence#hasSequence(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testHasSequenceMissing() throws Exception {
		assertFalse(sq.hasSequence("aabcde", "cde123llb"));
	}
	
	
	/**
	 * Test method for {@link com.smt.kata.data.StringSequence#hasSequence(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testHasSequenceCase() throws Exception {
		assertTrue(sq.hasSequence("aaBcDe", "cde123aab"));
	}
	
}
