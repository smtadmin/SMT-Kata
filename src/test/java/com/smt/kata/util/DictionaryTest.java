package com.smt.kata.util;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.Set;

/****************************************************************************
 * <b>Title</b>: DictionaryTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> test for the dictionary class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 3, 2021
 * @updates:
 ****************************************************************************/
class DictionaryTest {

	/**
	 * Tests the constructor
	 */
	@Test
	void test() {
		Dictionary d = new Dictionary();
		assertNotNull(d);
	}

	/**
	 * Validates that the dictionary can be loaded from the file
	 * @throws Exception
	 */
	@Test
	public void testGetDictionary() throws Exception {
		Dictionary d = new Dictionary();
		Set<String> dict = d.getDictionary();
		
		assertEquals(466551, dict.size());
		assertTrue(dict.contains("the"));
		assertTrue(dict.contains("following"));
		assertTrue(dict.contains("words"));
		assertTrue(dict.contains("exist"));
	}
}
