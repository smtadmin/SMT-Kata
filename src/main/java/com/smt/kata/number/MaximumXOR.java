package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: MaximumXOR.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Maximum XOR Kata
 * 
 * Given an array of integers, find the maximum XOR of any two elements.
 * 
 * Example:
 * Input: 1,2,3,4,5
 * Ouput: 7
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 14, 2021
 * @updates:
 ****************************************************************************/
public class MaximumXOR {

	/**
	 * Calculates the XOR against all of any 2 elements in the array
	 * @param numbers Numbers to calculate.
	 * @return Largest XOR value.  0 if invalid data (empty array, null, 
	 * array < 2 elements ...)
	 */
	public int calculate(int[] numbers) {
		// Validate the data
		int  maxTotal = 0;
		if (numbers == null || numbers.length < 2) return maxTotal;
		
		// Loop each number in the array
		for (int i = 0; i < numbers.length; i++) {
			
			// Loop each subsequent number to get all combinations
			for (int j = i+1; j < numbers.length; j++) {
				// Get the first and last number and XOR them
				int first = numbers[i];
				int last = numbers[j];
				int xor = first ^ last;
				
				// If the number is larger than the current max, update it
				if (xor > maxTotal) maxTotal = xor;
			}
		}
		
		// Return the highest XOR value
		return maxTotal;
	}

}
