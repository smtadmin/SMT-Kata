package com.smt.kata.code;

import java.util.regex.Pattern;

/****************************************************************************
 * <b>Title</b>: ValidRegexPin.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> RegEx: Validate PIN
Create a function that will test if a string is a valid PIN or not via a regular expression.

A valid PIN has:

Exactly 4 or 6 characters.
Only numeric characters (0-9).
No whitespace.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class ValidRegexPin {

	/**
	 * Reverse the number and compare to the original
	 * @param startNumber
	 * @return
	 */
	public boolean validate(String value){
		boolean b = Pattern.matches("[0-9]{6}", value);
		boolean c = Pattern.matches("[0-9]{4}", value);
		
		return b || c;
	}

}
