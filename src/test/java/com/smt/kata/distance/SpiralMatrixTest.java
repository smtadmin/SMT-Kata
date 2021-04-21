package com.smt.kata.distance;

// JDK 11.x
import java.util.List;

// Junit 5
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SpiralMatrixTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit tests for the Sprial Matrix Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 15, 2021
 * @updates:
 ****************************************************************************/
class SpiralMatrixTest {
	/**
	 * Matrix to utilize when 
	 */
	public static final int[][] MATRIX = new int[][] {
		{ 1,  2,  3,  4,  5  },
		{ 6,  7,  8,  9,  10 },
		{ 11, 12, 13, 14, 15 },
		{ 16, 17, 18, 19, 20 }
	};
	
	/**
	 * Sequence of the matrix in Clockwise order
	 */
	public static final int[] CLOCKWISE_ORDER = {1,2,3,4,5,10,15,20,19,18,17,16,11,6,7,8,9,14,13,12};
	
	/**
	 * Sequence of the matrix in Counter Clockwise order
	 */
	public static final int[] COUNTER_CLOCKWISE_ORDER = {1,6,11,16,17,18,19,20,15,10,5,4,3,2,7,12,13,14,9,8};
	
	// Member Variables
	private SpiralMatrix sm = new SpiralMatrix();

	/**
	 * Test method for {@link com.smt.kata.distance.SpiralMatrix#SpiralMatrix()}.
	 */
	@Test
	void testSpiralMatrix() throws Exception {
		assertNotNull(sm);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.SpiralMatrix#clockwise()}.
	 */
	@Test
	void testClockwiseEmpty() throws Exception {
		assertEquals(0, sm.clockwise(null).size());
		assertEquals(0, sm.clockwise(new int[0][0]).size());
	}

	/**
	 * Test method for {@link com.smt.kata.distance.SpiralMatrix#clockwise()}.
	 */
	@Test
	void testClockwise() throws Exception {
		List<Integer> clockwise = sm.clockwise(MATRIX);
		
		assertEquals(20, clockwise.size());
		for (int i=0; i < clockwise.size(); i++) {
			assertEquals(CLOCKWISE_ORDER[i], clockwise.get(i));
		}
	}
	
	
	/**
	 * Test method for {@link com.smt.kata.distance.SpiralMatrix#clockwise()}.
	 */
	@Test
	void testCounterClockwiseEmpty() throws Exception {
		assertEquals(0, sm.counterClockwise(null).size());
		assertEquals(0, sm.counterClockwise(new int[0][0]).size());
	}

	/**
	 * Test method for {@link com.smt.kata.distance.SpiralMatrix#counterClockwise()}.
	 */
	@Test
	void testCounterClockwise() throws Exception {
		List<Integer> counterClockwise = sm.counterClockwise(MATRIX);
		assertEquals(20, counterClockwise.size());
		for (int i=0; i < counterClockwise.size(); i++) {
			assertEquals(COUNTER_CLOCKWISE_ORDER[i], counterClockwise.get(i));
		}
	}

}
