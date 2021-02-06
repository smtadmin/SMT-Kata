package com.smt.kata.word;

/****************************************************************************
 * <b>Title</b>: Pangram.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Determine if a sentence is a pangram. A pangram 
 * (Greek: παν γράμμα, pan gramma, "every letter")
 * is a sentence using every letter of the alphabet at least once. The best known English pangram is: 
 * The quick brown fox jumps over the lazy dog. 
 * The alphabet used consists of ASCII letters a to z, inclusive, and is case 
 * insensitive. Input will not contain non-ASCII symbols.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class Pangram {

	/**
	 * Reverse the number and compare to the original
	 * @param startNumber
	 * @return
	 */
	public boolean isPangram(String sentence){
		sentence = sentence.toLowerCase();
		StringBuilder letters = new StringBuilder();
		
		for (int i=0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			if (! Character.isAlphabetic(c)) continue;
			
			if (letters.indexOf(c + "") == -1)
				letters.append(sentence.charAt(i));

		}
		
		return letters.length() == 26;
	}

}
