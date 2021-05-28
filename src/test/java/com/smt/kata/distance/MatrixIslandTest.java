package com.smt.kata.distance;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> MatrixIslandTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit Tests for the Matrix Island Kata
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
	int[][] noIslands = new int[][] {
		 { 0, 0, 0, 0, 0 },
		 { 0, 0, 0, 0, 0 },
		 { 0, 0, 0, 0, 0 },
		 { 0, 0, 0, 0, 0 },
		 { 0, 0, 0, 0, 0 },
		 { 0, 0, 0, 0, 0 }
	};
	
	/**
	 * Simple Matrix one island
	 */
	int[][] oneIslandSmall = new int[][] {
		 { 0, 0, 0, 0, 0 },
		 { 0, 0, 0, 0, 0 },
		 { 0, 0, 1, 0, 0 },
		 { 0, 0, 0, 0, 0 },
		 { 0, 0, 0, 0, 0 },
		 { 0, 0, 0, 0, 0 }
	};
	
	/**
	 * Simple Matrix one big island
	 */
	int[][] oneBigIslandSmall = new int[][] {
		 { 1, 1, 1, 1, 1 },
		 { 1, 1, 1, 1, 1 },
		 { 1, 1, 1, 1, 1 },
		 { 1, 1, 1, 1, 1 },
		 { 1, 1, 1, 1, 1 },
		 { 1, 1, 1, 1, 1 }
	};
	
	/**
	 * 4 island matrix, clumped together
	 */
	int[][] fourIslands = new int[][] {
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
		
		assertThrows(NullPointerException.class, () -> {
			new MatrixIsland(null);
		});
		
		assertThrows(NullPointerException.class, () -> {
			new MatrixIsland(new int[0][]);
		});
	}

	/**
	 * Test method for {@link com.smt.kata.distance.MatrixIsland#find()}.
	 */
	@Test
	void testFindNone() throws Exception {
		MatrixIsland mi = new MatrixIsland(noIslands);
		assertFalse(mi.hasIslands());
		assertEquals(0, mi.getNumberIslands());
		assertEquals(0, mi.getNodesInLargestIsland());
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MatrixIsland#find()}.
	 */
	@Test
	void testFindOneIslands() throws Exception {
		MatrixIsland mi = new MatrixIsland(oneIslandSmall);
		assertTrue(mi.hasIslands());
		assertEquals(1, mi.getNumberIslands());
		assertEquals(1, mi.getNodesInLargestIsland());
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.MatrixIsland#find()}.
	 */
	@Test
	void testFindOneBigIsland() throws Exception {
		MatrixIsland mi = new MatrixIsland(oneBigIslandSmall);
		assertTrue(mi.hasIslands());
		assertEquals(1, mi.getNumberIslands());
		assertEquals(30, mi.getNodesInLargestIsland());
	}

	/**
	 * Test method for {@link com.smt.kata.distance.MatrixIsland#find()}.
	 */
	@Test
	void testFindFourIslands() throws Exception {
		MatrixIsland mi = new MatrixIsland(fourIslands);
		assertTrue(mi.hasIslands());
		assertEquals(4, mi.getNumberIslands());
		assertEquals(4, mi.getNodesInLargestIsland());
	}
	
}
