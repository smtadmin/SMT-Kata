package com.smt.kata.code;

// Junit 5
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: CreditCardValidatorTest.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Tests the Credit Card validator class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 8, 2021
 * @updates:
 ****************************************************************************/
class CreditCardValidatorTest {
	
	// Members
	CreditCardValidator ccv = new CreditCardValidator();

	/**
	 * Test method for {@link com.smt.kata.code.CreditCardValidator#CreditCardValidator()}.
	 */
	@Test
	void testCreditCardValidator() throws Exception {
		assertNotNull(ccv);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.CreditCardValidator#isValid(java.lang.String)}.
	 */
	@Test
	void testIsValidEmpty() throws Exception {
		assertFalse(ccv.isValid(""));
		assertFalse(ccv.isValid(null));
	}

	/**
	 * Test method for {@link com.smt.kata.code.CreditCardValidator#isValid(java.lang.String)}.
	 */
	@Test
	void testIsValidFake() throws Exception {
		assertFalse(ccv.isValid("1234567890123456"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.CreditCardValidator#isValid(java.lang.String)}.
	 */
	@Test
	void testIsValidWrong() throws Exception {
		assertFalse(ccv.isValid("James Camire"));
		assertFalse(ccv.isValid("123helloworld"));
		assertFalse(ccv.isValid("1234567890 123452"));
	}

	/**
	 * Test method for {@link com.smt.kata.code.CreditCardValidator#isValid(java.lang.String)}.
	 */
	@Test
	void testIsValidGood() throws Exception {
		assertTrue(ccv.isValid("1234567890123452"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.CreditCardValidator#isValid(java.lang.String)}.
	 */
	@Test
	void testIsValidAmex() throws Exception {
		assertTrue(ccv.isValid("378282246310005"));
		assertTrue(ccv.isValid("371449635398431"));
		assertFalse(ccv.isValid("378734493671000"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.CreditCardValidator#isValid(java.lang.String)}.
	 */
	@Test
	void testIsValidDiners() throws Exception {
		assertTrue(ccv.isValid("30569309025904"));
		assertTrue(ccv.isValid("38520000023237"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.CreditCardValidator#isValid(java.lang.String)}.
	 */
	@Test
	void testIsValidDiscover() throws Exception {
		assertTrue(ccv.isValid("6011111111111117"));
		assertTrue(ccv.isValid("6011000990139424"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.CreditCardValidator#isValid(java.lang.String)}.
	 */
	@Test
	void testIsValidMasterCard() throws Exception {
		assertTrue(ccv.isValid("5555555555554444"));
		assertFalse(ccv.isValid("5105105105105100"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.CreditCardValidator#isValid(java.lang.String)}.
	 */
	@Test
	void testIsValidVisa() throws Exception {
		assertTrue(ccv.isValid("4111111111111111"));
		assertTrue(ccv.isValid("4012888888881881"));
		assertTrue(ccv.isValid("4222222222222"));
	}
}
