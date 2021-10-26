package com.smt.kata.distance;

// Junit 5
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.List;

/****************************************************************************
 * <b>Title</b>: IntersectingArraysTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unti Tests for the Intersecting Arrays Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 26, 2021
 * @updates:
 ****************************************************************************/
class IntersectingArraysTest {

	// Members
	IntersectingArrays ia = new IntersectingArrays();
	
	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingArrays#intersectNoCollections(int[], int[])}.
	 */
	@Test
	void testIntersectBothNull() throws Exception {
		assertEquals(0, ia.intersectNoCollections(null, null).length);
		assertEquals(0, ia.intersectWithCollections(null, null).size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingArrays#intersectNoCollections(int[], int[])}.
	 */
	@Test
	void testIntersectBothEmpty() throws Exception {
		assertEquals(0, ia.intersectNoCollections(new Integer[0], new Integer[0]).length);
		assertEquals(0, ia.intersectWithCollections(new Integer[0], new Integer[0]).size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingArrays#intersectNoCollections(int[], int[])}.
	 */
	@Test
	void testIntersectNullDataFirst() throws Exception {
		Integer[] first = new Integer[] {Integer.valueOf(1),null,Integer.valueOf(2),Integer.valueOf(1)};
		Integer[] second = new Integer[] {Integer.valueOf(2),Integer.valueOf(2)};
		assertEquals(0, ia.intersectNoCollections(first, second).length);
		assertEquals(0, ia.intersectWithCollections(first, second).size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingArrays#intersectNoCollections(int[], int[])}.
	 */
	@Test
	void testIntersectNullDataSecond() throws Exception {
		Integer[] first = new Integer[] {Integer.valueOf(1),Integer.valueOf(3),Integer.valueOf(2),Integer.valueOf(1)};
		Integer[] second = new Integer[] {null,Integer.valueOf(2)};
		assertEquals(0, ia.intersectNoCollections(first, second).length);
		assertEquals(0, ia.intersectWithCollections(first, second).size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingArrays#intersectNoCollections(int[], int[])}.
	 */
	@Test
	void testIntersectNoCollectionsExampleOne() throws Exception {
		Integer[] first = new Integer[] {Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(2),Integer.valueOf(1)};
		Integer[] second = new Integer[] {Integer.valueOf(2),Integer.valueOf(2)};
		Integer[] results = ia.intersectNoCollections(first, second);
		assertEquals(2, results.length);
		assertEquals(2, results[0]);
		assertEquals(2, results[1]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingArrays#intersectNoCollections(int[], int[])}.
	 */
	@Test
	void testIntersectNoCollectionsExampleTwo() throws Exception {
		Integer[] first = new Integer[] {Integer.valueOf(4),Integer.valueOf(9),Integer.valueOf(5)};
		Integer[] second = new Integer[] {Integer.valueOf(9),Integer.valueOf(4), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(4)};
		Integer[] results = ia.intersectNoCollections(first, second);
		assertEquals(2, results.length);
		assertEquals(4, results[0]);
		assertEquals(9, results[1]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingArrays#intersectNoCollections(int[], int[])}.
	 */
	@Test
	void testIntersectNoCollectionsNoMatch() throws Exception {
		Integer[] first = new Integer[] {Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3)};
		Integer[] second = new Integer[] {Integer.valueOf(9),Integer.valueOf(4), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(4)};
		Integer[] results = ia.intersectNoCollections(first, second);
		assertEquals(0, results.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingArrays#intersectNoCollections(int[], int[])}.
	 */
	@Test
	void testIntersectNoCollectionsAllMatch() throws Exception {
		Integer[] first = new Integer[] {Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3)};
		Integer[] second = new Integer[] {Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3)};
		Integer[] results = ia.intersectNoCollections(first, second);
		assertEquals(3, results.length);
		assertEquals(1, results[0]);
		assertEquals(2, results[1]);
		assertEquals(3, results[2]);
	}

	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingArrays#intersectWithCollections(java.lang.Integer[], java.lang.Integer[])}.
	 */
	@Test
	void testIntersectWithCollectionsExampleOne() throws Exception {
		Integer[] first = new Integer[] {Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(2),Integer.valueOf(1)};
		Integer[] second = new Integer[] {Integer.valueOf(2),Integer.valueOf(2)};
		List<Integer> results = ia.intersectWithCollections(first, second);
		assertEquals(2, results.size());
		assertEquals(2, results.get(0));
		assertEquals(2, results.get(1));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingArrays#intersectWithCollections(java.lang.Integer[], java.lang.Integer[])}.
	 */
	@Test
	void testIntersectWithCollectionsExample2() throws Exception {
		Integer[] first = new Integer[] {Integer.valueOf(4),Integer.valueOf(9),Integer.valueOf(5)};
		Integer[] second = new Integer[] {Integer.valueOf(9),Integer.valueOf(4), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(4)};
		List<Integer> results = ia.intersectWithCollections(first, second);
		assertEquals(2, results.size());
		assertTrue(results.contains(Integer.valueOf(4)));
		assertTrue(results.contains(Integer.valueOf(9)));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingArrays#intersectWithCollections(java.lang.Integer[], java.lang.Integer[])}.
	 */
	@Test
	void testIntersectWithCollectionsNoMatch() throws Exception {
		Integer[] first = new Integer[] {Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3)};
		Integer[] second = new Integer[] {Integer.valueOf(9),Integer.valueOf(4), Integer.valueOf(9), Integer.valueOf(8), Integer.valueOf(4)};
		List<Integer> results = ia.intersectWithCollections(first, second);
		assertEquals(0, results.size());
	}

	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingArrays#intersectWithCollections(java.lang.Integer[], java.lang.Integer[])}.
	 */
	@Test
	void testIntersectWithCollectionsAllMatch() throws Exception {
		Integer[] first = new Integer[] {Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3)};
		Integer[] second = new Integer[] {Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3)};
		List<Integer> results = ia.intersectWithCollections(first, second);
		assertEquals(3, results.size());
		assertTrue(results.contains(Integer.valueOf(1)));
		assertTrue(results.contains(Integer.valueOf(2)));
		assertTrue(results.contains(Integer.valueOf(3)));
	}
}
