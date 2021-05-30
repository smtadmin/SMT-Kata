package com.smt.kata.word;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: OrderPleaseTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
class OrderPleaseTest {
	
	// Members
	OrderPlease op = new OrderPlease();
	
	/**
	 * Test method for {@link com.smt.kata.word.OrderPlease#reorder(java.lang.String)}.
	 */
	@Test
	void testReorderEmpty() throws Exception {
		assertEquals("", op.reorder(""));
		assertEquals("", op.reorder(null));
	}

	/**
	 * Test method for {@link com.smt.kata.word.OrderPlease#reorder(java.lang.String)}.
	 */
	@Test
	void testReorderSimple() throws Exception {
		assertEquals("Thi1s is2 3a T4est", op.reorder("is2 Thi1s T4est 3a"));
	}

	/**
	 * Test method for {@link com.smt.kata.word.OrderPlease#reorder(java.lang.String)}.
	 */
	@Test
	void testReorderLonger() throws Exception {
		assertEquals("Fo1r the2 g3ood 4of th5e pe6ople", op.reorder("4of Fo1r pe6ople g3ood th5e the2"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.OrderPlease#reorder(java.lang.String)}.
	 */
	@Test
	void testReorderNoNums() throws Exception {
		assertEquals("We the people", op.reorder("We the people"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.OrderPlease#reorder(java.lang.String)}.
	 */
	@Test
	void testReorderDup() throws Exception {
		assertEquals("We1 1the p1eople i1n o1rder t1o 1form 1a 1more 1perfect 1union", op.reorder("We1 1the p1eople i1n o1rder t1o 1form 1a 1more 1perfect 1union"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.OrderPlease#reorder(java.lang.String)}.
	 */
	@Test
	void testReorderLargeNums() throws Exception {
		assertEquals("We100 t200he 300people", op.reorder("300people We100 t200he"));
	}
}
