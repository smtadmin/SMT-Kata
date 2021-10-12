package com.smt.kata.word;

// JDK 11.x
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/****************************************************************************
 * <b>Title</b>: RearrangeWords.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Rearrange Words Kata
 * 
 * Given a string with repeated characters, rearrange the string so that no two 
 * adjacent characters are the same. If this is not possible, return None.  Return a 
 * collection of all of the possible variations that can occur with no two
 * characters repeated
 * 
 * If the word passed in already has no repeating characters, return just that word
 * 
 * For example, given "aaabbc", you could return :
 * ababac, ababca, abacab, abacba, abcaba, acabab, acbaba, babaca, bacaba, cababa 
 * 
 * Given "aaab", return an empty collection.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 30, 2021
 * @updates:
 ****************************************************************************/
public class RearrangeWords {

	/**
	 * Rearranges the characters in a word such that there are no 2 adjacent characters
	 * @param word Word to rearrange
	 * @return All the possible ways the word can be rearranged to not have sequential characters
	 */
	public Collection<String> arrange(String word) {
		Set<String> items = new TreeSet<>();
		if (word == null || word.length() < 2 || ! word.matches("[a-zA-Z]+\\.?")) return items;
		
		// Check to see if the word has no repeating characters and return it if it does
		if (hasNoRepeatingChars(word)) {
			items.add(word);
			return items;
		}
		
		// Load all of the possible permutations into the set
		findPermutations("", word, items);
		
		// Return the set of possible variations
		return items;
	}
	
	/**
	 * Uses recursion to find each of the permutations and add assign if they 
	 * have no duplicate letters
	 * @param prev Holder as we iterate over the options
	 * @param word Word to find permutations
	 */
	protected void findPermutations(String prev, String word, Set<String> items) {
		if (word.isEmpty() && hasNoRepeatingChars(prev + word)) {
        	items.add(prev + word);
        } else if (hasNoRepeatingChars(prev)) {
            for (int i = 0; i < word.length(); i++) {
            	String temp = word.substring(0, i) + word.substring(i + 1, word.length());
            	findPermutations(prev + word.charAt(i), temp, items);
            }
        }

    }
	
	/**
	 * Check the word to ensure there are no characters in sequence
	 * @param word Word to check
	 * @return True if no two characters are sequential
	 */
	protected boolean hasNoRepeatingChars(String word) {
		char prev = ':';
		for (char c : word.toCharArray()) {
			if (c == prev) return false;
			prev = c;
		}
		
		return true;
	}
}
