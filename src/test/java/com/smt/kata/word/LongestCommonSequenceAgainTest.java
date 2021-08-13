package com.smt.kata.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: LongestCommonSequenceAgainTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
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
	void testGetSequence() throws Exception {
		assertEquals("", lcsa.getSequence(new String[]{ "cat" }));
	}

}
