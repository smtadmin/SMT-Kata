package com.smt.kata.number;

// Junit 5
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> SumOfMultiplesTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit tests for the Sum of Multiples Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 31, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class SumOfMultiplesTest {
	
	// Members
	SumOfMultiples som = new SumOfMultiples();

	/**
	 * Test method for {@link com.smt.kata.number.SumOfMultiples#SumOfMultiples()}.
	 */
	@Test
	void testSumOfMultiples() throws Exception {
		assertNotNull(som);
	}

	/**
	 * Test method for {@link com.smt.kata.number.SumOfMultiples#calculate(int, java.lang.Integer[])}.
	 */
	@Test
	void testCalculateLowValue() throws Exception {
		assertEquals(0, som.calculate(3, 3, 5));
	}

	/**
	 * Test method for {@link com.smt.kata.number.SumOfMultiples#calculate(int, java.lang.Integer[])}.
	 */
	@Test
	void testCalculateNoFactors() throws Exception {
		assertEquals(0, som.calculate(20));
	}

	/**
	 * Test method for {@link com.smt.kata.number.SumOfMultiples#calculate(int, java.lang.Integer[])}.
	 */
	@Test
	void testCalculateZeroFactor() throws Exception {
		assertEquals(0, som.calculate(0));
	}
	/**
	 * Test method for {@link com.smt.kata.number.SumOfMultiples#calculate(int, java.lang.Integer[])}.
	 */
	@Test
	void testCalculate() throws Exception {
		assertEquals(78, som.calculate(20, 3, 5));
	}


	/**
	 * Test method for {@link com.smt.kata.number.SumOfMultiples#calculate(int, java.lang.Integer[])}.
	 */
	@Test
	void testCalculate100() throws Exception {
		assertEquals(2946, som.calculate(100, 3, 5, 7, 8));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SumOfMultiples#calculate(int, java.lang.Integer[])}.
	 */
	@Test
	void testCalculate1000() throws Exception {
		assertEquals(2946, som.calculate(100, 3, 5, 7, 8));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SumOfMultiples#calculate(int, java.lang.Integer[])}.
	 */
	@Test
	void testCalculateNoMatch() throws Exception {
		assertEquals(0, som.calculate(10, 13, 15, 17, 18));
	}
}
