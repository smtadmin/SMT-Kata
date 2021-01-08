package siliconmtn.kata.simple;

// JDK 8.x
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

// Kata Libs
import siliconmtn.kata.util.Dictionary;

/****************************************************************************
 * <b>Title</b>: MirrorAlphabet.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Every kid learns that A is for Apple ... and Z is for Zebra.
 * But not every kid learns the mirror-alphabet words:
 * A is for Anaconda
 * B is for Bathtub
 * C is for Comic
 * ...
 * Z is for Zizz
 * Not only are the first letters of each word alphabetic, so are the last letters!
 * 
 * Unfortunately, you can't complete this list: no word in English begins and ends with X.
 * 
 * But what if you shift the alphabet by one letter for the ending?
 * 
 * A is for Absorb
 * B is for Byronic
 * C is for Caryatid
 * ...
 * X is for Xenophoby
 * Y is for Yez
 * Z is for Zebra
 * You'll find that this won't work either. How about shifting the end letter alphabet by 2?
 * 
 * A is for Antihemorrhagic
 * B is for Blindfold
 * C is for Capstone
 * ...
 * Y is for Yoga
 * Z is for Zimb
 * That fails, too! In fact, there is only one mirror-alphabetic ordering that works for English.
 * 
 * Write a program that generates a valid mirror-alphabet word list.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class MirrorAlphabet {
	/**
	 * Array holding all of the words in the dictionary
	 */
	private static String[] dict;
	
	/**
	 * Creates a variety of test cases to validate the sw
	 * @param args
	 */
	public static void main(String args[]) throws IOException{   
		dict = Dictionary.getDictionary();
		System.out.println("Word List: " + getMagicList());
	}

	/**
	 * Gets the list of 26 matching words
	 * @return
	 */
	private static List<String> getMagicList() {
	
		int offset = 0;
		for (int i=0; i < 26; i++) {
			List<String> wordList = new ArrayList<>();
			
			for (int start=97; start < 123; start++) {
				char endChar = (char)((start + offset) < 123 ? (start + offset) : start + (offset - 26));
				char startChar = (char)start;

				String val = checkDictionary(startChar, endChar);
				if (val.isEmpty()) break;
				else wordList.add(val);
			}
			
			offset++;
			if (wordList.size() == 26 || offset > 25) return wordList;
		}
		
		return new ArrayList<>();
	}
		
	/**
	 * Uses pattern matching regex to see if the dictionary contains a word that matches
	 * @param start letter that the word must start with
	 * @param end letter that the word must end with
	 * @return
	 */
	private static String checkDictionary(char start, char end) {
		
		for (int i=0; i < dict.length; i++) {
			String pattern = "^[" + start + "].*[" + end + "]$";
			if (Pattern.compile(pattern).matcher(dict[i]).find()) {
				return dict[i];
			}
		}
		
		return "";
	}
}
