package com.smt.kata.word;

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
		List<List<String>> res = swe.findPatterns("sarcasm");
	}

}
