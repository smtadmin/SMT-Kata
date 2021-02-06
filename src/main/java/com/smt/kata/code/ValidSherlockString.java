package com.smt.kata.code;

import java.util.Arrays;

/****************************************************************************
 * <b>Title</b>: ValidSherlockString.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Sherlock considers a string to be valid if all characters of the string appear 
 * the same number of times. It is also valid if he can remove just 1 character at 
 * 1 index in the string, and the remaining characters will occur the same number of times. 
 * Given a string str, determine if it is valid. If so, return "YES", otherwise return "NO".
 * 
 * For example, If str = "abc", the string is valid because the frequencies of characters 
 * are all the same. If str = "abcc", the string is also valid, because we can 
 * remove 1 "c" and have one of each character remaining in the string. However, 
 * if str = "abccc", the string is not valid, because removing one character does not 
 * result in the same frequency of characters.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class ValidSherlockString {

	/**
	 * Reverse the number and compare to the original
	 * @param startNumber
	 * @return
	 */
	public boolean isValid(String sequence) {
		// Initialize the array with the first value
		char[][] holder = new char[1][2];
		holder[0] = new char[]{sequence.charAt(0), 1};
		
		// loop from the second value as the first was previously assigned
		for (int i=1; i < sequence.length(); i++) {
			holder = addCounter(holder, sequence.charAt(i));
		}
		
		// validate array
		return validateArray(holder);
	}
	
	/**
	 * Validates the counts of each character
	 * @param holder
	 * @return
	 */
	private boolean validateArray(char[][] holder) {
		int baseCount = 1000;
		int offsetCount = 0;
		for (int i=0; i < holder.length; i++) {
			int total = (int)holder[i][1];
			if (total < baseCount) baseCount = total;
			
		}
		
		for (int i=0; i < holder.length; i++) {
			int total = (int)holder[i][1];
			
			// set the first item as the base and then increment for every deviation
			if (total != baseCount) {
				offsetCount++;
			}

			// If there are more than 1 with an offset or a difference of more than 1, return false
			if (offsetCount > 1 || Math.abs(baseCount - total) > 1) return false;
			
		}
		
		return true;
	}
	
	/**
	 * Manages the counts and array copying of the elements
	 * @param holder
	 * @param c
	 * @return
	 */
	private static char[][] addCounter(char[][] holder, char c) {
		
		for (int i=0; i < holder.length; i++) {
			if (holder[i][0] == c) {
				holder[i][1] ++;
				return holder;
			}
		}
		
		char[][] newHolder = Arrays.copyOf(holder, holder.length + 1);
		newHolder[holder.length] = new char[]{c, 1};

		return newHolder;
	}
}
