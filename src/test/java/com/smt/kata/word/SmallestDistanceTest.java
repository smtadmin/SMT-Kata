package com.smt.kata.word;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SmallestDistanceTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit test for the Smallest Distance kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 18, 2021
 * @updates:
 ****************************************************************************/
class SmallestDistanceTest {

	// Members
	SmallestDistance sd = new SmallestDistance();
	
	/**
	 * Test method for {@link com.smt.kata.word.SmallestDistance#calculate(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCalculate() throws Exception {
		assertEquals(1, sd.calculate("dog cat cat dog dog hello cat world", "hello", "world"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.SmallestDistance#calculate(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCalculateTwoStarts() throws Exception {
		assertEquals(1, sd.calculate("dog cat hello at dog dog hello cat world", "hello", "world"));
	}

	/**
	 * Test method for {@link com.smt.kata.word.SmallestDistance#calculate(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCalculateNullStartEnd() throws Exception {
		assertEquals(0, sd.calculate("dog cat hello cat dog dog hello cat world", null, null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.SmallestDistance#calculate(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCalculateAllNull() throws Exception {
		assertEquals(0, sd.calculate(null, null, null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.SmallestDistance#calculate(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCalculateNoStart() throws Exception {
		assertEquals(0, sd.calculate("dog cat cat dog dog cat world", "hello", "world"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.SmallestDistance#calculate(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCalculateNoEnd() throws Exception {
		assertEquals(0, sd.calculate("dog cat hello cat dog dog hello cat worlds", "hello", "world"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.SmallestDistance#calculate(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCalculateFirstLast() throws Exception {
		assertEquals(6, sd.calculate("hello dog cat cat dog dog cat world", "hello", "world"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.SmallestDistance#calculate(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCalculateFirstLastMixedCase() throws Exception {
		assertEquals(6, sd.calculate("HeLLo dog cat cat dog dog cat WORLD", "hello", "world"));
	}
}
