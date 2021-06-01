package com.smt.kata.math;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: LunarMathematicsTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Tests for Lunar Mathematics Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
class LunarMathematicsTest {
	
	// Mem0ebrs
	LunarMathematics lm = new LunarMathematics();

	/**
	 * Test method for {@link com.smt.kata.math.LunarMathematics#add(int, int)}.
	 */
	@Test
	void testAdd() throws Exception {
		assertEquals(8, lm.add(8,7));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.LunarMathematics#add(int, int)}.
	 */
	@Test
	void testAddNegative() throws Exception {
		assertEquals(8, lm.add(-8,-7));
	}

	/**
	 * Test method for {@link com.smt.kata.math.LunarMathematics#add(int, int)}.
	 */
	@Test
	void testAddDiffLen() throws Exception {
		assertEquals(475, lm.add(465, 72));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.LunarMathematics#add(int, int)}.
	 */
	@Test
	void testAddDiffLenSwap() throws Exception {
		assertEquals(475, lm.add(72, 465));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.LunarMathematics#add(int, int)}.
	 */
	@Test
	void testAddDiffLenSwapLarge() throws Exception {
		assertEquals(4655572, lm.add(72, 4655551));
	}
}
