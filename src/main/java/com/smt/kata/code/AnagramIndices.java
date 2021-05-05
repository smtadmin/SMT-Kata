package com.smt.kata.code;

// JDK 11.x
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title:</b> AnagramIndicie.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Anagram Indices
 * 
 * Given a word W and a string S, find all starting indices in S which are anagrams of W.
 * 
 * For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.
 * 
 * Remember, we are working with words, not characters.  The indice is the first
 * index of W in S
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 28, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class AnagramIndices {

	/**
	 * Finds the location of each indices of w in s
	 * @param w characters to find
	 * @param s String to locate w
	 * @return Collection of indices locations.  Empty collection if none found
	 */
	public Collection<Integer> find(String w, String s) {
		// Validate the input data
		Set<Integer> indices = new TreeSet<>();
		if (! isValidInput(w, s)) return indices;
		
		// Check forward
		evaluate(w, s, indices);
		
		// Check Backwards
		evaluate(new StringBuilder(w).reverse().toString(), s, indices);
		
		return indices;
	}
	
	/**
	 * Finds all of the indices for the given word and source
	 * @param w characters to find
	 * @param s String to locate w
	 * @param indices Collection of previously located indices
	 */
	private void evaluate(String w, String s, Set<Integer> indices) {
		var index = 0;
		while(true) {
			// Find the match beginning at the previous location
			index = s.indexOf(w, index);
			
			// If found, add to indices.  If not, break
			if (index > -1) indices.add(index);
			else break;
			
			// Increment the starting point s some item doesn't match
			index += w.length();
			
		}
	}
	
	/**
	 * Checks for valid input
	 * @param w characters to find
	 * @param s String to locate w
	 * @return True if all data is valid.  False otherwise
	 */
	public boolean isValidInput(String w, String s) {
		return ! (StringUtil.isEmpty(w) || StringUtil.isEmpty(s) || w.length() > s.length() || ! s.contains(w));
	}

}
