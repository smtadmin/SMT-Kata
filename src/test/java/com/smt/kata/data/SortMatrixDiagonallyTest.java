package com.smt.kata.data;

//Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SortMatrixDiagonallyTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit tests for the Sort Matrix Diagonally Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 16, 2021
 * @updates:
 ****************************************************************************/
class SortMatrixDiagonallyTest {
	
	// Members
	SortMatrixDiagonally smd = new SortMatrixDiagonally();
	
	/**
	 * Test method for {@link com.smt.kata.data.SortMatrixDiagonally#sort(int[][])}.
	 */
	@Test
	void testSortNull() throws Exception {
		int[][] resultMatrix = smd.sort(null);
		assertEquals(0, resultMatrix.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.SortMatrixDiagonally#sort(int[][])}.
	 */
	@Test
	void testSortEmpty() throws Exception {
		int[][] resultMatrix = smd.sort(new int[0][]);
		assertEquals(0, resultMatrix.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.SortMatrixDiagonally#sort(int[][])}.
	 */
	@Test
	void testSortSingle() throws Exception {
		int[][] resultMatrix = smd.sort(new int[][] {{3,3,1,1}});
		assertEquals(1, resultMatrix[0][0]);
		assertEquals(1, resultMatrix[0][1]);
		assertEquals(3, resultMatrix[0][2]);
		assertEquals(3, resultMatrix[0][3]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.SortMatrixDiagonally#sort(int[][])}.
	 */
	@Test
	void testSortDual() throws Exception {
		int[][] resultMatrix = smd.sort(new int[][] {{3,3,1,1}, {5,6,7,8}});
		assertEquals(1, resultMatrix[0][0]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.SortMatrixDiagonally#sort(int[][])}.
	 */
	@Test
	void testSortSmall() throws Exception {
		int[][] resultMatrix = smd.sort(new int[][] {{3,3,1,1},{2,2,1,2},{1,1,1,2}});
		assertEquals(1, resultMatrix[0][0]);
		assertEquals(2, resultMatrix[1][1]);
		assertEquals(3, resultMatrix[2][2]);
		assertEquals(3, resultMatrix[2][3]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.SortMatrixDiagonally#sort(int[][])}.
	 */
	@Test
	void testSortSmallWithNegative() throws Exception {
		int[][] resultMatrix = smd.sort(new int[][] {{3,3,1,1},{-2,-2,-1,-2},{1,1,1,2}});
		assertEquals(-2, resultMatrix[0][0]);
		assertEquals(1, resultMatrix[1][1]);
		assertEquals(3, resultMatrix[2][2]);
		assertEquals(3, resultMatrix[2][3]);
	}

	/**
	 * Test method for {@link com.smt.kata.data.SortMatrixDiagonally#sort(int[][])}.
	 */
	@Test
	void testSortBig() throws Exception {
		int[][] resultMatrix = smd.sort(new int[][] {{11,25,66,1,69,7},{23,55,17,45,15,52},{75,31,36,44,58,8},{22,27,33,25,68,4},{84,28,14,11,5,50}});
		assertEquals(8, resultMatrix[0][0]);
		assertEquals(25, resultMatrix[1][1]);
		assertEquals(45, resultMatrix[2][2]);
		assertEquals(66, resultMatrix[3][3]);
		assertEquals(75, resultMatrix[4][4]);
		assertEquals(84, resultMatrix[4][5]);
	}
}
