package com.smt.kata.distance;

// JDK 11.x
import java.util.LinkedHashMap;
import java.util.Map;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title:</b> RailFenceCypher.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Rail Fence Cypher
 * Implement encoding and decoding for the rail fence cipher.
 * 
 * The Rail Fence cipher is a form of transposition cipher that gets its name from 
 * the way in which it's encoded. It was already used by the ancient Greeks.
 * 
 * In the Rail Fence cipher, the message is written downwards on successive "rails" 
 * of an imaginary fence, then moving up when we get to the bottom (like a zig-zag). 
 * Finally the message is then read off in rows.
 * 
 * For example, using three "rails" and the message "WE ARE DISCOVERED FLEE AT ONCE", 
 * the cipherer writes out:
 * 
 * W . . . E . . . C . . . R . . . L . . . T . . . E
 * . E . R . D . S . O . E . E . F . E . A . O . C .
 * . . A . . . I . . . V . . . D . . . E . . . N . .
 * Then reads off:
 * 
 * WECRLTEERDSOEEFEAOCAIVDEN
 * To decrypt a message you take the zig-zag shape and fill the ciphertext along the rows.
 * 
 * ? . . . ? . . . ? . . . ? . . . ? . . . ? . . . ?
 * . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? .
 * . . ? . . . ? . . . ? . . . ? . . . ? . . . ? . .
 * The first row has seven spots that can be filled with "WECRLTE".
 * 
 * W . . . E . . . C . . . R . . . L . . . T . . . E
 * . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? . ? .
 * . . ? . . . ? . . . ? . . . ? . . . ? . . . ? . .
 * Now the 2nd row takes "ERDSOEEFEAOC".
 * 
 * W . . . E . . . C . . . R . . . L . . . T . . . E
 * . E . R . D . S . O . E . E . F . E . A . O . C .
 * . . ? . . . ? . . . ? . . . ? . . . ? . . . ? . .
 * Leaving "AIVDEN" for the last row.
 * 
 * W . . . E . . . C . . . R . . . L . . . T . . . E
 * . E . R . D . S . O . E . E . F . E . A . O . C .
 * . . A . . . I . . . V . . . D . . . E . . . N . .
 * 
 * If you now read along the zig-zag shape you can read the original message.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 22, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class RailFenceCypher {
	
	/**
	 * Holds the patterns for the cypher
	 */
	private Map<Integer, Integer> patterns;

	/**
	 * 
	 */
	public RailFenceCypher() {
		super();
		
		patterns = new LinkedHashMap<>();
		patterns.put(Integer.valueOf(0), Integer.valueOf(4));
		patterns.put(Integer.valueOf(1), Integer.valueOf(2));
		patterns.put(Integer.valueOf(2), Integer.valueOf(4));
	}

	/**
	 * Loops the phrase and performs a Rail Fence Cypher
	 * @param phrase Phrase to be encoded 
	 * @return Rail Fence Cypher encoded phrase
	 */
	public String encodePhrase(String phrase) {
		if (StringUtil.isEmpty(phrase)) return "";
		
		// Get rid of the spaces and uppercase the phrase
		phrase = phrase.replace(" ", "").toUpperCase();
		StringBuilder cypher = new StringBuilder();
		for(Map.Entry<Integer, Integer> pattern : patterns.entrySet()) {
			
			for (int i = pattern.getKey(); i < phrase.length(); i += pattern.getValue()) {
				cypher.append(phrase.charAt(i));
			}
		}
		
		return cypher.toString();
	}
	
	/**
	 * Returns the matrix of the phrase
	 * @param phrase Phrase ot encode into the matrix
	 * @return Matrix of the cypher
	 */
	public char[][] getMatrixFromPhrase(String phrase) {
		if (StringUtil.isEmpty(phrase)) return new char[0][];

		char[][] cypher = new char[3][phrase.length()];
		phrase = phrase.replace(" ", "").toUpperCase();
		
		int rowCount = 0;
		for(Map.Entry<Integer, Integer> pattern : patterns.entrySet()) {
			char[] row = new char[phrase.length()];
			
			for (int i=0; i < phrase.length(); i++) {
				if (i < pattern.getKey()) row[i] = '.';
				else if ((i % pattern.getValue()) - pattern.getKey() == 0) 
					row[i] = phrase.charAt(i);
				else row[i] = '.';
			}
			
			cypher[rowCount++] = row;
		}

		return cypher;
	}

}
