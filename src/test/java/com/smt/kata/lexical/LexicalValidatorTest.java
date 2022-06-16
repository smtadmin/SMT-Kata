package com.smt.kata.lexical;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LexicalValidatorTest {

	LexicalValidator lv = new LexicalValidator();

	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateNull() throws Exception {
		assertEquals(false, lv.validate(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateEmpty() throws Exception {
		assertEquals(false, lv.validate(""));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateInvalid() throws Exception {
		assertEquals(false, lv.validate("1"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateInvalid2() throws Exception {
		assertEquals(false, lv.validate("1 + a = 1"));
	}	
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateInvalid3() throws Exception {
		assertEquals(false, lv.validate("1 + 1"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateValid() throws Exception {
		assertEquals(true, lv.validate("1 + 1 = 2"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateValidCondensed() throws Exception {
		assertEquals(true, lv.validate("1+1=2"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateValid2() throws Exception {
		assertEquals(true, lv.validate("1 + 1 = 2"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateValid3() throws Exception {
		assertEquals(true, lv.validate("12+12-24+2=2"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateValidLong() throws Exception {
		assertEquals(true, lv.validate("1 + 2 + 3 + 4 + 5   - 4 - 3-2-1=5"));
	}
	
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateWeirdSpaces() throws Exception {
		assertEquals(true, lv.validate("  1    +   2  +    3  +4+        5   - 4 - 3- 2- 1     =5    "));
	}
	
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateBadMath() throws Exception {
		assertEquals(true, lv.validate("12+12-24+2=1"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateMult() throws Exception {
		assertEquals(false, lv.validate("1 * 5=5"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateDiv() throws Exception {
		assertEquals(false, lv.validate("10 / 5=2"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateMix() throws Exception {
		assertEquals(false, lv.validate("10 / 5 * 2 + 1 - 2 = 3"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateBadMath2() throws Exception {
		assertEquals(false, lv.validate("1 * 5=4"));
	}
}
