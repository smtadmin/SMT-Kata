package com.smt.kata.number;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SparseNumberTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Sparse NBumber Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 17, 2021
 * @updates:
 ****************************************************************************/
class SparseNumberTest {
	
	// Members
	SparseNumber sn = new SparseNumber();
	
	/**
	 * Test method for {@link com.smt.kata.number.SparseNumber#isSparse(int)}.
	 */
	@Test
	void testIsSparse() throws Exception {
		assertTrue(sn.isSparse(0));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SparseNumber#isSparse(int)}.
	 */
	@Test
	void testIsSparseNegative() throws Exception {
		assertTrue(sn.isSparse(-20));
	}

	/**
	 * Test method for {@link com.smt.kata.number.SparseNumber#isSparse(int)}.
	 */
	@Test
	void testIsSparse7() throws Exception {
		assertFalse(sn.isSparse(7));
	}

	/**
	 * Test method for {@link com.smt.kata.number.SparseNumber#isSparse(int)}.
	 */
	@Test
	void testIsSparse21() throws Exception {
		assertTrue(sn.isSparse(21));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SparseNumber#isSparse(int)}.
	 */
	@Test
	void testIsSparse1025() throws Exception {
		assertTrue(sn.isSparse(1025));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SparseNumber#isSparse(int)}.
	 */
	@Test
	void testIsSparse1365() throws Exception {
		assertTrue(sn.isSparse(1365));
	}

	/**
	 * Test method for {@link com.smt.kata.number.SparseNumber#findNext(int)}.
	 */
	@Test
	void testFindNext() throws Exception {
		assertEquals(0, sn.findNext(0));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SparseNumber#findNext(int)}.
	 */
	@Test
	void testFindNext22() throws Exception {
		assertEquals(32, sn.findNext(22));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SparseNumber#findNext(int)}.
	 */
	@Test
	void testFindNext1365() throws Exception {
		assertEquals(2048, sn.findNext(1366));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SparseNumber#findNext(int)}.
	 */
	@Test
	void testFindNext1026() throws Exception {
		assertEquals(1028, sn.findNext(1027));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SparseNumber#findNext(int)}.
	 */
	@Test
	void testFindNext102() throws Exception {
		assertEquals(128, sn.findNext(102));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SparseNumber#findNext(int)}.
	 */
	@Test
	void testFindNextNegative() throws Exception {
		assertEquals(128, sn.findNext(-102));
	}
}
