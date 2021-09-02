package com.smt.kata.distance;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

// Kata Libs
import com.smt.kata.distance.bean.CoordinateVO;
import com.smt.kata.distance.bean.Rectangle;

/****************************************************************************
 * <b>Title</b>: RangeSumQuery.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Range Sum Query Kata
 * 
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 * 
 * Calculate the sum of the elements of matrix inside the rectangle defined by 
 * its upper left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Implement the NumMatrix class:
 * 
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the 
 * elements of matrix inside the rectangle defined by its upper 
 * left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Allow multiple rectangles to be used inside the matrix.  If the rectangles overlap, 
 * those coordinates may be utilized only once when summing the values
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 31, 2021
 * @updates:
 ****************************************************************************/
public class RangeSumQuery {

	// Members
	private int[][] matrix;
	private boolean isDataValid = true;
	
	/**
	 * Initializes the class with a matrix to use to calculate against
	 * @param matrix Matrix to use for calculating sums
	 */
	public RangeSumQuery(int[][] matrix) {
		super();
		this.matrix = matrix;
		
		// validate the matrix data.,  If invalid, set a flag
		if (matrix == null || matrix.length < 3 || matrix[0] == null || matrix[0].length < 3)
			isDataValid = false;
	}
	
	/**
	 * Sums the values from the provided matrix that are inside the rectangle
	 * @param areas Rectangles to sum the areas
	 * @return Sum of all cells inside the rectangles
	 */
	public int sumRange(List<Rectangle> areas) {
		// Make sure the matrix data is valid
		if (! isDataValid) return 0;
		
		// Assign the totals and a collection of cells used
		int total = 0;
		List<CoordinateVO> mapped = new ArrayList<>();
		
		// Loop each rectangle
		for (Rectangle area : areas) {
			// Loop the matrix to get every cell
			for (int row = 0; row < matrix.length; row++) {
				for(int col = 0; col < matrix[0].length; col++) {
					// Create a coordinate from the cell location
					CoordinateVO coord = new CoordinateVO(row, col);
					
					// Make sure the cell wasn't used previously and that it 
					// resides in the rectangle
					if (!mapped.contains(coord) && area.contains(coord)) {
						// Update the totals and add the coordinate to mapped 
						// collection so it won't be used again
						total += matrix[row][col];
						mapped.add(coord);
					}
				}
			}
		}
		
		return total;
	}

}
