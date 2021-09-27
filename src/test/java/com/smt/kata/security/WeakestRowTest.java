package com.smt.kata.security;

// junit 5
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/****************************************************************************
 * <b>Title</b>: WeakestRowTest.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Unit tests for the Weakest Row Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 16, 2021
 * @updates:
 ****************************************************************************/
class WeakestRowTest {

	// Members
	WeakestRow wr = new WeakestRow();
	
	/**
	 * Test method for {@link com.smt.kata.security.WeakestRow#find(int[][], int)}.
	 */
	@Test
	void testFindNull() throws Exception {
		assertEquals(0, wr.find(null, 3).length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.WeakestRow#find(int[][], int)}.
	 */
	@Test
	void testFindEmpty() throws Exception {
		assertEquals(0, wr.find(new int[0][], 3).length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.WeakestRow#find(int[][], int)}.
	 */
	@Test
	void testFindRowNull() throws Exception {
		assertEquals(0, wr.find(new int[][] {null}, 3).length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.WeakestRow#find(int[][], int)}.
	 */
	@Test
	void testFindRowEmpty() throws Exception {
		assertEquals(0, wr.find(new int[][] {{}}, 3).length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.WeakestRow#find(int[][], int)}.
	 */
	@Test
	void testFindNegativeK() throws Exception {
		assertEquals(0, wr.find(new int[][] {{1,2,3}}, -3).length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.WeakestRow#find(int[][], int)}.
	 */
	@Test
	void testFindLargeK() throws Exception {
		assertEquals(0, wr.find(new int[][] {{1,2,3}}, 13).length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.WeakestRow#find(int[][], int)}.
	 */
	@Test
	void testFindDefault() throws Exception {
		int[][] matrix = new int[][] {
			{1,1,0,0,0},
			{1,1,1,1,0},
			{1,0,0,0,0},
			{1,1,0,0,0},
			{1,1,1,1,1}
		};
		
		List<Integer> res = Arrays.stream(wr.find(matrix, 3)).mapToObj(i -> i).collect(Collectors.toList());
		assertEquals(3, res.size());
		assertTrue(res.contains(2));
		assertTrue(res.contains(0));
		assertTrue(res.contains(3));
	}

	/**
	 * Test method for {@link com.smt.kata.security.WeakestRow#find(int[][], int)}.
	 */
	@Test
	void testFindSmaller() throws Exception {
		int[][] matrix = new int[][] {
			{1,0,0,0},
			{1,1,1,1},
			{1,0,0,0},
			{1,0,0,0}
		};
		
		List<Integer> res = Arrays.stream(wr.find(matrix, 2)).mapToObj(i -> i).collect(Collectors.toList());
		assertEquals(2, res.size());
		assertTrue(res.contains(0));
		assertTrue(res.contains(2));
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.WeakestRow#find(int[][], int)}.
	 */
	@Test
	void testFindNoSoldier() throws Exception {
		int[][] matrix = new int[][] {
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0}
		};
		
		List<Integer> res = Arrays.stream(wr.find(matrix, 2)).mapToObj(i -> i).collect(Collectors.toList());
		assertEquals(2, res.size());
		assertTrue(res.contains(0));
		assertTrue(res.contains(1));
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.WeakestRow#find(int[][], int)}.
	 */
	@Test
	void testFindALLSoldier() throws Exception {
		int[][] matrix = new int[][] {
			{1,1,1,1},
			{1,1,1,1},
			{1,1,1,1},
			{1,1,1,1},
			{1,1,1,1},
			{1,1,1,1},
			{1,1,1,1},
			{1,1,1,1}
		};
		
		List<Integer> res = Arrays.stream(wr.find(matrix, 8)).mapToObj(i -> i).collect(Collectors.toList());
		assertEquals(8, res.size());
		assertTrue(res.contains(0));
		assertTrue(res.contains(1));
		assertTrue(res.contains(7));
	}

}
