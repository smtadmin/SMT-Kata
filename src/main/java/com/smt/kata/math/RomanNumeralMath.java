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
	private static Map<Integer, String> ROMAN_NUMERALS = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L; {
			put(1000, "M");
			put(500, "D");
			put(100, "C");
			put(50, "L");
			put(10, "X");
			put(5, "V");
			put(1, "I");
		}
	};
	
	/**
	 * Map of the roman numerals to decimal conversion
	 */
	private static Map<String, Integer> NUMERALS = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L; {
			put("M", 1000);
			put("D", 500);
			put("C", 100);
			put("L", 50);
			put("X", 10);
			put("V", 5);
			put("I", 1);
		}
	};
	
	/**
	 * Takes two roman numerals and adds them together
	 * @param first
	 * @param second
	 * @return
	 */
	public String add(String first, String second) {
		if (StringUtil.isEmpty(first) || "0".equals(first)) return "";
		if (StringUtil.isEmpty(second) || "0".equals(second)) return "";
		
		int firstInt = getBase10FromRoman(first);
		int secondInt = getBase10FromRoman(second);
		
		return getRomanNumeral(firstInt + secondInt);
	}
	
	/**
	 * Takes two roman numerals and subtracts them.  Absolute value is
	 * used to ensure a positive number
	 * @param first
	 * @param second
	 * @return
	 */
	public String subtract(String first, String second) {
		if (StringUtil.isEmpty(first) || "0".equals(first)) return "";
		if (StringUtil.isEmpty(second) || "0".equals(second)) return "";
		
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
				total += NUMERALS.get(holder) - 2;
			else if ("C".equals(prev) && "X".equals(holder))
				total += NUMERALS.get(holder) - 20;
			else
				total += NUMERALS.get(holder);
			
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
		List<Integer> numeralKeys = new ArrayList<>(ROMAN_NUMERALS.keySet());
		
		// Loop the map of numeral
		for (int i = 0; i < numeralKeys.size(); i++) {
			int val = numeralKeys.get(i);
			int numVal = number/val;
			
			// Loop the number of elements for the given numerals value.
			if (numVal > 0) {
				for(int x = 0; x < numVal; x++) {
					roman.append(ROMAN_NUMERALS.get(val));
				}
				
				number -= (val * numVal);
			} 

			// Check to see if we need to subtract 1 from the next version (IX for 9)
			if (number > 0 && (number + 1) == val) {
				int item = (i + 2) > 6 ? 6 : i + 2;
				roman.append(ROMAN_NUMERALS.get(numeralKeys.get(item)));
				roman.append(ROMAN_NUMERALS.get(val));
				
				number -= (val - numeralKeys.get(item));
			}
		}
		
		return roman.toString();
	}

}
