package com.smt.kata.word;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: AlienAlphabetTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Alien Alphabet Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 23, 2021
 * @updates:
 ****************************************************************************/
class AlienAlphabetTest {

	// Members
	AlienAlphabet aa = new AlienAlphabet();
	
	/**
	 * Test method for {@link com.smt.kata.word.AlienAlphabet#alphabetize(java.lang.String[])}.
	 */
	@Test
	void testAlphabetizeNull() throws Exception {
		assertEquals("", new String(aa.alphabetize(null)));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.AlienAlphabet#alphabetize(java.lang.String[])}.
	 */
	@Test
	void testAlphabetizeEmpty() throws Exception {
		assertEquals("", new String(aa.alphabetize(new String[0])));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.AlienAlphabet#alphabetize(java.lang.String[])}.
	 */
	@Test
	void testAlphabetizeSingle() throws Exception {
		assertEquals("", new String(aa.alphabetize(new String[] {"xww"})));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.AlienAlphabet#alphabetize(java.lang.String[])}.
	 */
	@Test
	void testAlphabetizeEnd() throws Exception {
		assertEquals("xzwy", new String(aa.alphabetize(new String[] {"xww", "wxyz", "wxyw", "ywx", "ywz"})));
	}

	/**
	 * Test method for {@link com.smt.kata.word.AlienAlphabet#alphabetize(java.lang.String[])}.
	 */
	@Test
	void testAlphabetizeAgain() throws Exception {
		assertEquals("cadb", new String(aa.alphabetize(new String[] {"cdd", "dcba", "dcbd", "bdc", "bda"})));
	}
}
