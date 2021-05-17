package com.smt.kata.math;

/****************************************************************************
 * <b>Title</b>: BaseBPalindrome.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Base-b Palindromic Numbers
 * 
 * Write a function that finds the positive integers up to 1000 that are palindromes in base 2.
 * 
 * Write a function PalindromicNumbers that takes an integer b that is greater than 1
 * and outputs a list of base–10 numbers less than or equal to 1000 that are palindromic in base b.
 * 
 * More Examples
 * In base 2, the numbers up to 10 that are palindromes are 1, 3, 5:
 * 
 * NOTES - No Collections, Strings, Arrays or most other classes are to be used.  You MAY
 * NOT use the Integer or other number classes to do the base conversions.  Arrays
 * and primitives only.  
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 17, 2021
 * @updates:
 ****************************************************************************/
public class BaseBPalindrome {
	
	/**
	 * 
	 * @param value
	 * @param base
	 * @return
	 */
	public boolean isPalindrome(int value, int base) {
		if (!(base == 2 || base == 8 || base ==10 || base == 16)) return false;
		else if (value == 0) return true;
		
		// Get the binary value as a 
		char[] binValue = convertToBase(Math.abs(value), base);

		// Create a new array and reverse the order
		int ctr = 0;
		char[] reverse = new char[binValue.length];
		for (int i = binValue.length - 1; i >= 0; i--) reverse[ctr++] = binValue[i];
		
		// Compare the 2 arrays without the Arrays class.  Return false if they are not the same
		for (int i=0; i < binValue.length; i++) {
			if (binValue[i] != reverse[i]) return false;
		}
		
		// All values are the same, so return true
		return true;
	}

	/**
	 * Converts a decimal value into a binary, octal or hex value
	 * @param value Decimal value to convert
	 * @param base Base 2, 8 or 16
	 * @return String of the converted value.  A string is used as hex #s have characters
	 */
	private char[] convertToBase(int value, int base) {
		// Create a char[] to store the values
		char[] decimal = new char[40];
		
		// Divide (and modulus) at each location until value is 0
		int index = 0;
		while (value > 0) {
			// Get the remainder
			int val = (value % base);
			
			// Add the remainder to the array.  If hex and remainder is > 9, 
			// use char values
			if (val < 10) decimal[index++] = Character.forDigit(val, Character.MAX_RADIX);
			else decimal[index++] = (char)(val + 55);
			
			// Reassign the value by dividing by the base
			value = value / base;
		}
		
		// Reverse the number
		int ctr = 0;
		char[] res = new char[index];
		for (int i = index - 1; i >= 0; i--) res[ctr++] = decimal[i];
		
		// Return the string
		return res;
	}
}
