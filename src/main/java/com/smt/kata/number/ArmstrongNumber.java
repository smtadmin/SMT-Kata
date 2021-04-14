package com.smt.kata.number;

/****************************************************************************
 * <b>Title:</b> ArmstrongNumber.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Armstrong Number
 * An Armstrong number is a number that is the sum of its own digits each raised 
 * to the power of the number of digits.
 * 
 * For example:
 * 
 * 9 is an Armstrong number, because 9 = 9^1 = 9
 * 10 is not an Armstrong number, because 10 != 1^2 + 0^2 = 1
 * 153 is an Armstrong number, because: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
 * 154 is not an Armstrong number, because: 154 != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190
 * Write some code to determine whether a number is an Armstrong number.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 22, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class ArmstrongNumber {

	public boolean isArmstrongNumber(int number) {
		
		String strNum = number + "";
		int total = 0;
		for (int i = 0; i < strNum.length(); i++) {
			int val = strNum.charAt(i) - '0';
			total += Math.pow(val, strNum.length());
		}
		
		return total == number;
	}

}
