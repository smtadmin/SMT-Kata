package com.smt.kata.word;

// Junit 5
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.List;


/****************************************************************************
 * <b>Title</b>: WordSubsetsTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Word Subsets Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 9, 2021
 * @updates:
 ****************************************************************************/
class WordSubsetsTest {
	
	// Members
	WordSubsets ws = new WordSubsets();
	
	/**
	 * Test method for {@link com.smt.kata.word.WordSubsets#find(java.lang.String[], java.lang.String[])}.
	 */
	@Test
	void testFindNullWords() throws Exception {
		assertEquals(0, ws.find(null, new String[] {"e","o"}).size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.WordSubsets#find(java.lang.String[], java.lang.String[])}.
	 */
	@Test
	void testFindEmptyWords() throws Exception {
		assertEquals(0, ws.find(new String[0], new String[] {"e","o"}).size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.WordSubsets#find(java.lang.String[], java.lang.String[])}.
	 */
	@Test
	void testFindNullSearchVals() throws Exception {
		assertEquals(0, ws.find(new String[] {"one", "two"}, null).size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.WordSubsets#find(java.lang.String[], java.lang.String[])}.
	 */
	@Test
	void testFindEmptySearchVals() throws Exception {
		assertEquals(0, ws.find(new String[] {"one", "two"}, new String[0]).size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.WordSubsets#find(java.lang.String[], java.lang.String[])}.
	 */
	@Test
	void testFindTrioWithNullWord() throws Exception {
		List<String> results = ws.find(new String[] {"amazon","apple","facebook","google","leetcode", null}, new String[] {"e","o"});
		assertEquals(3, results.size());
		assertTrue(results.contains("facebook"));
		assertTrue(results.contains("google"));
		assertTrue(results.contains("leetcode"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.WordSubsets#find(java.lang.String[], java.lang.String[])}.
	 */
	@Test
	void testFindTrioWithNullSearchVal() throws Exception {
		List<String> results = ws.find(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"e","o", null});
		assertEquals(3, results.size());
		assertTrue(results.contains("facebook"));
		assertTrue(results.contains("google"));
		assertTrue(results.contains("leetcode"));
	}

	/**
	 * Test method for {@link com.smt.kata.word.WordSubsets#find(java.lang.String[], java.lang.String[])}.
	 */
	@Test
	void testFindTrio() throws Exception {
		List<String> results = ws.find(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"e","o"});
		assertEquals(3, results.size());
		assertTrue(results.contains("facebook"));
		assertTrue(results.contains("google"));
		assertTrue(results.contains("leetcode"));
	}

	/**
	 * Test method for {@link com.smt.kata.word.WordSubsets#find(java.lang.String[], java.lang.String[])}.
	 */
	@Test
	void testFindTrio2() throws Exception {
		List<String> results = ws.find(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"l","e"});
		assertEquals(3, results.size());
		assertTrue(results.contains("apple"));
		assertTrue(results.contains("google"));
		assertTrue(results.contains("leetcode"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.WordSubsets#find(java.lang.String[], java.lang.String[])}.
	 */
	@Test
	void testFindDual() throws Exception {
		List<String> results = ws.find(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"e","oo"});
		assertEquals(2, results.size());
		assertTrue(results.contains("facebook"));
		assertTrue(results.contains("google"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.WordSubsets#find(java.lang.String[], java.lang.String[])}.
	 */
	@Test
	void testFindDual2() throws Exception {
		List<String> results = ws.find(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"lo","eo"});
		System.out.println(results);
		assertEquals(2, results.size());
		assertTrue(results.contains("leetcode"));
		assertTrue(results.contains("google"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.WordSubsets#find(java.lang.String[], java.lang.String[])}.
	 */
	@Test
	void testFindTriple() throws Exception {
		List<String> results = ws.find(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"ec","oc","ceo"});
		assertEquals(2, results.size());
		assertTrue(results.contains("facebook"));
		assertTrue(results.contains("leetcode"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.WordSubsets#find(java.lang.String[], java.lang.String[])}.
	 */
	@Test
	void testFindTripleMixedCase() throws Exception {
		List<String> results = ws.find(new String[] {"amAzOn","APPLE","facebOOk","GOOGle","lEETCode"}, new String[] {"eC","Oc","cEo"});
		assertEquals(2, results.size());
		assertTrue(results.contains("facebook"));
		assertTrue(results.contains("leetcode"));
	}
}
