package com.smt.kata.data;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> CharacterBoardTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit test for the Character Board Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 15, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class CharacterBoardTest {
	
	
	char[][] board1 = new char[][] {
		{'A', 'B', 'C', 'E'},
		{'S', 'F', 'C', 'S'},
		{'A', 'D', 'E', 'E'}
	};

	/**
	 * Test method for {@link com.smt.kata.data.CharacterBoard#CharacterBoard(char[][])}.
	 */
	@Test
	void testCharacterBoard() throws Exception {
		CharacterBoard cb = new CharacterBoard(board1);
		assertNotNull(cb);
	}

	/**
	 * Test method for {@link com.smt.kata.data.CharacterBoard#exists(java.lang.String)}.
	 */
	@Test
	void testExistsEmpty() throws Exception {
		CharacterBoard cb = new CharacterBoard(board1);
		assertFalse(cb.exists(""));
		assertFalse(cb.exists(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.CharacterBoard#exists(java.lang.String)}.
	 */
	@Test
	void testExistsNoMatchFirst() throws Exception {
		CharacterBoard cb = new CharacterBoard(board1);
		assertFalse(cb.exists("LOW"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.CharacterBoard#exists(java.lang.String)}.
	 */
	@Test
	void testExistsNoMatch() throws Exception {
		CharacterBoard cb = new CharacterBoard(board1);
		assertFalse(cb.exists("SOW"));
		assertFalse(cb.exists("Ace"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.CharacterBoard#exists(java.lang.String)}.
	 */
	@Test
	void testExists() throws Exception {
		CharacterBoard cb = new CharacterBoard(board1);
		assertTrue(cb.exists("SEE"));
		assertTrue(cb.exists("see"));
		assertTrue(cb.exists("SCB"));
	}

	/**
	 * Test method for {@link com.smt.kata.data.CharacterBoard#exists(java.lang.String)}.
	 */
	@Test
	void testExistsABCCED() throws Exception {
		CharacterBoard cb = new CharacterBoard(board1);
		assertTrue(cb.exists("ABCCED"));
		assertTrue(cb.exists("ABCB"));
	}
}
