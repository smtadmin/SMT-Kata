package com.smt.kata.word;

// JDK 11.x
import java.util.Set;
import java.util.stream.Collectors;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: StringHalves.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> String Halves Kata
 * 
 * Determine if String Halves Are Alike
 * 
 * You are given a string s of even length. Split this string into two halves of 
 * equal lengths, and let a be the first half and b be the second half.
 * 
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 
 * 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
 * 
 * Return true if a and b are alike. Otherwise, return false.
 * 
 * Example 1:
 * Input: s = "book"
 * Output: true
 * Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
 * 
 * Example 2:
 * Input: s = "textbook"
 * Output: false
 * Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, 
 * they are not alike.
 * Notice that the vowel o is counted twice.
 * 
 * Example 3:
 * Input: s = "MerryChristmas"
 * Output: false
 * 
 * Example 4:
 * Input: s = "AbCdEfGh"
 * Output: true
 * 
 * Constraints:
 * 
 * 2 <= s.length <= 1000
 * s.length is even.
 * s consists of uppercase and lowercase letters.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 7, 2021
 * @updates:
 ****************************************************************************/
public class StringHalves {
	// Members
	private Set<Character> vowels = "aeiouAEIOU".chars().mapToObj(c -> Character.valueOf((char)c)).collect(Collectors.toSet());
	
	/**
	 * Calculates whether the number of vowels and consonants are the same after
	 * splitting the source string in half
	 * @param s Source String
	 * @return True if the numbers match.  False otherwise;
	 */
	public boolean calculate(String s) {
		if (StringUtil.isEmpty(s) || s.length() < 2 || (s.length() %2) == 1 ) return false;
		int len = s.length();
		int half = len/2;
		return getNumVowels(s.substring(0, half)) == getNumVowels(s.substring(half));
	}

	/**
	 * Counts the number of vowels in the provided string
	 * @param half String (half of the source string) to be counted
	 * @return Number of vowels
	 */
	public int getNumVowels(String half) {
		int total = 0;
		
		for (char c : half.toCharArray()) {
			if (vowels.contains(Character.valueOf(c))) total++;
		}
		
		return total;
	}
}
