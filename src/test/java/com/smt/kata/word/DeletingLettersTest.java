package com.smt.kata.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: DeletingLettersTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 17, 2021
 * @updates:
 ****************************************************************************/
class DeletingLettersTest {
	
	// Members 
	DeletingLetters dl = new DeletingLetters();
	
	/**
	 * Test method for {@link com.smt.kata.word.DeletingLetters#findLongest(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testFindLongestNull() throws Exception {
		assertEquals("", dl.findLongest("abpcplea", null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.DeletingLetters#findLongest(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testFindLongestSourceNull() throws Exception {
		assertEquals("", dl.findLongest(null, new String[] {"ale","apple","monkey","plea"}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.DeletingLetters#findLongest(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testFindLongestEmpty() throws Exception {
		assertEquals("", dl.findLongest("abpcplea", new String[0] ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.DeletingLetters#findLongest(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testFindLongestSourceEmpty() throws Exception {
		assertEquals("", dl.findLongest(null, new String[0]));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.DeletingLetters#findLongest(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testFindLongestDefault() throws Exception {
		assertEquals("apple", dl.findLongest("abpcplea", new String[] {"ale","apple","monkey","plea"}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.DeletingLetters#findLongest(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testFindLongestShort() throws Exception {
		assertEquals("a", dl.findLongest("abpcplea", new String[] {"a","b","c"}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.DeletingLetters#findLongest(java.lang.String, java.lang.String[])}.
	 */
	@Test
	void testFindLongestShortWithNull() throws Exception {
		assertEquals("a", dl.findLongest("abpcplea", new String[] {"a","b",null,"c"}));
	}
}
