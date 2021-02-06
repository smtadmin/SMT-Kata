package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: TripleUp.java 
 * <b>Project</b>: SMT-Kata 
 * <b>Description: </b> Return true if the array contains, somewhere, three 
 * increasing adjacent numbers like .... 4, 5, 6, ... or 23, 24, 25.
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class TripleUp {

	/**
	 * Loops through the array and counts how many are in sequence in a row
	 * @param nums
	 * @return
	 */
	public boolean tripleUp(int[] nums) {
		if (nums == null || nums.length < 3) return false;

		int prev = 0;
		int numSeq = 0;

		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && (nums[i] - prev) == 1) {
				numSeq++;
				if (numSeq == 2) return true;
			} else numSeq = 0;

			prev = nums[i];
		}

		return false;
	}

}
