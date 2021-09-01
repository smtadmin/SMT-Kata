package com.smt.kata.math;

// JDK 11.x
import java.util.Collection;

// Junit 5
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: ModulusSetsTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Tests for the Modulus Sets Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 12, 2021
 * @updates:
 ****************************************************************************/
class ModulusSetsTest {
	
	// Members
	ModulusSets ms = new ModulusSets();
	
	/**
	 * Test method for {@link com.smt.kata.math.ModulusSets#calculate(int[])}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		Collection<Integer> items = ms.calculate(new int[0]);
		assertEquals(0, items.size());
	}

	/**
	 * Test method for {@link com.smt.kata.math.ModulusSets#calculate(int[])}.
	 */
	@Test
	void testCalculateNull() throws Exception {
		Collection<Integer> items = ms.calculate(null);
		assertEquals(0, items.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.ModulusSets#calculate(int[])}.
	 */
	@Test
	void testCalculate() throws Exception {
		Collection<Integer> items = ms.calculate(new int[] {3, 5, 10, 20, 21});
		assertEquals(3, items.size());
		assertTrue(items.contains(5));
		assertTrue(items.contains(10));
		assertTrue(items.contains(20));
	}

	/**
	 * Test method for {@link com.smt.kata.math.ModulusSets#calculate(int[])}.
	 */
	@Test
	void testCalculateAllMatchUnordered() throws Exception {
		Collection<Integer> items = ms.calculate(new int[] {24, 3, 6, 1});
		assertEquals(4, items.size());
		assertTrue(items.contains(1));
		assertTrue(items.contains(3));
		assertTrue(items.contains(6));
		assertTrue(items.contains(24));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.ModulusSets#calculate(int[])}.
	 */
	@Test
	void testCalculateAllMatch() throws Exception {
		Collection<Integer> items = ms.calculate(new int[] {1, 3, 6, 24});
		assertEquals(4, items.size());
		assertTrue(items.contains(1));
		assertTrue(items.contains(3));
		assertTrue(items.contains(6));
		assertTrue(items.contains(24));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.ModulusSets#calculate(int[])}.
	 */
	@Test
	void testCalculateNoMatch() throws Exception {
		Collection<Integer> items = ms.calculate(new int[] {3, 7, 11, 17, 19, 29});
		assertEquals(0, items.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.ModulusSets#calculate(int[])}.
	 */
	@Test
	void testCalculatlong() throws Exception {
		Collection<Integer> items = ms.calculate(new int[] {3, 12, 17, 18, 6, 2, 45, 23, 16, 28, 42, 61, 100, 200, 45});
		System.out.println(items);
		assertEquals(9, items.size());
		
		assertTrue(items.contains(2));
		assertTrue(items.contains(6));
		assertTrue(items.contains(12));
		assertTrue(items.contains(16));
		assertTrue(items.contains(18));
		assertTrue(items.contains(28));
		assertTrue(items.contains(42));
		assertTrue(items.contains(100));
		assertTrue(items.contains(200));
	}
}
