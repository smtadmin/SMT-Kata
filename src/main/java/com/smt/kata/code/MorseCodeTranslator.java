package com.smt.kata.code;

// JDK 11.x
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: MorseCodeTranslator.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Morse Code converter.  Take any phrase and convert it to 
 * its morse code equivelant and decode a morse code phrase back to english.  In morse
 * code, spaces separate the letters and " / " separates words
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 15, 2021
 * @updates:
 ****************************************************************************/
public class MorseCodeTranslator {
	// Members
	protected Map<Character, char[]> codes;
	
	/**
	 * 
	 */
	public MorseCodeTranslator() {
		super();
		initializeCodes();
	}
	
	/**
	 * Converts a phrase or word into morse code
	 * @param phrase any set of characters or numbers
	 * @return Morse code as a space delimited document
	 */
	public String encode(String phrase) {
		StringBuilder morseCode = new StringBuilder();
		if (StringUtil.isEmpty(phrase)) return morseCode.toString();
		
		for (Character c : phrase.toCharArray()) {
			if (c == ' ' || ! codes.containsKey(c)) {
				if (c == ' ') morseCode.append("/ ");
				continue;
			} 
			
			char[] mc = codes.get(c);			
			for (Character ditDot : mc) {
				morseCode.append(ditDot);
			}
			
			morseCode.append(" ");
		}
		
		return morseCode.toString().trim();
	}
	
	/**
	 * Decodes a morse code encoded phrase
	 * @param encodedPhrase Uses spaces as the letter delimiter and / as the word delimiter
	 * @return English phrase decoded form the morse code snippet
	 */
	public String decode(String encodedPhrase) {
		StringBuilder phrase = new StringBuilder();
		if (StringUtil.isEmpty(encodedPhrase)) return phrase.toString();
		
		String[] words = encodedPhrase.split("/");
		for (String word : words) {
			
			String[] letters = word.trim().split(" ");
			for (String ditDot : letters) {
				Character c = convert(ditDot);
				if (c != ' ') phrase.append(c);
			}
			
			phrase.append(" ");
		}
		
		return phrase.toString().trim();
	}
	
	/**
	 * Takes the value (morse code) and converts to a letter.  Returns a space if not found
	 * @param ditDotLetter
	 * @return
	 */
	private Character convert(String ditDotLetter) {
		Optional<Character> value = codes
				.entrySet()
				.stream()
				.filter(entry -> ditDotLetter.equals(new String(entry.getValue())))
				.map(Map.Entry::getKey)
				.findFirst();

		if (value.isPresent()) return value.get();
		else return Character.valueOf(' ');
	}

	/**
	 * Initializes the morse code values
	 * @return
	 */
	private void initializeCodes() {

		codes = new LinkedHashMap<>();
		
		// Add the letters
		codes.put(Character.valueOf('A'), new char[] { '.','-' });
		codes.put(Character.valueOf('B'), new char[] { '-','.','.','.' });
		codes.put(Character.valueOf('C'), new char[] { '-','.','-','.' });
		codes.put(Character.valueOf('D'), new char[] { '-','.','.' });
		codes.put(Character.valueOf('E'), new char[] { '.' });
		codes.put(Character.valueOf('F'), new char[] { '.','.', '-', '.' });
		codes.put(Character.valueOf('G'), new char[] { '-','-','.' });
		codes.put(Character.valueOf('H'), new char[] { '.','.','.','.' });
		codes.put(Character.valueOf('I'), new char[] { '.','.' });
		codes.put(Character.valueOf('J'), new char[] { '.','-','-','-' });
		codes.put(Character.valueOf('K'), new char[] { '-','.','-' });
		codes.put(Character.valueOf('L'), new char[] { '.','-','.','.' });
		codes.put(Character.valueOf('M'), new char[] { '-','-' });
		codes.put(Character.valueOf('N'), new char[] { '-','.' });
		codes.put(Character.valueOf('O'), new char[] { '-','-','-' });
		codes.put(Character.valueOf('P'), new char[] { '.','-','-','.' });
		codes.put(Character.valueOf('Q'), new char[] { '-','-','.','-' });
		codes.put(Character.valueOf('R'), new char[] { '.','-','.' });
		codes.put(Character.valueOf('S'), new char[] { '.','.','.' });
		codes.put(Character.valueOf('T'), new char[] { '-' });
		codes.put(Character.valueOf('U'), new char[] { '.','.','-' });
		codes.put(Character.valueOf('V'), new char[] { '.','.','.','-' });
		codes.put(Character.valueOf('W'), new char[] { '.','-','-' });
		codes.put(Character.valueOf('X'), new char[] { '-','.','.','-' });
		codes.put(Character.valueOf('Y'), new char[] { '-','.','-','-' });
		codes.put(Character.valueOf('Z'), new char[] { '-','-','.','.' });
		
		// Add the numbers
		codes.put(Character.valueOf('0'), new char[] { '-','-','-','-', '-' });
		codes.put(Character.valueOf('1'), new char[] { '.','-','-','-','-' });
		codes.put(Character.valueOf('2'), new char[] { '.','.','-','-','-' });
		codes.put(Character.valueOf('3'), new char[] { '.','.','.','-','-' });
		codes.put(Character.valueOf('4'), new char[] { '.','.','.','.','-' });
		codes.put(Character.valueOf('5'), new char[] { '.','.','.','.','.' });
		codes.put(Character.valueOf('6'), new char[] { '-','.','.','.','.' });
		codes.put(Character.valueOf('7'), new char[] { '-','-','.','.','.' });
		codes.put(Character.valueOf('8'), new char[] { '-','-','-','.','.' });
		codes.put(Character.valueOf('9'), new char[] { '-','-','.','-','.' });
	}
}
