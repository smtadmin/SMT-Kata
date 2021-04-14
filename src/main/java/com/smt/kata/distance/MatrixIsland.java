package com.smt.kata.distance;

/****************************************************************************
 * <b>Title:</b> MatrixIsland.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Island Matrix
 * 
 * Given a matrix of 1s and 0s, return the number of "islands" in the matrix. 
 * A 1 represents land and 0 represents water, so an island is a group of 1s that are 
 * neighboring (horizontal or vertical.  Diagonal only does not count) whose 
 * perimeter is surrounded by water.
 * 
 * For example, this matrix has 4 islands.
 * 
 * 1 0 0 0 0
 * 0 0 1 1 0
 * 0 1 1 0 0
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 1 1 0 0 1
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 1, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class MatrixIsland {

	private int[][] matrix;
	
	/**
	 * 
	 */
	public MatrixIsland(int[][] matrix) {
		super();
		this.matrix = matrix;
	}
	
	/**
	 * Finds the number of islands in the matrix
	 * @return Number of islands
	 */
	public int find() {
		int islandCounter = 0;
		
		for (int i=0; i < matrix.length; i++) {
			int[] row = matrix[i];
			
			for (int j = 0; j < row.length; j++) {
				if (j > 0 && j < row.length - 1 && row[j] == 1) {
					System.out.println("Row: " + i + ", Index: " + j);
					if (isIsland(i, j)) islandCounter++;
				}
			}
		}
		
		return islandCounter;
	}
	
	
	public boolean isIsland(int row, int index) {
		
		// Check above
		int above = matrix[row-1][index];
		int below = matrix[row+1][index];
		int left = matrix[row][index - 1];
		int right = matrix[row-1][index + 1];
		
		return above == 0 && below == 0 && left == 0 && right == 0;
	}

}
