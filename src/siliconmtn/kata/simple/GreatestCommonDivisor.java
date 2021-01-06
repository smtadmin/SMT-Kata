package siliconmtn.kata.simple;

/****************************************************************************
 * <b>Title</b>: GreatestCommonDivisor.java 
 * <b>Project</b>: _Sandbox 
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
	 * Creates a variety of test cases to validate the sw
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(gcd(99, 44)); // 11
		System.out.println(gcd(44, 99)); // 11
		System.out.println(gcd(51, 17)); // 17
		System.out.println(gcd(27, 6)); // 3
		System.out.println(gcd(9, 25)); // 1
		System.out.println(gcd(-27, 6)); // -3
		System.out.println(gcd(-27, -6)); // -3
	}

	/**
	 * Uses recursion and modulus to locate the greatest common divisor
	 * @param p
	 * @param q
	 * @return
	 */
	public static Integer gcd(Integer p, Integer q) {
		if (q == 0) return p; 
		else if (p == 0) return q;
		
		return gcd(q, p % q);
	}

}
