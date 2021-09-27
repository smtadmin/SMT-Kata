package com.smt.kata.data;

// JDK 11.x
import java.util.HashSet;
import java.util.Set;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: DuplicateRemover.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Duplicate Remover
 * 
 * Remove All Adjacent Duplicates in String
 * 
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 * 
 * Example 1:
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * 
 * Example 2:
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation: 
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * 
 * Example 3:
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105
 * 2 <= k <= 104
 * s only contains lower case English letters.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 7, 2021
 * @updates:
 ****************************************************************************/
public class DuplicateRemover {

	/**
	 * Removes all of the duplicates with a sequential set of characters matching 
	 * the number of dups
	 * @param source Source string to process
	 * @param numDups Number of sequential duplicate characters
	 * @return Processed String.
	 */
	public String process(String source, int numDups) {
		// Validate the data
		if (StringUtil.isEmpty(source) || source.length() < numDups || numDups < 2) 
			return source;
		
		//Set to lower case
		source = source.toLowerCase();
		
		// Get a unique list of characters
		Set<Character> letters = new HashSet<>();
		for (char c : source.toCharArray()) {
			letters.add(Character.valueOf(c));
		}
		
		// Return the new source
		return removeDups(source, letters, numDups);
	}

	/**
	 * Iteratively removes the number of duplicates
	 * @param source Source to remove duplicates
	 * @param letters Unique list of letters in the source
	 * @param numDups Number of sequential duplicates
	 * @return Processed String.
	 */
	private String removeDups(String source, Set<Character> letters, int numDups) {
		// Loop and remove matches
		String origSource = "";
		String newSource = "";
		while (true) {
			// Assign the original tot he new source.  After each loop this assignment
			// Provides a baseline to compare before and after. 
			origSource = newSource;
			
			// Loop each letter in the source and pad the number of letters.  
			// Replace all occurrences
			for (Character letter : letters) {
				// Take the letter and pad that letter to the number of duplicates value
				String rep = StringUtil.padRight(letter + "", letter, numDups);
				
				// Replace those characters
				newSource = source.replaceAll(rep, "");
				
				// Reset the source
				source = newSource;
			}
			
			// If no changes were made in the loop, break out
			if (newSource.equals(origSource)) break;
		}
		
		return newSource;
	}

}
