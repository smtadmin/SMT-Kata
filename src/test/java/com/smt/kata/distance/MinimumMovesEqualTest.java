package com.smt.kata.distance;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: MinimumMovesEqualTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Tests for the Minimum Moves Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 30, 2021
 * @updates:
 ****************************************************************************/
class MinimumMovesEqualTest {

	// Members
	MinimumMovesEqual mme = new MinimumMovesEqual();
	
	/**
     * Test method for {@link com.smt.kata.distance.MinimumMovesEqual#calculate(int[])}.
     */
    @Test
    void testCalculateLongerClose() throws Exception {
        assertEquals(4, mme.calculate(new int[] {1,5,5,5,5} ));
    }
    
	/**
	 * Test method for {@link com.smt.kata.distance.MinimumMovesEqual#calculate(int[])}.
	 */
	@Test
	void testCalculateNull() throws Exception {
		assertEquals(0, mme.calculate(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MinimumMovesEqual#calculate(int[])}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		assertEquals(0, mme.calculate(new int[0]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MinimumMovesEqual#calculate(int[])}.
	 */
	@Test
	void testCalculateSingle() throws Exception {
		assertEquals(0, mme.calculate(new int[] { 1 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MinimumMovesEqual#calculate(int[])}.
	 */
	@Test
	void testCalculateDual() throws Exception {
		assertEquals(1, mme.calculate(new int[] { 1, 2 }));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MinimumMovesEqual#calculate(int[])}.
	 */
	@Test
	void testCalculateSimple() throws Exception {
		assertEquals(2, mme.calculate(new int[] { 1,2,3} ));
	}

	/**
	 * Test method for {@link com.smt.kata.distance.MinimumMovesEqual#calculate(int[])}.
	 */
	@Test
	void testCalculateLonger() throws Exception {
		assertEquals(16, mme.calculate(new int[] {1,10,2,9} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MinimumMovesEqual#calculate(int[])}.
	 */
	@Test
	void testCalculateNegative() throws Exception {
		assertEquals(138, mme.calculate(new int[] {2, 20, 33, -10, -12, 45, 34, 26} ));
	}
}
