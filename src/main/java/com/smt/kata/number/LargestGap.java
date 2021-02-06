package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: LargestGap.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Given an array of integers, return the largest gap between 
 * the sorted elements of the array.  For example, consider the array: 
 * [9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5] 
 * After sorting, the array becomes: [0, 0, 4, 5, 5, 6, 9, 20, 25, 26, 26] 
 * We now see that the largest gap in the array is between 9 and 20 which is 11.  
 * You must sort the arrays manually!  
 * You may not use Arrays.sort!
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class LargestGap {
	/**
	 * Sorts the array in sequential order
	 * @param arr
	 */
	void sort(int[] arr) {
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
	
	/**
	 * Calls out to get the array sorted and then finds the largest gap
	 * @param arr
	 * @return
	 */
	public int largestGap(int[] arr) {
		sort(arr);
		int largestGap = 0;
		for (int i=1; i < arr.length; i++) {
			int gap = arr[i] - arr[i-1];
			if (gap > largestGap) largestGap = gap;
		}
			
		return largestGap;
	}

}
