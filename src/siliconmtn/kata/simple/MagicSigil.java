package siliconmtn.kata.simple;

// JDK 8.x
import java.util.HashSet;
import java.util.Set;

/****************************************************************************
 * <b>Title</b>: MagicSigil.java
 * <b>Project</b>: _Sandbox
 * <b>Description: </b> A magic sigil is a glyph which represents a desire one wishes 
 * to manifest in their lives. There are many ways to create a sigil, but the 
 * most common is to write out a specific desire (e.g. "I HAVE WONDERFUL FRIENDS WHO LOVE ME"), 
 * remove all vowels and spaces, remove any duplicate letters (keeping the last occurence), 
 * and then design a glyph from what remains.  Using the sentence above as an example, 
 * we would remove duplicate letters: 
 * 		AUFRINDSWHLOVME 
 * And then remove all vowels, leaving us with: 
 * 		FRNDSWHLVM 
 * Create a method that takes a string and removes its vowels and duplicate letters. 
 * The returned string should not contain any spaces and be in uppercase.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class MagicSigil {

	/**
	 * Keep track of the letters we're removing
	 */
	private static Set<String> vowels = new HashSet<String>() {
		private static final long serialVersionUID = 1L; {
			add("A");
			add("E");
			add("I");
			add("O");
			add("U");
			add(" ");
		}
	};
	
	/**
	 * Creates a variety of test cases to validate the sw
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Sigalized Word: " + sigilize("I FOUND MY SOULMATE")); // "FNDYSLMT"
		System.out.println("Sigalized Word: " + sigilize("i am healthy")); // "MLTHY"
		System.out.println("Sigalized Word: " + sigilize("I have a job I enjoy and it pays well")); // "HVBJNDTPYSWL"
	}
	
	/**
	 * Sigilize the word
	 * @param word
	 * @return
	 */
	public static String sigilize(String word) {
		if (word == null || word.isEmpty()) return "";
		
		word = word.toUpperCase();
		StringBuilder newWord = new StringBuilder();
		
		// Loop to remove the vowels and spaces
		for (int i = 0; i < word.length(); i++) {
			String letter = word.charAt(i) + "";
			if (! vowels.contains(letter)) newWord.append(letter);
		}
		
		// Loop backwards to remove the first duplicate letters
		for (int i = newWord.length() - 1; i > -1; i--) {
			String letter = newWord.charAt(i) + "";
			if(newWord.lastIndexOf(letter) > i) newWord.deleteCharAt(i);
		}
		
 		return newWord.toString();
	}

}
