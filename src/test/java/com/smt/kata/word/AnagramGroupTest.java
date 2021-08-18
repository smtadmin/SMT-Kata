package com.smt.kata.word;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: AnagramGroupTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit test for the Anagram Group Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 18, 2021
 * @updates:
 ****************************************************************************/
class AnagramGroupTest {

	// Members
	AnagramGroup ag = new AnagramGroup();
	
	/**
	 * Test method for {@link com.smt.kata.word.AnagramGroup#assign(java.lang.String[])}.
	 */
	@Test
	void testAssignLong() throws Exception {
		Collection<List<String>> items = ag.assign(new String[] {"eat","tea","tan","ate","nat","bat"});
		assertEquals(3, items.size());
		
		for (List<String> item : items) {
			switch(item.size()) {
				case 1:
					assertEquals("bat", item.get(0));
					break;
				case 2:
					assertTrue(item.contains("nat"));
					assertTrue(item.contains("tan"));
					break;
				case 3:
					assertTrue(item.contains("eat"));
					assertTrue(item.contains("tea"));
					assertTrue(item.contains("ate"));
					break;
			}
		}
	}

	/**
	 * Test method for {@link com.smt.kata.word.AnagramGroup#assign(java.lang.String[])}.
	 */
	@Test
	void testAssignLongWithNull() throws Exception {
		Collection<List<String>> items = ag.assign(new String[] {"eat",null, "tea","tan","ate","nat","bat", ""});
		assertEquals(3, items.size());
		
		for (List<String> item : items) {
			switch(item.size()) {
				case 1:
					assertEquals("bat", item.get(0));
					break;
				case 2:
					assertTrue(item.contains("nat"));
					assertTrue(item.contains("tan"));
					break;
				case 3:
					assertTrue(item.contains("eat"));
					assertTrue(item.contains("tea"));
					assertTrue(item.contains("ate"));
					break;
			}
		}
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.AnagramGroup#assign(java.lang.String[])}.
	 */
	@Test
	void testAssignSingle() throws Exception {
		Collection<List<String>> items = ag.assign(new String[] {"a"});
		assertEquals(1, items.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.AnagramGroup#assign(java.lang.String[])}.
	 */
	@Test
	void testAssignEmpty() throws Exception {
		Collection<List<String>> items = ag.assign(new String[] {""});
		assertEquals(0, items.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.AnagramGroup#assign(java.lang.String[])}.
	 */
	@Test
	void testAssignInit() throws Exception {
		Collection<List<String>> items = ag.assign(new String[0]);
		assertEquals(0, items.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.AnagramGroup#assign(java.lang.String[])}.
	 */
	@Test
	void testAssignNull() throws Exception {
		Collection<List<String>> items = ag.assign(null);
		assertEquals(0, items.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.AnagramGroup#assign(java.lang.String[])}.
	 */
	@Test
	void testAssignLongWithNoMatches() throws Exception {
		Collection<List<String>> items = ag.assign(new String[] {"eat",null, "team","tangent","after","natural","bat", ""});
		assertEquals(6, items.size());
	}
}
