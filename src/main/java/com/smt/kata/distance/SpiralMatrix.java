package com.smt.kata.distance;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: SpiralMatrix.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Spiral Matrix
 * 
 * Given a N by M matrix of numbers, print out the matrix in a clockwise and 
 * counter clockwise spiral.
 * 
 * For example, given the following matrix:
 * 
 * [[1,  2,  3,  4,  5],
 *  [6,  7,  8,  9,  10],
 *  [11, 12, 13, 14, 15],
 *  [16, 17, 18, 19, 20]]
 *  
 * You should return a list of all of the items in the matrix in the following order for clockwise:
 * 
 * 1,2,3,4,5,10,15,20,19,18,17,16,11,6,7,8,9,14,13,12
 * 
 * and for counter-clockwise:
 * 
 * 1,6,11,16,17,18,19,20,15,10,5,4,3,2,7,12,13,14,9,8
 * 
 * Remember, that this code must work for a matrix of any size or 
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 15, 2021
 * @updates:
 ****************************************************************************/
public class SpiralMatrix {
	
	// Members
	private int left;
	private int right;
	private int top;
	private int bottom;
	private int rows;
	private int cols;
	
	/**
	 * 
	 */
	public SpiralMatrix() {
		super();
	}
	
	/**
	 * Assign the initial values for top/bottom/left/right abd cols and rows
	 * @param matrix
	 */
	private void assignVars(int[][] matrix) {
		// Assign the rows and columns
	    rows = matrix.length;
	    cols = matrix[0].length;
	    
	    // Assign the sides
	    left = 0;
	    right = cols - 1;
	    top = 0;
	    bottom = rows - 1;
	}

	/**
	 * Loops the matrix in the clockwise direction
	 * @param matrix Matrix to spiral
	 * @return List of the integers in clockwise spiral order
	 */
	public List<Integer> clockwise(int[][] matrix) {
	    List<Integer> result = new ArrayList<>();
	    if (matrix == null || matrix.length == 0) return result;
	 
	    // Assign the initial values for top/bottom/left/right
	    this.assignVars(matrix);
	 
	    // Loop while the number of items in the list is less than the array size
	    while(result.size() < rows * cols){
	    	// Get the top row.
	        for(int j=left; j<=right; j++) result.add(matrix[top][j]);
	        top++;
	        
	        // Get the outside right edge
	        for(int i=top; i<=bottom; i++) result.add(matrix[i][right]);
	        right--;
	 
	        // Get the bottom
	        for(int j=right; j>=left; j--) result.add(matrix[bottom][j]);
	        bottom--;
	        
	        // Get the left edge
	        for(int i=bottom; i>=top; i--) result.add(matrix[i][left]);
	        left++;
	    }
	 
	    return result;
	}
	
	/**
	 * Loops the matrix in the counter-clockwise direction
	 * @param matrix Matrix to spiral
	 * @return List of the integers in counter-clockwise spiral order
	 */
	public List<Integer> counterClockwise(int[][] matrix) {
	    List<Integer> result = new ArrayList<>();
	    if (matrix == null || matrix.length == 0) return result;
	    
	    // Assign the initial values for top/bottom/left/right
	    this.assignVars(matrix);
	 
	    // Loop while the number of items in the list is less than the array size
	    while(result.size() < rows * cols) {
	        // Get the left edge
	        for(int i=top; i <= bottom; i++) result.add(matrix[i][left]);
	        left++;
	       
	        // Get the bottom
	        for(int j=left; j <= right; j++) result.add(matrix[bottom][j]);
	        bottom--;
	        
	        // Get the outside right edge
	        for(int i=bottom; i >= top; i--) result.add(matrix[i][right]);
	        right--;
	        
	    	// Get the top row.
	        for(int j=right; j >= left; j--) result.add(matrix[top][j]);
	        top++;
	    }
	 
	    return result;
	}
}
