package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: LargestGapTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit test for the largest gap kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class LargestGapTest {

	/**
	 * Test method for {@link com.smt.kata.number.LargestGap#largestGap(int[])}.
	 */
	@Test
	void testLargestGap() {
		LargestGap lg = new LargestGap();
		assertEquals(61, lg.largestGap(new int[] { 0, 78, 34, 1, 3, 90, 34, -1, -4, 6, 55, 20, -65 }));
		assertEquals(11, lg.largestGap(new int[] { 9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5}));
		assertEquals(4, lg.largestGap(new int[] { 14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7 }));
		assertEquals(2, lg.largestGap(new int[] { 13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9 }));
	}

}
