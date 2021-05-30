package com.smt.kata.code;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: DashatizeItTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Dashatize It kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
class DashatizeItTest {
	
	// Members
	DashatizeIt di = new DashatizeIt();
	
	/**
	 * Test method for {@link com.smt.kata.code.DashatizeIt#process(java.lang.String)}.
	 */
	@Test
	void testProcessEmpty() throws Exception {
		assertEquals("", di.process(""));
		assertEquals("", di.process(null));
	}

	/**
	 * Test method for {@link com.smt.kata.code.DashatizeIt#process(java.lang.String)}.
	 */
	@Test
	void testProcess274() throws Exception {
		assertEquals("2-7-4", di.process("274"));
	}

	/**
	 * Test method for {@link com.smt.kata.code.DashatizeIt#process(java.lang.String)}.
	 */
	@Test
	void testProcessLetters() throws Exception {
		assertEquals("", di.process("abcd"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DashatizeIt#process(java.lang.String)}.
	 */
	@Test
	void testProcessMixed() throws Exception {
		assertEquals("2-7-4", di.process("a2b7c4d"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DashatizeIt#process(java.lang.String)}.
	 */
	@Test
	void testProcessMixed2() throws Exception {
		assertEquals("686-1-5", di.process("68615"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DashatizeIt#process(java.lang.String)}.
	 */
	@Test
	void testProcessAllOdd() throws Exception {
		assertEquals("1-3-5-7-9", di.process("13579"));
	}
}
