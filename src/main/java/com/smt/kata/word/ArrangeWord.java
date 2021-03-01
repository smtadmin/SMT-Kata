package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

// Apache Commons 3.x
import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: ArrangeWord.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Find all permutations of a given string.  Use recursion
 * to iterate through the method and find all possible combinations
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 6, 2021
 * @updates:
 ****************************************************************************/
public class ArrangeWord {
	
	/**
	 * Holds the results of the permutation
	 */
	private List<String> items;

	/**
	 * 
	 */
	public ArrangeWord() {
		super();
	}
	
	/**
	 * Loads and returns the possible permutations of a word
	 * @param word
	 * @return
	 */
	public List<String> getPermutations(String word) {
		items = new ArrayList<>();
		if (StringUtils.isEmpty(word)) return items;
		
		// load the permutations
		findPermutations("", word);
		
		return items;
	}
	
	/**
	 * Uses recursion to find each of the permutations
	 * @param perm
	 * @param word
	 */
	private void findPermutations(String perm, String word) {
        if (word.isEmpty()) {
            items.add(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
            	String temp = word.substring(0, i) + word.substring(i + 1, word.length());
            	findPermutations(perm + word.charAt(i), temp);
            }
        }

    }
}
