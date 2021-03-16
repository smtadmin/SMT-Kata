package com.smt.kata.code;

import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: BinaryAsciiConverter.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Binary To ASCII Conversion
 * Create a function that takes a string of 1's and 0's (binary) as an argument 
 * and return the equivalent decoded ASCII text. Characters can be in the range of 
 * "00000000" to "11111111", which means every eight digits of binary input 
 * represents a single character.
 * 
 * a = 01100001
 * b = 01100010
 * c = 01100011
 * 
 * If you were to combine these characters into the string "abc", the corresponding 
 * binary would be 011000010110001001100011. Use the resources tab for more 
 * info on how to approach this.
 * 
 * Notes
 * If you are given an empty string as input, you must also return an empty string. 
 * Otherwise, the input will always be a valid binary string.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 1, 2021
 * @updates:
 ****************************************************************************/
public class BinaryAsciiConverter {

	/**
	 * 
	 */
	public BinaryAsciiConverter() {
		super();
	}

	/**
	 * Converts a long binary string into ascii characters
	 * @param binary
	 * @return
	 */
	public String convert(String binary) {
		if (StringUtils.isEmpty(binary) || (binary.length() % 8 != 0)) return "";
		
		StringBuilder phrase = new StringBuilder();
		
		for (int i=0; i < (binary.length() / 8); i++ ) {
			int start = i * 8;
			int end = (i + 1) * 8;
			
			String binaryChar = binary.substring(start, end);
			phrase.append((char)convertBinaryInt(binaryChar));
			
		}
		
		return phrase.toString();
	}
	
	/**
	 * Converts a byte into a character
	 * @param val
	 * @return
	 */
	private int convertBinaryInt(String val) {
		int total = 0;
		StringBuilder sb = new StringBuilder(val);
		String strByte = sb.reverse().toString();
		for (int i = strByte.length() - 1; i >= 0; i--) {
			int bit = Character.valueOf(strByte.charAt(i)) - '0';
			if (bit == 0) continue;
			
			total += (int)Math.pow(2, i);
		}

		return total;
	}
}
