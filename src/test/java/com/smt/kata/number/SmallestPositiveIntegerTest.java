package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SmallestPositiveIntegerTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Tests for the Smallest Positive Integer Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 20, 2021
 * @updates:
 ****************************************************************************/
class SmallestPositiveIntegerTest {

	// Members
	SmallestPositiveInteger spi = new SmallestPositiveInteger();
	
	/**
	 * Test method for {@link com.smt.kata.number.SmallestPositiveInteger#find(int[])}.
	 */
	@Test
	void testFindNull() throws Exception {
		assertEquals(0, spi.find(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SmallestPositiveInteger#find(int[])}.
	 */
	@Test
	void testFindEmpty() throws Exception {
		assertEquals(0, spi.find(new int[0] ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SmallestPositiveInteger#find(int[])}.
	 */
	@Test
	void testFindSingle() throws Exception {
		assertEquals(2, spi.find(new int[] {1} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SmallestPositiveInteger#find(int[])}.
	 */
	@Test
	void testFindSmall() throws Exception {
		assertEquals(7, spi.find(new int[] {1,2,3,10} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SmallestPositiveInteger#find(int[])}.
	 */
	@Test
	void testFindSmallDigits() throws Exception {
		assertEquals(26, spi.find(new int[] {1,1,1,2,2,3,4,5,6} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SmallestPositiveInteger#find(int[])}.
	 */
	@Test
	void testFindSmallOutOfSequence() throws Exception {
		assertEquals(7, spi.find(new int[] {10,2,1,3} ));
	}

	/**
	 * Test method for {@link com.smt.kata.number.SmallestPositiveInteger#find(int[])}.
	 */
	@Test
	void testFindLong() throws Exception {
		assertEquals(162, spi.find(new int[] {24,37,1,7,4,2,8,34,23,11,10} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SmallestPositiveInteger#find(int[])}.
	 */
	@Test
	void testFindLonger() throws Exception {
		assertEquals(198, spi.find(new int[] {24,37,1,7,4,2,8,34,23,11,10,16, 20} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SmallestPositiveInteger#find(int[])}.
	 */
	@Test
	void testFindSkip2() throws Exception {
		assertEquals(2, spi.find(new int[] {1, 3, 6, 10, 11, 15} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SmallestPositiveInteger#find(int[])}.
	 */
	@Test
	void testFindAllOnes() throws Exception {
		assertEquals(5, spi.find(new int[] {1, 1, 1, 1} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SmallestPositiveInteger#find(int[])}.
	 */
	@Test
	void testFindSequence() throws Exception {
		assertEquals(22, spi.find(new int[] {1, 2, 3, 4, 5, 6} ));
	}
}
