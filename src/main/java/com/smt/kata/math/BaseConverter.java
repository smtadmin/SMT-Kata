package com.smt.kata.math;

/****************************************************************************
 * <b>Title:</b> BaseConverter.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Base Converter
 * 
 * In this kata, you must convert a base 10 integer into a binary, octal
 * or hexidecimal value.
 * 
 * You must also convert a binary, octal or hexidecimal number back to a base 10 integer
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 6, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class BaseConverter {

	/**
	 * Converts a decimal value to its binary equivalent
	 * @param value Decimal value to be converted
	 * @return binary number as an integer
	 */
	public int decimaltoBinary(int value) {
		return Integer.valueOf(convertToBase(value, 2));
	}
	
	/**
	 * Converts a decimal value to its octal equivalent
	 * @param value Decimal value to be converted
	 * @return Octal number as an integer
	 */
	public int decimaltoOctal(int value) {
		return Integer.valueOf(convertToBase(value, 8));
	}

	/**
	 * Converts a decimal value to its hexidecimal equivalent
	 * @param value Decimal value to be converted
	 * @return Hexidecimal number as a string
	 * 
	 */
	public String decimaltoHexidecimal(int value) {
		return convertToBase(value, 16);
	}
	
	/**
	 * Converts a decimal value into a binary, octal or hex value
	 * @param value Decimal value to convert
	 * @param base Base 2, 8 or 16
	 * @return String of the converted value.  A string is used as hex #s have characters
	 */
	private String convertToBase(int value, int base) {
		// Create a char[] to store the values
		char[] decimal = new char[40];
		int index = 0;
		
		// Divide (and modulus) at each location until value is 0
		while (value > 0) {
			// Get the remainder
			int val = (value % base);
			
			// Add the remainder to the array.  If hex and remainder is > 9, 
			// use char values
			if (val < 10) decimal[index++] = (char)(val + 48);
			else decimal[index++] = (char)(val + 55);
			
			// Reassign the value by dividing by the base
			value = value / base;
		}

		// Loop the array backwards form the last location and add to StringBuilder
		StringBuilder total = new StringBuilder();
		for (int i = index - 1; i >= 0; i--) {
			total.append(decimal[i]);
		}

		// Return the string
		return total.toString();
	}
	
	/**
	 * Converts a value with the given base back to decimal
	 * @param value Value to be converted
	 * @param base Base 2, 8 or 16
	 * @return Converted number in decimal (base10) format
	 */
	public int convertToDecimal(String value, int base) {
		int total = 0;
		StringBuilder reverseValue = new StringBuilder(value).reverse();
		
		for (int i = 0; i < reverseValue.length(); i++) {
			int item = reverseValue.charAt(i) - '0';
			if (item > 0) total += Math.pow(base, i) * item;
		}
		
		return total;
	}
}
