package com.smt.kata.word;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: AlienDictionaryTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 7, 2021
 * @updates:
 ****************************************************************************/
class AlienDictionaryTest {
	
	/**
	 * Test method for {@link com.smt.kata.word.AlienDictionary#isSorted(java.lang.String[])}.
	 */
	@Test
	void testIsSortedNull() throws Exception {
		assertDoesNotThrow(() -> {
			AlienDictionary ad = new AlienDictionary("worldabcefghijkmnpqstuvxyz");
			assertFalse(ad.isSorted(null));
		});
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.AlienDictionary#isSorted(java.lang.String[])}.
	 */
	@Test
	void testIsSortedEmpty() throws Exception {
		assertDoesNotThrow(() -> {
			AlienDictionary ad = new AlienDictionary("worldabcefghijkmnpqstuvxyz");
			assertFalse(ad.isSorted(new String[0]));
		});
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.AlienDictionary#isSorted(java.lang.String[])}.
	 */
	@Test
	void testIsSortedShort() throws Exception {
		assertDoesNotThrow(() -> {
			AlienDictionary ad = new AlienDictionary("worldabcefghijkmnpqstuvxyz");
			assertFalse(ad.isSorted(new String[] { "hello" }));
		});
	}

	/**
	 * Test method for {@link com.smt.kata.word.AlienDictionary#isSorted(java.lang.String[])}.
	 */
	@Test
	void testIsSortedBadOrder() throws Exception {
		assertThrows(DatatypeConfigurationException.class, () -> {
			new AlienDictionary("worldabceijkmnpqstuvxyz");
		});
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.AlienDictionary#isSorted(java.lang.String[])}.
	 */
	@Test
	void testIsSortedObvious() throws Exception {
		AlienDictionary ad = new AlienDictionary("hlabcdefgijkmnopqrstuvwxyz");
		assertTrue(ad.isSorted(new String[] {"hello","leetcode"}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.AlienDictionary#isSorted(java.lang.String[])}.
	 */
	@Test
	void testIsSortedMixedCase() throws Exception {
		AlienDictionary ad = new AlienDictionary("hlabcdefgijkmnopqrstuvwxyz");
		assertTrue(ad.isSorted(new String[] {"heLLo","Leetcode", "Time"}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.AlienDictionary#isSorted(java.lang.String[])}.
	 */
	@Test
	void testIsSortedThreeWords() throws Exception {
		AlienDictionary ad = new AlienDictionary("worldabcefghijkmnpqstuvxyz");
		assertFalse(ad.isSorted(new String[] {"word","world","row"}));
	}

	/**
	 * Test method for {@link com.smt.kata.word.AlienDictionary#isSorted(java.lang.String[])}.
	 */
	@Test
	void testIsSortedSimilar() throws Exception {
		AlienDictionary ad = new AlienDictionary("abcdefghijklmnopqrstuvwxyz");
		assertFalse(ad.isSorted(new String[] {"apple","app"}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.AlienDictionary#isSorted(java.lang.String[])}.
	 */
	@Test
	void testIsSortedSimilarWithNull() throws Exception {
		AlienDictionary ad = new AlienDictionary("abcdefghijklmnopqrstuvwxyz");
		assertTrue(ad.isSorted(new String[] {"apple", null, "option"}));
	}
}
