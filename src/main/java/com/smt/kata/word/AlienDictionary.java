package com.smt.kata.word;

// JDK 11.x
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.datatype.DatatypeConfigurationException;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: AlienDictionary.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Alien Dictionary Kata
 * 
 * In an alien language, surprisingly, they also use English lowercase letters, 
 * but possibly in a different order. The order of the alphabet is some permutation 
 * of lowercase letters.
 * 
 * Given a sequence of words written in the alien language, and the order of the alphabet, 
 * return true if and only if the given words are sorted lexicographically in this alien language.
 * 
 * Example 1:
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * 
 * Example 2:
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], 
 * hence the sequence is unsorted.
 * 
 * Example 3:
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is 
 * shorter (in size.) According to lexicographical rules "apple" > "app", 
 * because 'l' > '∅', where '∅' is defined as the blank character which is less 
 * than any other character (More info).
 * 
 * Constraints:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 
 * All characters in words[i] and order are English lowercase letters.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 7, 2021
 * @updates:
 ****************************************************************************/
public class AlienDictionary {
	
	/**
	 * The dictionary passed in broken into chars and added to the list
	 */
	private List<Character> dict;

	/**
	 * Initializes the class with the new alphabet order
	 * @param order Order of the letters in the new alphabet
	 * @throws DatatypeConfigurationException If the order of letters is invalid
	 */
	public AlienDictionary(String order) throws DatatypeConfigurationException {
		if (StringUtil.isEmpty(order) || order.length() != 26) 
			throw new DatatypeConfigurationException("Invalid Data");
		
		// Update the dictionary with the provided order of letters
		dict = order.chars().mapToObj(c -> Character.valueOf((char)c)).collect(Collectors.toList());
	}

	/**
	 * Determines if the provided words are in order
	 * @param words Words to check
	 * @return True if the words are in order and false otherwise
	 */
	public boolean isSorted(String[] words) {
		if (words == null || words.length < 2) return false; 
		int length = getMaxLength(words);
		long previous = 0;
		
		// Loop each word and encode the values.  if the value is less than the previous
		// Value, return false.  Otherwise, keep checking
		for (String word : words) {
			if (StringUtil.isEmpty(word)) continue;
			long value = encode(word.toLowerCase(), length);
			if (value < previous) return false;
			previous = value;
		}
		
		// If all of the items were in order, return true
		return true;
	}
	
	/**
	 * Encodes the word into the location values of the letters in the dictionary
	 * @param word Word to encode it's values
	 * @param length Length of the longest word so all values have the same 
	 * number of digits
	 * @return Encoded digits
	 */
	private long encode(String word, int length) {
		StringBuilder s = new StringBuilder();
		
		// Loop each word and find the index of its character.  If the index is > 9, 
		// Increment the length as the index is 2 digits
		for (char c : word.toCharArray()) {
			int loc = dict.indexOf(Character.valueOf(c)) + 1;
			if (loc > 9) length++;
			s.append(loc);
		}
		
		// Pad the data to the length so shorter words will end in all 0000s and 
		// The length of each encoded word will be the same
		return Long.valueOf(StringUtil.padRight(s.toString(), '0', length));
	}
	
	/**
	 * Gets the length of the longest word
	 * @param words All of the words to be checked
	 * @return Length of the longest word
	 */
	private int getMaxLength(String[] words) {
		int maxLength = 0;
		for (String word : words) {
			if (word != null && word.length() > maxLength) maxLength = word.length();
		}
		
		return maxLength;
	}
}
