package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/****************************************************************************
 * <b>Title</b>: CircularArray.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Circular Array Kata
 * 
 * Given a list of words, determine whether the words can be chained to form a circle. 
 * A word X can be placed in front of another word Y in a circle if the last 
 * character of X is same as the first character of Y.
 * 
 * For example, the words ['chair', 'height', 'racket', touch', 'tunic'] can 
 * form the following circle: chair --> racket --> touch --> height --> tunic --> chair.

 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 13, 2021
 * @updates:
 ****************************************************************************/
public class CircularArray {

	/**
	 * Creates the circular array from the array of words
	 * @param words Words to reorder in a circular pattern
	 * @return Collection of words reordered.  Empty list if not possible
	 */
	public List<String> create(String[] words) {
		// List to hold the chain
		List<String> items = new ArrayList<>();
		if(words == null || words.length < 2) return items;
		
		// Loop each word as the starting word may not be the first
		for (String word : words) {
			// Convert the word list into a collection (cloned)
			List<String> source = new ArrayList<>(Arrays.asList(words));
			
			// Remove the starting word from the source and add it to the circular 
			// list as the first word
			source.remove(word);
			items.add(word);
			
			// Call the recursion method to check all pathways
			recurse(source, items, word.charAt(word.length() - 1), word, source.size());
			
			// If the pathway worked, return the list.  Otherwise, clear the list 
			// and try the next word
			if (items.size() == words.length + 1) return items;
			items = new ArrayList<>();
		}
		
		return items;
	}

	/**
	 * Recursively looks for patterns that will match
	 * @param source Words to reorder in a circular pattern
	 * @param circItems Items in the circular pattern
	 * @param start Starting character
	 * @param chainStart First word in the chain (which will also be the last)
	 * @param len Original length of the chain
	 */
	private void recurse(List<String> source, List<String> circItems, char start, String chainStart, int len) {
		// Get a list of matching items.  Wrap in an array list so the remove method can be called
		List<String> matches = new ArrayList<>(source.stream().filter(p -> p.startsWith(start+"")).collect(Collectors.toList()));
		
		// If all of the source letters are utilized or the size matches, return
		if (source.isEmpty() || matches.isEmpty()) return;
		
		// Loop all of the matches and recurse
		for(String match : matches) {
			// Remove the match from the source and add to the chain
			source.remove(match);
			circItems.add(match);
			
			// Check to see if all of the words have been used.  Add the start word and return
			if (source.isEmpty() && chainStart.startsWith(match.charAt(match.length() - 1) + "")) {
				circItems.add(chainStart);
				return;
			}
			
			// Call itself for each new match
			recurse(source, circItems, match.charAt(match.length() - 1), chainStart, len);
		}
	}
}
