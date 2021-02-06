package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: MissingNumber.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Disarium Number A number is said to be Disarium if the 
 * sum of its digits raised to their respective positions is the number itself. 
 * Create a class that determines whether a number is a Disarium or not.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class DisariumNumber {

	/**
	 * Uses the sum of values to determine which number is missing
	 * @param numbers
	 * @return
	 */
	public boolean isDisarium(int number) {
		String s = number  + "";
		
		double total = 0.0;
		for (int i=0; i < s.length(); i++) {
			int val = Integer.parseInt(s.charAt(i) + "");
			total += Math.pow(val, (double)(i+1));
		}
		
		return number == ((int)total);
	}

}
