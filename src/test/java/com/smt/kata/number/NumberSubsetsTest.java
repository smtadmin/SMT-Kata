package com.smt.kata.number;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> NumberSubsetsTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit Tests for the NumberSubsets Kata
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
	void testFindMatachesNull() throws Exception {
		assertFalse(ns.findMataches(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.NumberSubsets#findMataches(int[])}.
	 */
	@Test
	void testFindMatachesEmpty() throws Exception {
		assertFalse(ns.findMataches(new int[0]));
	}

	/**
	 * Test method for {@link com.smt.kata.number.NumberSubsets#findMataches(int[])}.
	 */
	@Test
	void testFindMatachesOrdered() throws Exception {
		assertTrue(ns.findMataches(new int[] {20, 35, 15, 5,10, 15, 10}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.NumberSubsets#findMataches(int[])}.
	 */
	@Test
	void testFindMatachesNone() throws Exception {
		assertFalse(ns.findMataches(new int[] {15, 5, 20, 10, 35}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.NumberSubsets#findMataches(int[])}.
	 */
	@Test
	void testFindMatachesLong() throws Exception {
		assertTrue(ns.findMataches(new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 90}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.NumberSubsets#findMataches(int[])}.
	 */
	@Test
	void testFindMatachesLongNone() throws Exception {
		assertFalse(ns.findMataches(new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 73}));
	}
}
