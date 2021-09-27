package com.smt.kata.code;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: HarmoniousSequenceTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test Harmonious Sequence Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 16, 2021
 * @updates:
 ****************************************************************************/
class HarmoniousSequenceTest {
	
	// Members
	HarmoniousSequence hs = new HarmoniousSequence();
	
	/**
	 * Test method for {@link com.smt.kata.code.HarmoniousSequence#getLongest(int[])}.
	 */
	@Test
	void testGetLongestNull() throws Exception {
		assertEquals(0, hs.getLongest(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.HarmoniousSequence#getLongest(int[])}.
	 */
	@Test
	void testGetLongestEmpty() throws Exception {
		assertEquals(0, hs.getLongest(new int[0]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.HarmoniousSequence#getLongest(int[])}.
	 */
	@Test
	void testGetLongestTooSmall() throws Exception {
		assertEquals(0, hs.getLongest(new int[] {1}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.HarmoniousSequence#getLongest(int[])}.
	 */
	@Test
	void testGetLongestSmall() throws Exception {
		assertEquals(2, hs.getLongest(new int[] {1, 2}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.HarmoniousSequence#getLongest(int[])}.
	 */
	@Test
	void testGetLongestSmallNoMatch() throws Exception {
		assertEquals(0, hs.getLongest(new int[] {1, 5}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.HarmoniousSequence#getLongest(int[])}.
	 */
	@Test
	void testGetLongestSimple() throws Exception {
		assertEquals(5, hs.getLongest(new int[] {1,3,2,2,5,2,3,7}));
	}

	/**
	 * Test method for {@link com.smt.kata.code.HarmoniousSequence#getLongest(int[])}.
	 */
	@Test
	void testGetLongestSame() throws Exception {
		assertEquals(0, hs.getLongest(new int[] {1,1,1,1}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.HarmoniousSequence#getLongest(int[])}.
	 */
	@Test
	void testGetLongestNumbering() throws Exception {
		assertEquals(2, hs.getLongest(new int[] {1,2,3,4,5,6}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.HarmoniousSequence#getLongest(int[])}.
	 */
	@Test
	void testGetLongestEvenLong() throws Exception {
		assertEquals(0, hs.getLongest(new int[] {2,4,6,8,10,12,14,16,18}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.HarmoniousSequence#getLongest(int[])}.
	 */
	@Test
	void testGetLongestReplicating() throws Exception {
		assertEquals(8, hs.getLongest(new int[] {1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.HarmoniousSequence#getLongest(int[])}.
	 */
	@Test
	void testGetLongestReplicatingNegative() throws Exception {
		assertEquals(8, hs.getLongest(new int[] {-1,-2,-3,-4,-1,-2,-3,-4,-1,-2,-3,-4,-1,-2,-3,-4}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.HarmoniousSequence#getLongest(int[])}.
	 */
	@Test
	void testGetLongestReplicatingNegativeMixed() throws Exception {
		assertEquals(4, hs.getLongest(new int[] {-1,-2,-3,-4,1,2,3,4,-1,-2,-3,-4,1,2,3,4}));
	}
}
