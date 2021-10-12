package com.smt.kata.number;

// Junit 5.x
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: MaximumXORTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit test for the Maximum XOR kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 14, 2021
 * @updates:
 ****************************************************************************/
class MaximumXORTest {

	MaximumXOR mx = new MaximumXOR();
	
	/**
	 * Test method for {@link com.smt.kata.number.MaximumXOR#calculate(int[])}.
	 */
	@Test
	void testCalculateNull() throws Exception {
		assertEquals(0, mx.calculate(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaximumXOR#calculate(int[])}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		assertEquals(0, mx.calculate(new int[0]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaximumXOR#calculate(int[])}.
	 */
	@Test
	void testCalculateSingle() throws Exception {
		assertEquals(0, mx.calculate(new int[] {1}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaximumXOR#calculate(int[])}.
	 */
	@Test
	void testCalculateSimple() throws Exception {
		assertEquals(7, mx.calculate(new int[] {1,2,3,4,5}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaximumXOR#calculate(int[])}.
	 */
	@Test
	void testCalculateLarge() throws Exception {
		assertEquals(975968, mx.calculate(new int[] {1345,27623,356789,40,59233, 5612, 918273}));
	}

	/**
	 * Test method for {@link com.smt.kata.number.MaximumXOR#calculate(int[])}.
	 */
	@Test
	void testCalculateZeros() throws Exception {
		assertEquals(0, mx.calculate(new int[] {0,0,0,0,0}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaximumXOR#calculate(int[])}.
	 */
	@Test
	void testCalculateThrees() throws Exception {
		assertEquals(0, mx.calculate(new int[] {3,3,3,3,3}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaximumXOR#calculate(int[])}.
	 */
	@Test
	void testCalculateNegatives() throws Exception {
		assertEquals(31, mx.calculate(new int[] {-27, -5, -3, -6, -2}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaximumXOR#calculate(int[])}.
	 */
	@Test
	void testCalculateMirror() throws Exception {
		assertEquals(30, mx.calculate(new int[] {27, 5, 3, 6, 2}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaximumXOR#calculate(int[])}.
	 */
	@Test
	void testCalculateMixed() throws Exception {
		assertEquals(25, mx.calculate(new int[] {27,- 5, 3, -6, 2}));
	}
}
