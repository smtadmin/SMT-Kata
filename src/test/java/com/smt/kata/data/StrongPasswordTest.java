package com.smt.kata.data;

// Junit 5
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: StrongPasswordTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> The unit test for the String Password kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 8, 2021
 * @updates:
 ****************************************************************************/
class StrongPasswordTest {
	/**
	 * 
	 */
	private StrongPassword sp = new StrongPassword();

	/**
	 * Test method for {@link com.smt.kata.data.StrongPassword#StrongPassword()}.
	 */
	@Test
	void testStrongPassword() throws Exception {
		assertNotNull(sp);
		assertEquals(StrongPassword.MIN_PASSWORD_LENGTH, sp.getMinPasswordLength());
	}

	/**
	 * Test method for {@link com.smt.kata.data.StrongPassword#StrongPassword()}.
	 */
	@Test
	void testStrongPasswordLength() throws Exception {
		sp.setMinPasswordLength(12);
		assertEquals(12, sp.getMinPasswordLength());
	}

	/**
	 * Test method for {@link com.smt.kata.data.StrongPassword#StrongPassword(int)}.
	 */
	@Test
	void testStrongPasswordInt() throws Exception {
		StrongPassword sp1 = new StrongPassword(12);
		assertNotNull(sp1);
		assertEquals(12, sp1.getMinPasswordLength());
	}
	

	/**
	 * Test method for {@link com.smt.kata.data.StrongPassword#StrongPassword(int)}.
	 */
	@Test
	void testStrongPasswordSmallInt() throws Exception {
		StrongPassword sp1 = new StrongPassword(5);
		assertNotNull(sp1);
		assertEquals(8, sp1.getMinPasswordLength());
	}

	/**
	 * Test method for {@link com.smt.kata.data.StrongPassword#isValidPattern(java.lang.String)}.
	 */
	@Test
	void testIsValidPatternEmpty() throws Exception {
		assertFalse(sp.isValidPattern(""));
		assertFalse(sp.isValidPattern(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.StrongPassword#isValidPattern(java.lang.String)}.
	 */
	@Test
	void testIsValidPattern() throws Exception {
		assertTrue(sp.isValidPattern("J4m3s&M4ry!"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.StrongPassword#isValidPattern(java.lang.String)}.
	 */
	@Test
	void testIsValidPatternShort() throws Exception {
		assertFalse(sp.isValidPattern("hello"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.StrongPassword#isValidPattern(java.lang.String)}.
	 */
	@Test
	void testIsValidPatternNoDigit() throws Exception {
		assertFalse(sp.isValidPattern("hello world"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.StrongPassword#isValidPattern(java.lang.String)}.
	 */
	@Test
	void testIsValidPatternCase() throws Exception {
		// No upper or lower
		assertFalse(sp.isValidPattern("1234567890"));
		
		// No upper, lower present
		assertFalse(sp.isValidPattern("1234567890abc"));
		
		// Upper present, no present
		assertFalse(sp.isValidPattern("1234567890ABC"));
	}

	/**
	 * Test method for {@link com.smt.kata.data.StrongPassword#validateSpecialChars(java.lang.String)}.
	 */
	@Test
	void testValidateSpecialCharsInvalid() throws Exception {
		assertFalse(sp.validateSpecialChars("1234567890ABC"));
	}


}
