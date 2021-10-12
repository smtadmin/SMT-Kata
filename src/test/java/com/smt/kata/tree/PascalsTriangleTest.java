package com.smt.kata.tree;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: PascalsTriangleTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Pascals Triangle Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 27, 2021
 * @updates:
 ****************************************************************************/
class PascalsTriangleTest {

	// Members
	private PascalsTriangle pt = new PascalsTriangle();
	
	/**
	 * Test method for {@link com.smt.kata.tree.PascalsTriangle#build(int)}.
	 */
	@Test
	void testBuildNegative() throws Exception {
		int[][] triangle = pt.build(-1);
		assertEquals(0, triangle.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.PascalsTriangle#build(int)}.
	 */
	@Test
	void testBuildOne() throws Exception {
		int[][] triangle = pt.build(1);
		assertEquals(1, triangle[0][0]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.PascalsTriangle#build(int)}.
	 */
	@Test
	void testBuildTwo() throws Exception {
		int[][] triangle = pt.build(2);
		assertEquals(1, triangle[0][0]);
		assertEquals(1, triangle[1][0]);
		assertEquals(1, triangle[1][1]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.PascalsTriangle#build(int)}.
	 */
	@Test
	void testBuildThree() throws Exception {
		int[][] triangle = pt.build(3);
		assertEquals(1, triangle[2][0]);
		assertEquals(2, triangle[2][1]);
		assertEquals(1, triangle[2][2]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.PascalsTriangle#build(int)}.
	 */
	@Test
	void testBuildFour() throws Exception {
		int[][] triangle = pt.build(4);
		assertEquals(1, triangle[3][0]);
		assertEquals(3, triangle[3][1]);
		assertEquals(3, triangle[3][2]);
		assertEquals(1, triangle[3][3]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.PascalsTriangle#build(int)}.
	 */
	@Test
	void testBuildFive() throws Exception {
		int[][] triangle = pt.build(5);
		assertEquals(1, triangle[4][0]);
		assertEquals(4, triangle[4][1]);
		assertEquals(6, triangle[4][2]);
		assertEquals(4, triangle[4][3]);
		assertEquals(1, triangle[4][4]);
	}
}
