package com.smt.kata.word;

//Junit 5
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// JDK 11.x
import java.util.List;

/****************************************************************************
 * <b>Title</b>: CircularArrayTest.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Unit test for the Circular Array Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 13, 2021
 * @updates:
 ****************************************************************************/
class CircularArrayTest {
	
	// Members
	CircularArray ca = new CircularArray();

	/**
	 * Test method for {@link com.smt.kata.word.CircularArray#create(java.lang.String[])}.
	 */
	@Test
	void testCreateEmpty() throws Exception {
		List<String> results = ca.create(new String[0]);
		assertEquals(0, results.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.CircularArray#create(java.lang.String[])}.
	 */
	@Test
	void testCreateNull() throws Exception {
		List<String> results = ca.create(null);
		assertEquals(0, results.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.CircularArray#create(java.lang.String[])}.
	 */
	@Test
	void testCreateSingle() throws Exception {
		List<String> results = ca.create(new String[] { "test" });
		assertEquals(0, results.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.CircularArray#create(java.lang.String[])}.
	 */
	@Test
	void testCreateDuplicate() throws Exception {
		List<String> results = ca.create(new String[] { "test", "test" });
		assertEquals(3, results.size());
		assertEquals("test", results.get(0));
		assertEquals("test", results.get(0));
		assertEquals("test", results.get(0));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.CircularArray#create(java.lang.String[])}.
	 */
	@Test
	void testCreateDefault() throws Exception {
		List<String> results = ca.create(new String[] {"chair", "height", "racket", "touch", "tunic"});
		
		assertEquals(6, results.size());
		assertEquals("touch", results.get(0));
		assertEquals("height", results.get(1));
		assertEquals("tunic", results.get(2));
		assertEquals("chair", results.get(3));
		assertEquals("racket", results.get(4));
		assertEquals("touch", results.get(5));
	}

	/**
	 * Test method for {@link com.smt.kata.word.CircularArray#create(java.lang.String[])}.
	 */
	@Test
	void testCreateStartMiddle() throws Exception {
		List<String> results = ca.create(new String[] {"height", "racket", "chair", "touch", "tunic"});
		
		assertEquals(6, results.size());
		assertEquals("touch", results.get(0));
		assertEquals("height", results.get(1));
		assertEquals("tunic", results.get(2));
		assertEquals("chair", results.get(3));
		assertEquals("racket", results.get(4));
		assertEquals("touch", results.get(5));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.CircularArray#create(java.lang.String[])}.
	 */
	@Test
	void testCreateNoChain() throws Exception {
		List<String> results = ca.create(new String[] {"height", "build", "car", "xray", "zoo"});
		assertEquals(0, results.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.CircularArray#create(java.lang.String[])}.
	 */
	@Test
	void testCreateSmallOrder() throws Exception {
		List<String> results = ca.create(new String[] {"apartment", "tot", "terra"});
		
		assertEquals(4, results.size());
		assertEquals("tot", results.get(0));
		assertEquals("terra", results.get(1));
		assertEquals("apartment", results.get(2));
		assertEquals("tot", results.get(3));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.CircularArray#create(java.lang.String[])}.
	 */
	@Test
	void testCreateSmallReversed() throws Exception {
		List<String> results = ca.create(new String[] {"sierra", "apartment", "toe", "eats"});
		assertEquals(5, results.size());
		assertEquals("sierra", results.get(0));
		assertEquals("apartment", results.get(1));
		assertEquals("toe", results.get(2));
		assertEquals("eats", results.get(3));
		assertEquals("sierra", results.get(4));
	}
}
