package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: AscendingNumbers.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Ascending Consecutive Numbers
 * Write a method that returns true if a string consists of ascending or ascending 
 * AND consecutive numbers.
 * 
 * Examples
 * ascending("232425") ➞ true
 * // Consecutive numbers 23, 24, 25
 * 
 * ascending("2324256") ➞ false
 * No matter how this string is divided, the numbers are not consecutive.
 * 
 * ascending("444445") ➞ true
 * Consecutive numbers 444 and 445.
 * Notes:
 * A number can consist of any number of digits, so long as the numbers are adjacent 
 * to each other,and the string has at least two of them.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 12, 2021
 * @updates:
 ****************************************************************************/
public class AscendingNumbers {

	/**
	 * 
	 */
	public AscendingNumbers() {
		super();
	}

	/**
	 * Determines if the provided value has sequential numbers
	 * @param sequence
	 * @return
	 */
	public boolean isAscending(String sequence) {
		
		for (int i = 1; i < sequence.length(); i++) {
			if ((sequence.length() % i) > 0) continue;

			boolean valid = true;
			int prev = -1;
			int start = 0;
			for (int x = 0; x < (sequence.length() / i); x++) {
				start = (x == 0) ? 0 : (start + i);
				int val = Integer.parseInt(sequence.substring(start, start + i));

				if (x > 0 && val != (prev + 1)) {
					valid = false;
					break;
				}
				
				prev = val;
			}
			
			if (valid) return true;
		}
		
		return false;
	}
}
