package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SpreadsheetNumberingTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Tests for the Spreadsheet Numbering
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 10, 2021
 * @updates:
 ****************************************************************************/
class SpreadsheetNumberingTest {
	
	// Members
	SpreadsheetNumbering sn = new SpreadsheetNumbering();
	
	/**
	 * Test method for {@link com.smt.kata.number.SpreadsheetNumbering#getColumnLabel(int)}.
	 */
	@Test
	void testGetColumnLabel() throws Exception {
		assertEquals("A", sn.getColumnLabel(1));
	}

	/**
	 * Test method for {@link com.smt.kata.number.SpreadsheetNumbering#getColumnLabel(int)}.
	 */
	@Test
	void testGetColumnLabelSize3() throws Exception {
		assertEquals("BA", sn.getColumnLabel(53));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SpreadsheetNumbering#getColumnLabel(int)}.
	 */
	@Test
	void testGetColumnLabelSize3Plus1() throws Exception {
		assertEquals("BB", sn.getColumnLabel(54));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SpreadsheetNumbering#getColumnLabel(int)}.
	 */
	@Test
	void testGetColumnLabelSizeZZ() throws Exception {
		assertEquals("ZZ", sn.getColumnLabel(675));
	}
	
	/**
	 * Test method for {@link com.smt.kata.number.SpreadsheetNumbering#getColumnLabel(int)}.
	 */
	@Test
	void testGetColumnLabelSizeAAA() throws Exception {
		assertEquals("AAA", sn.getColumnLabel(676));
	}
}
