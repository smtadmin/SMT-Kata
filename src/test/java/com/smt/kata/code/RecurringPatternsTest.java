package com.smt.kata.code;

// JDK 11.x
import java.util.List;

// Junit 5
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: RecurringPatternsTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Tests for the RucurringPatterns Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 10, 2021
 * @updates:
 ****************************************************************************/
class RecurringPatternsTest {
	
	// Members
	RecurringPatterns rp = new RecurringPatterns();
	
	/**
	 * Test method for {@link com.smt.kata.code.RecurringPatterns#count(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCountNullWord() throws Exception {
		List<Integer> locations = rp.count(null, "abr");
		assertEquals(0, locations.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.RecurringPatterns#count(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCountNullPattern() throws Exception {
		List<Integer> locations = rp.count("abracadabra", null);
		assertEquals(0, locations.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.RecurringPatterns#count(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCountEmpty() throws Exception {
		List<Integer> locations = rp.count("", "");
		assertEquals(0, locations.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.RecurringPatterns#count(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCountEmptyWord() throws Exception {
		List<Integer> locations = rp.count("", "abr");
		assertEquals(0, locations.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.RecurringPatterns#count(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCountEmptyPattern() throws Exception {
		List<Integer> locations = rp.count("abracadabra", "");
		assertEquals(0, locations.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.RecurringPatterns#count(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCount() throws Exception {
		List<Integer> locations = rp.count("abracadabra", "abr");
		assertEquals(2, locations.size());
		assertTrue(locations.contains(0));
		assertTrue(locations.contains(7));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.RecurringPatterns#count(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCountSpacesWord() throws Exception {
		List<Integer> locations = rp.count("ab racad abr a", "abr");
		assertEquals(2, locations.size());
		assertTrue(locations.contains(0));
		assertTrue(locations.contains(7));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.RecurringPatterns#count(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCountWordSingle() throws Exception {
		List<Integer> locations = rp.count("ab racad abr a", "a");
		assertEquals(5, locations.size());
		assertTrue(locations.contains(0));
		assertTrue(locations.contains(3));
		assertTrue(locations.contains(5));
		assertTrue(locations.contains(7));
		assertTrue(locations.contains(10));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.RecurringPatterns#count(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCountLargePattern() throws Exception {
		List<Integer> locations = rp.count("abr", "abracadabra");
		assertEquals(0, locations.size());
	}
	
}
