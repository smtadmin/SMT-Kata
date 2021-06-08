package com.smt.kata.io;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: CountingLinesTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 26, 2021
 * @updates:
 ****************************************************************************/
class CountingLinesTest {
	
	// Members
	CountingLines cl = new CountingLines();
	
	/**
	 * Test method for {@link com.smt.kata.io.CountingLines#getNumberLines()}.
	 */
	@Test
	void testGetNumberLines() throws Exception {
		assertThrows(NullPointerException.class, () -> {
			cl.getNumberLines(null);
		});
		
		assertThrows(IOException.class, () -> {
			cl.getNumberLines("");
		});
	}

	/**
	 * Test method for {@link com.smt.kata.io.CountingLines#getNumberLines()}.
	 */
	@Test
	void testGetNumberLinesHashCode() throws Exception {
		assertEquals(52,  cl.getNumberLines("com.smt.kata.util.HashCodeUtil"));
	}

	/**
	 * Test method for {@link com.smt.kata.io.CountingLines#getNumberLines()}.
	 */
	@Test
	void testGetNumberLinesDictionary() throws Exception {
		assertEquals(30,  cl.getNumberLines("com.smt.kata.util.Dictionary"));
	}

	/**
	 * Test method for {@link com.smt.kata.io.CountingLines#getNumberLines()}.
	 */
	@Test
	void testGetNumberLinesMissing() throws Exception {
		assertThrows(IOException.class, () -> {
			cl.getNumberLines("com.smt.kata.util.SomeClass");
		});
	}
}
