package com.smt.kata.number;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> ArmstrongNumberTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Tests the ArmstrongNumber kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 22, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class ArmstrongNumberTest {
	
	// Members
	ArmstrongNumber arm = new ArmstrongNumber();

	/**
	 * Test method for {@link com.smt.kata.number.ArmstrongNumber#isArmstrongNumber(int)}.
	 */
	@Test
	void testIsArmstrongNumber() throws Exception {
		assertTrue(arm.isArmstrongNumber(9));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.ArmstrongNumber#isArmstrongNumber(int)}.
	 */
	@Test
	void testIsArmstrongNumber10() throws Exception {
		assertFalse(arm.isArmstrongNumber(10));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.ArmstrongNumber#isArmstrongNumber(int)}.
	 */
	@Test
	void testIsArmstrongNumberZero() throws Exception {
		assertTrue(arm.isArmstrongNumber(0));
	}

	/**
	 * Test method for {@link com.smt.kata.number.ArmstrongNumber#isArmstrongNumber(int)}.
	 */
	@Test
	void testIsArmstrongNumber153() throws Exception {
		assertTrue(arm.isArmstrongNumber(153));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.ArmstrongNumber#isArmstrongNumber(int)}.
	 */
	@Test
	void testIsArmstrongNumber154() throws Exception {
		assertFalse(arm.isArmstrongNumber(154));
	}
}
