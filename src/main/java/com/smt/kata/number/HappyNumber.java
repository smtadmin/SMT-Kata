package com.smt.kata.number;

/****************************************************************************
 * <b>Title:</b> HappyNumber.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Happy Number
 * 
 * A happy number is a number which yields a 1 by repeatedly summing up the square 
 * of its digit. If such a process results in an endless cycle of numbers 
 * containing 4, the number is said to be an unhappy number.  You need to continue 
 * processing the results until a happy or unhappy state is achieved
 * 
 * Create a function that accepts a number and determines whether the number is a 
 * happy number or not. Return true if so, false otherwise.
 *
 * Examples
 * isHappy(67) ➞ false
 * isHappy(89) ➞ false
 * isHappy(139) ➞ true
 * isHappy(1327) ➞ false
 * isHappy(2871) ➞ false
 * isHappy(3970) ➞ true
 * 
 * Notes
 * Hint: Your loop terminates if the value of n is either 1 or 4.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class HappyNumber {

	/**
	 * Determines if the provided number is happy
	 * @param val Number to validate
	 * @return True if the number is happy.  False otherwise
	 */
	public boolean isHappy(int val) {
		if (val == 0) return false;
		
		// Holds the total of the val results
		int total = 0;
		
		// Loop until 4 is hit
		while (total != 4) {
			// Reset the total
			total = 0;
			
			// Loop each digit, square it and add to the total
			for (char c : String.valueOf(val).toCharArray()) {
				total += Math.pow((c - '0'), 2);
			}
			
			// If total is one, it is a happy number
			if (total == 1) return true;
			
			// Assign the total to the new value
			val = total;
		}
		
		// This means 4 was hit (endless loop).  Return false
		return false;
	}
}
