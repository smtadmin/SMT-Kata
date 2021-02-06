package com.smt.kata.word;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: PangramTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the Pangram Kata class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class PangramTest {

	/**
	 * Test method for {@link com.smt.kata.word.Pangram#isPangram(java.lang.String)}.
	 */
	@Test
	void testIsPangram() {
		Pangram p = new Pangram();
	    assertTrue(p.isPangram("The quick brown fox jumps over the lazy dog"));
	    assertTrue(p.isPangram("Waltz, bad nymph, for quick jigs vex"));
	    assertTrue(p.isPangram("Crazy Fredrick bought many very exquisite opal jewels"));
	    assertFalse(p.isPangram("Five quacking zephyrs jot my wax bed."));
	    assertFalse(p.isPangram("A mad boxer shot a quick, loved jab to the jaw of his dizzy opponent"));
	}

}
