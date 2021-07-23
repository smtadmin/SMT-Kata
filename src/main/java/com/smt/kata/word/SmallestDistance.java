package com.smt.kata.word;

// Apache Commons 3.x
import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: SmallestDistance.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Smallest Distance Kata
 * Find an efficient algorithm to find the smallest distance (measured in number 
 * of words) between any two given words in a string.
 * 
 * For example, given words "hello", and "world" and a text content of 
 * "dog cat hello cat dog dog hello cat world", return 1 because there's only one 
 * word "cat" in between the two words.  As in the example above, if the first
 * word is restarted, the counter resets.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 18, 2021
 * @updates:
 ****************************************************************************/
public class SmallestDistance {

	/**
	 * Calculates the number of words between the start and end word in the phrase
	 * The case of the phrase and words is irrelevant to the calculation
	 * @param phrase Phrase to be calculated
	 * @param startWord The start word in the sequence of calculation
	 * @param endWord The end word in the sequence
	 * @return Number of words between the start and end.  0 if none found
	 */
	public int calculate(String phrase, String startWord, String endWord) {
		// Split the phrase by spaces
		String[] words = StringUtils.defaultString(phrase).toLowerCase().split(" ");
		int total = 0;
		boolean hasStarted = false;
		
		// Lop each word and count after the first word is found
		for (String word : words) {
			if(word.equalsIgnoreCase(startWord)) {
				total = 0;
				hasStarted = true;
			} 
			else if (hasStarted && word.equalsIgnoreCase(endWord)) return total;
			else if (hasStarted) total++;
		}
		
		return 0;
	}

}
