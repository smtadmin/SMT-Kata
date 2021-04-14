package com.smt.kata.distance;

// Junit 5
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.List;

/****************************************************************************
 * <b>Title:</b> SaddlePointsTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit Test for the Saddle Points Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 18, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class SaddlePointsTest {
	
	/**
	 * Three by Three Matrix to validate
	 */
	private static int[][] threeByThreeMatrix;
	
	/**
	 * Four by Four Matrix to validate
	 */
	private static int[][] threeByFourMatrix;
	
	/**
	 * Class under test
	 */
	private SaddlePoints points;
	
	@BeforeAll
	static void init() {
		threeByThreeMatrix = new int[][] {
			{ 9, 8, 7 },
			{ 5, 3, 2 },
			{ 6, 6, 7 }
		};
		
		threeByFourMatrix = new int[][] {
			{ 5, 2, 2, 5 },
			{ 6, 6, 7, 8 },
			{ 7, 1, 4, 6 }
		};
	}

	/**
	 * Test method for {@link com.smt.kata.distance.SaddlePoints#SaddlePoints(int[][])}.
	 */
	@Test
	void testSaddlePointsThreeByThree() throws Exception {
		points = new SaddlePoints(threeByThreeMatrix);
		assertNotNull(points);
		
		List<int[]> data = points.getCoordinates();
		assertEquals(1, data.size());
		assertEquals(0, data.get(0)[0]);
		assertEquals(1, data.get(0)[1]);
		assertEquals(5, data.get(0)[2]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.SaddlePoints#SaddlePoints(int[][])}.
	 */
	@Test
	void testSaddlePointsFourByFour() throws Exception {
		points = new SaddlePoints(threeByFourMatrix);
		assertNotNull(points);
		List<int[]> data = points.getCoordinates();
		assertEquals(2, data.size());
		
		// First saddle point
		assertEquals(0, data.get(0)[0]);
		assertEquals(0, data.get(0)[1]);
		assertEquals(5, data.get(0)[2]);
		
		// Last saddle point
		assertEquals(3, data.get(1)[0]);
		assertEquals(0, data.get(1)[1]);
		assertEquals(5, data.get(1)[2]);
	}
}
