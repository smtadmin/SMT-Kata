package com.smt.kata.data;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: IsogramTest.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Tests the Isogram Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 17, 2021
 * @updates:
 ****************************************************************************/
class IsogramTest {

	// Members
	protected Isogram iso = new Isogram();
	
	/**
	 * Test method for {@link com.smt.kata.data.Isogram()}.
	 */
	@Test
	void testIsogram() throws Exception {
		assertNotNull(iso);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.Isogram#isValidIsogram(java.lang.String)}.
	 */
	@Test
	void testIsValidIsogramEmpty() throws Exception {
		assertEquals(false, iso.isValidIsogram(""));
		assertEquals(false, iso.isValidIsogram(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.Isogram#isValidIsogram(java.lang.String)}.
	 */
	@Test
	void testIsValidIsogram() throws Exception {
		assertEquals(true, iso.isValidIsogram("james"));
	}

	/**
	 * Test method for {@link com.smt.kata.data.Isogram#isValidIsogram(java.lang.String)}.
	 */
	@Test
	void testIsValidIsogramFalse() throws Exception {
		assertFalse(iso.isValidIsogram("hello"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.Isogram#isValidIsogram(java.lang.String)}.
	 */
	@Test
	void testIsValidIsogramCase() throws Exception {
		assertFalse(iso.isValidIsogram("helLo"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.Isogram#isValidIsogram(java.lang.String)}.
	 */
	@Test
	void testIsValidIsogramSpace() throws Exception {
		assertEquals(true, iso.isValidIsogram("Dr. Stef Quia"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.Isogram#isValidIsogram(java.lang.String)}.
	 */
	@Test
	void testIsValidIsogramDash() throws Exception {
		assertEquals(true, iso.isValidIsogram("Dr.-Stef-Quia"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.Isogram#isValidIsogram(java.lang.String)}.
	 */
	@Test
	void testIsValidIsogramPhrase() throws Exception {
		assertEquals(false, iso.isValidIsogram("Dr. Stef Quia."));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.Isogram#isValidIsogram(java.lang.String)}.
	 */
	@Test
	void testIsValidIsogramAlphabet() throws Exception {
		assertEquals(true, iso.isValidIsogram("A b C-d-e-f G H I J. K l m n o-PQR-S T u v WXYZ"));
	}
}
