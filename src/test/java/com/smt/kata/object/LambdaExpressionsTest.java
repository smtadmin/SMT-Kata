package com.smt.kata.object;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: LambdaExpressionsTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 24, 2021
 * @updates:
 ****************************************************************************/
class LambdaExpressionsTest {
	
	// Members
	LambdaExpressions le = new LambdaExpressions();

	/**
	 * Test method for {@link com.smt.kata.object.LambdaExpressions#isOdd(int)}.
	 */
	@Test
	void testIsOdd() throws Exception {
		assertTrue(le.isOdd(35));
		assertTrue(le.isOdd(1345678935));
		assertFalse(le.isOdd(246));
		assertFalse(le.isOdd(345678246));
	}

	/**
	 * Test method for {@link com.smt.kata.object.LambdaExpressions#isPalindrome(java.lang.String)}.
	 */
	@Test
	void testIsPalindrome() throws Exception {
		assertTrue(le.isPalindrome("peep"));
		assertTrue(le.isPalindrome("PeEp"));
		assertFalse(le.isPalindrome("james"));
	}

	/**
	 * Test method for {@link com.smt.kata.object.LambdaExpressions#isPrime(int)}.
	 */
	@Test
	void testIsPrime() throws Exception {
		assertFalse(le.isPrime(24));
		assertFalse(le.isPrime(24242424));
		assertTrue(le.isPrime(37));
	}

}
