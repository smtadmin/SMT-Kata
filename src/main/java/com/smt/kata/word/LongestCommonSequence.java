package com.smt.kata.word;

/****************************************************************************
 * <b>Title</b>: LongestCommonSequence.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Given two strings, write a method that finds the longest 
 * common sub-sequence.  No COLLECTIONS or other libraries are needed
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class LongestCommonSequence {

	/**
	 * Finds the sequence
	 * @param s1 First String to compare
	 * @param s2 Second String to compare
	 * @return
	 */
	public String find(String s1, String s2) {
		String result = "";
		for (int length = s1.length(); length > 0; length--) {
			int startIndex = 0;
			while (startIndex + length <= s1.length()) {
				String current = s1.substring(startIndex, startIndex + length);
				if (s2.contains(current)) {
					result = current;
					break;
				}
				startIndex++;
			}
			if (result.length() != 0) {
				break;
			}
		}
		
		return result;
	}

}
