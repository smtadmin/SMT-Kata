package siliconmtn.kata.simple;

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
	 * Creates a variety of test cases to validate the sw
	 * @param args
	 */
	public static void main(String args[]){      
		System.out.println(validate("121317")); // true
		System.out.println(validate("1234")); // true
		System.out.println(validate("45135")); // false
		System.out.println(validate("89abc1")); // false
		System.out.println(validate("900876")); // true
		System.out.println(validate(" 4983")); // false
		System.out.println(validate(" 49835")); // false
		System.out.println(validate("498356")); // true
	}

	/**
	 * Reverse the number and compare to the original
	 * @param startNumber
	 * @return
	 */
	private static boolean validate(String value){
		boolean b = Pattern.matches("[0-9]{6}", value);
		boolean c = Pattern.matches("[0-9]{4}", value);
		
		return b || c;
	}

}
