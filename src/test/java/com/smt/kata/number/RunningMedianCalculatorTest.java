package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.List;


/****************************************************************************
 * <b>Title</b>: RunningMedianCalculatorTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 25, 2021
 * @updates:
 ****************************************************************************/
class RunningMedianCalculatorTest {
	
	// Members
	RunningMedianCalculator rmc = new RunningMedianCalculator();
	
	@Test
	void test() {
		assertNotNull(rmc);
	}

	/**
	 * Test the example given
	 * @throws Exception
	 */
	@Test
	void testGetMedianValues() throws Exception {
		List<Double> medianValues = rmc.getMedianValues(new int[] {2, 1, 5, 7, 2, 0, 5});
		assertEquals(7, medianValues.size());
		assertEquals(2, medianValues.get(0));
		assertEquals(1.5, medianValues.get(1));
		assertEquals(2, medianValues.get(2));
		assertEquals(3.5, medianValues.get(3));
		assertEquals(2, medianValues.get(4));
		assertEquals(2, medianValues.get(5));
		assertEquals(2, medianValues.get(6));
	}

	/**
	 * Tests a null value being passed
	 * @throws Exception
	 */
	@Test
	void testGetMedianValuesNull() throws Exception {
		List<Double> medianValues = rmc.getMedianValues(null);
		assertEquals(0, medianValues.size());
	}
	
	/**
	 * Tests an empty array value being passed
	 * @throws Exception
	 */
	@Test
	void testGetMedianValuesEmpty() throws Exception {
		List<Double> medianValues = rmc.getMedianValues(new int[0]);
		assertEquals(0, medianValues.size());
	}
	
	/**
	 * Test the example given
	 * @throws Exception
	 */
	@Test
	void testGetMedianValuesOneEntry() throws Exception {
		List<Double> medianValues = rmc.getMedianValues(new int[] {2});
		assertEquals(1, medianValues.size());
	}
	
	/**
	 * Test the example given
	 * @throws Exception
	 */
	@Test
	void testGetMedianValuesNegative() throws Exception {
		List<Double> medianValues = rmc.getMedianValues(new int[] {-2, -1, -5, -7, -2, 0, -5});
		assertEquals(7, medianValues.size());
		assertEquals(-2, medianValues.get(0));
		assertEquals(-1.5, medianValues.get(1));
		assertEquals(-2, medianValues.get(2));
		assertEquals(-3.5, medianValues.get(3));
		assertEquals(-2, medianValues.get(4));
		assertEquals(-2, medianValues.get(5));
		assertEquals(-2, medianValues.get(6));
	}
	
	/**
	 * Test the example given
	 * @throws Exception
	 */
	@Test
	void testGetMedianValuesmixed() throws Exception {
		List<Double> medianValues = rmc.getMedianValues(new int[] {-2, 1, -5, 7, -2, 0, 5});
		assertEquals(7, medianValues.size());
		assertEquals(-2, medianValues.get(0));
		assertEquals(-.5, medianValues.get(1));
		assertEquals(-2, medianValues.get(2));
		assertEquals(-.5, medianValues.get(3));
		assertEquals(-2, medianValues.get(4));
		assertEquals(-1, medianValues.get(5));
		assertEquals(-0, medianValues.get(6));
	}
}
