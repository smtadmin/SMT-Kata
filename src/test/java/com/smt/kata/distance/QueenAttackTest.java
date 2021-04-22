package com.smt.kata.distance;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> QueenAttackTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit test for the Queen Attack Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 22, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class QueenAttackTest {
	
	// Members
	private char[][] chessboard = new char[8][8];
	private QueenAttack qa = new QueenAttack(chessboard);

	/**
	 * Test method for {@link com.smt.kata.distance.QueenAttack#QueenAttack(char[][])}.
	 */
	@Test
	void testQueenAttack() throws Exception {
		assertNotNull(qa);
		assertEquals('-', chessboard[0][0]);
		assertEquals('-', chessboard[7][7]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.QueenAttack#QueenAttack(char[][])}.
	 */
	@Test
	void testQueenAttackBad() throws Exception {
		assertFalse(qa.canAttack(null, new int[] {2,0}));
		assertFalse(qa.canAttack(new int[] {2,3}, null));
		assertFalse(qa.canAttack(null, null));
		assertFalse(qa.canAttack(new int[] {2,3,4}, new int[] {2,0}));
		assertFalse(qa.canAttack(new int[] {2,3}, new int[] {2,0, 1}));
	}

	/**
	 * Test method for {@link com.smt.kata.distance.QueenAttack#canAttack(int[], int[])}.
	 */
	@Test
	void testCanAttackHorizontally() throws Exception {
		assertTrue(qa.canAttack(new int[] {2,3}, new int[] {2,0}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.QueenAttack#canAttack(int[], int[])}.
	 */
	@Test
	void testCanAttackVertically() throws Exception {
		assertTrue(qa.canAttack(new int[] {5,3}, new int[] {0,3}));
	}

	/**
	 * Test method for {@link com.smt.kata.distance.QueenAttack#canAttack(int[], int[])}.
	 */
	@Test
	void testCanAttackDiagonallyUpperLeft() throws Exception {
		assertTrue(qa.canAttack(new int[] {2,3}, new int[] {5,6}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.QueenAttack#canAttack(int[], int[])}.
	 */
	@Test
	void testCanAttackDiagonallyUpperRight() throws Exception {
		assertTrue(qa.canAttack(new int[] {1,5}, new int[] {4,2}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.QueenAttack#canAttack(int[], int[])}.
	 */
	@Test
	void testCanAttackDiagonallyLowerLeft() throws Exception {
		assertTrue(qa.canAttack(new int[] {4,2}, new int[] {1,5}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.QueenAttack#canAttack(int[], int[])}.
	 */
	@Test
	void testCanAttackDiagonallyLowerRight() throws Exception {
		assertTrue(qa.canAttack(new int[] {5,6}, new int[] {2,3}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.QueenAttack#canAttack(int[], int[])}.
	 */
	@Test
	void testCanNotAttack() throws Exception {
		assertFalse(qa.canAttack(new int[] {2,2}, new int[] {3, 6}));
	}
}
