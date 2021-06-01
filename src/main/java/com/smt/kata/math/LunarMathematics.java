package com.smt.kata.math;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: LunarMathematics.java 
 * <b>Project</b>: SMT-Kata 
 * <b>Description: </b> Lunar Mathematics 
 * 
 * Lunar Mathematics, otherwise known as 'Dismal Mathematics'
 * (a play on 'decimal mathematics'), was created as an alternate way to view
 * mathematics interacts with numbers. Here, we will create the addition
 * function.
 * 
 * On the moon, there is no need to carry over numbers into the next column.
 * Instead, we take the largest value of each column, and set that as our total.
 * 
 * Examples:
 * 
 * 8 + 7 ---- 8 <- Since 8 is the larger number of the two, it is the one used.
 * 
 * 234 + 180 ----- 284 <- the larger values of each number are used for each portion.
 * 
 * 50 +59 ------ 59 <- If a number in two columns match, either one of the
 * numbers can be used.
 * 
 * 465 + 72 ----- 475 <- You must handle situations where numbers are not of
 * equal length Assume all numbers given are valid, nonnegative integers (as
 * there are no negative numbers on the moon). 
 * 
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
public class LunarMathematics {
	
	/**
	 * Performs Lunar Math on the 2 provided numbers
	 * @param firstNumber First number to add
	 * @param secondNumber Second Number to add
	 * @return Total of the lunar math addition of the provided 2 numbers
	 */
	public int add(int firstNumber, int secondNumber) {
		// Find the largest number and assign as loop.  Other number as eval
		String loopNumber = firstNumber >= secondNumber ? String.valueOf(Math.abs(firstNumber)) : String.valueOf(Math.abs(secondNumber));
		String evalNumber = firstNumber < secondNumber ? String.valueOf(Math.abs(firstNumber)) : String.valueOf(Math.abs(secondNumber));
		
		// Pad the eval with zeros to match the length of the loop
		evalNumber =  StringUtil.padLeft(evalNumber, '0', loopNumber.length());
		
		// Create a variable to hold max.  Loop, evaluate and assign to hldr
		StringBuilder hldr = new StringBuilder();
		for (int i=0; i < loopNumber.length(); i++) {
			int loopVal = Character.digit(loopNumber.charAt(i), Character.MAX_RADIX);
			int val =Character.digit(evalNumber.charAt(i), Character.MAX_RADIX);
			
			// Only append the largest character
			hldr.append(loopVal >= val ? loopVal : val);
		}
		
		// Convert to an int and return
		return Integer.valueOf(hldr.toString());
	}

}
