package com.smt.kata.game;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// Kata Imports
import com.smt.kata.game.TicTacToeCheck.Player;

/****************************************************************************
 * <b>Title</b>: TicTacToeCheckTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Tests for the Tic-Tac-Toe Check kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 26, 2021
 * @updates:
 ****************************************************************************/
class TicTacToeCheckTest {
	
	// Members
	TicTacToeCheck tttc = new TicTacToeCheck();

	/**
	 * Test method for {@link com.smt.kata.game.TicTacToeCheck#evaluate(int{}{})}.
	 */
	@Test
	void testEvaluateNull() throws Exception {
		assertEquals(Player.N, tttc.evaluate(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.TicTacToeCheck#evaluate(int{}{})}.
	 */
	@Test
	void testEvaluateEmpty() throws Exception {
		assertEquals(Player.N, tttc.evaluate(new int[0][]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.TicTacToeCheck#evaluate(int{}{})}.
	 */
	@Test
	void testEvaluateNullCol() throws Exception {
		assertEquals(Player.N, tttc.evaluate(new int[3][]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.TicTacToeCheck#evaluate(int{}{})}.
	 */
	@Test
	void testEvaluateEmptyCol() throws Exception {
		assertEquals(Player.N, tttc.evaluate(new int[3][0]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.TicTacToeCheck#evaluate(int{}{})}.
	 */
	@Test
	void testEvaluateExampleOne() throws Exception {
		int[][] moves = new int[][] {{0,0},{2,0},{1,1},{2,1},{2,2}};
		assertEquals(Player.A, tttc.evaluate(moves));
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.TicTacToeCheck#evaluate(int{}{})}.
	 */
	@Test
	void testEvaluateExampleTwo() throws Exception {
		int[][] moves = new int[][]{{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
		assertEquals(Player.B, tttc.evaluate(moves));
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.TicTacToeCheck#evaluate(int{}{})}.
	 */
	@Test
	void testEvaluateExampleThree() throws Exception {
		int[][] moves = new int[][]{{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};
		assertEquals(Player.N, tttc.evaluate(moves));
	}

	/**
	 * Test method for {@link com.smt.kata.game.TicTacToeCheck#evaluate(int{}{})}.
	 */
	@Test
	void testEvaluateExampleFour() throws Exception {
		int[][] moves = new int[][]{{0,0},{1,1}};
		assertEquals(Player.N, tttc.evaluate(moves));
	}
}
