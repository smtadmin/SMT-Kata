package com.smt.kata.code;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: ValidRegexPinTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit test for the Kata class to regex validate a pin
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class ValidRegexPinTest {

	/**
	 * Test method for {@link com.smt.kata.code.ValidRegexPin#validate(java.lang.String)}.
	 */
	@Test
	void testValidate() {
		ValidRegexPin pin = new ValidRegexPin();
		assertTrue(pin.validate("121317"));
		assertTrue(pin.validate("1234"));
		assertFalse(pin.validate("45135"));
		assertFalse(pin.validate("89abc1"));
		assertTrue(pin.validate("900876"));
		assertFalse(pin.validate(" 4983"));
		assertFalse(pin.validate(" 49835"));
		assertTrue(pin.validate("498356"));
	}

}
