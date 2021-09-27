package com.smt.kata.code;

// JDK 11.x
import java.util.LinkedList;
import java.util.List;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: PhoneNumberCombos.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Phone Number Combos Kata
 * 
 * A phone number keypad has a series of characters that are associated with 
 * each number (except 1 and 0) as shown in this image 
 * https://i.insider.com/5aa8433b3be59f1f008b4651?width=1200
 * 
 * In this kata, you will be provided a set of digits.  You must create all of 
 * the possible permutations from each set of numbers provided
 * 
 * Example 1
 * input "5"
 * output: [ "j", "k","l" ]
 * 
 * Example 2
 * input "23"
 * output: [ "ad","ae","af","bd","be","bf","cd","ce","cf" ]
 * 
 * Example 3
 * input ""
 * output: [ ]
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 2, 2021
 * @updates:
 ****************************************************************************/
public class PhoneNumberCombos {
	
	/**
	 * Map with the digits to it's character options.  Array location matches the digit value
	 */
	private static final String[] DIGIT_MAP = new String[] {
		"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" 
	};

	/**
	 * Calculates all of the possible permutations for a phone number to letter mapping
	 * @param digits Digits to transcribe 
	 * @return Collection of all of the permutations
	 */
	public List<String> calculate(String digits) {
		// Validate the input
		LinkedList<String> output = new LinkedList<>();
		if (StringUtil.isEmpty(digits) || ! digits.matches("^[0-9]+$")) return output;
		
		// Add an empty entry, which will be removed in the 0 case
		output.add("");
		
		// Loop each digit in the digits string
		for(int i=0; i < digits.length(); i++) {
			// Get it's numerical value
			int index = Character.getNumericValue(digits.charAt(i));
			
			// Keep concatenating until the permutation matches the length of the digits
			while(output.peek().length() == i) {
				// Remove the first element in the list
				String permutation = output.remove();
				
				// For each digit, loop it's character options and concatenate to
				// To the permutation removed from the output list
				for(char c: DIGIT_MAP[index].toCharArray()) {
					output.add(permutation + c);
				}
			}
		}
		
		return output;
	}
}
