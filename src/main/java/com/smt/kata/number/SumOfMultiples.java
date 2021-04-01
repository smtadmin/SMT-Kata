package com.smt.kata.number;

// JDK 11.x
import java.util.HashSet;
import java.util.Set;

/****************************************************************************
 * <b>Title:</b> SumOfMultiples.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Sum of Multiples
 * Given a number, find the sum of all the unique multiples of particular numbers 
 * up to but not including that number.
 * 
 * If we list all the natural numbers below 20 that are multiples of 3 or 5, 
 * we get 3, 5, 6, 9, 10, 12, 15, and 18.
 * 
 * The sum of these multiples is 78.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 31, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class SumOfMultiples {
	// Members
	private Set<Integer> factorList = new HashSet<>();
	
	/**
	 * Default Constructor
	 */
	public SumOfMultiples() {
		super();
	}

	/**
	 * Calculates the sum of the multiples of the given max value.  The factors 
	 * are 1 to n values
	 * @param maxValue Maximum value to calculate the multiples. Multiples must
	 * be LESS than the max Value
	 * @param factors Factors used to calculate the multiples
	 * @return Sum of th multiples
	 */
	public int calculate(int maxValue, Integer...factors) {
		int total = 0;
		if (factors == null || factors.length == 0 || maxValue < 5) return total;
		
		for (Integer factor : factors) getFactors(maxValue, factor);
		for (Integer factor : factorList) total += factor;
		
		return total;
	}
	
	/**
	 * Loops an grabs the multiples for each value
	 * @param maxValue Maximum value for the Multiples.  Multiples must be LESS
	 * than the max value
	 * @param factor Factor to get the multiples
	 */
	private void getFactors(int maxValue, Integer factor) {
		for (int i = factor; i < maxValue; i = i + factor) {
			factorList.add(i);
		}
	}
	
}
