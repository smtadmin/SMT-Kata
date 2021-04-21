package com.smt.kata.math;

// JDK 11.x
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: RomanNumeralMath.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Roman Numeral Math
 * Take 2 roman numerals and return the sum or difference between the 2 values.
 * When subtracting, use absolute value for the difference to ensure the number
 * returned is always positive
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 15, 2021
 * @updates:
 ****************************************************************************/
public class RomanNumeralMath {

	/**
	 * Map of the roman numerals to decimal conversion
	 */
	protected final Map<Integer, String> romanNumerals = new LinkedHashMap<>();
	
	/**
	 * Map of the roman numerals to decimal conversion
	 */
	protected static final Map<String, Integer> numerals = new LinkedHashMap<>();
	
	
	public RomanNumeralMath() {
		super();
		
		// Initialize the roman numerals
		romanNumerals.put(1000, "M");
		romanNumerals.put(500, "D");
		romanNumerals.put(100, "C");
		romanNumerals.put(50, "L");
		romanNumerals.put(10, "X");
		romanNumerals.put(5, "V");
		romanNumerals.put(1, "I");
		
		// Initalize the numerals
		numerals.put("M", 1000);
		numerals.put("D", 500);
		numerals.put("C", 100);
		numerals.put("L", 50);
		numerals.put("X", 10);
		numerals.put("V", 5);
		numerals.put("I", 1);
	}
	
	/**
	 * Validates the inputs
	 * @param first Roman numeral to add
	 * @param second Roman numeral to add
	 * @return boolean if the inputs are valid or invalid
	 */
	private boolean isInputValid(String first, String second) {
		return (! (StringUtil.isEmpty(first) || "0".equals(first) || StringUtil.isEmpty(second) || "0".equals(second)));
	}
	
	/**
	 * Takes two roman numerals and adds them together
	 * @param first Roman numeral to add
	 * @param second Roman numeral to add
	 * @return Roman numeral that adds the 2 values
	 */
	public String add(String first, String second) {
		if (!isInputValid(first, second)) return "";
		
		int firstInt = getBase10FromRoman(first);
		int secondInt = getBase10FromRoman(second);
		
		return getRomanNumeral(firstInt + secondInt);
	}
	
	/**
	 * Takes two roman numerals and subtracts them.  Absolute value is
	 * used to ensure a positive number
	 * @param first Roman numeral to subtract
	 * @param second Roman numeral to subtract
	 * @return
	 */
	public String subtract(String first, String second) {
		if (!isInputValid(first, second)) return "";
		
		int firstInt = getBase10FromRoman(first);
		int secondInt = getBase10FromRoman(second);
		
		return getRomanNumeral(Math.abs(firstInt - secondInt));
	}
	
	/**
	 * Converts from roman to base 10 int
	 * @param roman
	 * @return
	 */
	private int getBase10FromRoman(String roman) {
		int total = 0;
		String prev = "";
		for (char c : roman.toCharArray()) {
			String holder = String.valueOf(c);
			if ("I".equals(prev) && ! "I".equals(holder))
				total += numerals.get(holder) - 2;
			else if ("C".equals(prev) && "X".equals(holder))
				total += numerals.get(holder) - 20;
			else
				total += numerals.get(holder);
			
			prev = holder;
		}
		
		return total;
	}

	/**
	 * Convert a number into its roman numeral counterpart
	 * @param startNumber
	 * @return
	 */
	private String getRomanNumeral(int number){
		StringBuilder roman = new StringBuilder();
		List<Integer> numeralKeys = new ArrayList<>(romanNumerals.keySet());
		
		// Loop the map of numeral
		for (int i = 0; i < numeralKeys.size(); i++) {
			int val = numeralKeys.get(i);
			int numVal = number/val;
			
			// Loop the number of elements for the given numerals value.
			if (numVal > 0) {
				for(int x = 0; x < numVal; x++) {
					roman.append(romanNumerals.get(val));
				}
				
				number -= (val * numVal);
			} 

			// Check to see if we need to subtract 1 from the next version (IX for 9)
			if (number > 0 && (number + 1) == val) {
				int item = (i + 2) > 6 ? 6 : i + 2;
				roman.append(romanNumerals.get(numeralKeys.get(item)));
				roman.append(romanNumerals.get(val));
				
				number -= (val - numeralKeys.get(item));
			}
		}
		
		return roman.toString();
	}

}
