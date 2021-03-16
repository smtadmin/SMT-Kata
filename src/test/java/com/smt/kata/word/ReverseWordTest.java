package com.smt.kata.word;

// Junit 5
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: ReverseWordTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit ttest for the reverseword kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 8, 2021
 * @updates:
 ****************************************************************************/
class ReverseWordTest {

	// Members
	ReverseWord rw = new ReverseWord();
	
	/**
	 * Test method for {@link com.smt.kata.word.ReverseWord#ReverseWord()}.
	 */
	@Test
	void testReverseWord() throws Exception {
		assertNotNull(rw);
	}

	/**
	 * Test method for {@link com.smt.kata.word.ReverseWord#processPhrase(java.lang.String)}.
	 */
	@Test
	void testProcessPhraseEmpty() throws Exception {
		assertEquals("", rw.processPhrase(""));
		assertEquals("", rw.processPhrase(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.ReverseWord#processPhrase(java.lang.String)}.
	 */
	@Test
	void testProcessPhrase() throws Exception {
		assertEquals("blue is sky the", rw.processPhrase("the sky is blue"));
	}

	/**
	 * Test method for {@link com.smt.kata.word.ReverseWord#processPhrase(java.lang.String)}.
	 */
	@Test
	void testProcessPhraseStartEndSpaces() throws Exception {
		assertEquals("world! hello", rw.processPhrase("  hello world!  "));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.ReverseWord#processPhrase(java.lang.String)}.
	 */
	@Test
	void testProcessPhraseExtraSpaces() throws Exception {
		assertEquals("example good a", rw.processPhrase("a good   example"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.ReverseWord#processPhrase(java.lang.String)}.
	 */
	@Test
	void testProcessPhraseSolo() throws Exception {
		assertEquals("a", rw.processPhrase("a"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.ReverseWord#processPhrase(java.lang.String)}.
	 */
	@Test
	void testProcessPhraseAlphabet() throws Exception {
		assertEquals("z y x w v u t s r q p o n m l k j i h g f e d c b a", rw.processPhrase("a b c d e f g h i j k l m n o p q r s t u v w x y z"));
	}
}
