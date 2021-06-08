package com.smt.kata.distance;

// JDK 11.x
import java.util.regex.Pattern;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title:</b> OneFingerDistance.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> One-Finger Distance
 * 
 * Given a linear , alphabetic keyboard of the letters of the alphabet, 
 * how many letters in total does your finger have to jump over in order to 
 * type a given word?
 * 
 * Consider the linear keyboard of the upper case letters of the alphabet laid 
 * out like this:
 * 
 * | A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z |
 * 
 *  The word "boost" has a one-finger distance of 15 because there are 12, 0, 3, 0 
 *  letters between b and o, o and o, o and s, s and t, respectively.
 *   
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 30, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class OneFingerDistance {

	/**
	 * Calculates the finger distance on the keyboard
	 * @param word Word to calculate against
	 * @return distance between the letters
	 */
	public int calculate(String word) {
		// Validate the  input and uppercase the data
		int total = 0;
		if(hasInvalidData(word)) return total;
		word = word.toUpperCase();
		
		// Loop each character and compare to previous
		char prev = '0';
		for (char c : word.toCharArray()) {
			// Skip the first one and the ones that are equal
			if (prev != '0' && prev != c) {
				// Add the difference in letters, convert to positive and subtract one
				total += Math.abs(((int)prev) - ((int)c)) - 1;
			}
			
			// Assign the current char to the previous
			prev = c;
		}
		
		// Return the total
		return total;
	}
	
	/**
	 * Checks for invalid data in the word (empty, too short, invalid chars, etc ...)
	 * @param word Word to evaluate
	 * @return True if there is any invalid data.  False otherwise
	 */
	public boolean hasInvalidData(String word) {
		return  StringUtil.isEmpty(word) || 
				word.length() < 2 || 
				! Pattern.matches("[A-Z]+", word.toUpperCase());
	}

}
