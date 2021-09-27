package com.smt.kata.data;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: DuplicateRemoverTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Tests for the Duplicate Remover Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 7, 2021
 * @updates:
 ****************************************************************************/
class DuplicateRemoverTest {
	
	// Members
	DuplicateRemover dr = new DuplicateRemover();
	
	/**
	 * Test method for {@link com.smt.kata.data.DuplicateRemover#process(java.lang.String, int)}.
	 */
	@Test
	void testProcessNull() throws Exception {
		assertEquals(null, dr.process(null, 2));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.DuplicateRemover#process(java.lang.String, int)}.
	 */
	@Test
	void testProcessEmpty() throws Exception {
		assertEquals("", dr.process("", 2));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.DuplicateRemover#process(java.lang.String, int)}.
	 */
	@Test
	void testProcessShort() throws Exception {
		assertEquals("aaaa", dr.process("aaaa", 5));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.DuplicateRemover#process(java.lang.String, int)}.
	 */
	@Test
	void testProcessShortDups() throws Exception {
		assertEquals("aaaa", dr.process("aaaa", 1));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.DuplicateRemover#process(java.lang.String, int)}.
	 */
	@Test
	void testProcessNoMatch() throws Exception {
		assertEquals("abcd", dr.process("abcd", 2));
	}

	/**
	 * Test method for {@link com.smt.kata.data.DuplicateRemover#process(java.lang.String, int)}.
	 */
	@Test
	void testProcessMany() throws Exception {
		assertEquals("aa", dr.process("deeedbbcccbdaa", 3));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.DuplicateRemover#process(java.lang.String, int)}.
	 */
	@Test
	void testProcessDouble() throws Exception {
		assertEquals("ps", dr.process("pbbcggttciiippooaais", 2));
	}
}
