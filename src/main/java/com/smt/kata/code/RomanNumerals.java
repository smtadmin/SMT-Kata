 package com.smt.kata.code;

// JDK 8.x
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: RomanNumerals.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Translate a number into its roman numeral counterpart.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class RomanNumerals {
	
	/**
	 * Map of the roman numerals to decimal conversion
	 */
	private static Map<Integer, String> numerals = new LinkedHashMap<Integer,String>() {
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
	 * Convert a number into its roman numeral counterpart
	 * @param startNumber
	 * @return
	 */
	public String getRomanNumeral(int number){
		StringBuilder roman = new StringBuilder();
		List<Integer> numeralKeys = new ArrayList<>(numerals.keySet());
		
		// Loop the map of numeral
		for (int i = 0; i < numeralKeys.size(); i++) {
			int val = numeralKeys.get(i);
			int numVal = number/val;
			
			// Loop the number of elements for the given numerals value.
			if (numVal > 0) {
				for(int x = 0; x < numVal; x++) {
					roman.append(numerals.get(val));
				}
				
				number -= (val * numVal);
			} 

			// Check to see if we need to subtract 1 from the next version (IX for 9)
			if (number > 0 && (number + 1) == val) {
				int item = (i + 2) > 6 ? 6 : i + 2;
				roman.append(numerals.get(numeralKeys.get(item)));
				roman.append(numerals.get(val));
				
				number -= (val - numeralKeys.get(item));
			}
		}
		
		return roman.toString();
	}

}
