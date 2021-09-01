package com.smt.kata.tree;

// JDK 11.x
import java.util.Arrays;

// Junit 5
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: WallsAndGatesTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Walls and Gates Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 30, 2021
 * @updates:
 ****************************************************************************/
class WallsAndGatesTest {
	
	// Members
	private final int INF = 99999999;
	private WallsAndGates wag = new WallsAndGates();
	
	/**
	 * Test method for {@link com.smt.kata.tree.WallsAndGates#assign(int[][])}.
	 */
	@Test
	void testAssignNull() throws Exception {
		assertEquals(0, wag.assign(null).length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.WallsAndGates#assign(int[][])}.
	 */
	@Test
	void testAssignEmpty() throws Exception {
		assertEquals(0, wag.assign(new int[0][]).length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.WallsAndGates#assign(int[][])}.
	 */
	@Test
	void testAssignNullRow() throws Exception {
		int[][] rooms = new int[][] { null };
		assertEquals(0, wag.assign(rooms).length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.WallsAndGates#assign(int[][])}.
	 */
	@Test
	void testAssignEmptyRow() throws Exception {
		int[][] rooms = new int[3][0];
		assertEquals(0, wag.assign(rooms).length);
	}

	/**
	 * Test method for {@link com.smt.kata.tree.WallsAndGates#assign(int[][])}.
	 */
	@Test
	void testAssignBase() throws Exception {
		int[][] rooms = new int[][] {
			{ INF, -1,  0,   INF },
			{ INF, INF, INF, -1 },
			{ INF, -1, INF,  -1 },
			{ 0, -1, INF, INF }
		};
		
		int[][] newRooms = wag.assign(rooms);
		assertTrue(Arrays.equals(new int[] { 3, -1, 0,  1 }, newRooms[0]));
		assertTrue(Arrays.equals(new int[] { 2,  2, 1, -1 }, newRooms[1]));
		assertTrue(Arrays.equals(new int[] { 1, -1, 2, -1 }, newRooms[2]));
		assertTrue(Arrays.equals(new int[] { 0, -1, 3,  4 }, newRooms[3]));
	}

	/**
	 * Test method for {@link com.smt.kata.tree.WallsAndGates#assign(int[][])}.
	 */
	@Test
	void testAssignNoPath() throws Exception {
		int[][] rooms = new int[][] {
			{ INF, -1,  INF,   INF },
			{ INF, INF, INF, -1 },
			{ -1, -1, INF,  -1 },
			{ 0, -1, INF, INF }
		};
		
		int[][] newRooms = wag.assign(rooms);
		assertTrue(Arrays.equals(new int[] { INF, -1,  INF,   INF }, newRooms[0]));
		assertTrue(Arrays.equals(new int[] { INF, INF, INF, -1 }, newRooms[1]));
		assertTrue(Arrays.equals(new int[] { -1, -1, INF,  -1 }, newRooms[2]));
		assertTrue(Arrays.equals(new int[] { 0, -1, INF, INF }, newRooms[3]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.WallsAndGates#assign(int[][])}.
	 */
	@Test
	void testAssignSingleGate() throws Exception {
		int[][] rooms = new int[][] {
			{ INF, -1,  0,   INF },
			{ INF, INF, INF, -1 },
			{ INF, -1, INF,  -1 },
			{ INF, -1, -1, INF }
		};
		
		int[][] newRooms = wag.assign(rooms);
		for(int[] row : newRooms) System.out.println(Arrays.toString(row));
		assertTrue(Arrays.equals(new int[] { 4, -1, 0, 1 }, newRooms[0]));
		assertTrue(Arrays.equals(new int[] { 3, 2, 1, -1 }, newRooms[1]));
		assertTrue(Arrays.equals(new int[] { 4, -1, 2, -1 }, newRooms[2]));
		assertTrue(Arrays.equals(new int[] { 5, -1, -1, INF }, newRooms[3]));
	}
}
