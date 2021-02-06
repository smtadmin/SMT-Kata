package com.smt.kata.word;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: LongestCommonSequenceTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class LongestCommonSequenceTest {

	/**
	 * Test method for {@link com.smt.kata.word.LongestCommonSequence#find(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testFind() {
		LongestCommonSequence lcs = new LongestCommonSequence();
		
		String one = "Over hill over dale";
		String two = "James is old and over the hill";
		assertEquals(" over ", lcs.find(one, two));
		
		one = "a long time ago in a galaxy far far away";
		two = "there is going to be a time at the movie";
		assertEquals(" time a", lcs.find(one, two));
		
		one = "the denver broncos really suck this year";
		two = "the year 2020 has been really crappy";
		assertEquals(" really ", lcs.find(one, two));
		
		one = "cookies are realy yummy, especially chocolate chips";
		two = "browser can track usage through the use of cookies";
		assertEquals("cookies", lcs.find(one, two));
		
		// Empty string check
		assertEquals("", lcs.find("", two));
	}

}
