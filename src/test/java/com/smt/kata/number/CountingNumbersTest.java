package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: CountingNumbersTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Counting Numbers Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 26, 2021
 * @updates:
 ****************************************************************************/
class CountingNumbersTest {
	
	// Members
	private CountingNumbers cn = new CountingNumbers();
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingNumbers#calculate(int[])}.
	 */
	@Test
	void testCalculateNull() throws Exception {
		int[] res = cn.calculate(null);
		assertEquals(0, res.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingNumbers#calculate(int[])}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		int[] res = cn.calculate(new int[0]);
		assertEquals(0, res.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingNumbers#calculate(int[])}.
	 */
	@Test
	void testCalculateSingle() throws Exception {
		int[] res = cn.calculate(new int[] { 12 });
		assertEquals(0, res[0]);
	}

	/**
	 * Test method for {@link com.smt.kata.number.CountingNumbers#calculate(int[])}.
	 */
	@Test
	void testCalculate() throws Exception {
		int[] res = cn.calculate(new int[] {5,2,6,1});
		assertEquals(4, res.length);
		assertEquals(2, res[0]);
		assertEquals(1, res[1]);
		assertEquals(1, res[2]);
		assertEquals(0, res[3]);
	}

	/**
	 * Test method for {@link com.smt.kata.number.CountingNumbers#calculate(int[])}.
	 */
	@Test
	void testCalculateAscending() throws Exception {
		int[] res = cn.calculate(new int[] {1,2,3,4});
		assertEquals(4, res.length);
		assertEquals(0, res[0]);
		assertEquals(0, res[1]);
		assertEquals(0, res[2]);
		assertEquals(3, res[3]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingNumbers#calculate(int[])}.
	 */
	@Test
	void testCalculateEquals() throws Exception {
		int[] res = cn.calculate(new int[] {5,5,5,5});
		assertEquals(4, res.length);
		assertEquals(0, res[0]);
		assertEquals(0, res[1]);
		assertEquals(0, res[2]);
		assertEquals(0, res[3]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingNumbers#calculate(int[])}.
	 */
	@Test
	void testCalculateLong() throws Exception {
		int[] res = cn.calculate(new int[] {8,1000, 24675, 192,12,45,56,23,11,8,3,1,24,67});
		int[] correct = new int[] {2, 11, 11, 10, 4, 6, 6, 4, 3, 2, 1, 0, 0, 10 };
		assertEquals(14, res.length);
		for (int i = 0; i < res.length; i++)
			assertEquals(correct[i], res[i]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.CountingNumbers#calculate(int[])}.
	 */
	@Test
	void testCalculateNegative() throws Exception {
		int[] res = cn.calculate(new int[] {5,-8,5,-5});
		assertEquals(4, res.length);
		assertEquals(2, res[0]);
		assertEquals(0, res[1]);
		assertEquals(1, res[2]);
		assertEquals(1, res[3]);
	}
}
