package com.smt.kata.math;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: CostClimbingStairsTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Tests for the Cost of Climbing Stairs Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 26, 2021
 * @updates:
 ****************************************************************************/
class CostClimbingStairsTest {

	// Members
	CostClimbingStairs ccs = new CostClimbingStairs();
	
	/**
	 * Test method for {@link com.smt.kata.math.CostClimbingStairs#calculate(int[])}.
	 */
	@Test
	void testCalculateNull() throws Exception {
		assertEquals(0, ccs.calculate(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.CostClimbingStairs#calculate(int[])}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		assertEquals(0, ccs.calculate(new int[0]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.CostClimbingStairs#calculate(int[])}.
	 */
	@Test
	void testCalculateSingle() throws Exception {
		assertEquals(5, ccs.calculate(new int[] { 5 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.CostClimbingStairs#calculate(int[])}.
	 */
	@Test
	void testCalculateShort() throws Exception {
		assertEquals(15, ccs.calculate(new int[] {10,15,20}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.CostClimbingStairs#calculate(int[])}.
	 */
	@Test
	void testCalculateLong() throws Exception {
		assertEquals(6, ccs.calculate(new int[] {1,100,1,1,1,100,1,1,100,1}));
	}

}
