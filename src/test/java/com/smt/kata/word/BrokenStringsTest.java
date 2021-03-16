package com.smt.kata.word;

// Junit 5
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: BrokenStringsTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the broken strings kata class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 10, 2021
 * @updates:
 ****************************************************************************/
class BrokenStringsTest {
	
	// Members
	private BrokenStrings bs = new BrokenStrings();

	/**
	 * Test method for {@link com.smt.kata.word.BrokenStrings#BrokenStrings()}.
	 */
	@Test
	void testBrokenStrings() throws Exception {
		assertNotNull(bs);
	}

	/**
	 * Test method for {@link com.smt.kata.word.BrokenStrings#slice(java.lang.String, int)}.
	 */
	@Test
	void testSliceEmpty() throws Exception {
		assertEquals(0, bs.slice(null, 0).size());
		assertEquals(0, bs.slice("", 0).size());
		assertEquals(0, bs.slice("test", 0).size());
	}

	/**
	 * Test method for {@link com.smt.kata.word.BrokenStrings#slice(java.lang.String, int)}.
	 */
	@Test
	void testSlice() throws Exception {
		List<String> data = bs.slice("The quick brown fox jumps over the lazy dog", 10);
		assertEquals(5, data.size());
		assertEquals("The quick", data.get(0));
		assertEquals("brown fox", data.get(1));
		assertEquals("jumps over", data.get(2));
		assertEquals("the lazy", data.get(3));
		assertEquals("dog", data.get(4));
	}

	/**
	 * Test method for {@link com.smt.kata.word.BrokenStrings#slice(java.lang.String, int)}.
	 */
	@Test
	void testSliceLarge() throws Exception {
		List<String> data = bs.slice("He quickly recited the pledgeof allegience", 8);
		assertEquals(0, data.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.BrokenStrings#slice(java.lang.String, int)}.
	 */
	@Test
	void testSliceSpaces() throws Exception {
		List<String> data = bs.slice("     The quick brown fox jumps over the lazy dog      ", 10);
		assertEquals(5, data.size());
		assertEquals("The quick", data.get(0));
		assertEquals("brown fox", data.get(1));
		assertEquals("jumps over", data.get(2));
		assertEquals("the lazy", data.get(3));
		assertEquals("dog", data.get(4));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.BrokenStrings#slice(java.lang.String, int)}.
	 */
	@Test
	void testSliceSmallK() throws Exception {
		List<String> data = bs.slice("The quick brown fox jumps over the lazy dog", 5);
		assertEquals(9, data.size());
		
	}
}
