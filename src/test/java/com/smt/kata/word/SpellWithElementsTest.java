package com.smt.kata.word;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SpellWithElementsTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 25, 2021
 * @updates:
 ****************************************************************************/
class SpellWithElementsTest {
	
	// Members
	private SpellWithElements swe = new SpellWithElements();
	
	/**
	 * Test method for {@link com.smt.kata.word.SpellWithElements#findPatterns(java.lang.String)}.
	 */
	@Test
	void testFindPatterns() throws Exception {
		assertEquals(0, swe.findPatterns("").size());
		assertEquals(0, swe.findPatterns(null).size());
	}

	/**
	 * Test method for {@link com.smt.kata.word.SpellWithElements#findPatterns(java.lang.String)}.
	 */
	@Test
	void testFindPatternsSarcasm() throws Exception {
		List<String> res = swe.findPatterns("sarcasm").get(0);
		assertEquals(4, res.size());
		assertEquals("s", res.get(0));
		assertEquals("ar", res.get(1));
		assertEquals("ca", res.get(2));
		assertEquals("sm", res.get(3));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.SpellWithElements#findPatterns(java.lang.String)}.
	 */
	@Test
	void testFindPatternsPolice() throws Exception {
		List<List<String>> res = swe.findPatterns("police");
		assertEquals(2, res.size());
		
		for (List<String> row : res) {
			if (row.get(0).equals("p")) {
				assertEquals("p", row.get(0));
				assertEquals("o", row.get(1));
				assertEquals("li", row.get(2));
				assertEquals("ce", row.get(3));
			} else {
				assertEquals("po", row.get(0));
				assertEquals("li", row.get(1));
				assertEquals("ce", row.get(2));
			}
		}
	}

	/**
	 * Test method for {@link com.smt.kata.word.SpellWithElements#findPatterns(java.lang.String)}.
	 */
	@Test
	void testFindPatternsNoMatch() throws Exception {
		List<List<String>> res = swe.findPatterns("zoo");
		assertEquals(0, res.size());
	}
}
