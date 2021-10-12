package com.smt.kata.code;

// JDK 11.x
import java.util.Map;
import java.util.TreeMap;

/****************************************************************************
 * <b>Title</b>: HarmoniousSequence.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Longest Harmonious Sequence Kata
 * 
 * We define a harmonious array as an array where the difference between its 
 * maximum value and its minimum value is exactly 1.
 * 
 * Given an integer array nums, return the length of its longest harmonious 
 * subsequence among all its possible subsequences.
 * 
 * A subsequence of array is a sequence that can be derived from the array by 
 * deleting some or no elements without changing the order of the remaining elements.
 * 
 * Example 1:
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * 
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 2
 * 
 * Example 3:
 * Input: nums = [1,1,1,1]
 * Output: 0
 * 
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 16, 2021
 * @updates:
 ****************************************************************************/
public class HarmoniousSequence {

	/**
	 * Calculates the Longest Harmonious Sequence
	 * @param sequence Numbers to use to calculate
	 * @return total items in the harmonious sequence
	 */
	public int getLongest(int[] sequence) {
		// Validate the data
		if(sequence == null || sequence.length < 2) return 0;
		
		// Add a counter for each item and order in sequential order
		Map<Integer, Integer> counter = new TreeMap<>();
		for (int value : sequence) {
			counter.merge(Integer.valueOf(value), Integer.valueOf(1), Integer::sum);
		}
		
		// Return the longest value
		return calculateLongest(counter);
	}
	
	/**
	 * Loops the elements to find the total of the sequence
	 * @param counter Ordered Map of values in the sequence and the number of times each was used
	 * @return Total of the harmonious sequence
	 */
	private int calculateLongest(Map<Integer, Integer> counter) {
		// Assign the total
		int total = 0;
		
		// Assign previous value and total
		Integer prevValue = Integer.MAX_VALUE;
		int prevTotal = 0;
		
		// Loop the map looking for difference of 1.  Map is in sequential order
		for(Map.Entry<Integer, Integer> item : counter.entrySet()) {
			// get the difference between the prev and current value
			int diff = Math.abs(prevValue - item.getKey());
			
			// If the diff is 1 and the total between this value and the 
			// previous > total variable, update total
			if (diff == 1 && (prevTotal + item.getValue()) > total)
				total = prevTotal + item.getValue();
			
			// Assign the previous value and total
			prevValue = item.getKey();
			prevTotal = item.getValue();
		}
		
		// Return the total
		return total;
	}
}
