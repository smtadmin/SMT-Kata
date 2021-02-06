package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: GreatestCommonDivisor.java 
 * <b>Project</b>: SMT-Kata 
 * <b>Description: </b> The Greatest Common Divisor of two positive integers is the 
 * largest integer that divides both without remainder.  Write a method that 
 * returns the Greatest Common Divisor of p and q. Hint: Easily solved using recursion.  
 * You MUST use recursion to solve
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class GreatestCommonDivisor {

	/**
	 * Uses recursion and modulus to locate the greatest common divisor
	 * @param p
	 * @param q
	 * @return
	 */
	public int gcd(int p, int q) {
		if (q == 0) return p; 
		
		return gcd(q, p % q);
	}

}
