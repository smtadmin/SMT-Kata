package com.smt.kata.distance;

// JDK 11.x
import java.util.Arrays;

/****************************************************************************
 * <b>Title</b>: MinimumMovesEqual.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Minimum Moves to Equal Array Elements
 * 
 * Given an integer array nums of size n, return the minimum number of moves 
 * required to make all array elements equal.
 * 
 * In one move, you can increment or decrement an element of the array by 1.
 * Test cases are designed so that the answer will fit in a 32-bit integer.
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: 2
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 
 * Example 2:
 * Input: nums = [1,10,2,9]
 * Output: 16
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 30, 2021
 * @updates:
 ****************************************************************************/
public class MinimumMovesEqual {

	/**
	 * Calculates the number of moves to make each item in the array the equal
	 * @param elements Array to make equal
	 * @return Number of moves to make equal
	 */
	public int calculate(int[] elements) {
		// Validate the incoming data.  Return 0 if invalid
		if (elements == null || elements.length < 2) return 0;

		// Calculate the median for the numbers in the array
		int avg = median(elements);
		
		// Calculate the moves by finding the difference for each item in the 
		// array to the average
		int moves = 0;
		for (int ele : elements) moves += Math.abs(avg - ele);
		
		return moves;
	}
	
	/**
	 * Calculate the median value for the provided int[]
	 * @param scores Array of numeric values to calculate against
	 * @return Median value of the array values
	 */
	private int median(int[] scores) {
		// Sort the scores
	      Arrays.sort(scores);
	 
	      // Calculate median (middle number)
	      double median = 0;
	      double pos1 = Math.floor((scores.length - 1.0) / 2.0);
	      double pos2 = Math.ceil((scores.length - 1.0) / 2.0);
	      if (pos1 == pos2 ) median = scores[(int)pos1];
	      else median = (scores[(int)pos1] + scores[(int)pos2]) / 2.0 ;
	      
	      // Convert to int and return
	      return (int) Math.ceil(median);
	}
}
