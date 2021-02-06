package com.smt.kata.code;

// Junit5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: ValidSherlockStringTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Performs a unit test on the Valid Sherlock String Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class ValidSherlockStringTest {

	/**
	 * Test method for {@link com.smt.kata.code.ValidSherlockString#isValid(java.lang.String)}.
	 */
	@Test
	void testIsValid() {
		ValidSherlockString vss = new ValidSherlockString();
		assertTrue(vss.isValid("abc"));
		assertTrue(vss.isValid("abcc"));
		assertFalse(vss.isValid("abccc"));
		assertFalse(vss.isValid("aabccc"));
		assertTrue(vss.isValid("aabbccc"));
		assertFalse(vss.isValid("aaabbccc"));
		assertTrue(vss.isValid("allcdcad"));
	}

}
