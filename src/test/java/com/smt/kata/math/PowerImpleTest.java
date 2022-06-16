package com.smt.kata.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PowerImpleTest {

	PowerImpl pi = new PowerImpl();
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testPow2() throws Exception {
		assertEquals(100, pi.calcPower(10, 2));
	}

	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testPow3() throws Exception {
		assertEquals(1000, pi.calcPower(10, 3));
	}

	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testPowNeg() throws Exception {
		assertEquals(1/1000.0, pi.calcPower(10, -3));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void BothNeg() throws Exception {
		assertEquals(-1/1000.0, pi.calcPower(-10, -3));
	}

	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void NegEvenPower() throws Exception {
		assertEquals(100, pi.calcPower(-10, 2));
	}

	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testZeroPow() throws Exception {
		assertEquals(1, pi.calcPower(10, 0));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void BothZeroPow() throws Exception {
		assertEquals(0, pi.calcPower(0, 0));
	}
	
}
