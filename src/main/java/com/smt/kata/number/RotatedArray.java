package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: RotatedArray.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Rotated Array Kata
 * 
 * Search for the index of an element inside an array.  
 * However, the array will be pivoted at the provided pivot value such that the
 * array will be reorder from that pivot. For example:
 * 
 * Example 1
 * method: array, target value, pivot
 * input: [6,5,4,3,2,1,0], 3, 2
 * New array order: [3,2,1,0,6,5,4]
 * output 0 (target of 3 is in the 0 array location)
 * 
 * Example 1, Pivot is auto calculated by getting the number of elements, halved and
 * then subtract one for the 0 location.  So the pivot would be ((8/2) -1) = 3
 * method: array, target value
 * input: [6,5,4,3,2,1,0,8], 3
 * New array order: [2,1,0,8,6,5,4,3]
 * output 7 (target of 3 is in the 7 array location)
 * 
 * Note:
 * if the target number is not in the array, return -1
 * 
 * **** No imports of any kind are allowed for this kata.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 2, 2021
 * @updates:
 ****************************************************************************/
public class RotatedArray {

	/**
	 * Searches for the target across the items in the nums array with the offset
	 * applied after pivoting the array.  The pivot is calculated by finding the 
	 * middle index in the array after accounting for the 0 offset int he array
	 * @param nums Array to target and pivot
	 * @param target Element in the array to find it's index
	 * @return Index of the target after pivoting.  -1 if target not located
	 */
	public int search(int[] nums, int target) {
		// Calculate the pivot as the middle of the array
		int pivot = (nums.length / 2) - 1;
		return search(nums, target, pivot);
	}
	
	/**
	 * Searches for the target across the items in the nums array with the offset
	 * applied after pivoting the array
	 * @param nums Array to target and pivot
	 * @param target Element in the array to find it's index
	 * @param pivot Array location to pivot the array
	 * @return Index of the target after pivoting.  -1 if target not located
	 */
	public int search(int[] nums, int target, int pivot) {
		
		// Loop the nums to locate the target
		for (int i=0; i < nums.length; i++) {
			
			// When the target is found, calculate the new index based upon the pivot
			if (target == nums[i]) {
				if (i < pivot) return (nums.length - 1 - pivot) + i;
				else return (i - pivot - 1);
			}
		}
		
		// If target is not found, return -1
		return -1;
	}
}
