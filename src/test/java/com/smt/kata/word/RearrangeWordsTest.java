package com.smt.kata.word;

// JDK 11.x
import java.util.Collection;

// Junit 5
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: RearrangeWordsTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Rearrange Words Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 30, 2021
 * @updates:
 ****************************************************************************/
class RearrangeWordsTest {
	
	// Members
	RearrangeWords rw = new RearrangeWords();

	/**
	 * Test method for {@link com.smt.kata.word.RearrangeWords#arrange(java.lang.String)}.
	 */
	@Test
	void testArrangeNull() throws Exception {
		assertEquals(0, rw.arrange(null).size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.RearrangeWords#arrange(java.lang.String)}.
	 */
	@Test
	void testArrangeEmpty() throws Exception {
		assertEquals(0, rw.arrange("").size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.RearrangeWords#arrange(java.lang.String)}.
	 */
	@Test
	void testArrangeShort() throws Exception {
		assertEquals(0, rw.arrange("A").size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.RearrangeWords#arrange(java.lang.String)}.
	 */
	@Test
	void testArrangeInvalid() throws Exception {
		assertEquals(0, rw.arrange("ABC&^").size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.RearrangeWords#arrange(java.lang.String)}.
	 */
	@Test
	void testArrangeMixedCase() throws Exception {
		Collection<String> words = rw.arrange("aAabBc");
		assertEquals(1, words.size()); 
		assertTrue(words.contains("aAabBc"));	
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.RearrangeWords#arrange(java.lang.String)}.
	 */
	@Test
	void testArrangeMain() throws Exception {
		String[] results = new String[]{
			"ababac", "ababca", "abacab", "abacba", "abcaba", 
			"acabab", "acbaba", "babaca", "bacaba", "cababa"
		};
		
		Collection<String> words = rw.arrange("aaabbc");
		assertEquals(10, words.size()); 
		for(String word : results) assertTrue(words.contains(word));	
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.RearrangeWords#arrange(java.lang.String)}.
	 */
	@Test
	void testArrangeNone() throws Exception {
		Collection<String> words = rw.arrange("aaab");
		assertEquals(0, words.size()); 
	}

}
