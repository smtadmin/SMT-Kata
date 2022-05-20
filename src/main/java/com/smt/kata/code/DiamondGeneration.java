package com.smt.kata.code;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem Description
 * 
 * Given a letter, print a diamond starting with ‘A’ with the supplied letter at the widest point.
 * 
 * For example: generateDiamond ‘C’ prints
 *   A
 *  B B
 * C   C
 *  B B
 *   A
 * 
 * Given character should be a printable letter in the range of [A-Z]
 * Lowercase character would be promoted to uppercase.
 * Non-Printable or non-letter characters would return empty.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author raptor
 * @version 3.0
 * @since May 17, 2022
 *
 */
public class DiamondGeneration {

	/**
	 * Generates List of Strings consisting of diamond pattern for given
	 * character 
	 * @param l Target Diamond Letter.
	 * @return
	 */
	public List<String> generateDiamond(Character l) {

		///Create List
		List<String> diamond = new ArrayList<>();

		///Validate Input
		if(l == null || !((l.charValue() >= 'a' && l.charValue() <= 'z') || (l.charValue() >= 'A' && l.charValue() <= 'Z'))) {
			return diamond;
		}

		///Upcast to Capital Letter 
		l = Character.toUpperCase(l.charValue());

		///Loops over characters and build the diamond.
		for(char c = l; c >= 'A'; c--) {

			///Generate the Diamond String
			String d = generateString(c, l);

			///Add to the diamond list.
			diamond.add(d);

			///Push to the stack if this isn't the target letter.
			if(c != l) {
				diamond.add(0, d);
			}
		}

		return diamond;
	}

	/**
	 * Generate the String representation for a row of the diamond.
	 * @param c Target letter we're generating
	 * @param l End letter of the diamond.
	 * @return
	 */
	private String generateString(char c, Character l) {
		final int diffChars = l - c;
		final int totalChars = (l.charValue() - 'A') * 2 + 1;
		return IntStream
				.range(0, totalChars)
				.boxed()
				.map(i -> (i == totalChars - diffChars - 1 || i == diffChars) ? Character.valueOf(c).toString() : " ")
				.collect(Collectors.joining());

	}
	
	
}
