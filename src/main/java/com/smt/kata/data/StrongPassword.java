package com.smt.kata.data;

// JDK 11.x
import java.util.Arrays;
import java.util.List;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: StrongPassword.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Strong Password
 * Create a function that determines the minimum number of characters needed to 
 * make a strong password.
 * 
 * A password is considered strong if it satisfies the following criteria:
 * 
 * Its length is at least 6.
 * It contains at least one digit.
 * It contains at least one lowercase English character.
 * It contains at least one uppercase English character.
 * It contains at least one special character: !@#$%^&*()-+
 * Types of characters in a form you can paste into your solution:
 * 
 * static final String numbers = "0123456789";
 * static final String lower_case = "abcdefghijklmnopqrstuvwxyz";
 * static final String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 * static final String special_characters = "!@#$%^&*()-+";
 * Examples
 * strongPassword(“Ed1”) ➞ 3
 * 
 * strongPassword(“#Edabit”) ➞ 1
 * 
 * strongPassword("W1llth!spass?") ➞ 0
 * 
 * Notes
 * ---- Do not use regex to solve this
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 8, 2021
 * @updates:
 ****************************************************************************/
public class StrongPassword {
	/**
	 * Defines the minimum password length
	 */
	public static final int MIN_PASSWORD_LENGTH = 8;
	
	/**
	 * Protected characters in use
	 */
	protected static final List<Character> SPECIAL_CHARS = Arrays.asList('!','@','#','$','%','^','&','*','(',')','-','+' );

	// Members
	private int minPasswordLength;
	
	/**
	 * Initializes the class with the MIN_PASSWORD_LENGTH
	 */
	public StrongPassword() {
		super();
		this.minPasswordLength = MIN_PASSWORD_LENGTH;
	}

	/**
	 * min password length is assigned when initializing
	 * @param passwordLength
	 */
	public StrongPassword(int minPasswordLength) {
		super();
		this.minPasswordLength = minPasswordLength > MIN_PASSWORD_LENGTH ? minPasswordLength : MIN_PASSWORD_LENGTH;
	}
	
	/**
	 * Determines if the provided password matches the Strong Password patterns
	 * @param password USer's password
	 * @return Boolean if valid or not
	 */
	public boolean isValidPattern(String password) {
		// Validate the length
		if (! validateLength(password)) return false;
		
		// Validate at least on digit
		if (! validateDigit(password)) return false;
		
		// Validate the case of the letters
		if (! validateCase(password)) return false;
		
		// Return the output of the special chars validation
		return validateSpecialChars(password);
	}
	
	/**
	 * Checks for special characters
	 * @param password
	 * @return
	 */
	boolean validateSpecialChars(String password) {
		
		for (char c : password.toCharArray()) {
			if (SPECIAL_CHARS.contains(c)) return true;
		}
		
		return false;
	}
	
	/**
	 * Validates that the password has at least 1 upper and one lower case character
	 * @param password
	 * @return
	 */
	boolean validateCase(String password) {
		boolean lower = false;
		boolean upper = false;
		
		for (char c : password.toCharArray()) {
			if (Character.isLowerCase(c)) lower = true;
			else if (Character.isUpperCase(c)) upper = true;
		}
		
		return upper && lower;
	}
	
	/**
	 * Searches for a digit
	 * @param password
	 * @return
	 */
	boolean validateDigit(String password) {
		
		for (char c : password.toCharArray()) {
			if (Character.digit(c, 10) > -1) return true;
		}
		
		return false;
	}
	
	/**
	 * Checks the length of the password against the minimum password length
	 * @param password
	 * @return
	 */
	boolean validateLength(String password) {
		if (StringUtil.isEmpty(password)) return false;
		else return password.length() > minPasswordLength;
	}

	/**
	 * @return the minPasswordLength
	 */
	public int getMinPasswordLength() {
		return minPasswordLength;
	}

	/**
	 * @param minPasswordLength the minPasswordLength to set
	 */
	public void setMinPasswordLength(int minPasswordLength) {
		this.minPasswordLength = minPasswordLength;
	}
}
