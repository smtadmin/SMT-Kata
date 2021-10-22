package com.smt.kata.math;

/****************************************************************************
 * <b>Title</b>: PythagoreamTriplet.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Pythagorean Triplet Kata
 * 
 * Given an array of integers, determine whether it contains a Pythagorean triplet. 
 * Recall that a Pythogorean triplet (a, b, c) is defined by the equation a2 + b2 = c2.
 * 
 * Example:
 * input: [9, 3, 7, 5, 4]
 * result: true (3sq + 4sq = 5sq)
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 22, 2021
 * @updates:
 ****************************************************************************/
public class PythagoreamTriplet {

	/**
	 * Checks to see if any of the triplets in the values array make a 
	 * pythagoream theory equate to true
	 * @param values Array of numbers to evaluate
	 * @return True if 3 values match pythagoreams thereom.  False otherwise
	 */
	public boolean hasMatch(int[] values) {
		if(values == null || values.length < 3) return false;
		
		for (int i = 0; i < values.length; i++) {
			for (int j = (i+1); j < values.length; j++) {
				int k = j;
				while (++k < values.length) {
					if (checkPairs(values[i], values[j], values[k])) return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Checks to see if any of the 3 digits provided can be switched to comply
	 * with pythagoream theory
	 * @param a First value
	 * @param b Second Value
	 * @param c Third value
	 * @return True if it matches.  False otherwise
	 */
	private boolean checkPairs(int a, int b, int c) {
		return ((Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) ||
				(Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2)) ||
				(Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2)));
	}
}
