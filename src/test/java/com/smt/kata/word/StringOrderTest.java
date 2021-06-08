package com.smt.kata.word;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> StringOrderTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit test for the String Order kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class StringOrderTest {
	
	// Members
	private StringOrder so = new StringOrder();
	
	/**
	 * Test method for {@link com.smt.kata.word.StringOrder#isInOrder(java.lang.String)}.
	 */
	@Test
	void testIsInOrderEmpty() throws Exception {
		assertFalse(so.isInOrder(""));
		assertFalse(so.isInOrder(null));
		assertTrue(so.isInOrder("1"));
	}

	/**
	 * Test method for {@link com.smt.kata.word.StringOrder#isInOrder(java.lang.String)}.
	 */
	@Test
	void testIsInOrderABC() throws Exception {
		assertTrue(so.isInOrder("abc"));
		assertTrue(so.isInOrder("al"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.StringOrder#isInOrder(java.lang.String)}.
	 */
	@Test
	void testIsInOrderDdabit() throws Exception {
		assertFalse(so.isInOrder("edabit"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.StringOrder#isInOrder(java.lang.String)}.
	 */
	@Test
	void testIsInOrder369() throws Exception {
		assertTrue(so.isInOrder("369"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.StringOrder#isInOrder(java.lang.String)}.
	 */
	@Test
	void testIsInOrderXYZZ() throws Exception {
		assertTrue(so.isInOrder("xyzz"));
		assertTrue(so.isInOrder("xxxxxxxyyyyyyyzzzzzzz"));
	}

	/**
	 * Test method for {@link com.smt.kata.word.StringOrder#isInOrder(java.lang.String)}.
	 */
	@Test
	void testIsInOrderMixed() throws Exception {
		assertFalse(so.isInOrder("aBc"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.StringOrder#isInOrder(java.lang.String)}.
	 */
	@Test
	void testIsInOrderMixedGood() throws Exception {
		assertTrue(so.isInOrder("159BLMac"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.StringOrder#isInOrder(java.lang.String)}.
	 */
	@Test
	void testIsInOrderNonAlpha() throws Exception {
		assertTrue(so.isInOrder(" \"+9:>\\_dkl"));
	}
}
