package com.smt.kata.number;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: OriginalDigits.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Reconstruct Original Digits from English
 * 
 * Given a string s containing an out-of-order English representation of digits 0-9, 
 * return the digits in ascending order.
 * 
 * Example 1:
 * Input: s = "owoztneoer"
 * Output: "012"
 * 
 * Example 2:
 * Input: s = "fviefuro"
 * Output: "45"
 * 
 * Constraints:
 * 1 <= s.length <= 105
 * s[i] is one of the characters ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"].
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 9, 2021
 * @updates:
 ****************************************************************************/
public class OriginalDigits {
	
	// List of words for each digit in order
	List<String> words = new ArrayList<>();
	
	/**
	 * Initializes the class and the words list
	 */
	public OriginalDigits() {
		super();
		words.add("zero");
		words.add("one");
		words.add("two");
		words.add("three");
		words.add("four");
		words.add("five");
		words.add("six");
		words.add("seven");
		words.add("eight");
		words.add("nine");
	}
	
	/**
	 * Calculates the digits in the word
	 * @param source Source to find digits
	 * @return Digits in order
	 */
	public String calculate(String source) {
		if (StringUtil.isEmpty(source)) return "";
		
		StringBuilder hldr = new StringBuilder();
		for(String word : words) {
			boolean valid = true;
			for (char letter : word.toCharArray()) {
				if(! source.toLowerCase().contains(letter+"")) valid = false;
			}
			
			if(valid) hldr.append(words.indexOf(word));
		}
		
		return hldr.toString();
	}
}
