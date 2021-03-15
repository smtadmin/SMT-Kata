package com.smt.kata.math;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: RomanNumeralMathTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Kata for the Roman Numeral Math problem
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 15, 2021
 * @updates:
 ****************************************************************************/
class RomanNumeralMathTest {
	
	private RomanNumeralMath rnm = new RomanNumeralMath();

	/**
	 * Test method for {@link com.smt.kata.math.RomanNumeralMath#add(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAdd() throws Exception {
		assertEquals("II", rnm.add("I", "I"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.RomanNumeralMath#add(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAddEmpty() throws Exception {
		assertEquals("", rnm.add("", ""));
		assertEquals("", rnm.add(null, null));
		assertEquals("", rnm.add("V", null));
		assertEquals("", rnm.add("V", ""));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.RomanNumeralMath#add(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAddZero() throws Exception {
		assertEquals("", rnm.add("0", "V"));
		assertEquals("", rnm.add("V", "0"));
	}

	/**
	 * Test method for {@link com.smt.kata.math.RomanNumeralMath#add(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAddMore() throws Exception {
		assertEquals("VI", rnm.add("I", "V"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.RomanNumeralMath#add(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testSubtractMore() throws Exception {
		assertEquals("IV", rnm.subtract("I", "V"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.RomanNumeralMath#add(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAddFirstPreIssue() throws Exception {
		assertEquals("IX", rnm.add("IV", "V"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.RomanNumeralMath#add(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testSubtractFirstPreIssue() throws Exception {
		assertEquals("I", rnm.subtract("IV", "V"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.RomanNumeralMath#add(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAddSecondPreIssue() throws Exception {
		assertEquals("IV", rnm.add("III", "I"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.RomanNumeralMath#add(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testSubtractSecondPreIssue() throws Exception {
		assertEquals("II", rnm.subtract("III", "I"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.RomanNumeralMath#add(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAddLarge() throws Exception {
		assertEquals("CXXXXVIII", rnm.add("LXXIV", "LXXIV"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.RomanNumeralMath#add(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testSubtractLarge() throws Exception {
		assertEquals("IV", rnm.subtract("LXX", "LXXIV"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.RomanNumeralMath#add(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAddJumbo() throws Exception {
		assertEquals("DCCCCLXXIII", rnm.add("DCCCXCIX", "LXXIV"));
	}
	/**
	 * Test method for {@link com.smt.kata.math.RomanNumeralMath#add(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testSubtractJumbo() throws Exception {
		assertEquals("DCCCXXV", rnm.subtract("DCCCXCIX", "LXXIV"));
	}
}
