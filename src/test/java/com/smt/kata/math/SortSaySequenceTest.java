package com.smt.kata.math;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SortSaySequenceTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit tests for the Sort Say Sequence Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
class SortSaySequenceTest {
	
	// Members
	SortSaySequence sss = new SortSaySequence();
	
	/**
	 * Test method for {@link com.smt.kata.math.SortSaySequence#reorder(int[])}.
	 */
	@Test
	void testReorderEmpty() throws Exception {
		int[] values = sss.reorder(new int[] { });
		assertEquals(0, values.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.SortSaySequence#reorder(int[])}.
	 */
	@Test
	void testReorderEmptyInside() throws Exception {
		int[] values = sss.reorder(new int[] { 1, 0});
		assertEquals(2, values.length);
		assertEquals(1, values[0]);
		assertEquals(0, values[1]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.SortSaySequence#reorder(int[])}.
	 */
	@Test
	void testReorderNull() throws Exception {
		int[] values = sss.reorder(null);
		assertEquals(0, values.length);
	}

	/**
	 * Test method for {@link com.smt.kata.math.SortSaySequence#reorder(int[])}.
	 */
	@Test
	void testReorder1234() throws Exception {
		int[] values = sss.reorder(new int[] { 1, 2, 3, 4 });

		assertEquals(4, values.length);
		assertEquals(4, values[0]);
		assertEquals(1, values[1]);
		assertEquals(3, values[2]);
		assertEquals(2, values[3]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.SortSaySequence#reorder(int[])}.
	 */
	@Test
	void testReorder863174() throws Exception {
		int[] values = sss.reorder(new int[] { 8, 6, 3, 1, 7, 4 });

		assertEquals(6, values.length);
		assertEquals(8, values[0]);
		assertEquals(4, values[1]);
		assertEquals(1, values[2]);
		assertEquals(7, values[3]);
		assertEquals(6, values[4]);
		assertEquals(3, values[5]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.SortSaySequence#reorder(int[])}.
	 */
	@Test
	void testReorder863174Neg() throws Exception {
		int[] values = sss.reorder(new int[] { -8, -6, -3, -1, -7, -4 });

		assertEquals(6, values.length);
		assertEquals(8, values[0]);
		assertEquals(4, values[1]);
		assertEquals(1, values[2]);
		assertEquals(7, values[3]);
		assertEquals(6, values[4]);
		assertEquals(3, values[5]);
	}
}
