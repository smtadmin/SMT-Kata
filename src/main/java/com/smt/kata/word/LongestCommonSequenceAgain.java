package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/****************************************************************************
 * <b>Title</b>: LongestCommonSequenceAgain.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Longest Common Sequence Again Kata
 *  
 * Write a program that computes the length of the longest common subsequence of 
 * a variable number of given strings. For example, given "epidemiologist", "refrigeration", 
 * and "believingmore", it should return "eieio" since that is the longest common subsequence.
 * 
 * The sequences are case sensitive.  The sequences do not need to be sequntial,
 * though they must be in order.
 * 
 * Another Example
 * Given: "bat", "hat", "cat"
 * Return: "at"
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 12, 2021
 * @updates:
 ****************************************************************************/
public class LongestCommonSequenceAgain {
	private StringBuilder output;
	
	/**
	 * Calculates the longest matching sequence of the words
	 * @param words Words to evaluate
	 * @return Longest sequence in all words
	 */
	public String getSequence(String[] wordsArray) {
		// Get clean data
		List<String> words = cleanInput(wordsArray);
		if (words.size() < 2) return "";
		
		// Holder for all possible sequences of each word
		List<Set<String>> allSequences = new ArrayList<>();
		
		// Evaluate each word and get all possible combinations
		for(String word : words) {
			Set<String> data = new HashSet<>(2048);
			output = new StringBuilder();
			combine(0, word, data);
			System.out.println(data);
			// Add the set of combinations to the list
			allSequences.add(data);
		}
		
		// Get a corss section of matches against the word
		Set<String> matches = crossSection(allSequences);
		
		// Return the longest match
		return getLongestSequence(matches);
	}
	
	/**
	 * Converts the array to a collection and checks each array item for a non-empty word
	 * @param wordsArray Array of strings ot clean
	 * @return List of words.  Empty of null or if each item in array is empty
	 */
	private List<String> cleanInput(String[] wordsArray) {
		List<String> words = new ArrayList<>();
		if (wordsArray == null) return words;
		
		for (String word : wordsArray) {
			if (word == null || word.length() == 0) continue;
			words.add(word);
		}
		
		return words;
	}
	
	/**
	 * Based upon the provided matches, find the longest sequence
	 * @param matches Matched sequences across all of the words
	 * @return Longest matching sequence
	 */
	private String getLongestSequence(Set<String> matches) {
		String longest = "";
		
		for (String match : matches) {
			if (match.length() > longest.length()) longest = match;
		}
		
		return longest;
	}
	
	/**
	 * Find all of the matching sequences against the mates for each word
	 * @param allSequences A collection of matching sequences fo reach word
	 * @return matching sequences
	 */
	private Set<String> crossSection(List<Set<String>> allSequences) {
		Set<String> first = allSequences.get(0);
		
		for (int i = 1; i < allSequences.size(); i++) {
			first.retainAll(allSequences.get(i));
		}
		
		return first;
	}
	
	/**
	 * Gets all possible combinations of the provided word
	 * @param start Start index
	 * @param word Word being evaluated
	 * @param data Collection to store each combination
	 */
	private void combine(int start, String word, Set<String> data) {
		for (int i = start; i < word.length(); ++i) {
			output.append(word.charAt(i));
			data.add(output.toString());
			if (i < word.length()) combine(i + 1, word, data);
			output.setLength(output.length() - 1);
		}
	}
}
