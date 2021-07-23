package com.smt.kata.distance;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: RotateMatrixTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 28, 2021
 * @updates:
 ****************************************************************************/
class RotateMatrixTest {
	
	// Member
	RotateMatrix rm = new RotateMatrix();
	int[][] matrix;
	int[][] largeMatrix;
	int[][] smallMatrix;
	
	@BeforeEach
	void init() {
		smallMatrix = new int[][] {
			{1}
		};
		
		matrix = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		
		largeMatrix = new int[][] {
			{0,1,2,3,4,5,6,7,8,9},
			{0,1,2,3,4,5,6,7,8,9},
			{0,1,2,3,4,5,6,7,8,9},
			{0,1,2,3,4,5,6,7,8,9},
			{0,1,2,3,4,5,6,7,8,9},
			{0,1,2,3,4,5,6,7,8,9},
			{0,1,2,3,4,5,6,7,8,9},
			{0,1,2,3,4,5,6,7,8,9},
			{0,1,2,3,4,5,6,7,8,9},
			{0,1,2,3,4,5,6,7,8,9}
		};
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.RotateMatrix#rotateClockwise(int[][])}.
	 */
	@Test
	void testRotateClockwiseNull() {
		assertEquals(0, rm.rotateClockwise(null).length);
		assertEquals(0, rm.rotateClockwise(new int[0][]).length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.RotateMatrix#rotateCounterClockwise(int[][])}.
	 */
	@Test
	void testRotateCounterClockwiseNull() throws Exception {
		assertEquals(0, rm.rotateCounterClockwise(null).length);
		assertEquals(0, rm.rotateCounterClockwise(new int[0][]).length);
	}

	/**
	 * Test method for {@link com.smt.kata.distance.RotateMatrix#rotateClockwise(int[][])}.
	 */
	@Test
	void testRotateClockwise() throws Exception {
		int[][] rotated = rm.rotateClockwise(matrix);
		assertEquals(7, rotated[0][0]);
		assertEquals(5, rotated[1][1]);
		assertEquals(3, rotated[2][2]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.RotateMatrix#rotateClockwise(int[][])}.
	 */
	@Test
	void testRotateClockwiseLarge() throws Exception {
		int[][] rotated = rm.rotateClockwise(largeMatrix);
		for (int i=0; i < rotated.length; i++) {
			for (int x=0; x < rotated.length; x++) {
				assertEquals(i, rotated[i][x]);
			}
		}
	}

	/**
	 * Test method for {@link com.smt.kata.distance.RotateMatrix#rotateCounterClockwise(int[][])}.
	 */
	@Test
	void testRotateCounterClockwise() throws Exception {
		int[][] rotated = rm.rotateCounterClockwise(matrix);
		assertEquals(3, rotated[0][0]);
		assertEquals(5, rotated[1][1]);
		assertEquals(7, rotated[2][2]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.RotateMatrix#rotateCounterClockwise(int[][])}.
	 */
	@Test
	void testRotateCounterClockwiseLarge() throws Exception {
		int[][] rotated = rm.rotateCounterClockwise(largeMatrix);
		
		for (int i=0; i < rotated.length; i++) {
			for (int x=0; x < rotated.length; x++) {
				assertEquals(rotated.length - 1 - i, rotated[i][x]);
			}
		}
	}

	/**
	 * Test method for {@link com.smt.kata.distance.RotateMatrix#rotateClockwise(int[][])}.
	 */
	@Test
	void testRotateClockwiseSmall() throws Exception {
		int[][] rotated = rm.rotateClockwise(smallMatrix);
		assertEquals(1, rotated[0][0]);
	}
}
