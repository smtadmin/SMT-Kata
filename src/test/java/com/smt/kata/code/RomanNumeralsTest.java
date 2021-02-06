package com.smt.kata.code;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: RomanNumeralsTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> tests the roman numerals kata which converts a decimal
 * value into a roman numeral
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class RomanNumeralsTest {

	/**
	 * Test method for {@link com.smt.kata.code.RomanNumerals#getRomanNumeral(int)}.
	 */
	@Test
	void testGetRomanNumeral() {
		RomanNumerals rn = new RomanNumerals();
		assertEquals("IV", rn.getRomanNumeral(4));  
	    assertEquals("X", rn.getRomanNumeral(10));  
	    assertEquals("III", rn.getRomanNumeral(3)); 
	    assertEquals("VIII", rn.getRomanNumeral(8)); 
	    assertEquals("XIX", rn.getRomanNumeral(19));
	    assertEquals("LXXIV", rn.getRomanNumeral(74));
	    assertEquals("DCCCXCIX", rn.getRomanNumeral(899));
	    assertEquals("MMMCCXXVIII", rn.getRomanNumeral(3228));
	}

}
