package com.smt.kata.distance;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: MaximalRectangleTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> unit Test for the Maximal Rectangle Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 28, 2021
 * @updates:
 ****************************************************************************/
class MaximalRectangleTest {

	// Members
	private MaximalRectangle mr = new MaximalRectangle();
	
	/**
	 * Test method for {@link com.smt.kata.distance.MaximalRectangle#calculate(int[][])}.
	 */
	@Test
	void testCalculate() throws Exception {
		int[][] matrix = new int[][] {
			{1,0,1,0,0},
			{1,0,1,1,1},
			{1,1,1,1,1},
			{1,0,0,1,0}
		};
		
		assertEquals(6, mr.calculate(matrix));
	}

	/**
	 * Test method for {@link com.smt.kata.distance.MaximalRectangle#calculate(int[][])}.
	 */
	@Test
	void testCalculateSingleZero() throws Exception {
		int[][] matrix = new int[][] {
			{0}
		};
		
		assertEquals(0, mr.calculate(matrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MaximalRectangle#calculate(int[][])}.
	 */
	@Test
	void testCalculateNull() throws Exception {
		assertEquals(0, mr.calculate(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MaximalRectangle#calculate(int[][])}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		int[][] matrix = new int[0][];
		
		assertEquals(0, mr.calculate(matrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MaximalRectangle#calculate(int[][])}.
	 */
	@Test
	void testCalculateSingleOne() throws Exception {
		int[][] matrix = new int[][] {
			{1}
		};
		
		assertEquals(1, mr.calculate(matrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MaximalRectangle#calculate(int[][])}.
	 */
	@Test
	void testCalculateDoubleZero() throws Exception {
		int[][] matrix = new int[][] {
			{0, 0}
		};
		
		assertEquals(0, mr.calculate(matrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MaximalRectangle#calculate(int[][])}.
	 */
	@Test
	void testCalculateAllOnes() throws Exception {
		int[][] matrix = new int[][] {
			{1,1,1,1,1},
			{1,1,1,1,1},
			{1,1,1,1,1},
			{1,1,1,1,1}
		};
		
		assertEquals(20, mr.calculate(matrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MaximalRectangle#calculate(int[][])}.
	 */
	@Test
	void testCalculateAllZero() throws Exception {
		int[][] matrix = new int[][] {
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
		};
		
		assertEquals(0, mr.calculate(matrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MaximalRectangle#calculate(int[][])}.
	 */
	@Test
	void testCalculateFirstColumnAllOne() throws Exception {
		int[][] matrix = new int[][] {
			{1,0,0,0,0},
			{1,0,0,0,0},
			{1,0,0,0,0},
			{1,0,0,0,0}
		};
		
		assertEquals(4, mr.calculate(matrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MaximalRectangle#calculate(int[][])}.
	 */
	@Test
	void testCalculateLastColumnAllOne() throws Exception {
		int[][] matrix = new int[][] {
			{0,0,0,0,1},
			{0,0,0,0,1},
			{0,0,0,0,1},
			{0,0,0,0,1}
		};
		
		assertEquals(4, mr.calculate(matrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MaximalRectangle#calculate(int[][])}.
	 */
	@Test
	void testCalculateFirstRowAllOne() throws Exception {
		int[][] matrix = new int[][] {
			{1,1,1,1,1},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
		};
		
		assertEquals(5, mr.calculate(matrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MaximalRectangle#calculate(int[][])}.
	 */
	@Test
	void testCalculateLastRowAllOne() throws Exception {
		int[][] matrix = new int[][] {
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{1,1,1,1,1}
		};
		
		assertEquals(5, mr.calculate(matrix));
	}
}
