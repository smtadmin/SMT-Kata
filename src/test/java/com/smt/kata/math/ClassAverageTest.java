package com.smt.kata.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> ClassAverageTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class ClassAverageTest {

	// Members
	private ClassAverage ca = new ClassAverage();
	
	/**
	 * Test method for {@link com.smt.kata.math.ClassAverage#takeDownAverage(java.lang.String[])}.
	 */
	@Test
	void testTakeDownAverageZeros() throws Exception {
		assertEquals("0%", ca.takeDownAverage(new String[] {"0%", "0%", "0%"}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.ClassAverage#takeDownAverage(java.lang.String[])}.
	 */
	@Test
	void testTakeDownAverageones() throws Exception {
		assertEquals("1%", ca.takeDownAverage(new String[] {"1%", "1%", "1%"}));
	}

	
	/**
	 * Test method for {@link com.smt.kata.math.ClassAverage#takeDownAverage(java.lang.String[])}.
	 */
	@Test
	void testTakeDownAverage() throws Exception {
		assertEquals("16%", ca.takeDownAverage(new String[] {"10%", "20%", "30%"}));
	}

	/**
	 * Test method for {@link com.smt.kata.math.ClassAverage#takeDownAverage(java.lang.String[])}.
	 */
	@Test
	void testTakeDownAverageFirst() throws Exception {
		assertEquals("58%", ca.takeDownAverage(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.ClassAverage#takeDownAverage(java.lang.String[])}.
	 */
	@Test
	void testTakeDownAverageSingle() throws Exception {
		assertEquals("9%", ca.takeDownAverage(new String[] {"10%"}));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.ClassAverage#takeDownAverage(java.lang.String[])}.
	 */
	@Test
	void testTakeDownAverageDouble() throws Exception {
		assertEquals("56%", ca.takeDownAverage(new String[] {"53%", "79%"}));
	}
}
