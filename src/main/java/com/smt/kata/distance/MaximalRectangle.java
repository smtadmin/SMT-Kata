package com.smt.kata.distance;

// Kata Libs
import com.smt.kata.distance.bean.CoordinateVO;

/****************************************************************************
 * <b>Title</b>: MaximalRectangle.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Maximal Rectangle
 * 
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * https://assets.leetcode.com/uploads/2020/09/14/maximal.jpg
 * 
 * Example 1:
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * 
 * Example 2:
 * Input: matrix = []
 * Output: 0

 * Example 3:
 * Input: matrix = [["0"]]
 * Output: 0
 * 
 * Example 4:
 * Input: matrix = [["1"]]
 * Output: 1
 * 
 * Example 5:
 * Input: matrix = [["0","0"]]
 * Output: 0
 * 
 * Constraints:
 * rows == matrix.length
 * cols == matrix[i].length
 * 0 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 28, 2021
 * @updates:
 ****************************************************************************/
public class MaximalRectangle {

	/**
	 * Calculates the largest rectangle of all ones
	 * @param matrix Matrix to calculate against
	 * @return Count of all of the "1"s in the rectangle
	 */
	public int calculate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
			return 0;
		
		// Loop each cell and if it is a one, calculate the size
		int total = 0;
		for (int x = 0; x < matrix.length; x++) {
			for(int y = 0; y < matrix[0].length; y++) {
				if (matrix[x][y] == 1) {
					// Get the top left and bottom right location
					CoordinateVO start = new CoordinateVO(x,y);
					CoordinateVO end = new CoordinateVO(checkRow(matrix, start), checkColumn(matrix, start));
					
					// Count the number of ones in a rectangle for each cell
					int rectCount = checkRectangle(matrix, start,end);
					
					// Update the count if greater
					if (rectCount > total) total = rectCount;
				}
			}
		}
		
		return total;
	}
	
	/**
	 * Loops through the rectangle and checks to see if they are all "1"s
	 * @param matrix Matrix to search against
	 * @param start Upper left cell location
	 * @param end Bottom Right cell location
	 * @return Count of "1"s if ALL items in the rectangle are "1"s.  0 Otherwise
	 */
	public int checkRectangle(int[][] matrix, CoordinateVO start, CoordinateVO end) {
		int count = 0;
		for (int x = start.getRow(); x <= end.getRow(); x++) {
			for (int y = start.getColumn(); y <= end.getColumn(); y++) {
				if (matrix[x][y] == 0) return 0;
				else count++;
			}
		}
		
		return count;
	}

	/**
	 * Based on the cell location, return the value of the last "1" in that row
	 * @param matrix Matrix to search
	 * @param cell Starting cell
	 * @return Cell Row number of the last "1" in that column
	 */
	private int checkRow(int[][] matrix, CoordinateVO cell) {
		int ctr = cell.getRow();
		for (int i = cell.getRow() + 1; i < matrix.length; i++) {
			if (matrix[i][cell.getColumn()] == 0) return ctr;
			ctr++;
		}
		
		return ctr;
	}
	
	/**
	 * Based on the cell location, return the value of the last "1" in that column
	 * @param matrix Matrix to search
	 * @param cell Starting cell
	 * @return Cell column number of the last "1" in that column
	 */
	private int checkColumn(int[][] matrix, CoordinateVO cell) {
		int ctr = cell.getColumn();
		for (int i = cell.getColumn() + 1; i < matrix[0].length; i++) {
			if (matrix[cell.getRow()][i] == 0) return ctr;
			ctr++;
		}
		
		return ctr;
	}
}
