package com.smt.kata.number;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> HappyNumberTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit tests for the Happy Number Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class HappyNumberTest {

	// Members
	private HappyNumber hn = new HappyNumber();
	
	/**
	 * Test method for {@link com.smt.kata.number.HappyNumber#isHappy(int)}.
	 */
	@Test
	void testIsHappy() throws Exception {
		assertTrue(hn.isHappy(139));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.HappyNumber#isHappy(int)}.
	 */
	@Test
	void testIsHappyOne() throws Exception {
		assertTrue(hn.isHappy(1));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.HappyNumber#isHappy(int)}.
	 */
	@Test
	void testIsHappyZero() throws Exception {
		assertFalse(hn.isHappy(0));
	}

	/**
	 * Test method for {@link com.smt.kata.number.HappyNumber#isHappy(int)}.
	 */
	@Test
	void testIsHappy67() throws Exception {
		assertFalse(hn.isHappy(67));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.HappyNumber#isHappy(int)}.
	 */
	@Test
	void testIsHappy89() throws Exception {
		assertFalse(hn.isHappy(89));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.HappyNumber#isHappy(int)}.
	 */
	@Test
	void testIsHappyLargeFalse() throws Exception {
		assertFalse(hn.isHappy(1327));
		assertFalse(hn.isHappy(2871));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.HappyNumber#isHappy(int)}.
	 */
	@Test
	void testIsHappyLarge() throws Exception {
		assertTrue(hn.isHappy(3970));
	}
}
