package com.smt.kata.data;

//Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.Arrays;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: SingularArrayTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Singular Array Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 27, 2021
 * @updates:
 ****************************************************************************/
class SingularArrayTest {
	
	// Members
	SingularArray sa = new SingularArray();

	/**
	 * Test method for {@link com.smt.kata.data.SingularArray#findUnmatched(java.lang.Integer[])}.
	 */
	@Test
	void testFindUnmatchedEmpty() throws Exception {
		assertEquals(0, sa.findUnmatched(null).length);
		assertEquals(0, sa.findUnmatched(new Integer[0]).length);
	}

	/**
	 * Test method for {@link com.smt.kata.data.SingularArray#findUnmatched(java.lang.Integer[])}.
	 */
	@Test
	void testFindUnmatchedSmall() throws Exception {
		Integer[] values = sa.findUnmatched(new Integer[] {2, 4, 6, 8, 10, 2, 6, 10 });
		List<Integer> list = Arrays.asList(values);
		assertEquals(2, values.length);
		assertTrue(list.contains(4));
		assertTrue(list.contains(8));
		assertFalse(list.contains(2));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.SingularArray#findUnmatched(java.lang.Integer[])}.
	 */
	@Test
	void testFindUnmatchedSmallNull() throws Exception {
		Integer[] values = sa.findUnmatched(new Integer[] {2, null, 4, 6, 8, 10, 2, 6, 10 });
		List<Integer> list = Arrays.asList(values);
		assertEquals(3, values.length);
		assertTrue(list.contains(4));
		assertTrue(list.contains(8));
		assertTrue(list.contains(null));
		assertFalse(list.contains(2));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.SingularArray#findUnmatched(java.lang.Integer[])}.
	 */
	@Test
	void testFindUnmatchedTwoNull() throws Exception {
		Integer[] values = sa.findUnmatched(new Integer[] {2, null, 4, 6, 8, 10, 2, null, 6, 10 });
		List<Integer> list = Arrays.asList(values);
		assertEquals(2, values.length);
		assertTrue(list.contains(4));
		assertTrue(list.contains(8));
		assertFalse(list.contains(null));
		assertFalse(list.contains(2));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.SingularArray#findUnmatched(java.lang.Integer[])}.
	 */
	@Test
	void testFindUnmatchedNoneSingular() throws Exception {
		Integer[] values = sa.findUnmatched(new Integer[] {1,1,1,1,1,1,1,1,1,1,1,1});
		List<Integer> list = Arrays.asList(values);
		assertEquals(0, values.length);
		assertFalse(list.contains(null));
	}
}
