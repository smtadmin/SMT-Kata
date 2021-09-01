package com.smt.kata.data;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SmallestElementTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Smallest Element in Matrix Kata unit test
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 18, 2021
 * @updates:
 ****************************************************************************/
class SmallestElementTest {
	
	// Members
	SmallestElement se = new SmallestElement();
	
	/**
	 * Test method for {@link com.smt.kata.data.SmallestElement#calculate(int[][], int)}.
	 */
	@Test
	void testCalculateNull() throws Exception {
		assertEquals(0, se.calculate(null, 8));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.SmallestElement#calculate(int[][], int)}.
	 */
	@Test
	void testCalculateNullRow() throws Exception {
		int[][] matrix = new int[1][];
		matrix[0] = null;
		assertEquals(0, se.calculate(matrix, 8));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.SmallestElement#calculate(int[][], int)}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		assertEquals(0, se.calculate(new int[0][], 8));
	}

	/**
	 * Test method for {@link com.smt.kata.data.SmallestElement#calculate(int[][], int)}.
	 */
	@Test
	void testCalculateOrdered() throws Exception {
		assertEquals(13, se.calculate(new int[][] {
			{1,5,9},
			{10,11,13},
			{12,13,15}
		}, 8));
	}

	/**
	 * Test method for {@link com.smt.kata.data.SmallestElement#calculate(int[][], int)}.
	 */
	@Test
	void testCalculateUnOrdered() throws Exception {
		assertEquals(13, se.calculate(new int[][] {
			{11,13,10},
			{1,5,9},
			{15,13,12}
		}, 8));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.SmallestElement#calculate(int[][], int)}.
	 */
	@Test
	void testCalculateUnOrderedMixedSign() throws Exception {
		assertEquals(-1, se.calculate(new int[][] {
			{11,-13,10},
			{-1,5,-9},
			{15,13,12}
		}, 3));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.SmallestElement#calculate(int[][], int)}.
	 */
	@Test
	void testCalculateSmall() throws Exception {
		assertEquals(-5, se.calculate(new int[][] {
			{-5}
		}, 1));
	}
}
