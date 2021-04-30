package com.smt.kata.code;

// Junit 5
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> PhoneNumberDecoderTest.java
 * <b>Project:</b> Daily-Kata
 * <b>Description:</b> Unit test for the phone number decoder kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class PhoneNumberDecoderTest {
	// Members
	private PhoneNumberDecoder pnd = new PhoneNumberDecoder();
	
	/**
	 * Test method for {@link com.smt.kata.code.PhoneNumberDecoder#PhoneNumberDecoder()}.
	 */
	@Test
	void testPhoneNumberDecoder() throws Exception {
		assertNotNull(pnd);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.PhoneNumberDecoder#PhoneNumberDecoder()}.
	 */
	@Test
	void testPhoneNumberDecoderEmpty() throws Exception {
		assertEquals("", pnd.textToNum(""));
		assertEquals("", pnd.textToNum(null));
	}

	/**
	 * Test method for {@link com.smt.kata.code.PhoneNumberDecoder#PhoneNumberDecoder()}.
	 */
	@Test
	void testPhoneNumberDecoderSize() throws Exception {
		assertEquals("", pnd.textToNum("303550156789"));
		assertEquals("", pnd.textToNum("303550-&*%"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.PhoneNumberDecoder#textToNum(java.lang.String)}.
	 */
	@Test
	void testTextToNum() throws Exception {
		assertEquals("123.647.3937", pnd.textToNum("123-647-EYES"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.PhoneNumberDecoder#textToNum(java.lang.String)}.
	 */
	@Test
	void testTextToNumBraces() throws Exception {
		assertEquals("325.444.8378", pnd.textToNum("(325)444-TEST"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.PhoneNumberDecoder#textToNum(java.lang.String)}.
	 */
	@Test
	void testTextToNum2Words() throws Exception {
		assertEquals("653.879.8447", pnd.textToNum("653-TRY-THIS"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.PhoneNumberDecoder#textToNum(java.lang.String)}.
	 */
	@Test
	void testTextToNumDash() throws Exception {
		assertEquals("435.224.7613", pnd.textToNum("435-224-7613"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.PhoneNumberDecoder#textToNum(java.lang.String)}.
	 */
	@Test
	void testTextToNumlowerCase() throws Exception {
		assertEquals("325.444.8378", pnd.textToNum("(325)(444)-test"));
	}
}
