package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: MaxKSumPairsTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit tests for the Max K Sum Pairs Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 24, 2021
 * @updates:
 ****************************************************************************/
class MaxKSumPairsTest {
	
	// Members
	MaxKSumPairs mkp = new MaxKSumPairs();
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxKSumPairs#calculate(int[], int)}.
	 */
	@Test
	void testCalculateNull() throws Exception {
		assertEquals(0, mkp.calculate(null, 10));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxKSumPairs#calculate(int[], int)}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		assertEquals(0, mkp.calculate(new int[0], 10));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxKSumPairs#calculate(int[], int)}.
	 */
	@Test
	void testCalculateNoMatch() throws Exception {
		assertEquals(0, mkp.calculate(new int[] {5}, 10));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxKSumPairs#calculate(int[], int)}.
	 */
	@Test
	void testCalculateSingle() throws Exception {
		assertEquals(1, mkp.calculate(new int[]{1, 2, 3, 4}, 10));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxKSumPairs#calculate(int[], int)}.
	 */
	@Test
	void testCalculateAll() throws Exception {
		assertEquals(6, mkp.calculate(new int[]{2,2,2,2,2,2}, 2));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxKSumPairs#calculate(int[], int)}.
	 */
	@Test
	void testCalculateDual() throws Exception {
		assertEquals(2, mkp.calculate(new int[]{2,2,2,2,2,2}, 6));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxKSumPairs#calculate(int[], int)}.
	 */
	@Test
	void testCalculatenome() throws Exception {
		assertEquals(0, mkp.calculate(new int[]{1, 2, 3, 4}, 20));
	}

	/**
	 * Test method for {@link com.smt.kata.number.MaxKSumPairs#calculate(int[], int)}.
	 */
	@Test
	void testCalculateExampleOne() throws Exception {
		assertEquals(2, mkp.calculate(new int[]{1, 2, 3, 4}, 5));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxKSumPairs#calculate(int[], int)}.
	 */
	@Test
	void testCalculateExample2() throws Exception {
		assertEquals(1, mkp.calculate(new int[]{3,1,3,4,3}, 6));
	}
}
