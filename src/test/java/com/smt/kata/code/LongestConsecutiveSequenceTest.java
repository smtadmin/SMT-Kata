package com.smt.kata.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: LongestConsecutiveSequenceTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 24, 2021
 * @updates:
 ****************************************************************************/
class LongestConsecutiveSequenceTest {

	// Members
	LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
	
	/**
	 * Test method for {@link com.smt.kata.code.LongestConsecutiveSequence#calculate(int[])}.
	 */
	@Test
	void testCalculateMixed() throws Exception {
		assertEquals(4, lcs.calculate(new int[] {100,4,200,1,3,2}));
	}

	/**
	 * Test method for {@link com.smt.kata.code.LongestConsecutiveSequence#calculate(int[])}.
	 */
	@Test
	void testCalculateOneDup() throws Exception {
		assertEquals(9, lcs.calculate(new int[] {0,3,7,2,5,8,4,6,0,1}));
	}
}
