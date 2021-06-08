package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: DigitFrequenciesTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Tests for the Digit Frequencies Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 13, 2021
 * @updates:
 ****************************************************************************/
class DigitFrequenciesTest {
	
	// Members
	DigitFrequencies df = new DigitFrequencies();

	/**
	 * Test method for {@link com.smt.kata.number.DigitFrequencies#calculate(int)}.
	 */
	@Test
	void testCalculate() throws Exception {
		int[] res = df.calculate(0);
		assertEquals(1, res[1]);
		
		for (int i=0; i < res.length; i++) {
			if (i == 1) continue;
			assertEquals(0, res[i]);
		}

	}
	
	/**
	 * Test method for {@link com.smt.kata.number.DigitFrequencies#calculate(int)}.
	 */
	@Test
	void testCalculateNegative() throws Exception {
		int[] res = df.calculate(-8);
		assertEquals(4, res[0]);
		assertEquals(1, res[2]);
		assertEquals(1, res[3]);
		assertEquals(1, res[5]);
		assertEquals(1, res[9]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.DigitFrequencies#calculate(int)}.
	 */
	@Test
	void testCalculate10() throws Exception {
		int[] res = df.calculate(10);
		assertEquals(1, res[0]);
		assertEquals(1, res[1]);
		assertEquals(1, res[2]);
		assertEquals(1, res[4]);
	}

	/**
	 * Test method for {@link com.smt.kata.number.DigitFrequencies#calculate(int)}.
	 */
	@Test
	void testCalculate100() throws Exception {
		int[] res = df.calculate(100);
		assertEquals(6, res[0]);
		assertEquals(2, res[1]);
		assertEquals(6, res[2]);
		assertEquals(2, res[3]);
		assertEquals(2, res[4]);
		assertEquals(2, res[5]);
		assertEquals(5, res[6]);
		assertEquals(3, res[7]);
		assertEquals(1, res[8]);
		assertEquals(2, res[9]);
	}
	

	/**
	 * Test method for {@link com.smt.kata.number.DigitFrequencies#calculate(int)}.
	 */
	@Test
	void testCalculate64() throws Exception {
		int[] res = df.calculate(64);
		assertEquals(2, res[0]);
		assertEquals(3, res[1]);
		assertEquals(0, res[2]);
		assertEquals(1, res[3]);
		assertEquals(4, res[4]);
		assertEquals(2, res[5]);
		assertEquals(3, res[6]);
		assertEquals(3, res[7]);
		assertEquals(1, res[8]);
		assertEquals(1, res[9]);
	}
}
