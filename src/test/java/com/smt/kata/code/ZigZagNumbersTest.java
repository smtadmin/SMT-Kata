package com.smt.kata.code;

// junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: ZigZagNumbersTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit tests for the ZigZagNumbers kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 17, 2021
 * @updates:
 ****************************************************************************/
class ZigZagNumbersTest {
	
	// Members
	ZigZagNumbers zzn = new ZigZagNumbers();

	/**
	 * Test method for {@link com.smt.kata.code.ZigZagNumbers#isZigZag(int[])}.
	 */
	@Test
	void testIsZigZag() throws Exception {
		assertFalse(zzn.isZigZag(new int[0]));
		assertFalse(zzn.isZigZag(new int[] { 3 }));
		assertFalse(zzn.isZigZag(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.ZigZagNumbers#isZigZag(int[])}.
	 */
	@Test
	void testIsZigZagValid() throws Exception {
		assertTrue(zzn.isZigZag(new int[]{3,4,2,6,1,5}));
	}

	/**
	 * Test method for {@link com.smt.kata.code.ZigZagNumbers#isZigZag(int[])}.
	 */
	@Test
	void testIsZigZagInvalid() throws Exception {
		assertFalse(zzn.isZigZag(new int[]{7,4,6,2,1,5,3}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.ZigZagNumbers#isZigZag(int[])}.
	 */
	@Test
	void testIsZigZagSame() throws Exception {
		assertFalse(zzn.isZigZag(new int[]{2,4,2,2,1,5,3}));
	}

	/**
	 * Test method for {@link com.smt.kata.code.ZigZagNumbers#isZigZag(int[])}.
	 */
	@Test
	void testIsZigZagNegative() throws Exception {
		assertTrue(zzn.isZigZag(new int[]{-4,-2,-8,-2,-10,-5,-13}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.ZigZagNumbers#isZigZag(int[])}.
	 */
	@Test
	void testIsZigZagOddLarger() throws Exception {
		assertFalse(zzn.isZigZag(new int[]{10000, 500000, 25000000, 2000000, 100000, 1980000, 76587}));
	}

	/**
	 * Test method for {@link com.smt.kata.code.ZigZagNumbers#isZigZag(int[])}.
	 */
	@Test
	void testIsZigZagLarge() throws Exception {
		assertTrue(zzn.isZigZag(new int[]{10000, 500000, 250000, 2000000, 100000, 1980000, 76587}));
	}
}
