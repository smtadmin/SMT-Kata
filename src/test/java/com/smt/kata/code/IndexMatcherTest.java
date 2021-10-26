package com.smt.kata.code;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: IndexMatcherTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Tests for the Index Matcher Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 20, 2021
 * @updates:
 ****************************************************************************/
class IndexMatcherTest {
	
	// Members
	IndexMatcher im = new IndexMatcher();
	
	/**
	 * Test method for {@link com.smt.kata.code.IndexMatcher#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchEmpty() throws Exception {
		assertFalse(im.hasMatch(new int[0]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.IndexMatcher#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchBlank() throws Exception {
		assertFalse(im.hasMatch(new int[] { } ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.IndexMatcher#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchNull() throws Exception {
		assertFalse(im.hasMatch(null));
	}


	/**
	 * Test method for {@link com.smt.kata.code.IndexMatcher#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchExampleOne() throws Exception {
		assertTrue(im.hasMatch(new int[] { -6, 0, 2, 40 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.IndexMatcher#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchExampleTwo() throws Exception {
		assertFalse(im.hasMatch(new int[] { 1, 5, 7, 8}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.IndexMatcher#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchFirstMatch() throws Exception {
		assertTrue(im.hasMatch(new int[] { 0, 1, 5, 7, 8}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.IndexMatcher#hasMatch(int[])}.
	 */
	@Test
	void testHasMatchLastMatch() throws Exception {
		assertTrue(im.hasMatch(new int[] { 5, 1, 5, 7, 8, 6, 7, 8, 8}));
	}
}
