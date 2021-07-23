package com.smt.kata.distance;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Kata libs
import com.smt.kata.distance.bean.CoordinateVO;

/****************************************************************************
 * <b>Title</b>: MatrixRangeTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit tets for the Matrix Range Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 22, 2021
 * @updates:
 ****************************************************************************/
class MatrixRangeTest {
	
	// Members
	int[][] matrix;
	MatrixRange mr;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		mr = new MatrixRange();
		matrix = new int[][] {
			{1, 3, 7, 10, 15, 20},
			{2, 6, 9, 14, 22, 25},
	        {3, 8, 10, 15, 25, 30},
	        {10, 11, 12, 23, 30, 35},
	        {20, 25, 30, 35, 40, 45}
		};
	}

	/**
	 * Test method for {@link com.smt.kata.distance.MatrixRange#getNumberElements(int[][], com.smt.kata.distance.bean.CoordinateVO, com.smt.kata.distance.bean.CoordinateVO)}.
	 */
	@Test
	void testGetNumberElementsAllBad() throws Exception {
		assertEquals(0, mr.getNumberElements(null, null, null));
		assertEquals(0, mr.getNumberElements(new int[0][], null, null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MatrixRange#getNumberElements(int[][], com.smt.kata.distance.bean.CoordinateVO, com.smt.kata.distance.bean.CoordinateVO)}.
	 */
	@Test
	void testGetNumberElementsNoStart() throws Exception {
		assertEquals(0, mr.getNumberElements(matrix, null, new CoordinateVO(3, 3)));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MatrixRange#getNumberElements(int[][], com.smt.kata.distance.bean.CoordinateVO, com.smt.kata.distance.bean.CoordinateVO)}.
	 */
	@Test
	void testGetNumberElementsNoEnd() throws Exception {
		assertEquals(0, mr.getNumberElements(matrix, new CoordinateVO(3, 3), null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MatrixRange#getNumberElements(int[][], com.smt.kata.distance.bean.CoordinateVO, com.smt.kata.distance.bean.CoordinateVO)}.
	 */
	@Test
	void testGetNumberElementsNoStartOrEnd() throws Exception {
		assertEquals(0, mr.getNumberElements(matrix, null, null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MatrixRange#getNumberElements(int[][], com.smt.kata.distance.bean.CoordinateVO, com.smt.kata.distance.bean.CoordinateVO)}.
	 */
	@Test
	void testGetNumberElementsOutOfRange() throws Exception {
		assertEquals(0, mr.getNumberElements(matrix, new CoordinateVO(-3, 3), new CoordinateVO(3, 30)));
		assertEquals(0, mr.getNumberElements(matrix, new CoordinateVO(3, -3), new CoordinateVO(30, 3)));
		assertEquals(0, mr.getNumberElements(matrix, new CoordinateVO(3, 30), new CoordinateVO(-3, 3)));
		assertEquals(0, mr.getNumberElements(matrix, new CoordinateVO(30, 3), new CoordinateVO(3, -3)));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MatrixRange#getNumberElements(int[][], com.smt.kata.distance.bean.CoordinateVO, com.smt.kata.distance.bean.CoordinateVO)}.
	 */
	@Test
	void testGetNumberElementsBackwards() throws Exception {
		assertEquals(14, mr.getNumberElements(matrix, new CoordinateVO(3,3), new CoordinateVO(1, 1)));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MatrixRange#getNumberElements(int[][], com.smt.kata.distance.bean.CoordinateVO, com.smt.kata.distance.bean.CoordinateVO)}.
	 */
	@Test
	void testGetNumberElements() throws Exception {
		assertEquals(14, mr.getNumberElements(matrix, new CoordinateVO(1, 1), new CoordinateVO(3, 3)));
	}

	/**
	 * Test method for {@link com.smt.kata.distance.MatrixRange#getNumberElements(int[][], com.smt.kata.distance.bean.CoordinateVO, com.smt.kata.distance.bean.CoordinateVO)}.
	 */
	@Test
	void testGetNumberElementsNone() throws Exception {
		assertEquals(0, mr.getNumberElements(matrix, new CoordinateVO(0, 0), new CoordinateVO(5, 4)));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MatrixRange#getNumberElements(int[][], com.smt.kata.distance.bean.CoordinateVO, com.smt.kata.distance.bean.CoordinateVO)}.
	 */
	@Test
	void testGetNumberElementsMost() throws Exception {
		assertEquals(28, mr.getNumberElements(matrix, new CoordinateVO(3, 2), new CoordinateVO(3, 2)));
	}
}
