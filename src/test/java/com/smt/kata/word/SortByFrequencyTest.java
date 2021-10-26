package com.smt.kata.word;

// Junit 5
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SortByFrequencyTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for Sort Characters By Frequency Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 25, 2021
 * @updates:
 ****************************************************************************/
class SortByFrequencyTest {
	
	// Members
	private SortByFrequency sf = new SortByFrequency();
	
	/**
	 * Test method for {@link com.smt.kata.word.SortByFrequency#sort(java.lang.String)}.
	 */
	@Test
	void testSortNull() throws Exception {
		assertEquals("", sf.sort(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.SortByFrequency#sort(java.lang.String)}.
	 */
	@Test
	void testSortEmpty() throws Exception {
		assertEquals("", sf.sort(""));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.SortByFrequency#sort(java.lang.String)}.
	 */
	@Test
	void testSortSingle() throws Exception {
		assertEquals("j", sf.sort("J"));
	}

	/**
	 * Test method for {@link com.smt.kata.word.SortByFrequency#sort(java.lang.String)}.
	 */
	@Test
	void testSortExampleOne() throws Exception {
		assertTrue(sf.sort("HelloWorld").startsWith("lo"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.SortByFrequency#sort(java.lang.String)}.
	 */
	@Test
	void testSortExampleOneCaps() throws Exception {
		assertTrue(sf.sort("HELLOWORLD").startsWith("lo"));
	}

	/**
	 * Test method for {@link com.smt.kata.word.SortByFrequency#sort(java.lang.String)}.
	 */
	@Test
	void testSortExampleOneMixed() throws Exception {
		assertTrue(sf.sort("HELlOWoRlD").startsWith("lo"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.SortByFrequency#sort(java.lang.String)}.
	 */
	@Test
	void testSortLonger() throws Exception {
		assertTrue(sf.sort("alabamasandarkansas").startsWith("asn"));
	}
}
