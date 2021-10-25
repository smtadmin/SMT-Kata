package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: MaxConsecutiveOnesTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 25, 2021
 * @updates:
 ****************************************************************************/
class MaxConsecutiveOnesTest {
	
	// Members 
	private MaxConsecutiveOnes mco = new MaxConsecutiveOnes();

	/**
	 * Test method for {@link com.smt.kata.number.MaxConsecutiveOnes#count(int[])}.
	 */
	@Test
	void testCountNull() throws Exception {
		assertEquals(0, mco.count(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxConsecutiveOnes#count(int[])}.
	 */
	@Test
	void testCountEmpty() throws Exception {
		assertEquals(0, mco.count(new int[0]));
		assertEquals(0, mco.count(new int[] {}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxConsecutiveOnes#count(int[])}.
	 */
	@Test
	void testCountSingleOne() throws Exception {
		assertEquals(1, mco.count(new int[] { 1 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxConsecutiveOnes#count(int[])}.
	 */
	@Test
	void testCountSingleZero() throws Exception {
		assertEquals(0, mco.count(new int[] { 0 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxConsecutiveOnes#count(int[])}.
	 */
	@Test
	void testCountAllOnes() throws Exception {
		assertEquals(10, mco.count(new int[] { 1,1,1,1,1,1,1,1,1,1 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxConsecutiveOnes#count(int[])}.
	 */
	@Test
	void testCountAllZeros() throws Exception {
		assertEquals(0, mco.count(new int[] { 0,0,0,0,0,0,0,0,0,0 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxConsecutiveOnes#count(int[])}.
	 */
	@Test
	void testCountExampleOne() throws Exception {
		assertEquals(3, mco.count(new int[] {1,1,0,1,1,1}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.MaxConsecutiveOnes#count(int[])}.
	 */
	@Test
	void testCountlng() throws Exception {
		assertEquals(5, mco.count(new int[] {1,1,1,1,1,0,0,0,1,1,1,1,0,0,0,1,1,0,0,1}));
	}
}