package com.smt.kata.word;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: PalindromeTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the palindrome kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class PalindromeTest {

	@Test
	void testIsPalindrome() throws Exception {
	    Palindrome p = new Palindrome();
	    assertTrue(p.isPalindrome(1));
	    assertFalse(p.isPalindrome(20));
	    assertTrue(p.isPalindrome(22));
	    assertFalse(p.isPalindrome(102));
	    assertTrue(p.isPalindrome(101));
	    assertTrue(p.isPalindrome(1221));
	    assertFalse(p.isPalindrome(13321));
	    assertTrue(p.isPalindrome(13331));
	    assertTrue(p.isPalindrome(0));
	    assertTrue(p.isPalindrome(11));
	}

}
