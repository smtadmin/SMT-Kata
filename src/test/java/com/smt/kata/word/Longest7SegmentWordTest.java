package com.smt.kata.word;

// Junit 5
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: Longest7SegmentWordTest.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Unit Test for the Longest Seven Segment Word Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 28, 2021
 * @updates:
 ****************************************************************************/
class Longest7SegmentWordTest {
	
	// Members
	Longest7SegmentWord lssw = new Longest7SegmentWord();
	
	/**
	 * Test method for {@link com.smt.kata.word.Longest7SegmentWord#calculate(java.lang.String[])}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		assertNull(lssw.calculate(null));
		assertEquals("", lssw.calculate(new String[]{} ));
		assertEquals("", lssw.calculate(new String[0] ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.Longest7SegmentWord#calculate(java.lang.String[])}.
	 */
	@Test
	void testCalculateNullWords() throws Exception {
		assertEquals("parental", lssw.calculate(new String[]{null, "parental", "fridge", null} ));
	}
		
	/**
	 * Test method for {@link com.smt.kata.word.Longest7SegmentWord#calculate(java.lang.String[])}.
	 */
	@Test
	void testCalculate() throws Exception {
		assertEquals("parental", lssw.calculate(new String[]{"knighthood", "parental", "fridge", "clingfilm"} ));
	}

	/**
	 * Test method for {@link com.smt.kata.word.Longest7SegmentWord#calculate(java.lang.String[])}.
	 */
	@Test
	void testCalculateMixedCase() throws Exception {
		assertEquals("pArEntAl", lssw.calculate(new String[]{"knighthood", "pArEntAl", "fridge", "clingfilm"} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.Longest7SegmentWord#calculate(java.lang.String[])}.
	 */
	@Test
	void testCalculateNoMatch() throws Exception {
		assertEquals("", lssw.calculate(new String[]{"velocity", "mackerel", "woven", "kingsmen"} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.Longest7SegmentWord#calculate(java.lang.String[])}.
	 */
	@Test
	void testCalculateCelebrate() throws Exception {
		assertEquals("celebration", lssw.calculate(new String[]{"coding", "crackers", "edabit", "celebration"} ));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.Longest7SegmentWord#calculate(java.lang.String[])}.
	 */
	@Test
	void testCalculateCelebrateWithSpace() throws Exception {
		assertEquals("cele bration", lssw.calculate(new String[]{"coding", "crackers", "edabit", "cele bration"} ));
	}
}
