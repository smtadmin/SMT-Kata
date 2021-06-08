package com.smt.kata.math;


// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: BaseBPalindromeTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Tests for the BaseBPalindrome test
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 17, 2021
 * @updates:
 ****************************************************************************/
class BaseBPalindromeTest {
	
	// Members
	BaseBPalindrome base = new BaseBPalindrome();

	/**
	 * Test method for {@link com.smt.kata.math.BaseBPalindrome#isPalindrome(int)}.
	 */
	@Test
	void testIsPalindromeTest() throws Exception {
		assertFalse(base.isPalindrome(10, 1));
		assertTrue(base.isPalindrome(0, 2));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.BaseBPalindrome#isPalindrome(int)}.
	 */
	@Test
	void testIsPalindromeTestBase2() throws Exception {
		assertFalse(base.isPalindrome(10, 2));
		assertFalse(base.isPalindrome(84, 2));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.BaseBPalindrome#isPalindrome(int)}.
	 */
	@Test
	void testIsPalindromeValidBase2() throws Exception {
		assertTrue(base.isPalindrome(3, 2));
		assertTrue(base.isPalindrome(-3, 2));
		assertTrue(base.isPalindrome(85, 2));
	}

	/**
	 * Test method for {@link com.smt.kata.math.BaseBPalindrome#isPalindrome(int)}.
	 */
	@Test
	void testIsPalindromeValidBase16() throws Exception {
		assertTrue(base.isPalindrome(255, 16));
		assertTrue(base.isPalindrome(47787, 16));
		assertFalse(base.isPalindrome(47788, 16));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.BaseBPalindrome#isPalindrome(int)}.
	 */
	@Test
	void testIsPalindromeValidBase10() throws Exception {
		assertTrue(base.isPalindrome(1001, 10));
		assertTrue(base.isPalindrome(777777777, 10));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.BaseBPalindrome#isPalindrome(int)}.
	 */
	@Test
	void testIsPalindromeValidBase8() throws Exception {
		assertTrue(base.isPalindrome(1160412, 8));
		assertFalse(base.isPalindrome(1160413, 10));
	}
}
