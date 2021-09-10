package com.smt.kata.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: WiggleSequenceTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Wiggle Sequence Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 9, 2021
 * @updates:
 ****************************************************************************/
class WiggleSequenceTest {

	// Members
	WiggleSequence ws = new WiggleSequence();
	
	/**
	 * Test method for {@link com.smt.kata.code.WiggleSequence#count(int[])}.
	 */
	@Test
	void testCountAll() throws Exception {
		assertEquals(6, ws.count(new int[] {1,7,4,9,2,5}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.WiggleSequence#count(int[])}.
	 */
	@Test
	void testCountPartial() throws Exception {
		assertEquals(6, ws.count(new int[] {1,17,5,10,13,15,10,5,16,8}));
	}

	/**
	 * Test method for {@link com.smt.kata.code.WiggleSequence#count(int[])}.
	 */
	@Test
	void testCountAscending() throws Exception {
		assertEquals(2, ws.count(new int[] {1,2,3,4,5,6,7,8,9}));
	}

}
