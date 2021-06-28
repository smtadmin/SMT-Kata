package com.smt.kata.distance;

/****************************************************************************
 * <b>Title</b>: RotateMatrix.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Rotate Matrix
 * Given an N by N matrix, rotate it by 90 degrees clockwise. * 
 * For example, given the following matrix:
 * 
 * [[1, 2, 3],
 *  [4, 5, 6],
 *  [7, 8, 9]]
 * 
 * you should return:
 * 
 * [[7, 4, 1],
 *  [8, 5, 2],
 *  [9, 6, 3]]
 * 
 * We should also rotate it counter-clockwise
 * 
 * [[1, 2, 3],
 *  [4, 5, 6],
 *  [7, 8, 9]]
 * 
 * you should return:
 * 
 * [[3, 6, 9],
 *  [2, 5, 8],
 *  [1, 4, 7]]
 * 
 * We can assume the matrix will have the same number of rows and columns for 
 * this kata
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 28, 2021
 * @updates:
 ****************************************************************************/
public class RotateMatrix {

	/**
	 * Rotates a matrix in the clockwise direction
	 * @param matrix Matrix to rotate clockwise
	 * @return Rotated matrix.  Empty matrix of input is null
	 */
	public int[][] rotateClockwise(int[][] matrix) {
		return rotate(matrix, true);
	}
	
	/**
	 * Rotates a matrix in the counter-clockwise direction
	 * @param matrix Matrix to rotate clockwise
	 * @return Rotated matrix.  Empty matrix of input is null
	 */
	public int[][] rotateCounterClockwise(int[][] matrix) {
		return rotate(matrix, false);
	}
	
	/**
	 * Rotates the matrix in either direction
	 * @param matrix Matrix to rotate
	 * @param isClockwise Determines which direction to rotate
	 * @return Rotated matrix.  Empty matrix of input is null
	 */
	private int[][] rotate(int[][] matrix, boolean isClockwise) {
		if (matrix == null || matrix.length == 0) return new int[0][0];
		
		// Initialize a new array and the col/row length
		int length = matrix.length;
		int[][] rotated = new int[length][length];
		
		// Loop the array and turn it clockwise
		for(int i=0; i < length; i++) {
			for(int x=0; x < length; x++) {
				int val = length - 1 - i;
				if (isClockwise) rotated[x][val] = matrix[i][x];
				else rotated[val][x] = matrix[x][i];
			}
		}
		
		return rotated;
	}
}
