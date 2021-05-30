package com.smt.kata.word;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SpinningWordsTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> unit tests for the Spinning words kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
class SpinningWordsTest {
	
	// Members
	SpinningWords sw = new SpinningWords();

	/**
	 * Test method for {@link com.smt.kata.word.SpinningWords#spin(java.lang.String)}.
	 */
	@Test
	void testSpinEmpty() throws Exception {
		assertEquals("", sw.spin(""));
		assertEquals("", sw.spin(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.SpinningWords#spin(java.lang.String)}.
	 */
	@Test
	void testSpinPhrase() throws Exception {
		assertEquals("Hey wolleF sroirraW" , sw.spin("Hey fellow warriors"));
	}

	/**
	 * Test method for {@link com.smt.kata.word.SpinningWords#spin(java.lang.String)}.
	 */
	@Test
	void testSpinPhraseSmall() throws Exception {
		assertEquals("This is a test" , sw.spin("This is a test"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.SpinningWords#spin(java.lang.String)}.
	 */
	@Test
	void testSpinPhraseMixed() throws Exception {
		assertEquals("This is rehtonA test" , sw.spin("This is another test"));
	}
}
