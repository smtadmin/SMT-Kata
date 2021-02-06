package com.smt.kata.number;

// JDK 11.x
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: TripleUpTest.java
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
class TripleUpTest {

	/**
	 * Test method for {@link com.smt.kata.number.TripleUp#tripleUp(int[])}.
	 */
	@Test
	void testTripleUp() {
		TripleUp tu = new TripleUp();
		assertTrue(tu.tripleUp(new int[] { 1, 4, 5, 6, 2 }));
		assertTrue(tu.tripleUp(new int[] { 1, 2, 3 }));
		assertFalse(tu.tripleUp(new int[] { 1, 2, 4 }));
		assertFalse(tu.tripleUp(new int[] { -1, -2, -3, 7, 6, 8 }));
		assertTrue(tu.tripleUp(new int[] { -3, -2, -1, 3, 4, 8 }));
		assertFalse(tu.tripleUp(new int[] { 4, 8 }));
		assertFalse(tu.tripleUp(null));
	}

}
