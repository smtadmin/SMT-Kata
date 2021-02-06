package com.smt.kata.word;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: PalindromeSubstringTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the Palindrome Substring kata class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class PalindromeSubstringTest {

	/**
	 * Test method for {@link com.smt.kata.word.PalindromeTest#testIsPalindrome()}.
	 */
	@Test
	void testTestIsPalindrome() {
		
		PalindromeSubstring ps = new PalindromeSubstring();
		assertEquals("ara", ps.find("caramel"));
		assertEquals("abba", ps.find("AbbA"));
		assertEquals("", ps.find("Monster"));
		assertEquals("bats stab", ps.find("Acrobats stab orca"));
		assertEquals(" deified ", ps.find("We Deified her as a god"));
		assertEquals("",  ps.find(""));
		assertEquals("",  ps.find(null));
	}

}
