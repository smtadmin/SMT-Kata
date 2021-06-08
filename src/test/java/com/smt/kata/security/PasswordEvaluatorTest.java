package com.smt.kata.security;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Junit 5
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: PasswordEvaluatorTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Password Evaluator Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
class PasswordEvaluatorTest {
	
	// Members
	PasswordEvaluator pe = new PasswordEvaluator();

	/**
	 * Test method for {@link com.smt.kata.security.PasswordEvaluator#isValidPassword(java.lang.String, int)}.
	 */
	@Test
	void testIsValidPassword() throws Exception {
		assertThrows(NullPointerException.class, () -> {
			pe.isValidPassword(null, 10);
		});
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.PasswordEvaluator#isValidPassword(java.lang.String, int)}.
	 */
	@Test
	void testIsValidPasswordEmpty() throws Exception {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {
			pe.isValidPassword("", 10);
		});
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.PasswordEvaluator#isValidPassword(java.lang.String, int)}.
	 */
	@Test
	void testIsValidPasswordSimple() throws Exception {
		assertTrue(pe.isValidPassword("HelloWorld1!", 10));
	}

	/**
	 * Test method for {@link com.smt.kata.security.PasswordEvaluator#isValidPassword(java.lang.String, int)}.
	 */
	@Test
	void testIsValidPasswordInvalidLength() throws Exception {
		assertFalse(pe.isValidPassword("HelloWorld1!", 20));
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.PasswordEvaluator#isValidPassword(java.lang.String, int)}.
	 */
	@Test
	void testIsValidPasswordNoUpper() throws Exception {
		assertFalse(pe.isValidPassword("helloworld1!", 10));
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.PasswordEvaluator#isValidPassword(java.lang.String, int)}.
	 */
	@Test
	void testIsValidPasswordNoLower() throws Exception {
		assertFalse(pe.isValidPassword("HELLOWORLD1!", 10));
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.PasswordEvaluator#isValidPassword(java.lang.String, int)}.
	 */
	@Test
	void testIsValidPasswordNoNumber() throws Exception {
		assertFalse(pe.isValidPassword("HelloWorld!!", 10));
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.PasswordEvaluator#isValidPassword(java.lang.String, int)}.
	 */
	@Test
	void testIsValidPasswordNoSpecial() throws Exception {
		assertFalse(pe.isValidPassword("HelloWorld1", 10));
	}
}
