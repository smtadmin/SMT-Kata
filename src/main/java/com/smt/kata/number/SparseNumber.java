package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: SparseNumber.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Sparse Number Kata
 * 
 * We say a number is sparse if there are no adjacent ones in its binary representation. 
 * For example, 21 (10101) is sparse, but 22 (10110) is not. For a given input N, 
 * find the smallest sparse number greater than or equal to N as well as determine 
 * if the number is sparse.
 * 
 * The "isSparse(int)" method will determine if a number is sparse.  The "findNext(int)"
 * method will return the next sparse number that is greater than or equal to the passed integer.
 * 
 * You may use any class in the Java JDK for this solution
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 17, 2021
 * @updates:
 ****************************************************************************/
public class SparseNumber {
	
	/**
	 * Determines if a number is a sparse number
	 * @param val value to evaluate
	 * @return True if sparse, false otherwise
	 */
	public boolean isSparse(int val) {
		return ! Integer.toBinaryString(Math.abs(val)).contains("11");
	}
	
	/**
	 * Finds the next sparse number that is greater than or equal to the value passed
	 * @param val Value to use as the baseline number
	 * @return Next sparse number
	 */
	public int findNext(int val) {
		val = Math.abs(val);
		while (true) {
			String binVal = Integer.toBinaryString(val);
			if (! binVal.contains("11")) return Integer.parseInt(binVal, 2);
			val++;
		}
	}
}
