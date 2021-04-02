package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> CountingParensTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit test for the Counting Parens Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 2, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class CountingParensTest {

	/**
	 * Test method for {@link com.smt.kata.number.CountingParens#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculate() throws Exception {
		CountingParens cp = new CountingParens();
		assertEquals(1, cp.calculate("()())()"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingParens#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		CountingParens cp = new CountingParens();
		assertEquals(0, cp.calculate(""));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingParens#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateNull() throws Exception {
		CountingParens cp = new CountingParens();
		assertEquals(0, cp.calculate(null));
	}

	/**
	 * Test method for {@link com.smt.kata.number.CountingParens#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateMismatch() throws Exception {
		CountingParens cp = new CountingParens();
		assertEquals(2, cp.calculate(")("));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingParens#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateMismatchLeftOnly() throws Exception {
		CountingParens cp = new CountingParens();
		assertEquals(5, cp.calculate("((((("));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingParens#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateMismatchRightOnly() throws Exception {
		CountingParens cp = new CountingParens();
		assertEquals(5, cp.calculate(")))))"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingParens#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateMismatchWithChars() throws Exception {
		CountingParens cp = new CountingParens();
		assertEquals(2, cp.calculate("ja)m(es"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingParens#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateNested() throws Exception {
		CountingParens cp = new CountingParens();
		assertEquals(0, cp.calculate("(())"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingParens#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateNestedExtraLeft() throws Exception {
		CountingParens cp = new CountingParens();
		assertEquals(1, cp.calculate("(())("));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingParens#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateNestedExtraRight() throws Exception {
		CountingParens cp = new CountingParens();
		assertEquals(1, cp.calculate("(()))"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingParens#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateNestedComplex() throws Exception {
		CountingParens cp = new CountingParens();
		assertEquals(0, cp.calculate("(()(()()))"));
	}
}
