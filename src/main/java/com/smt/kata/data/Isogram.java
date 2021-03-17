package com.smt.kata.data;

// Spacelibs 1.0
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: Isogram.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Isograms
 *
 * Determine if a word or phrase is an isogram.
 * 
 * An isogram (also known as a "nonpattern word") is a word or phrase without a 
 * repeating letter, however spaces and hyphens are allowed to appear multiple times.
 * 
 * Examples of isograms:
 * 
 * lumberjacks
 * background
 * downstream
 * six-year-old
 * The word isograms, however, is not an isogram, because the s repeats.
 * 
 * You MAY not use collections or anything other than primitives and Strings for this exercise
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 17, 2021
 * @updates:
 ****************************************************************************/
public class Isogram {

	/**
	 * Validates whether or not the 
	 * @param phrase Phrase to check against the Isogram rules
	 * @return true if an isogram.  False if empty or not an isogram
	 */
	public boolean isValidIsogram(String phrase) {
		if (StringUtil.isEmpty(phrase)) return false;
		
		char[] holder = new char[phrase.length()];
		
		for (int i=0; i < phrase.toCharArray().length; i++) {
			char c = phrase.toLowerCase().charAt(i);
			if (contains(holder, c)) return false;
			
			holder[i] = c;
		}
		
		return true;
	}
	
	/**
	 * Determines if the array contains the passed value
	 * @param arr array to check
	 * @param c char to validate
	 * @return True if c is on the array
	 */
	private boolean contains(char[] arr, char c) {
		for (char a : arr) {
			if (!(a == ' ' || a == '-') && c == a) return true;
		}
		
		return false;
	}

}
