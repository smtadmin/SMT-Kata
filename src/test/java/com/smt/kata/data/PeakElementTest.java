package com.smt.kata.data;

// JDK 11.x
import java.util.Arrays;

// Junit 5
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: PeakElementTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Peak Elelment Kata Unit Test
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 18, 2021
 * @updates:
 ****************************************************************************/
class PeakElementTest {
	
	// Members
	PeakElement pe = new PeakElement();

	/**
	 * Test method for {@link com.smt.kata.data.PeakElement#find(int[])}.
	 */
	@Test
	void testFindSingle() throws Exception {
		assertEquals(2, pe.find(new int[] {1,2,3,1})[0]);
	}

	/**
	 * Test method for {@link com.smt.kata.data.PeakElement#find(int[])}.
	 */
	@Test
	void testFindNull() throws Exception {
		assertEquals(0, pe.find(null).length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.PeakElement#find(int[])}.
	 */
	@Test
	void testFindEmpty() throws Exception {
		assertEquals(0, pe.find(new int[0]).length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.PeakElement#find(int[])}.
	 */
	@Test
	void testFindSmall() throws Exception {
		assertEquals(0, pe.find(new int[] { 1,2 }).length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.PeakElement#find(int[])}.
	 */
	@Test
	void testFindTwo() throws Exception {
		Integer[] peaks = pe.find(new int[] {1,2,1,3,5,6,4});
		assertEquals(2, peaks.length);
		assertTrue(Arrays.binarySearch(peaks, 1) > -1);
		assertTrue(Arrays.binarySearch(peaks, 5) > -1);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.PeakElement#find(int[])}.
	 */
	@Test
	void testFindMixed() throws Exception {
		Integer[] peaks = pe.find(new int[] {-1,2,1,-3,5,6,4});
		assertEquals(2, peaks.length);
		assertTrue(Arrays.binarySearch(peaks, 1) > -1);
		assertTrue(Arrays.binarySearch(peaks, 5) > -1);
	}
}
