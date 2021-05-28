package com.smt.kata.math;

/****************************************************************************
 * <b>Title</b>: LookSaySequence.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Look and Say Sequence
 * 
 * In mathematics, the look-and-say sequence is the sequence of integers beginning as follows:
 * 
 * 1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211, ... (sequence A005150 in the OEIS).
 * To generate a member of the sequence from the previous member, read off the digits 
 * of the previous member, counting the number of digits in groups of the same digit. For example:
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 1211 is read off as "one 1, one 2, then two 1s" or 111221.
 * 111221 is read off as "three 1s, two 2s, then one 1" or 312211
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 28, 2021
 * @updates:
 ****************************************************************************/
public class LookSaySequence {

	/**
	 * Translates a number into a look say sequence number
	 * @param number Number to translate
	 * @return A look say sequence representing the passe din number
	 */
	public int translate(int number) {
		// Convert the number to a string.  This allows processing of each character
		String strNums = String.valueOf(Math.abs(number));
		
		// Add a string builder to place the results while building
		StringBuilder res = new StringBuilder();
		
		// Translate the chars to a look and say sequence
		translateCharacters(strNums, res);
		
		// Return the results as a new number
		return Integer.valueOf(res.toString());
	}
	
	/**
	 * Performs the translate sequences
	 * @param strNums Source Number as a string to translate
	 * @param res String builder to store the sequences
	 */
	private void translateCharacters(String strNums, StringBuilder res) {
		int count = 0;
		int prev = -1;
		for (char c : strNums.toCharArray()) {
			int val = Character.digit(c, Character.MAX_RADIX);
			if (val == prev) count++;
			else {
				if (count > 0) res.append(count).append(prev);
				count = 1;
				prev = val;
			}
		}
		
		res.append(count).append(prev);
	}
}
