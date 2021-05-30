package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: RotateForMaxTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit tests for the Rotate for Max kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
class RotateForMaxTest {
	
	// Members
	RotateForMax rfm = new RotateForMax();

	/**
	 * Test method for {@link com.smt.kata.number.RotateForMax#rotate(long)}.
	 */
	@Test
	void testRotate() throws Exception {
		assertEquals(68957, rfm.rotate(56789));
	}

	/**
	 * Test method for {@link com.smt.kata.number.RotateForMax#rotate(long)}.
	 */
	@Test
	void testRotateAllSmaller() throws Exception {
		assertEquals(51111, rfm.rotate(51111));
	}
}
