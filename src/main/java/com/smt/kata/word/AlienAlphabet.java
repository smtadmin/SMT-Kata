package com.smt.kata.word;

//JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Apache commons 3.x
import org.apache.commons.lang3.ArrayUtils;

/****************************************************************************
 * <b>Title</b>: AlienAlphabet.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Alien Alphabet Kata
 * 
 * You come across a dictionary of sorted words in a language you've never seen 
 * before. Write a program that returns the correct order of letters in this language.
 * 
 * For example, given ['xww', 'wxyz', 'wxyw', 'ywx', 'ywz'], 
 * you should return ['x', 'z', 'w', 'y'].
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 23, 2021
 * @updates:
 ****************************************************************************/
public class AlienAlphabet {

	/**
	 * Finds the "Alien" alphabet in order
	 * @param words List of words in the proper order
	 * @return Order of the characters
	 */
	public char[] alphabetize(String[] words) {
		if (words == null || words.length < 2) return new char[0];
		Set<String> letters = getUniqueCharacters(words);
		List<String> choices = new ArrayList<>();
		findPermutations("", String.join("", new ArrayList<>(letters)), choices);
		
		for (String choice : choices) {
			List<String> newWords = Arrays.asList(words.clone());
			AlphabetizeComparator ac = new AlphabetizeComparator(choice.toCharArray());
			Collections.sort(newWords, ac);
			if (evaluate(words, newWords)) return choice.toCharArray();
		}
		
		return new char[0];
	}
	
	/**
	 * Determines if the new sorting matches the original
	 * @param orig Original array of words
	 * @param newWords Sorted set of words
	 * @return
	 */
	private boolean evaluate(String[] orig, List<String> newWords) {
		for (int i=0; i < orig.length; i++) {
			if (! newWords.get(i).equals(orig[i])) return false;
		}
		
		return true;
	}
	
	/**
	 * Uses recursion to find each of the permutations
	 * @param perm
	 * @param word
	 */
	private void findPermutations(String perm, String word, List<String> items) {
        if (word.isEmpty()) {
            items.add(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
            	String temp = word.substring(0, i) + word.substring(i + 1, word.length());
            	findPermutations(perm + word.charAt(i), temp, items);
            }
        }

    }
	
	/**
	 * Retrieves the unique list of letters
	 * @param words Words to parse
	 * @return Unique set of characters
	 */
	private Set<String> getUniqueCharacters(String[] words) {
		// Get the letters in the alphabet
		Set<String> letters = new HashSet<>();
		for (String word : words) {
			Stream<String> charStream = new String(word.toCharArray()).chars().mapToObj(c -> new String((char)c + ""));
			letters.addAll(charStream.collect(Collectors.toList()));
		}
		
		return letters;
	}
}

/**
 * Comparator that accepts the uniquely ordered set of characters and uses that
 * set to order the provided words
 */
class AlphabetizeComparator implements Comparator<String> {
	
	private char[] order;
	
	public AlphabetizeComparator(char[] order) {
		super();
		this.order = order;
	}

	@Override
	public int compare(String o1, String o2) {
		int length = o1.length();
		if (o2.length() < length) length = o2.length();
		
		for (int i=0; i < length; i++) {
			int o1loc = ArrayUtils.indexOf(order, o1.charAt(i));
			int o2loc = ArrayUtils.indexOf(order, o2.charAt(i));
			
			if (o1loc == o2loc) continue;
			
			return Integer.valueOf(o1loc).compareTo(Integer.valueOf(o2loc));
		}

		return 0;
	}
	
}