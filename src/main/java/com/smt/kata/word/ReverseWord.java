package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

// Spacelibs java
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: ReverseWord.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Reverse Words in a String
 * Given an input string, reverse the string word by word.
 * 
 * Examples
 * reverseWords("the sky is blue") ➞ "blue is sky the"
 * 
 * reverseWords("  hello world!  ") ➞ "world! hello"
 * 
 * reverseWords("a good   example") ➞ "example good a"
 * 
 * Notes
 * A word is defined as a sequence of non-space characters.
 * The input string may contain leading or trailing spaces. However, your reversed 
 * string should not contain leading or trailing spaces. You need to reduce multiple 
 * spaces between two words to a single space in the reversed string. You *** MAY NOT ***
 * utilize String.split() or parsing methods.  You must loop the phrase and process 
 * the characters in a loop.  You may use collections to store words if desired.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 8, 2021
 * @updates:
 ****************************************************************************/
public class ReverseWord {

	/**
	 * 
	 */
	public ReverseWord() {
		super();
	}

	/**
	 * Takes the phrase and reverses the ords
	 * @param phrase
	 * @return
	 */
	public String processPhrase(String phrase) {
		// Check for empty
		if (StringUtil.isEmpty(phrase)) return "";

		// Loop the phrase and separate the words
		List<String> words = parseWords(phrase);
		
		// Loop the results backwards and append to the return phrase
		StringBuilder retPhrase = new StringBuilder();
		for (int i= words.size() - 1; i > -1; i--) retPhrase.append(words.get(i)).append(" ");
		
		// Make sure to trim the return phrase to remove the extra space at the end
		return retPhrase.toString().trim();
	}
	
	/**
	 * Loop the phrase and separate the words
	 * @param phrase
	 * @return
	 */
	protected List<String> parseWords(String phrase) {
		List<String> words = new ArrayList<>();
		StringBuilder holder = new StringBuilder();
		for (char c : phrase.trim().toCharArray()) {
			if (c == ' ' && holder.length() > 0) {
				words.add(holder.toString());
				holder = new StringBuilder();
			} else if (c != ' ') {
				holder.append(c);
			}
		}
		
		// Cleanup the last word
		words.add(holder.toString());
		
		return words;
	}
}
