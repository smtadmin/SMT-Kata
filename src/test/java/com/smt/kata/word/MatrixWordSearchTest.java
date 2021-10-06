package com.smt.kata.word;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: MatrixWordSearchTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit test for the Matrix Search Word Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 28, 2021
 * @updates:
 ****************************************************************************/
class MatrixWordSearchTest {
	
	// Members
	MatrixWordSearch mws = new MatrixWordSearch();
	String[][] board = new String[][] {
		{"A","B","C","E"},
		{"S","F","C","S"},
		{"A","D","E","E"}
	};
	
	/**
	 * Test method for {@link com.smt.kata.word.MatrixWordSearch#find(java.lang.String[}[], java.lang.String)}.
	 */
	@Test
	void testFindExampleNullBoard() throws Exception {
		assertFalse(mws.find(null, "ABCCED"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.MatrixWordSearch#find(java.lang.String[}[], java.lang.String)}.
	 */
	@Test
	void testFindExampleEmptyBoard() throws Exception {
		assertFalse(mws.find(new String[0][], "ABCCED"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.MatrixWordSearch#find(java.lang.String[}[], java.lang.String)}.
	 */
	@Test
	void testFindExampleNullWord() throws Exception {
		assertFalse(mws.find(board, null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.MatrixWordSearch#find(java.lang.String[}[], java.lang.String)}.
	 */
	@Test
	void testFindExampleEmptyWord() throws Exception {
		assertFalse(mws.find(board, "ZLMFT"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.MatrixWordSearch#find(java.lang.String[}[], java.lang.String)}.
	 */
	@Test
	void testFindExampleNotPresent() throws Exception {
		assertFalse(mws.find(board, ""));
	}

	/**
	 * Test method for {@link com.smt.kata.word.MatrixWordSearch#find(java.lang.String[}[], java.lang.String)}.
	 */
	@Test
	void testFindExampleOne() throws Exception {
		assertTrue(mws.find(board, "ABCCED"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.MatrixWordSearch#find(java.lang.String[}[], java.lang.String)}.
	 */
	@Test
	void testFindExampleTwo() throws Exception {
		assertTrue(mws.find(board, "SEE"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.MatrixWordSearch#find(java.lang.String[}[], java.lang.String)}.
	 */
	@Test
	void testFindExampleThree() throws Exception {
		assertFalse(mws.find(board, "ABCB"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.MatrixWordSearch#find(java.lang.String[}[], java.lang.String)}.
	 */
	@Test
	void testFindExampleBackwards() throws Exception {
		assertTrue(mws.find(board, "DECCBA"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.MatrixWordSearch#find(java.lang.String[}[], java.lang.String)}.
	 */
	@Test
	void testFindExampleSeed() throws Exception {
		assertTrue(mws.find(board, "SEED"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.MatrixWordSearch#find(java.lang.String[}[], java.lang.String)}.
	 */
	@Test
	void testFindExampleOverlap() throws Exception {
		assertFalse(mws.find(board, "SECCS"));
	}


}
