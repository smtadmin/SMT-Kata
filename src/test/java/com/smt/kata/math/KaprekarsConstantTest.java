package com.smt.kata.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: KaprekarsConstantTest.java
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
class KaprekarsConstantTest {
	
	// Members
	KaprekarsConstant kc = new KaprekarsConstant();
	
	/**
	 * Test method for {@link com.smt.kata.math.KaprekarsConstant#calculateSteps(int)}.
	 */
	@Test
	void testCalculateStepsNegative() throws Exception {
		assertEquals(0, kc.calculateSteps(-1234));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.KaprekarsConstant#calculateSteps(int)}.
	 */
	@Test
	void testCalculateStepsLarge() throws Exception {
		assertEquals(0, kc.calculateSteps(123456));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.KaprekarsConstant#calculateSteps(int)}.
	 */
	@Test
	void testCalculateStepsNoTwoUnique() throws Exception {
		assertEquals(0, kc.calculateSteps(1111));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.KaprekarsConstant#calculateSteps(int)}.
	 */
	@Test
	void testCalculateStepsTwoUnique() throws Exception {
		assertEquals(4, kc.calculateSteps(1115));
	}


	/**
	 * Test method for {@link com.smt.kata.math.KaprekarsConstant#calculateSteps(int)}.
	 */
	@Test
	void testCalculateStepsExampleOne() throws Exception {
		assertEquals(3, kc.calculateSteps(1234));
	}

	/**
	 * Test method for {@link com.smt.kata.math.KaprekarsConstant#calculateSteps(int)}.
	 */
	@Test
	void testCalculateStepsExampleOneJumbled() throws Exception {
		assertEquals(3, kc.calculateSteps(2314));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.KaprekarsConstant#calculateSteps(int)}.
	 */
	@Test
	void testCalculateStepsMatching() throws Exception {
		assertEquals(6, kc.calculateSteps(2244));
	}
}
