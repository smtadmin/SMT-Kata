package com.smt.kata.data;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: ZeroMatrixTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Zero Matrix Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 18, 2021
 * @updates:
 ****************************************************************************/
class ZeroMatrixTest {
	
	// Members
	ZeroMatrix zm = new ZeroMatrix();
	
	/**
	 * Test method for {@link com.smt.kata.data.ZeroMatrix#assign(int[][])}.
	 */
	@Test
	void testAssignNull() throws Exception {
		int[][] matrix = zm.assign(null);
		assertEquals(0, matrix.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.ZeroMatrix#assign(int[][])}.
	 */
	@Test
	void testAssignEmpty() throws Exception {
		int[][] matrix = zm.assign(new int[0][]);
		assertEquals(0, matrix.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.ZeroMatrix#assign(int[][])}.
	 */
	@Test
	void testAssignEmptyRow() throws Exception {
		int[][] matrix = zm.assign(new int[][] {});
		assertEquals(0, matrix.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.ZeroMatrix#assign(int[][])}.
	 */
	@Test
	void testAssignNullRow() throws Exception {
		int[][] matrix = zm.assign(new int[][] {null});
		assertEquals(0, matrix.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.ZeroMatrix#assign(int[][])}.
	 */
	@Test
	void testAssignMiddle() throws Exception {
		int[][] matrix = zm.assign(new int[][] {
			{1,1,1},
			{1,0,1},
			{1,1,1}
		});
		
		// Make sure the middle column is set to 0
		assertEquals(0, matrix[0][1]);
		assertEquals(0, matrix[1][1]);
		assertEquals(0, matrix[2][1]);
		
		// Make sure the middle row is set to 0
		assertEquals(0, matrix[1][0]);
		assertEquals(0, matrix[1][1]);
		assertEquals(0, matrix[1][2]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.ZeroMatrix#assign(int[][])}.
	 */
	@Test
	void testAssignAll() throws Exception {
		int[][] matrix = zm.assign(new int[][] {
			{0,1,1},
			{1,0,1},
			{1,1,0}
		});
		
		for (int i=0; i < matrix.length; i++) {
			for (int j=0; j < matrix[i].length; j++) {
				assertEquals(0, matrix[i][j]);
			}
		}
	}

	/**
	 * Test method for {@link com.smt.kata.data.ZeroMatrix#assign(int[][])}.
	 */
	@Test
	void testAssignOuter() throws Exception {
		int[][] matrix = zm.assign(new int[][] {
			{0,1,2,0},
			{3,4,5,2},
			{1,3,1,5}
		});
		
		// Make sure the first column is set to 0
		assertEquals(0, matrix[0][0]);
		assertEquals(0, matrix[1][0]);
		assertEquals(0, matrix[2][0]);
		
		// Make sure the last column is set to 0
		assertEquals(0, matrix[0][3]);
		assertEquals(0, matrix[1][3]);
		assertEquals(0, matrix[2][3]);
		
		// Make sure the top row inner is set to 0
		assertEquals(0, matrix[0][1]);
		assertEquals(0, matrix[0][2]);
	}
}
