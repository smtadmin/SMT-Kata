package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: MaxConsecutiveOnes.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Max Consecutive Ones
 * 
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * 
 * Example 1:
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * 
 * Example 2:
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 * 
 * Constraints:
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 25, 2021
 * @updates:
 ****************************************************************************/
public class MaxConsecutiveOnes {

	/**
	 * Finds and counts the longest sequence of 1s int he array
	 * @param values Array to count
	 * @return Count of the largest sequence of ones
	 */
	public int count(int[] values) {
		// Validate the input
		if (values == null || values.length == 0) return 0;
		
		// Add a counter for each sequence and the max count of each sequence
		int count = 0;
		int maxCount = 0;
		
		// Loop the values and count
		for (int val : values) {
			// if its a one, increment the counter.  Otherwise compare to max and 
			// reset the counter
			if (val == 1) count++;
			else {
				if (count > maxCount) maxCount = count;
				count = 0;
			}
		}
		
		// Make sure to check the last value of count in case the last sequence 
		// ends with the last element
		return count > maxCount ? count : maxCount;
	}

}
