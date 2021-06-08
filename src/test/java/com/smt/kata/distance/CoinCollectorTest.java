package com.smt.kata.distance;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: CoinCollectorTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the coin collector
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 20, 2021
 * @updates:
 ****************************************************************************/
class CoinCollectorTest {
	
	// Members
	CoinCollector cc = new CoinCollector();
	
	int[][] firstMatrix = new int[][] {
		{0, 3, 1, 1},
		{2, 0, 0, 4},
		{1, 5, 3, 1}
	};
	
	int[][] secondMatrix = new int[][] {
		{3, 3, 3, 2},
		{1, 2, 3, 3},
		{1, 2, 6, 5}
	};
	
	int[][] thirdMatrix = new int[][] {
		{3},
		{7},
		{8}
	};
	
	int[][] fourthMatrix = new int[][] {
		{3, 3, 3, 9},
		{1, 2, 3, 3, 1, 2},
		{1, 2, 6, 5, 4}
	};

	/**
	 * Test method for {@link com.smt.kata.distance.CoinCollector#collect(int[][])}.
	 */
	@Test
	void testCollectFirst() throws Exception {
		assertEquals(12, cc.collect(firstMatrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.CoinCollector#collect(int[][])}.
	 */
	@Test
	void testCollectSecond() throws Exception {
		assertEquals(23, cc.collect(secondMatrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.CoinCollector#collect(int[][])}.
	 */
	@Test
	void testCollectThird() throws Exception {
		assertEquals(18, cc.collect(thirdMatrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.CoinCollector#collect(int[][])}.
	 */
	@Test
	void testCollectMismatch() throws Exception {
		assertEquals(30, cc.collect(fourthMatrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.CoinCollector#collect(int[][])}.
	 */
	@Test
	void testCollect() throws Exception {
		assertEquals(0, cc.collect(null));
		assertEquals(0, cc.collect(new int[0][0]));
	}

}
