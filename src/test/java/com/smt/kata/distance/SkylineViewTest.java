package com.smt.kata.distance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SkylineViewTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit tests for the Skyline View Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 21, 2021
 * @updates:
 ****************************************************************************/
class SkylineViewTest {

	// Members
	private SkylineView sv = new SkylineView();
	
	/**
	 * Test method for {@link com.smt.kata.distance.SkylineView#getNumViewsBackwards(int[])}.
	 */
	@Test
	void testGetNumViewsNull() throws Exception {
		assertEquals(0,  sv.getNumViewsBackwards(null));
		assertEquals(0,  sv.getNumViewsForward(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.SkylineView#getNumViewsBackwards(int[])}.
	 */
	@Test
	void testGetNumViewsEmpty() throws Exception {
		assertEquals(0,  sv.getNumViewsBackwards(new int[0]));
		assertEquals(0,  sv.getNumViewsForward(new int[0]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.SkylineView#getNumViewsBackwards(int[])}.
	 */
	@Test
	void testGetNumViewsSingle() throws Exception {
		assertEquals(1,  sv.getNumViewsBackwards(new int[] { 6 }));
		assertEquals(1,  sv.getNumViewsForward(new int[] { 6 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.SkylineView#getNumViewsBackwards(int[])}.
	 */
	@Test
	void testGetNumViewsBackwards() throws Exception {
		assertEquals(3,  sv.getNumViewsBackwards(new int[] { 3, 7, 8, 3, 6, 1 }));
		assertEquals(3,  sv.getNumViewsForward(new int[] { 3, 7, 8, 3, 6, 1 }));
	}

	/**
	 * Test method for {@link com.smt.kata.distance.SkylineView#getNumViewsBackwards(int[])}.
	 */
	@Test
	void testGetNumViewsBackwardsDesc() throws Exception {
		assertEquals(5,  sv.getNumViewsBackwards(new int[] { 5,4,3,2,1 }));
		assertEquals(5,  sv.getNumViewsForward(new int[] { 5,4,3,2,1 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.SkylineView#getNumViewsBackwards(int[])}.
	 */
	@Test
	void testGetNumViewsBackwardsAsc() throws Exception {
		assertEquals(1,  sv.getNumViewsBackwards(new int[] { 1, 2, 3, 4, 5 }));
		assertEquals(1,  sv.getNumViewsForward(new int[] { 1, 2, 3, 4, 5 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.SkylineView#getNumViewsBackwards(int[])}.
	 */
	@Test
	void testGetNumViewsBackwardsAlt() throws Exception {
		assertEquals(2,  sv.getNumViewsBackwards(new int[] { 5, 2, 5, 1, 4 }));
		assertEquals(2,  sv.getNumViewsForward(new int[] { 5, 2, 5, 1, 4 }));
	}
}
