package com.smt.kata.data;

// JDK 11.x
import java.util.HashSet;
import java.util.Set;

/****************************************************************************
 * <b>Title</b>: ZeroMatrix.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Zero Matrix
 * 
 * Given an m x n integer matrix, if an element is 0, set its entire row 
 * and column to 0's, and return the matrix.
 * 
 * You must do it in place.
 * 
 * Example 1:
 * https://assets.leetcode.com/uploads/2020/08/17/mat1.jpg
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * 
 * Example 2:
 * https://assets.leetcode.com/uploads/2020/08/17/mat2.jpg
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *  
 * Constraints:
 * m == matrix.length
 * n == matrix[0].length
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 18, 2021
 * @updates:
 ****************************************************************************/
public class ZeroMatrix {

	/**
	 * Assigns the columns and rows to all zeros when a cell is 0
	 * @param matrix Matrix to assign
	 * @return Matrix with the rows and columns updated
	 */
	public int[][] assign(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null) 
			return new int[0][0];
		
		// Collections to hold rows and columns to be set to 0
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();
		
		// Loop the matrix and look for 0.  Add to rows and cols collections
		for (int i=0; i < matrix.length; i++) {
			for (int j=0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		// Assign zeros to the appropriate rows/columns
		this.setRowZero(matrix, rows);
		this.setColZero(matrix, cols);
		
		// Return the updated matrix
		return matrix;
	}

	/**
	 * Assigns all of the rows to 0 that are in the set
	 * @param matrix matrix to assign
	 * @param rows Rows that have a 0
	 */
	private void setRowZero(int[][] matrix, Set<Integer> rows) {
		for(Integer row : rows) {
			for (int i = 0; i < matrix[row].length; i++) {
				matrix[row][i] = 0;
			}
		}
	}
	
	/**
	 * Assigns all of the rows to 0 that are in the set
	 * @param matrix matrix to assign
	 * @param rows Rows that have a 0
	 */
	private void setColZero(int[][] matrix, Set<Integer> cols) {
		for(int i = 0; i < matrix.length; i++ ) {
			for (int col : cols) {
				matrix[i][col] = 0;
			}
		}
	}
}
