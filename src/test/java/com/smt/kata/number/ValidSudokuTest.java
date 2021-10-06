package com.smt.kata.number;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: ValidSudokuTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit test for the Valid Sudoku Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 24, 2021
 * @updates:
 ****************************************************************************/
class ValidSudokuTest {

	// Members
	ValidSudoku vs = new ValidSudoku();
	
	/**
	 * Test method for {@link com.smt.kata.number.ValidSudoku#isValid(java.lang.String[][])}.
	 */
	@Test
	void testIsValidExampleOne() throws Exception {
		String[][] board = {
			{"5","3",".",".","7",".",".",".","."},
			{"6",".",".","1","9","5",".",".","."},
			{".","9","8",".",".",".",".","6","."},
			{"8",".",".",".","6",".",".",".","3"},
			{"4",".",".","8",".","3",".",".","1"},
			{"7",".",".",".","2",".",".",".","6"},
			{".","6",".",".",".",".","2","8","."},
			{".",".",".","4","1","9",".",".","5"},
			{".",".",".",".","8",".",".","7","9"}
		};
		
		assertTrue(vs.isValid(board));
	}

	/**
	 * Test method for {@link com.smt.kata.number.ValidSudoku#isValid(java.lang.String[][])}.
	 */
	@Test
	void testIsValidExample2() throws Exception {
		String[][] board = {
			{"8","3",".",".","7",".",".",".","."},
			{"6",".",".","1","9","5",".",".","."},
			{".","9","8",".",".",".",".","6","."},
			{"8",".",".",".","6",".",".",".","3"},
			{"4",".",".","8",".","3",".",".","1"},
			{"7",".",".",".","2",".",".",".","6"},
			{".","6",".",".",".",".","2","8","."},
			{".",".",".","4","1","9",".",".","5"},
			{".",".",".",".","8",".",".","7","9"}
		};
		
		assertFalse(vs.isValid(board));
	}
}
