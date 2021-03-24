package com.smt.kata.number;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> NumberSubsetsTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class NumberSubsetsTest {

	// Members
	private NumberSubsets ns = new NumberSubsets();
	/**
	 * Test method for {@link com.smt.kata.number.NumberSubsets#findMataches(int[])}.
	 */
	@Test
	void testFindMataches() throws Exception {
		assertTrue(ns.findMataches(new int[] {15, 5, 20, 10, 35, 15, 10}));
	}

	/**
	 * Test method for {@link com.smt.kata.number.NumberSubsets#findMataches(int[])}.
	 */
	@Test
	void testFindMatachesOrdered() throws Exception {
		assertTrue(ns.findMataches(new int[] {20, 35, 15, 5,10, 15, 10}));
	}
}
