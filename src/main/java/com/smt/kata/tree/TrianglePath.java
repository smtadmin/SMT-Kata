package com.smt.kata.tree;

/****************************************************************************
 * <b>Title</b>: TrianglePath.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Triangle Path Kata
 * 
 * Triangle
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3715/
 * Given a triangle array, return the minimum path sum from top to bottom.
 * 
 * For each step, you may move to an adjacent number of the row below. More formally, 
 * if you are on index i on the current row, you may move to either index i or 
 * index i + 1 on the next row.
 * 
 * Example 1:
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11.
 * 
 * Example 2:
 * Input: triangle = [[-10]]
 * Output: -10
 * 
 * Constraints:
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 14, 2021
 * @updates:
 ****************************************************************************/
public class TrianglePath {
	/**
	 * Holds the shortest path total
	 */
	private int total;
	
	/**
	 * Sums the entries through the triangle and finds the shortest path
	 * @param triangle Multi-dimensional array to sum against
	 * @return
	 */
	public int sum(int[][] triangle) {
		// Validate the data
		if (triangle == null || triangle.length == 0 || triangle[0] == null || triangle[0].length == 0) 
			return 0;
		
		// Set the total top the max for an int
		total = Integer.MAX_VALUE;
		
		// Call a recursive method to search each layer and find the smallest path
		calculate(triangle, 0, 0, triangle[0][0]);
		
		// Return the calculated total
		return total;
	}
	
	/**
	 * Recursive method to calculate the path with the smallest sum
	 * @param triangle Triangle to recurse
	 * @param row Row in the triangle to process
	 * @param col The column in the triangle to process
	 * @param value Total value of that path  up to that point
	 */
	private void calculate(int[][] triangle, int row, int col, int value) {
		// If the last row has been processed, check to see if it was quicker 
		// than the previous total and return
		if (row >= triangle.length - 1) {
			total = total > value ? value : total;
			return;
		} else if (value >= total) return;
		
		// call i, i+1 on next row and recurse
		calculate(triangle, row+1, col, triangle[row+1][col] + value);
		calculate(triangle, row+1, col+1, triangle[row+1][col+1] + value);
	}
}
