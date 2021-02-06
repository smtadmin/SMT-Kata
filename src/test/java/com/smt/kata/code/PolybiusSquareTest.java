package com.smt.kata.code;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: PolybiusSquareTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class PolybiusSquareTest {

	/**
	 * Test method for {@link com.smt.kata.code.PolybiusSquare#polybiusEncode(java.lang.String)}.
	 */
	@Test
	void testPolybiusEncode() {
		PolybiusSquare ps = new PolybiusSquare();
		assertEquals("2324", ps.polybiusEncode("Hi"));
		assertEquals("2324 4423154215 113121", ps.polybiusEncode("Hi There Alf"));
		assertEquals("23113314 24245115", ps.polybiusEncode("Hand Jive"));

	}

	/**
	 * Test method for {@link com.smt.kata.code.PolybiusSquare#decodeValue(java.lang.String)}.
	 */
	@Test
	void testDecodeValue() {
		PolybiusSquare ps = new PolybiusSquare();
		assertEquals("hi", ps.decodeValue("2324")); 
		assertEquals("hi there alf", ps.decodeValue("2324 4423154215 113121"));
		assertEquals("hand iive", ps.decodeValue("23113314 24245115"));
	}

}
