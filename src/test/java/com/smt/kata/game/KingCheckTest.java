package com.smt.kata.game;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: KingCheckTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Tests for the King in Check Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 6, 2021
 * @updates:
 ****************************************************************************/
class KingCheckTest {

	// Members
	KingCheck kc;
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckNull() throws Exception {
		kc = new KingCheck(null);
		assertFalse(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckTooSmallCol() throws Exception {
		kc = new KingCheck(new char[8][7]);
		assertFalse(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckTooSmallRow() throws Exception {
		kc = new KingCheck(new char[][] {
			null,
			null,
			null,
			null,
			null,
			null,
			null,
			null
		});
		
		assertFalse(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckNoKing() throws Exception {
		kc = new KingCheck(new char[][] {
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','B','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','P','O' },
			{ 'O','O','O','O','O','O','O','R' },
			{ 'O','O','N','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','Q','O','O' }
		});
		
		assertFalse(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckBishop() throws Exception {
		kc = new KingCheck(new char[][] {
			{ 'O','O','O','K','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','B','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','P','O' },
			{ 'O','O','O','O','O','O','O','R' },
			{ 'O','O','N','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','Q','O','O' }
		});
		
		assertTrue(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckBishopBlocked() throws Exception {
		kc = new KingCheck(new char[][] {
			{ 'O','O','O','K','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','R','O','O','O','O','O','O' },
			{ 'B','O','O','O','O','O','P','O' },
			{ 'O','O','O','O','O','O','O','R' },
			{ 'O','O','N','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','Q','O','O' }
		});
		
		assertFalse(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckPawn() throws Exception {
		kc = new KingCheck(new char[][] {
			{ 'O','O','O','K','O','O','O','O' },
			{ 'O','O','P','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','P','O' },
			{ 'O','O','O','O','O','O','O','R' },
			{ 'O','O','N','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','Q','O','O' }
		});
		
		assertTrue(kc.isKingCheck());
	}
	
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckRookRow() throws Exception {
		kc = new KingCheck(new char[][] {
			{ 'O','O','O','K','O','O','O','R' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','P','O' },
			{ 'O','B','O','O','O','O','O','R' },
			{ 'O','O','N','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','Q','O','O' }
		});
		
		assertTrue(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckRookColumn() throws Exception {
		kc = new KingCheck(new char[][] {
			{ 'O','O','O','K','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','P','O' },
			{ 'O','B','O','O','O','O','O','R' },
			{ 'O','O','N','R','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','Q','O','O' }
		});
		
		assertTrue(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckRookColumnBlocked() throws Exception {
		kc = new KingCheck(new char[][] {
			{ 'O','O','O','K','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','P','O','O','P','O' },
			{ 'O','B','O','O','O','O','O','R' },
			{ 'O','O','N','R','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','Q','O','O' }
		});
		
		assertFalse(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckQueenVertical() throws Exception {
		kc = new KingCheck(new char[][] {
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','K','O','O','P','O' },
			{ 'O','B','O','O','O','O','O','R' },
			{ 'O','N','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','Q','O','Q','O','O' }
		});
		
		assertTrue(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckQueenDiagonal() throws Exception {
		kc = new KingCheck(new char[][] {
			{ 'O','O','O','O','O','O','O','Q' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','P','O' },
			{ 'O','B','O','K','O','O','O','B' },
			{ 'O','N','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','P','O','R' }
		});
		
		assertTrue(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckQueenDiagonalBlocked() throws Exception {
		kc = new KingCheck(new char[][] {
			{ 'O','O','O','O','O','O','O','Q' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','P','O','O' },
			{ 'O','O','O','O','O','O','P','O' },
			{ 'O','B','O','K','O','O','O','B' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','P','O','R' }
		});
		
		assertFalse(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckKnightUpperLeft() throws Exception {
		kc = new KingCheck(new char[][] {
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','P','O','O' },
			{ 'O','O','O','O','O','O','P','O' },
			{ 'O','B','O','K','O','O','O','B' },
			{ 'O','N','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','P','O','R' }
		});
		
		assertTrue(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckKnightLowerRight() throws Exception {
		kc = new KingCheck(new char[][] {
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','N','P','O','O' },
			{ 'O','O','O','O','O','O','P','O' },
			{ 'O','B','O','K','O','O','O','B' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','P','O','R' }
		});
		
		assertTrue(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckKnightLowerRightBlocked() throws Exception {
		kc = new KingCheck(new char[][] {
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','N','P','O','O' },
			{ 'O','O','O','B','R','O','P','O' },
			{ 'O','B','O','K','O','O','O','B' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','P','O','R' }
		});
		
		assertTrue(kc.isKingCheck());
	}
	
	/**
	 * Test method for {@link com.smt.kata.game.KingCheck#isKingCheck(char[][])}.
	 */
	@Test
	void testIsKingCheckOnlyKing() throws Exception {
		kc = new KingCheck(new char[][] {
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','K','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' },
			{ 'O','O','O','O','O','O','O','O' }
		});
		
		assertFalse(kc.isKingCheck());
	}
}
