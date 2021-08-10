package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: SpreadsheetNumbering.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 10, 2021
 * @updates:
 ****************************************************************************/
public class SpreadsheetNumbering {

	/**
	 * Converts the number provided to the excel column labels
	 * @param col Decimal column number
	 * @return Excel column heading
	 */
	public String getColumnLabel(int col) {
		// Convert from ASCII to base 26
		String value = convertToBase26(col);
		
		// Loop the base26 value and convert
		StringBuilder label = new StringBuilder();
		for (char c : value.toCharArray()) {
			// If it is a digit and 0, convert to an 'A'
			if (Character.isDigit(c)) {
				int val = Character.digit(c, 16) + 64;
				if (val == 64) val++;
				label.append(((char)(val)));
			} else {
				label.append((char)(((int)c) + 10));
			}
		}

		return label.toString();
	}
	
	/**
	 * Assumes the elements are a base 26 and converts the decimal to base 26
	 * @param value decimal value to convert
	 * @return Converted value as a string
	 */
	private String convertToBase26(int value) {
		// Create a char[] to store the values
		StringBuilder total = new StringBuilder();
		
		// Divide (and modulus) at each location until value is 0
		while (value > 0) {
			// Get the remainder
			int val = (value % 26);
			
			// Add the remainder to the array.  If hex and remainder is > 9, 
			// use char values
			if (val < 10) total.append((char)(val + 48));
			else total.append((char)(val + 55));
			
			// Reassign the value by dividing by the base
			value = value / 26;
		}

		// Reverse and return the string
		return total.reverse().toString();
	}
}
