 package com.smt.kata.distance;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title:</b> SaddlePoints.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Saddle Points
 * Detect saddle points in a matrix.
 * 
 * So say you have a matrix:
 * 
 *     1  2  3
 *   |---------
 * 1 | 9  8  7
 * 2 | 5  3  2     <--- saddle point at column 1, row 2, with value 5
 * 3 | 6  6  7
 * 
 * It has a saddle point at column 1, row 2.
 * 
 * It's called a "saddle point" because it is greater than or equal to every element 
 * in its row and less than or equal to every element in its column.
 * 
 * A matrix may have zero or more saddle points.
 * 
 * Your code should be able to provide the (possibly empty) list of all the saddle 
 * points for any given matrix.
 * 
 * The matrix can have a different number of rows and columns (Non square).
 * 
 * Note that you may find other definitions of matrix saddle points online, but the 
 * tests for this exercise follow the above unambiguous definition.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 18, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class SaddlePoints {
	
	/**
	 * Matrix to process
	 */
	private int[][] matrix;
	
	/**
	 * Map of the points
	 */
	private List<int[]> coords;

	/**
	 * Assigns the matrix and initializes the class
	 * @param matrix multi-dimensional array to search for saddle points
	 */
	public SaddlePoints(int[][] matrix) {
		this.coords = new ArrayList<>();
		this.matrix = matrix;
		this.mapPoints();
	}
	
	/**
	 * Maps all of the saddle points in the given matrix
	 */
	private void mapPoints() {
		List<int[]> points = new ArrayList<>();
		assignRowPoints(points);
		checkColumnPoints(points);
	}
	
	/**
	 * Loops the largest point in each row and determines if it is the smallest 
	 * in the column
	 * @param points Largest point coordinates from the row processing
	 */
	public void checkColumnPoints(List<int[]> points) {
		for (int[] point : points) {
			// Get the column data
			int[] col = getColumn(point[0]);
			
			// Get the smallest and if it matches the coord point, add to saddle point
			int smallest = findSmallest(col);
			if(smallest == matrix[point[1]][point[0]]) {
				coords.add(new int[] {point[0], point[1], matrix[point[1]][point[0]]});
			}
		}
	}
	
	/**
	 * Gets a column of data from the matrix
	 * @param idx Column to retrieve
	 * @return Array of values in that column
	 */
	public int[] getColumn(int idx) {
		int[] col = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			col[i] = matrix[i][idx];
			
		}
		
		return col;
	}
	
	/**
	 * Loops the rows and finds the largest elements
	 * @param points Holds the coords from the row check
	 */
	private void assignRowPoints(List<int[]> points) {
		// Get each row from the matrix
		for (int i = 0; i < matrix.length; i++) {
			int[] row = matrix[i];
			
			// find the largest entry(s) and add to the map
			int largest = findLargest(row);
			for (int x = 0; x < row.length; x++) {
				int item = row[x];
				if (item == largest) points.add(new int[] {x, i});
			}
		}
	}
	
	/**
	 * Finds the largest element in the array.
	 * @param data
	 * @return largest value
	 */
	private int findLargest(int[] data) {
		int max = 0;
		
		for (int item : data) {
			if (item > max) max = item;
		}

		return max;
	}
	
	/**
	 * Finds the largest element in the array.
	 * @param data
	 * @return largest value
	 */
	private int findSmallest(int[] data) {
		int min = 10;
		
		for (int item : data) {
			if (item < min) min = item;
		}

		return min;
	}
	
	/**
	 * Gets the saddle points
	 * @return Map of column number/row number / value for all saddle points
	 */
	public List<int[]> getCoordinates() {
		return coords;
	}

}
