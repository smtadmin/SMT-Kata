package com.smt.kata.math;

/****************************************************************************
 * <b>Title:</b> NoOpDivision.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> No Operator Division
 * 
 * Implement division of two positive integers without using the division, 
 * multiplication, or modulus operators. Return the quotient as an integer, 
 * ignoring the remainder.  The sign of the dividend and divisor must be taken into
 * account.
 * 
 * Example:
 * 
 * 10 / 3 = 3;
 * 
 * 12 / 5 = 2;
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
public class NoOpDivision {

	/**
	 * Divide two integers and receive an integer.  Round to floor
	 * @param dividend Number to be divided
	 * @param divisor Number to be divided by
	 * @return rounded number.  Zero if dividend or divisor is zero
	 */
	public int divide(int dividend, int divisor) {
		if (dividend == 0 || divisor == 0) return 0;

		// Calculate sign of divisor i.e.,
		// sign will be negative only if
		// either one of them is negative
		// otherwise it will be positive
		int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

		// Update both divisor and
		// dividend positive
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		// Initialize the quotient
		int quotient = 0;

		while (dividend >= divisor) {
			dividend -= divisor;
			quotient++;
		}
		
		return sign * quotient;
	}

}
