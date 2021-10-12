package com.smt.kata.tree;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: TrianglePathTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Triangle Path Kata Unit Test
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 14, 2021
 * @updates:
 ****************************************************************************/
class TrianglePathTest {

	// Members
	TrianglePath tp = new TrianglePath();
	
	/**
	 * Test method for {@link com.smt.kata.tree.TrianglePath#sum(int[][])}.
	 */
	@Test
	void testSumNull() throws Exception {
		assertEquals(0, tp.sum(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.TrianglePath#sum(int[][])}.
	 */
	@Test
	void testSumEmpty() throws Exception {
		assertEquals(0, tp.sum(new int[0][]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.TrianglePath#sum(int[][])}.
	 */
	@Test
	void testSumNullRow() throws Exception {
		int[][] triangle = new int[1][];
		triangle[0] = null;
		assertEquals(0, tp.sum(triangle));
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.TrianglePath#sum(int[][])}.
	 */
	@Test
	void testSumEmptyRow() throws Exception {
		int[][] triangle = new int[1][];
		triangle[0] = new int[] {};
		assertEquals(0, tp.sum(triangle));
	}
	
	
	/**
	 * Test method for {@link com.smt.kata.tree.TrianglePath#sum(int[][])}.
	 */
	@Test
	void testSumDefault() throws Exception {
		assertEquals(11, tp.sum(new int[][] {{2},{3,4},{6,5,7},{4,1,8,3} }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.TrianglePath#sum(int[][])}.
	 */
	@Test
	void testSumDepthFive() throws Exception {
		assertEquals(41, tp.sum(new int[][] {
			{1},
			{7,12},
			{13, 5, 27},
			{25, 10, 22, 1},
			{16, 18, 20, 22, 24} 
		}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.TrianglePath#sum(int[][])}.
	 */
	@Test
	void testSumDepthFiveOuter() throws Exception {
		assertEquals(38, tp.sum(new int[][] {
			{1},
			{7,12},
			{13, 5, 2},
			{25, 10, 22, 1},
			{16, 18, 20, 24, 22} 
		}));
	}
	
	
	/**
	 * Test method for {@link com.smt.kata.tree.TrianglePath#sum(int[][])}.
	 */
	@Test
	void testSumSingle() throws Exception {
		assertEquals(-10, tp.sum(new int[][] {{-10}}));
	}
}
