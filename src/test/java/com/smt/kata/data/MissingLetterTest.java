package com.smt.kata.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: MissingLetterTest.java
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
class MissingLetterTest {

	/**
	 * Test method for {@link com.smt.kata.data.MissingLetter#missingLetter(java.lang.String[])}.
	 */
	@Test
	void testMissingLetter() {
		MissingLetter ml = new MissingLetter();
		assertEquals('d', ml.missingLetter(new String[] { "a", "b", "c", "e", "f", "g" }));
		assertEquals('P', ml.missingLetter(new String[] { "O", "Q", "R", "S" }));
		assertEquals('y', ml.missingLetter(new String[] { "t", "u", "v", "w", "x", "z" }));
		assertEquals('n', ml.missingLetter(new String[] { "m", "o" }));
		assertEquals('*', ml.missingLetter(new String[0]));
	}

}
