package com.smt.kata.number;

//Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: GreatestCommonDivisorTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the Greatest common divisor Kata class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class GreatestCommonDivisorTest {

	/**
	 * Test method for {@link com.smt.kata.number.GreatestCommonDivisor#gcd(java.lang.Integer, java.lang.Integer)}.
	 */
	@Test
	void testGcd() throws Exception {
		GreatestCommonDivisor div = new GreatestCommonDivisor();
		
		assertEquals(11, div.gcd(99, 44));
		assertEquals(11, div.gcd(44, 99));
		assertEquals(17, div.gcd(51, 17));
		assertEquals(3, div.gcd(27, 6));
		assertEquals(1, div.gcd(9, 25));
		assertEquals(-3, div.gcd(-27, 6));
		assertEquals(-3, div.gcd(-27, -6));
	}

}
