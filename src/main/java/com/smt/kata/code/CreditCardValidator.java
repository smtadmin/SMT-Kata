package com.smt.kata.code;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: CreditCardValidator.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Validate Credit Card Number
 * Create a function that takes a number as an argument and returns true if the number 
 * is a valid credit card number, false otherwise.
 * 
 * Credit card numbers must be between 14-19 digits in length, and pass the
 *  Luhn test, described below:
 * 
 * Remove the last digit (this is the "check digit").
 * Reverse the number.
 * Double the value of each digit in odd-numbered positions. If the doubled 
 * value has more than 1 digit, add the digits together (e.g. 8 x 2 = 16 ➞ 1 + 6 = 7).
 * Add all digits.
 * Subtract the last digit of the sum (from step 4) from 10. The result should be equal to the check digit from step 1.
 * 
 * Examples
 * validateCard(1234567890123456) ➞ false
 * 
 * // Step 1: check digit = 6, num = 123456789012345
 * // Step 2: num reversed = 543210987654321
 * // Step 3: digit array after selective doubling: [1, 4, 6, 2, 2, 0, 9, 8, 5, 6, 1, 4, 6, 2, 2]
 * // Step 4: sum = 58
 * // Step 5: 10 - 8 = 2 (not equal to 6) ➞ false
 * 
 * isValid(1234567890123452) ➞ true
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 8, 2021
 * @updates:
 ****************************************************************************/
public class CreditCardValidator {

	/**
	 * 
	 */
	public CreditCardValidator() {
		super();
	}
	
	/**
	 * Validates the provided CC number
	 * @param ccn
	 * @return
	 */
	public boolean isValid(String ccn) {
		// Validate the input
		if (StringUtil.isEmpty(ccn)) return false;
		
		char c = ccn.toCharArray()[ccn.length() - 1];
		int checkDigit = Character.digit(c, 10);
		if (checkDigit == -1) return false;
		
		// Reverse the ccn
		String reverseNumber = this.reverseNumber(ccn);
		
		// Get the sum of the digits as a string
		String sum = getSum(reverseNumber);
		

		// Validate the checkDigit and sums
		return validateSums(sum, checkDigit);
	}
	
	/**
	 * Grabs the last digit from the sum and compares it to the 
	 * @param sum
	 * @param checkDigit
	 * @return
	 */
	public boolean validateSums(String sum, int checkDigit) {
		int sumVal = Integer.parseInt(sum.substring(sum.length() - 1));
		return (10 - sumVal) == checkDigit;
	}
	
	/**
	 * Takes every odd location and doubles.  Adds all items and returns the sum as a string
	 * @param reverseNumber
	 * @return
	 */
	private String getSum(String reverseNumber) {
		
		int doubleVals = 0;
		
		for (int i=0; i < reverseNumber.length(); i++) {
			char c = reverseNumber.charAt(i);
			int digit = Character.digit(c, 10);
			if (digit == -1) continue;
			
			if (((i+ 1) % 2) > 0) {
				digit = digit * 2;
				if (digit >= 10) digit = (digit -10) + 1;
			}
			
			doubleVals += digit;
		}
		
		return String.valueOf(doubleVals);
	}
	
	/**
	 * Takes the CCN and removes the check digit and reverses the value
	 * @param ccn
	 * @return
	 */
	private String reverseNumber(String ccn) {
		StringBuilder number = new StringBuilder(ccn.substring(0, ccn.length() - 1));
		return number.reverse().toString();
	}
}
