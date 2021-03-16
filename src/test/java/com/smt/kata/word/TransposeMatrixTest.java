package com.smt.kata.word;

//Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: TransposeMatrixTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the transpose matrix kata class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 1, 2021
 * @updates:
 ****************************************************************************/
class TransposeMatrixTest {
	
	// Members
	private TransposeMatrix tm = new TransposeMatrix();
	
	/**
	 * Test method for {@link com.smt.kata.word.TransposeMatrix#TransposeMatrix()}.
	 */
	@Test
	void testTransposeMatrix() throws Exception {
		assertNotNull(tm);
	}

	/**
	 * Test method for {@link com.smt.kata.word.TransposeMatrix#parse(java.lang.String[][])}.
	 */
	@Test
	void testParseEmpty() throws Exception {
		assertEquals("", tm.parse(null));
		assertEquals("", tm.parse(new String[][] {}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.TransposeMatrix#parse(java.lang.String[][])}.
	 */
	@Test
	void testParseSingle() throws Exception {
		String[][] matrix = {
			{ "Enter" },
			{ "the" },
			{ "Matrix!" }
		};
		
		assertEquals("Enter the Matrix!", tm.parse(matrix));
	}

	/**
	 * Test method for {@link com.smt.kata.word.TransposeMatrix#parse(java.lang.String[][])}.
	 */
	@Test
	void testParseDouble() throws Exception {
		String[][] matrix = {
			{ "I","working" },
			{ "really","at" },
			{ "love","SMT!" }
		};
		
		assertEquals("I really love working at SMT!", tm.parse(matrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.TransposeMatrix#parse(java.lang.String[][])}.
	 */
	@Test
	void testParseTriple() throws Exception {
		String[][] matrix = {
			{ "My","evolves","on" },
			{ "world","solely","coding." }
		};
		
		assertEquals("My world evolves solely on coding.", tm.parse(matrix));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.TransposeMatrix#parse(java.lang.String[][])}.
	 */
	@Test
	void testParseLarge() throws Exception {
		String[][] matrix = {
			{ "My","revolves","around" },
			{ "world","solely","Katas!" }
		};
		
		assertEquals("My world revolves solely around Katas!", tm.parse(matrix));
	}
}
