package com.smt.kata.number;

/****************************************************************************
 * <b>Title:</b> HarshadNumber.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Harshad Number
 * 
 * A number is said to be Harshad if it's exactly divisible by the sum of its digits. 
 * Create a function that determines whether a number is a Harshad or not.
 * 
 * Examples:
 * 
 * isHarshad(75) ➞ false
 * // 7 + 5 = 12
 * // 75 is not exactly divisible by 12
 * 
 * isHarshad(171) ➞ true
 * // 1 + 7 + 1 = 9
 * // 9 exactly divides 171
 * 
 * isHarshad(481) ➞ true
 * isHarshad(89) ➞ false
 * isHarshad(516) ➞ true
 * isHarshad(200) ➞ true
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
public class HarshadNumber {

	/**
	 * Determines if a number is a harshad number
	 * @param value
	 * @return
	 */
	public boolean isHarshad(int value) {
		if (value == 0) return false;
		value = Math.abs(value);
		
		// Convert the number to a string so it can be looped
		int total = 0;
		String digits = String.valueOf(value);
		
		// Loop each char, convert to a number and increment total
		for (char c : digits.toCharArray()) {
			total += c - '0';
		}
		
		// Return false if total is 0.  Otherwise make sure modulus is 0
		if (total == 0) return false;
		else return value % total == 0 ;
	}

}
