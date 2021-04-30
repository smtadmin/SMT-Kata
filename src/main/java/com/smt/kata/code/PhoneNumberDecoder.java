package com.smt.kata.code;

// JDK 11.x
import java.util.LinkedHashMap;
import java.util.Map;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title:</b> PhoneNumberDecoder.java
 * <b>Project:</b> Daily-Kata
 * <b>Description:</b> Phone Number Word Decoder
 * 
 * Create a program that converts a phone number with letters to one with only numbers.
 * Examples
 * 
 * textToNum("123-647-EYES") ➞  "123.647.3937"
 * textToNum("(325)444-TEST") ➞ "325.444.8378"
 * textToNum("653-TRY-THIS") ➞  "653.879.8447"
 * textToNum("435-224-7613") ➞  "435.224.7613"
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class PhoneNumberDecoder {
	
	// Members
	private Map<Character, Integer> numberMap;

	/**
	 * 
	 */
	public PhoneNumberDecoder() {
		super();
		assignNumberMap();
	}

	/**
	 * Converts a phone number with text to a formatted phone number
	 * @param pn phone number to parse
	 * @return formatted phone number.
	 */
	public String textToNum(String pn) {
		if (StringUtil.isEmpty(pn)) return "";
		
		// Strip all non-alphas and Set to upper case
		pn = StringUtil.removeNonAlphaNumeric(pn).toUpperCase();
		if (pn.length() > 10 || pn.length() < 10) return "";
		
		StringBuilder formatted = new StringBuilder();
		for(char c : pn.toCharArray()) {
			if (Character.isDigit(c)) formatted.append(c);
			else formatted.append(numberMap.get(c));
			
			if (formatted.length() == 3 || formatted.length() == 7) 
				formatted.append('.');
		}
		
		return formatted.toString();
	}
	
	/**
	 * Assigns the number map
	 */
	private void assignNumberMap() {
		numberMap = new LinkedHashMap<>();
		numberMap.put('A', Integer.valueOf(2));
		numberMap.put('B', Integer.valueOf(2));
		numberMap.put('C', Integer.valueOf(2));
		numberMap.put('D', Integer.valueOf(3));
		numberMap.put('E', Integer.valueOf(3));
		numberMap.put('F', Integer.valueOf(3));
		numberMap.put('G', Integer.valueOf(4));
		numberMap.put('H', Integer.valueOf(4));
		numberMap.put('I', Integer.valueOf(4));
		numberMap.put('J', Integer.valueOf(5));
		numberMap.put('K', Integer.valueOf(5));
		numberMap.put('L', Integer.valueOf(5));
		numberMap.put('M', Integer.valueOf(6));
		numberMap.put('N', Integer.valueOf(6));
		numberMap.put('O', Integer.valueOf(6));
		numberMap.put('P', Integer.valueOf(7));
		numberMap.put('Q', Integer.valueOf(7));
		numberMap.put('R', Integer.valueOf(7));
		numberMap.put('S', Integer.valueOf(7));
		numberMap.put('T', Integer.valueOf(8));
		numberMap.put('U', Integer.valueOf(8));
		numberMap.put('V', Integer.valueOf(8));
		numberMap.put('W', Integer.valueOf(9));
		numberMap.put('X', Integer.valueOf(9));
		numberMap.put('Y', Integer.valueOf(9));
		numberMap.put('Z', Integer.valueOf(9));
	}
}
