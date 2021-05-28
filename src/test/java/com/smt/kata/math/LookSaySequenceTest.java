package com.smt.kata.math;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: LookSaySequenceTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit test for the look say sequence kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 28, 2021
 * @updates:
 ****************************************************************************/
class LookSaySequenceTest {

	// Members
	LookSaySequence lss = new LookSaySequence();
	
	/**
	 * Test method for {@link com.smt.kata.math.LookSaySequence#translate(int)}.
	 */
	@Test
	void testTranslate11() throws Exception {
		assertEquals(21, lss.translate(11));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.LookSaySequence#translate(int)}.
	 */
	@Test
	void testTranslateOne() throws Exception {
		assertEquals(11, lss.translate(1));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.LookSaySequence#translate(int)}.
	 */
	@Test
	void testTranslate21() throws Exception {
		assertEquals(1211, lss.translate(21));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.LookSaySequence#translate(int)}.
	 */
	@Test
	void testTranslate111221() throws Exception {
		assertEquals(312211, lss.translate(111221));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.LookSaySequence#translate(int)}.
	 */
	@Test
	void testTranslateNegative() throws Exception {
		assertEquals(312211, lss.translate(-111221));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.LookSaySequence#translate(int)}.
	 */
	@Test
	void testTranslate1211() throws Exception {
		assertEquals(111221, lss.translate(1211));
	}
}
