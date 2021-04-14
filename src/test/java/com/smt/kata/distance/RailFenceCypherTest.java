package com.smt.kata.distance;

// Junit 5
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> RailFenceCypherTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Tests the rail fence cypher class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 22, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class RailFenceCypherTest {
	
	// Members
	private RailFenceCypher cypher = new RailFenceCypher();

	/**
	 * Test method for {@link com.smt.kata.distance.RailFenceCypher#RailFenceCypher()}.
	 */
	@Test
	void testRailFenceCypher() throws Exception {
		assertNotNull(cypher);
	}

	/**
	 * Test method for {@link com.smt.kata.distance.RailFenceCypher#encodePhrase(java.lang.String)}.
	 */
	@Test
	void testEncodePhrase() throws Exception {
		assertEquals("WECRLTEERDSOEEFEAOCAIVDEN", cypher.encodePhrase("WE ARE DISCOVERED FLEE AT ONCE"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.RailFenceCypher#encodePhrase(java.lang.String)}.
	 */
	@Test
	void testEncodePhraseEmpty() throws Exception {
		assertEquals("", cypher.encodePhrase(""));
		assertEquals("", cypher.encodePhrase(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.RailFenceCypher#encodePhrase(java.lang.String)}.
	 */
	@Test
	void testEncodePhraseMixed() throws Exception {
		assertEquals("WECRLTEERDSOEEFEAOCAIVDEN", cypher.encodePhrase("WE ARE disCovErEd FLEE AT once"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.RailFenceCypher#getMatrixFromPhrase(java.lang.String)}.
	 */
	@Test
	void testGetMatrixFromPhraseEmpty() throws Exception {
		assertEquals(0, cypher.getMatrixFromPhrase("").length);
		assertEquals(0, cypher.getMatrixFromPhrase(null).length);
	}

	/**
	 * Test method for {@link com.smt.kata.distance.RailFenceCypher#getMatrixFromPhrase(java.lang.String)}.
	 */
	@Test
	void testGetMatrixFromPhrase() throws Exception {
		char[][] matrix = cypher.getMatrixFromPhrase("WE ARE DISCOVERED FLEE AT ONCE");
		
		assertEquals("W...E...C...R...L...T...E", new String(matrix[0]));
		assertEquals(".E.R.D.S.O.E.E.F.E.A.O.C.", new String(matrix[1]));
		assertEquals("..A...I...V...D...E...N..", new String(matrix[2]));
	}

}
