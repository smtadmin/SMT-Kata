package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: CountingNumbers.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Counting Numbers Kata
 * 
 * You are given an integer array nums and you have to return a new counts array. 
 * The counts array has the property where counts[i] is the number of smaller 
 * elements to the right of nums[i].  When you get to the last element, jump 
 * back to the 0 element to calculate
 * 
 * Example 1:
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 (starting with the zero location) there is 0 smaller elements.
 * 
 * Example 2:
 * Input: nums = [-1]
 * Output: [0]
 * 
 * Example 3:
 * Input: nums = [-1,-1]
 * Output: [0,0]
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 26, 2021
 * @updates:
 ****************************************************************************/
public class CountingNumbers {

	/**
	 * Calculates the number of smaller elements for each location in the array
	 * @param source Source array to calculate against
	 * @return Number of smaller elements for each item in the source array
	 */
	public int[] calculate(int[] source) {
		// Validate the data
		if (source == null) return new int[0];
		else if (source.length == 1) return new int[] {0};
		
		// Create an empty array with the same length as the source
		int[] holder = new int[source.length];
		
		// Loop the source and assign the counts
		for(int i=0; i < source.length; i++) {
			
			// Identify the starting index, which is i + 1, unless it's the last 
			// element, then it is 0
			int start = (i >= (source.length - 1)) ? 0 : i + 1;
			holder[i] = findSmallest(source, start, source[i]);
		}
		
		return holder;
	}
	
	/**
	 * Finds the number of smaller elements
	 * @param source Source array to use
	 * @param start Starting index for calculation
	 * @param val Value of the item to be compared
	 * @return Number of smaller elements
	 */
	private int findSmallest(int[] source, int start, int val) {
		int total = 0;
		for (int i=start; i < source.length; i++) {
			
			if (source[i] < val) total ++;
		}
		
		return total;
	}
}
