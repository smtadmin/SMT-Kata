package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: AscendingNumbersTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit test for the Ascending Numbers Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 12, 2021
 * @updates:
 ****************************************************************************/
class AscendingNumbersTest {

	private AscendingNumbers an;
	
	/**
	 * Setup before each run
	 */
	@BeforeEach
	void initMethods() {
		an = new AscendingNumbers();
	}
	
	/**
	 * simple constructor test
	 */
	@Test
	void test() {
		assertNotNull(an);
	}

	/**
	 * Main test method for tis kata
	 * @throws Exception
	 */
	@Test
	void testIsAscending() throws Exception {
		assertFalse(an.isAscending("123457"));
		assertTrue(an.isAscending("123456"));
		assertTrue(an.isAscending("1213"));
		assertTrue(an.isAscending("232425"));
		assertFalse(an.isAscending("2324256"));
		assertTrue(an.isAscending("444445"));
		assertTrue(an.isAscending("4567456845694570"));
		assertFalse(an.isAscending("4567456845694571"));
	}

}
