package com.smt.kata.code;

//Junit 5
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: MorseCodeTranslatorTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the Morse Code Translator kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 15, 2021
 * @updates:
 ****************************************************************************/
class MorseCodeTranslatorTest {
	
	// Members
	MorseCodeTranslator xltr = new MorseCodeTranslator();

	/**
	 * Test method for {@link com.smt.kata.code.MorseCodeTranslator#MorseCodeTranslator()}.
	 */
	@Test
	void testMorseCodeTranslator() throws Exception {
		assertNotNull(xltr);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.MorseCodeTranslator#encode(java.lang.String)}.
	 */
	@Test
	void testEncodeEmpty() throws Exception {
		assertEquals("", xltr.encode(""));
		assertEquals("", xltr.encode(null));
	}

	/**
	 * Test method for {@link com.smt.kata.code.MorseCodeTranslator#decode(java.lang.String)}.
	 */
	@Test
	void testDecodeEmpty() throws Exception {
		assertEquals("", xltr.decode(""));
		assertEquals("", xltr.decode(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.MorseCodeTranslator#encode(java.lang.String)}.
	 */
	@Test
	void testEncode() throws Exception {
		assertEquals("... --- ...", xltr.encode("SOS"));
	}

	/**
	 * Test method for {@link com.smt.kata.code.MorseCodeTranslator#decode(java.lang.String)}.
	 */
	@Test
	void testDecode() throws Exception {
		assertEquals("SOS", xltr.decode("... --- ..."));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.MorseCodeTranslator#encode(java.lang.String)}.
	 */
	@Test
	void testEncodeSMTPhone() throws Exception {
		String response = "--... ..--- ----- ..--- -.... ----- ....- --... -.... ---..";
		assertEquals(response, xltr.encode("7202604768"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.MorseCodeTranslator#decode(java.lang.String)}.
	 */
	@Test
	void testDecodeSMTPhone() throws Exception {
		String response = "--... ..--- ----- ..--- -.... ----- ....- --... -.... ---..";
		assertEquals("7202604768", xltr.decode(response));
	}

	/**
	 * Test method for {@link com.smt.kata.code.MorseCodeTranslator#encode(java.lang.String)}.
	 */
	@Test
	void testEncodeSMTPhoneFormatted() throws Exception {
		String response = "--... ..--- ----- ..--- -.... ----- ....- --... -.... ---..";
		assertEquals(response, xltr.encode("720-260-4768"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.MorseCodeTranslator#decode(java.lang.String)}.
	 */
	@Test
	void testDecodeSMTPhoneFormatted() throws Exception {
		String response = "--... ..--- ----- ..--- -.... ----- ....- --... -.... ---..";
		assertEquals("7202604768", xltr.decode(response));
	}

	/**
	 * Test method for {@link com.smt.kata.code.MorseCodeTranslator#encode(java.lang.String)}.
	 */
	@Test
	void testEncodeQwerty() throws Exception {
		String phrase = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
		String response = "- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --.";
		assertEquals(response, xltr.encode(phrase));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.MorseCodeTranslator#decode(java.lang.String)}.
	 */
	@Test
	void testDecodeQwerty() throws Exception {
		String phrase = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
		String response = "- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --.";
		assertEquals(phrase, xltr.decode(response));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.MorseCodeTranslator#decode(java.lang.String)}.
	 */
	@Test
	void testDecodeQwertyBad() throws Exception {
		String phrase = "THE UICK BRWN FOX JUMPS OVER THE LAZY DOG";
		String response = "- .... . / l--.- ..- .. -.-. -.- / -... .-. 7--- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --.";
		assertEquals(phrase, xltr.decode(response));
	}
}
