package com.smt.kata.number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: RotatedArrayTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 2, 2021
 * @updates:
 ****************************************************************************/
class RotatedArrayTest {
	
	// Members
	private RotatedArray ra = new RotatedArray();
	
	/**
	 * Test method for {@link com.smt.kata.number.RotatedArray#search(int[], int)}.
	 */
	@Test
	void testSearchNotAvailable() throws Exception {
		assertEquals(-1, ra.search(new int[] {4,5,6,7,0,1,2,3}, 12));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.RotatedArray#search(int[], int)}.
	 */
	@Test
	void testSearch() throws Exception {
		assertEquals(0, ra.search(new int[] {4,5,6,7,0,1,2,3}, 0));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.RotatedArray#search(int[], int)}.
	 */
	@Test
	void testSearchPivot() throws Exception {
		assertEquals(0, ra.search(new int[] {4,5,6,7,0,1,2,3}, 0, 3));
	}

	/**
	 * Test method for {@link com.smt.kata.number.RotatedArray#search(int[], int)}.
	 */
	@Test
	void testSearchBefore() throws Exception {
		assertEquals(5, ra.search(new int[] {4,5,6,7,0,1,2,3}, 5));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.RotatedArray#search(int[], int)}.
	 */
	@Test
	void testSearchBeforePivot() throws Exception {
		assertEquals(5, ra.search(new int[] {4,5,6,7,0,1,2,3}, 5, 3));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.RotatedArray#search(int[], int)}.
	 */
	@Test
	void testSearchLonger() throws Exception {
		assertEquals(0, ra.search(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}, 9));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.RotatedArray#search(int[], int)}.
	 */
	@Test
	void testSearchLongerPivot() throws Exception {
		assertEquals(0, ra.search(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}, 9, 7));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.RotatedArray#search(int[], int)}.
	 */
	@Test
	void testSearchLongerEnd() throws Exception {
		assertEquals(7, ra.search(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}, 16));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.RotatedArray#search(int[], int)}.
	 */
	@Test
	void testSearchLongerEndPivot() throws Exception {
		assertEquals(7, ra.search(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}, 16, 7));
	}
}
