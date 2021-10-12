package com.smt.kata.code;

/****************************************************************************
 * <b>Title</b>: LongestConsecutiveSequence.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * 
 * You may only use primitives and standard Java.  Collections, Arrays.class, etc .. are not permitted
 * There should be NO imports in your class
 * 
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 24, 2021
 * @updates:
 ****************************************************************************/
public class LongestConsecutiveSequence {
	
	/**
	 * Finds the longest sequence of numbers on the array
	 * @param items Items to be calculated against
	 * @return Largest sequence of numbers in the array
	 */
	public int calculate(int[] items) {
		// Validate data.  Return 0 if invalid
		if (items == null || items.length == 0) return 0;
		else if (items.length == 1) return 1;
		
		// sort the items
		this.sort(items);

		// Find the longest
		int longest = 1;
		int curr = 1;
		for (int i = 1; i < items.length; i++) {

			if ((items[i] - items[i-1]) == 1) curr++;
			else {
				if (curr > longest) longest = curr;
				curr = 1;
			}
		}
		
		// If the sequence is still going at the last number, we need to assign it
		if (curr > longest ) longest = curr;
		
		return longest;
	}
	
	/**
	 * Sorts the array in sequential order
	 * @param arr Array to be sorted
	 */
	private void sort(int[] arr) {
		// sorting logic
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int tmp = 0;
				if (arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
}
