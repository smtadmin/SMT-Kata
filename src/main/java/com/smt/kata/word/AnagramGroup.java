package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: AnagramGroup.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Group Anagrams
 * 
 * Given an array of strings strs, group the anagrams together. You can return 
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a different 
 * word or phrase, typically using all the original letters exactly once.
 * 
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * 
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * 
 * Constraints:
 * strs[i] consists of lower-case English letters.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 18, 2021
 * @updates:
 ****************************************************************************/
public class AnagramGroup {

	/**
	 * Group the anagrams together
	 * @param words Array of words to group 
	 * @return Groups of anagrams
	 */
	public Collection<List<String>> assign(String[] words) {
		
		// Holds an alphabetized word as the key and a list of matches as the value
		Map<String, List<String>> items = new LinkedHashMap<>();
		
		// Validate the input
		if (words == null || words.length < 1) return items.values();
		
		// Loop the words
		for (String word : words) {
			// Make sure the word is not null or empty
			if (StringUtil.isEmpty(word)) continue;
			
			// Create an ordered version
			char[] ordered = word.toCharArray();
			Arrays.sort(ordered);
			String orderedStr = new String(ordered);
			
			// Add to the map using the ordered string as the key
			if (items.containsKey(orderedStr)) {
				List<String> ele = items.get(orderedStr);
				ele.add(word);
			} else {
				List<String> ele = new ArrayList<>();
				ele.add(word);
				items.put(orderedStr, ele);
			}
		}
		
		// Return the collection of values
		return items.values();
	}

}
