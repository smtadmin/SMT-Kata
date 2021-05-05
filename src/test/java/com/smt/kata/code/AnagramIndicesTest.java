package com.smt.kata.code;

// Junit 5
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

//JDK 11.x
import java.util.Collection;

/****************************************************************************
 * <b>Title:</b> AnagramIndicieTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit test for the Anagram indices kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 28, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class AnagramIndicesTest {
	
	// Members
	private AnagramIndices ai = new AnagramIndices();

	/**
	 * Test method for {@link com.smt.kata.code.AnagramIndices#find(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testFind() throws Exception {
		Collection<Integer> indices = ai.find("ab", "abxaba");
		assertEquals(3, indices.size());
		
		assertTrue(indices.contains(0));
		assertTrue(indices.contains(3));
		assertTrue(indices.contains(4));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.AnagramIndices#find(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testFindAnagram() throws Exception {
		Collection<Integer> indices = ai.find("ee", "FeelBetterBeer");
		assertEquals(2, indices.size());
		
		assertTrue(indices.contains(1));
		assertTrue(indices.contains(11));
	}

	/**
	 * Test method for {@link com.smt.kata.code.AnagramIndices#find(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testFindEmptyWord() throws Exception {
		Collection<Integer> indices = ai.find(null, "abxaba");
		assertEquals(0, indices.size());
		
		indices = ai.find("", "abxaba");
		assertEquals(0, indices.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.AnagramIndices#find(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testFindNullSource() throws Exception {
		Collection<Integer> indices = ai.find("ab", null);
		assertEquals(0, indices.size());
		
		indices = ai.find("ab", "");
		assertEquals(0, indices.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.AnagramIndices#find(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testFindSize() throws Exception {
		Collection<Integer> indices = ai.find("abxaba", "ab");
		assertEquals(0, indices.size());
		
		indices = ai.find("ab", "123rty");
		assertEquals(0, indices.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.AnagramIndices#find(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testFindSame() throws Exception {
		Collection<Integer> indices = ai.find("abxaba", "abxaba");
		assertEquals(1, indices.size());
	}
}
