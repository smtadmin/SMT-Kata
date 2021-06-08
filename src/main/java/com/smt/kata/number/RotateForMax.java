package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: RotateForMax.java 
 * <b>Project</b>: SMT-Kata 
 * <b>Description: </b> Rotate for Max
 * 
 * Let us begin with an example:
 * 
 * Take a number: 56789. Rotate left, you get 67895. 
 * Keep the first digit in
 * place and rotate left the other digits: 68957. 
 * Keep the first two digits in
 * place and rotate the other ones: 68579. 
 * Keep the first three digits and rotate left the rest: 68597. 
 * 
 * Now it is over since keeping the first four it
 * remains only one digit which rotated is itself. You have the following
 * sequence of numbers: 56789 -> 67895 -> 68957 -> 68579 -> 68597 and you must
 * return the greatest: 68957.
 * 
 * Task Write function rotate(n) which given a positive integer n returns the
 * maximum number you got doing rotations similar to the above example.
 * 
 * Note: No collections will be used.  COnvert negatve numbers to positive
 * 
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
public class RotateForMax {

	/**
	 * Rotates each sequence of digits
	 * @param input number to be rotated
	 * @return
	 */
	public long rotate(long input) {
        String num = String.valueOf(input);
        
       // Loop each character
        for (int i = 0; i < num.length() - 1; i++) {
        	// Append the characters from start to loc.  0,0 returns nothing.
        	// Append the rest of the digits.  Append the first character to be 
        	// rotated to the end
            num = num.substring(0, i) + num.substring(i + 1) + num.charAt(i);
            
            // Since we are only returning the larger number after rotation, 
            // Only add if the rotated number is larger than the original
            if (Long.parseLong(num) > input) {
                input = Long.parseLong(num);
            }
        }
        
        return input;
    }
}
