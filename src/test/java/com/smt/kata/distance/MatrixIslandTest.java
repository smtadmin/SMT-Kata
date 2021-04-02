package com.smt.kata.distance;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> MatrixIslandTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 1, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class MatrixIslandTest {
	/**
	 * Simple Matrix
	 */
	int[][] matrix = new int[][] {
		 { 0, 0, 0, 0, 0 },
		 { 0, 0, 0, 0, 0 },
		 { 0, 0, 1, 0, 0 },
		 { 0, 0, 0, 0, 0 },
		 { 0, 0, 0, 0, 0 },
		 { 0, 0, 0, 0, 0 }
	};
	
	/**
	 * 4 island matrix, clumped together
	 */
	int[][] matrix1 = new int[][] {
		 { 1, 0, 0, 0, 0 },
		 { 0, 0, 1, 1, 0 },
		 { 0, 1, 1, 0, 0 },
		 { 0, 0, 0, 0, 0 },
		 { 1, 1, 0, 0, 1 },
		 { 1, 1, 0, 0, 1 }
	};

	/**
	 * Test method for {@link com.smt.kata.distance.MatrixIsland#MatrixIsland(int[][])}.
	 */
	@Test
	void testMatrixIsland() throws Exception {
		MatrixIsland mi = new MatrixIsland(matrix);
		assertNotNull(mi);
	}

	/**
	 * Test method for {@link com.smt.kata.distance.MatrixIsland#find()}.
	 */
	@Test
	void testFindSimple() throws Exception {
		MatrixIsland mi = new MatrixIsland(matrix);
		assertEquals(1, mi.find());
	}

}
