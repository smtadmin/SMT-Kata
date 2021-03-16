package com.smt.kata.code;

//Junit 5
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: BinaryAsciiConverterTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the Ascii-Binary COnversion class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 1, 2021
 * @updates:
 ****************************************************************************/
class BinaryAsciiConverterTest {
	
	// Members
	BinaryAsciiConverter bac = new BinaryAsciiConverter();
	
	/**
	 * Test method for {@link com.smt.kata.code.BinaryAsciiConverter#BinaryAsciiConverter()}.
	 */
	@Test
	void testBinaryAsciiConverter() throws Exception {
		assertNotNull(bac);
	}

	/**
	 * Test method for {@link com.smt.kata.code.BinaryAsciiConverter#convert(java.lang.String)}.
	 */
	@Test
	void testConvertEmpty() throws Exception {
		assertEquals("", bac.convert(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.BinaryAsciiConverter#convert(java.lang.String)}.
	 */
	@Test
	void testConvertPhrase() throws Exception {
		String b = "010010010010000001101100011011110111011001100101001000000101010001100101011100110110100000100001";
		assertEquals("I love Tesh!", bac.convert(b));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.BinaryAsciiConverter#convert(java.lang.String)}.
	 */
	@Test
	void testConvertBadBinary() throws Exception {
		String b = "0011000100110010001100010011001100110001001101";
		assertEquals("", bac.convert(b));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.BinaryAsciiConverter#convert(java.lang.String)}.
	 */
	@Test
	void testConvertNumber() throws Exception {
		String b = "001100010011001000110001001100110011000100110111";
		assertEquals("121317", bac.convert(b));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.BinaryAsciiConverter#convert(java.lang.String)}.
	 */
	@Test
	void testConvertAmazing() throws Exception {
		String b = "010000010110110101100001011110100110100101101110011001110010000001000101011001000110000101100010011010010111010000100001";
		assertEquals("Amazing Edabit!", bac.convert(b));
	}
}
