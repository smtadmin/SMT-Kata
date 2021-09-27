package com.smt.kata.tree;

/****************************************************************************
 * <b>Title</b>: PascalsTriangle.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Pascals Triangle Kata
 * 
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * 
 * https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif
 * 
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 27, 2021
 * @updates:
 ****************************************************************************/
public class PascalsTriangle {

	/**
	 * Builds a pascal triangle with the provided number of levels
	 * @param levels Number of levels in the triangle
	 * @return Pascal Triangle
	 */
	public int[][] build(int levels) {
		if (levels < 1) return new int[0][];
		
		// Create an empty triangle
		int[][] triangle = new int[levels][];
		
		// Array to hold the previous data
		int[] prev = new int[0];
		
		// Loop the levels and assign the parameters
		for (int i=0; i < levels; i++) {
			// Add a row with the assigned number of cells
			int[] row = new int[i+1];
			
			// Assign the data
			assignParams(row, prev);
			
			// Add the row into the triangle
			triangle[i] = row;
			
			// Reassign the previous row
			prev = row;
		}
		
		return triangle;
	}

	/**
	 * Builds a row on the triangle
	 * @param row Current empty row
	 * @param prev Data form the prev row to use in calculations
	 */
	private void assignParams(int[] row, int[] prev) {
		// Assign the first cell in the row
		row[0] = 1;
		
		// Calculate the inner values
		for (int i=1; i < row.length - 1; i++) {
			row[i] = prev[i-1] + prev[i];
		}
		
		// If the length is more than one, add the ending entry
		if (row.length > 1) row[row.length-1] = 1;
	}
}
